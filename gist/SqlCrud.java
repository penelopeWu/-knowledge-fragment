package com.yunjuanyunshu.modules.form.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.yunjuanyunshu.common.utils.IdGen;
import com.yunjuanyunshu.common.utils.SpringContextHolder;
import com.yunjuanyunshu.modules.form.entity.FormSql;
import com.yunjuanyunshu.modules.form.service.FormSqlService;
import com.yunjuanyunshu.modules.form.service.impl.FormSqlServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 11655 on 2017-07-25.
 */
public class SqlCrud {

    private static DruidDataSource dataSource;
    private static SqlCrud instance = new SqlCrud();
    SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 正则表达式
     **/
    private static final String REG = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
            + "(\\b(select|update|union|and|or|delete|insert|trancate|char|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
    //      \\b  表示 限定单词边界  比如  select 不通过   1select则是可以的
    private static Pattern sqlPattern = Pattern.compile(REG, Pattern.CASE_INSENSITIVE);
    private Logger logger = LoggerFactory.getLogger(getClass());

    //让构造函数为 private，这样该类就不会被实例化
    private SqlCrud() {
        dataSource = SpringContextHolder.getBean(DruidDataSource.class);
    }

    /**
     * 获取操作实例
     *
     * @return
     */
    public static SqlCrud getInstance() {
        return instance;
    }

    /**
     * 获取数据库连接
     */
    private Connection getConnection() throws SQLException {
        Connection conn = DataSourceUtils.getConnection(dataSource);
        return conn;
    }

    /**
     * 获取连接操作对象
     *
     * @param conn
     * @return
     * @throws SQLException
     */
    private Statement getStatement(Connection conn) throws SQLException {
        return conn.createStatement();
    }

    private void close(Connection conn) {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }

    private void close(Connection conn, Statement stmt) throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            DataSourceUtils.releaseConnection(conn, dataSource);
        }


    }


    private boolean isValid(String str) {
        if (sqlPattern.matcher(str).find()) {
            logger.error("未能通过过滤器：str=" + str);
            return false;
        }
        return true;
    }

    private boolean isValid(JSONObject jsonObject) {
        for (Iterator it = jsonObject.keys(); it.hasNext(); ) {
            String a = (String) it.next();
            if (sqlPattern.matcher(jsonObject.getString(a)).find()) {
                logger.error("未能通过过滤器：str=" + jsonObject.getString(a));
                return false;
            }
        }
        return true;
    }

    //stringbuilder的替换
    public static void replaceAll(StringBuilder sb, String target, String replace) {
        if (null == sb || null == target) return;
        if (null == replace) replace = "";
        int targetLen = target.length();
        int replaceLen = replace.length();
        for (int fromIndex = 0, curIndex = sb.indexOf(target, fromIndex);
             curIndex > -1; curIndex = sb.indexOf(target, fromIndex)) {
            sb.replace(curIndex, curIndex + targetLen, replace);
            fromIndex = curIndex + replaceLen;
        }
    }

    //使用反射机制替换对应字符串
    public static void reflectReplace(StringBuilder sb) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //根据类名创建类对象
        Class clas = Class.forName("com.yunjuanyunshu.modules.form.entity.FormReflection");
        //获取构造器
        Constructor cons = clas.getConstructor();
        //根据构造器，实例化出对象
        Object serv = cons.newInstance();
        String ex = sb.toString();
        Pattern pattern = Pattern.compile("&&(.*?)&&");   //正则匹配 &........&
        Matcher matcher = pattern.matcher(ex);
        while (matcher.find()) {

            //根据方法名称获取方法
            Method m = clas.getMethod(matcher.group(0).replace("&&", ""));
            //调用对象的指定方法
            Object objString = m.invoke(serv);
            replaceAll(sb, matcher.group(0), objString.toString());
        }

    }

    //用来判断表名是否合法
    private JSONObject isValidTableName(JSONObject jsonObject, JSONObject respo) {
        if (jsonObject.get("name") == null) {
            respo.put("result", "fail");
            respo.put("msg", "不能获得表名！");
            return respo;
        }
        if (!isValid(jsonObject.get("name").toString())) {
            respo.put("result", "fail");
            respo.put("msg", "失败，表单名字\" " + jsonObject.get("name") + "\" 不通过验证！ ");
            return respo;
        }
        return respo;
    }


    //插入单条数据函数
    // {"name":"lxf","json1":"这是测试数据1","json2":"222"}
    // Type=insertData
    // INSERT INTO ?  set  id = ? , create_date =? ,  update_date = ? , ? ;
    private JSONObject insertData(String sql, JSONObject jsonObject) throws SQLException {

        Connection conn = null;
        Statement stmt = null;

        JSONObject respo = new JSONObject();

        StringBuilder sq2 = new StringBuilder();
        try {
            respo = isValidTableName(jsonObject, respo);
            if (respo.get("result") != null)
                return respo;
            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name"));
            sql = sql.replaceFirst("\\?", "\"" + IdGen.uuid() + "\"");
            sql = sql.replaceFirst("\\?", "\"" + dateFm.format(new Date()) + "\"");
            sql = sql.replaceFirst("\\?", "\"" + dateFm.format(new Date()) + "\"");
            Iterator it = jsonObject.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                if (!key.equals("name")) {
                    sq2.append(key).append(" = \"").append(jsonObject.getString(key)).append("\" ,");
                }
            }
            sq2.deleteCharAt(sq2.length() - 1);
            sq2.append(";");
            if (!isValid(sq2.toString())) {
                respo.put("result", "fail");
                respo.put("msg", "失败，插入内容不通过验证！ ");
                return respo;
            }
            sql = sql.replaceFirst("\\?", String.valueOf(sq2));
            conn = getConnection();
            stmt = getStatement(conn);
            logger.debug("sql：" + sql);
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功

            if (result != -1) {
                logger.debug("添加数据成功");
                respo.put("result", 1);
                respo.put("msg", "成功插入" + result + "条数据！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            respo.put("result", "fail");
            respo.put("msg", e.getMessage());
        } finally {
            close(conn, stmt);
        }
        return respo;
    }

    //批量插入数据函数
    // {"name":"te","attri":["json1","json2","json3"],"valu":[["d1","d2","d3"],["d11","d22","d33"],["d16","d33","d3"]]}
    //  Type=insertDatas
    //  INSERT into ? ( ? )  VALUES ? ;
    private JSONObject insertDatas(String sql, JSONObject jsonObject) throws SQLException {

        Connection conn = null;
        Statement stmt = null;

        JSONObject respo = new JSONObject();
        StringBuilder sq2 = new StringBuilder();
        StringBuilder sq3 = new StringBuilder();
        try {
            respo = isValidTableName(jsonObject, respo);
            if (respo.get("result") != null)
                return respo;
            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name"));
            Iterator it = jsonObject.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                if (key.equals("attri")) {
                    String value = jsonObject.getString(key);
                    for (Object a : (List<Object>) jsonObject.get(key)) {
                        sq2.append(a).append(",");
                    }
                    sq2.append(" id,create_date,update_date ");
                }
                if (key.equals("valu")) {
                    for (List<Object> a : (List<List<Object>>) jsonObject.get(key)) {
                        sq3.append("(");
                        for (Object b : a) {
                            sq3.append("\"").append(b).append("\"").append(",");
                        }
                        sq3.append("\"").append(IdGen.uuid()).append("\" , ");
                        sq3.append("\"").append(dateFm.format(new Date())).append("\" , ");
                        sq3.append("\"").append(dateFm.format(new Date())).append("\" ),");
                    }
                }
            }
            sq3.deleteCharAt(sq3.length() - 1);
            if (!isValid(sq2.toString()) || !isValid(sq3.toString())) {
                respo.put("result", "fail");
                respo.put("msg", "失败，插入内容不通过验证！ ");
                return respo;
            }
            sql = sql.replaceFirst("\\?", String.valueOf(sq2));
            sql = sql.replaceFirst("\\?", String.valueOf(sq3));

            conn = getConnection();
            stmt = getStatement(conn);
            logger.debug("sql：" + sql);
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != -1) {
                logger.debug("添加多条数据成功");
                respo.put("result", 1);
                respo.put("msg", "成功插入" + result + "条数据！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respo.put("result", "fail");
            respo.put("msg", e.getMessage());
        } finally {
            close(conn, stmt);
        }
        return respo;
    }

    //更新指定数据
    // {"name":"lxf","id":"42d3d0a265714602a17aad0c73ecf1e6","json1":"修改后的值"}
    // Type=updateData
    // UPDATE ? SET  last_updated=? , ?  where id = ? ;
    private JSONObject updateData(String sql, JSONObject jsonObject) throws SQLException {

        Connection conn = null;
        Statement stmt = null;

        JSONObject respo = new JSONObject();

        StringBuilder sq2 = new StringBuilder();
        try {
            respo = isValidTableName(jsonObject, respo);
            if (respo.get("result") != null)
                return respo;
            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name"));
            sql = sql.replaceFirst("\\?", "\"" + dateFm.format(new Date()) + "\"");

            Iterator it = jsonObject.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                if (!key.equals("name") && !key.equals("id")) {
                    sq2.append(key).append(" = \"").append(jsonObject.getString(key)).append("\" ,");
                }
            }
            sq2.deleteCharAt(sq2.length() - 1);
            if (!isValid(sq2.toString()) || !isValid((String) jsonObject.get("id"))) {
                respo.put("result", "fail");
                respo.put("msg", "失败，更新内容不通过验证！ ");
                return respo;
            }
            sql = sql.replaceFirst("\\?", String.valueOf(sq2));
            sql = sql.replaceFirst("\\?", "\"" + (String) jsonObject.get("id") + "\"");
            System.out.println(sql);
            conn = getConnection();
            stmt = getStatement(conn);
            logger.debug("sql：" + sql);
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != -1) {
                logger.debug("更新数据成功");
                respo.put("result", 1);
                respo.put("msg", "成功更新" + result + "条数据！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            respo.put("result", "fail");
            respo.put("msg", e.getMessage());
        } finally {
            close(conn, stmt);
        }
        return respo;
    }


    //查询指定数据
    // {"name":"lxf","json1":"like \"%2%\""}
    // Type=selectData
    // SELECT * FROM ? WHERE ? ;
    private JSONObject selectData(String sql, JSONObject jsonObject) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        JSONObject respo = new JSONObject();
        JSONArray myJsonArray = new JSONArray();

        StringBuilder sq2 = new StringBuilder("");
        String sq3;
        try {
            respo = isValidTableName(jsonObject, respo);
            if (respo.get("result") != null)
                return respo;
            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name"));
            Iterator it = jsonObject.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                if (!key.equals("name")) {
                    sq3 = " " + key + " " + jsonObject.getString(key);
                    if (!isValid(sq3)) {
                        respo.put("result", "fail");
                        respo.put("msg", "失败，查询内容 " + sq3 + " 不通过验证！ ");
                        return respo;
                    }
                    sq2.append(sq3).append(" and");
                }
            }
            if (sq2.toString().equals("")) {
                sql = sql.replaceFirst("\\?", "1=1");
            } else {
                sq2.deleteCharAt(sq2.length() - 1);
                sq2.deleteCharAt(sq2.length() - 1);
                sq2.deleteCharAt(sq2.length() - 1);
            }
            sql = sql.replaceFirst("\\?", String.valueOf(sq2));
            conn = getConnection();
            stmt = getStatement(conn);
            logger.debug("sql：" + sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            String columnName, columnValue;
            while (rs.next()) {
                JSONObject json = new JSONObject();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    columnName = rsmd.getColumnName(i + 1);
                    columnValue = rs.getString(columnName);
                    json.put(columnName, columnValue);
                }
                myJsonArray.add(json);
            }
            respo.put("data", myJsonArray);
            System.out.println("查询数据成功");
            respo.put("result", 1);
            respo.put("msg", "成功查询" + myJsonArray.size() + "条数据！");
            rs.close();


        } catch (Exception e) {
            e.printStackTrace();
            respo.put("result", "fail");
            respo.put("msg", e.getMessage());
        } finally {
            close(conn, stmt);
        }
        return respo;
    }


    //分页查询数据
    // {"name":"test","page":"2","num":"20","shu1":">500"}
    // Type=pageData
    // SELECT * FROM ？ WHERE id >= (select id from ？ where ？ limit ？,1) and ？ limit ？ ;
    private JSONObject pageData(String sql, JSONObject jsonObject) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        JSONArray myJsonArray = new JSONArray();
        JSONObject respo = new JSONObject();
        String sql3 = null;
        try {
            respo = isValidTableName(jsonObject, respo);
            if (respo.get("result") != null)
                return respo;
            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name"));
            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name"));
            StringBuilder sql2 = new StringBuilder();
            Iterator it = jsonObject.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                if (!key.equals("name") && !key.equals("page") && !key.equals("num")) {
                    sql3 = " " + key + " " + jsonObject.getString(key);
                    if (!isValid(sql3)) {
                        respo.put("result", "fail");
                        respo.put("msg", "失败，查询内容 " + sql3 + " 不通过验证！ ");
                        return respo;
                    }
                    sql2.append(sql3).append(" and ");
                }
            }
            sql2.deleteCharAt(sql2.length() - 1);
            sql2.deleteCharAt(sql2.length() - 1);
            sql2.deleteCharAt(sql2.length() - 1);
            sql2.deleteCharAt(sql2.length() - 1);
            sql = sql.replaceFirst("\\?", String.valueOf(sql2));
            int page = Integer.parseInt((String) jsonObject.get("page"));
            int num = Integer.parseInt((String) jsonObject.get("num"));
            sql = sql.replaceFirst("\\?", String.valueOf((page - 1) * num));
            sql = sql.replaceFirst("\\?", String.valueOf(sql2));
            sql = sql.replaceFirst("\\?", String.valueOf(num));
            System.out.println(sql);
            conn = getConnection();
            stmt = getStatement(conn);
            logger.debug("sql：" + sql.toString());
            ResultSet rs = stmt.executeQuery(sql.toString());
            ResultSetMetaData rsmd = rs.getMetaData();
            String columnName, columnValue;
            while (rs.next()) {
                JSONObject json = new JSONObject();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    columnName = rsmd.getColumnName(i + 1);
                    columnValue = rs.getString(columnName);
                    json.put(columnName, columnValue);
                }
                myJsonArray.add(json);
            }
            respo.put("data", myJsonArray);
            System.out.println("查询数据成功");
            respo.put("result", "success");
            respo.put("msg", "成功查询" + myJsonArray.size() + "条数据！");
            rs.close();


        } catch (Exception e) {
            e.printStackTrace();
            respo.put("result", "fail");
            respo.put("msg", e.getMessage());
        } finally {
            close(conn, stmt);
        }
        return respo;
    }

    //查询数据表
    // {"name":"lxf"}
    //Type=getColname
    //select COLUMN_NAME from information_schema.COLUMNS where table_name = '?' and table_schema = 'lab';
    private JSONObject selectTables(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        JSONArray myJsonArray = new JSONArray();
        JSONObject respo = new JSONObject();

        try {


            System.out.println(sql);
            conn = getConnection();
            stmt = getStatement(conn);
            logger.debug("数据表查找成功" + "sql：" + sql.toString());
            ResultSet rs = stmt.executeQuery(sql.toString());
            ResultSetMetaData rsmd = rs.getMetaData();
            String columnName, columnValue;
            while (rs.next()) {
                JSONObject json = new JSONObject();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    columnName = rsmd.getColumnName(i + 1);
                    columnValue = rs.getString(columnName);
                    json.put(columnName, columnValue);
                }
                myJsonArray.add(json);
            }
            respo.put("data", myJsonArray);
            System.out.println("查询列名成功");
            respo.put("result", "success");
            respo.put("msg", "成功查询" + myJsonArray.size() + "条数据！");
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            respo.put("result", "fail");
            respo.put("msg", e.getMessage());
        } finally {
            close(conn, stmt);
        }
        return respo;
    }

    //删除批量数据
    // {"name":"lxf","id":["10235a7912ee413d972ad2f6b2a6915c","42d3d0a265714602a17aad0c73ecf1e6","52ab39f1774f4d829242a59d67fbb668"]}
    //  Type=deleteDatas
    //  DELETE lxf TestTable WHERE ID IN (1, 3, 54, 68)
    private JSONObject deleteDatas(String sql, JSONObject jsonObject) throws SQLException {

        Connection conn = null;
        Statement stmt = null;

        JSONObject respo = new JSONObject();

        StringBuilder sq2 = new StringBuilder();
        try {
            respo = isValidTableName(jsonObject, respo);
            if (respo.get("result") != null)
                return respo;
            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name"));
            Iterator it = jsonObject.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                if (key.equals("id")) {
                    String value = jsonObject.getString(key);
                    for (Object a : (List<Object>) jsonObject.get(key)) {
                        sq2.append("\"").append(a).append("\"").append(",");
                    }
                }
            }
            sq2.deleteCharAt(sq2.length() - 1);
            sql = sql.replaceFirst("\\?", String.valueOf(sq2));
            if (!isValid(jsonObject.get("id").toString())) {
                respo.put("result", "fail");
                respo.put("msg", "失败，删除数据的id不通过验证！ ");
                return respo;
            }
            System.out.println(sql);
            conn = getConnection();
            stmt = getStatement(conn);
            logger.debug("sql：" + sql);
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != -1) {
                logger.debug("删除数据成功");
                respo.put("result", 1);
                respo.put("msg", "成功删除" + result + "条数据！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            respo.put("result", "fail");
            respo.put("msg", e.getMessage());
        } finally {
            close(conn, stmt);
        }
        return respo;
    }

    //批量修改数据
    // {"name":"tsee","attri":["id","json1"],"valu":[["6c179151037f4615899b3d1fa24fd748","O2"],["7a145f95ee464dcf92210cef70ef2e43","T3"]]}
    //  Type=updateDatas
    //  insert into ? (?) values ? on duplicate key update update_date=?,?;
    private JSONObject updateDatas(String sql, JSONObject jsonObject) throws SQLException {

        Connection conn = null;
        Statement stmt = null;

        JSONObject respo = new JSONObject();
        StringBuilder sq2 = new StringBuilder();
        StringBuilder sq3 = new StringBuilder();
        StringBuilder sq4 = new StringBuilder();
        try {
            respo = isValidTableName(jsonObject, respo);
            if (respo.get("result") != null)
                return respo;
            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name"));
            Iterator it = jsonObject.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                if (key.equals("attri")) {
                    String value = jsonObject.getString(key);
                    for (Object a : (List<Object>) jsonObject.get(key)) {
                        sq2.append(a).append(",");
                        if (!a.equals("id")) {
                            sq4.append(a).append("=values(").append(a).append("),");
                        }
                    }
                }
                if (key.equals("valu")) {
                    for (List<Object> a : (List<List<Object>>) jsonObject.get(key)) {
                        sq3.append("(");
                        for (Object b : a) {
                            sq3.append("\"").append(b).append("\"").append(",");
                        }
                        sq3.deleteCharAt(sq3.length() - 1);
                        sq3.append("),");
                    }
                }
            }
            sq2.deleteCharAt(sq2.length() - 1);
            sq3.deleteCharAt(sq3.length() - 1);
            sq4.deleteCharAt(sq4.length() - 1);
            if (!isValid(sq2.toString()) || !isValid(sq3.toString())) {
                respo.put("result", "fail");
                respo.put("msg", "失败，插入内容不通过验证！ ");
                return respo;
            }
            sql = sql.replaceFirst("\\?", String.valueOf(sq2));
            sql = sql.replaceFirst("\\?", String.valueOf(sq3));
            sql = sql.replaceFirst("\\?", "\"" + dateFm.format(new Date()) + "\"");
            sql = sql.replaceFirst("\\?", String.valueOf(sq4));
            conn = getConnection();
            stmt = getStatement(conn);
            logger.debug("sql：" + sql);
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != -1) {
                logger.debug("更新多条数据成功");
                respo.put("result", 1);
                respo.put("msg", "成功更新" + result + "条数据！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respo.put("result", "fail");
            respo.put("msg", e.getMessage());
        } finally {
            close(conn, stmt);
        }
        return respo;
    }


    //需要参数
    private JSONObject crudMethod(StringBuilder sql, String descprition, JSONObject jsonObject) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        JSONObject respo = new JSONObject();
        try {
            if (!isValid(jsonObject)) {
                respo.put("result", "fail");
                respo.put("msg", "失败，内容不通过验证！ ");
                return respo;
            }
            for (Iterator it = JSONObject.fromObject(jsonObject).keys(); it.hasNext(); ) {
                String a = (String) it.next();
                replaceAll(sql, "?" + a + "?", jsonObject.getString(a));
            }
            reflectReplace(sql);

            conn = getConnection();
            stmt = getStatement(conn);

            logger.debug("sql：" + sql);

            if (sql.indexOf("SELECT") >= 0 || sql.indexOf("select") >= 0) {
                ResultSet rs = stmt.executeQuery(sql.toString());
                ResultSetMetaData rsmd = rs.getMetaData();
                String columnName, columnValue;
                JSONArray myJsonArray = new JSONArray();
                while (rs.next()) {
                    JSONObject json = new JSONObject();
                    for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        columnName = rsmd.getColumnName(i + 1);
                        columnValue = rs.getString(columnName);
                        json.put(columnName, columnValue);
                    }
                    myJsonArray.add(json);
                }
                respo.put("data", myJsonArray);
                System.out.println("多表查询数据成功");
                respo.put("result", "success");
                respo.put("msg", "成功查询" + myJsonArray.size() + "条数据！");
                rs.close();
            } else {
                stmt.execute(sql.toString());
                respo.put("result", "success");
                respo.put("msg", "成功执行！");

            }

        } catch (Exception e) {
            e.printStackTrace();
            respo.put("result", "fail");
            respo.put("msg", e.getMessage());
        } finally {
            close(conn, stmt);
        }
        return respo;
    }

    //不需要参数
    private JSONObject crudMethod(StringBuilder sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        JSONObject respo = new JSONObject();
        try {
            conn = getConnection();
            stmt = getStatement(conn);
            logger.debug("sql：" + sql);
            if (sql.indexOf("SELECT") >= 0 || sql.indexOf("select") >= 0) {
                ResultSet rs = stmt.executeQuery(sql.toString());
                ResultSetMetaData rsmd = rs.getMetaData();
                String columnName, columnValue;
                JSONArray myJsonArray = new JSONArray();
                while (rs.next()) {
                    JSONObject json = new JSONObject();
                    for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        columnName = rsmd.getColumnName(i + 1);
                        columnValue = rs.getString(columnName);
                        json.put(columnName, columnValue);
                    }
                    myJsonArray.add(json);
                }
                respo.put("data", myJsonArray);
                System.out.println("多表查询数据成功");
                respo.put("result", "success");
                respo.put("msg", "成功查询" + myJsonArray.size() + "条数据！");
                rs.close();
            } else {
                stmt.execute(sql.toString());
                respo.put("result", "success");
                respo.put("msg", "成功执行！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            respo.put("result", "fail");
            respo.put("msg", e.getMessage());
        } finally {
            close(conn, stmt);
        }
        return respo;
    }


    public JSONObject crud(String type, String sqlDeatil, String descprition, JSONObject jsonObject) throws SQLException {
        JSONObject resp;
        if (("{}").equals(descprition))
            resp = crudMethod(new StringBuilder(sqlDeatil));
        else
            resp = crudMethod(new StringBuilder(sqlDeatil), descprition, jsonObject);
        return resp;
    }
//        switch (CRUD.toCRUD(type)) {
//            case selectTables:
//                resp = selectTables(sqlDeatil);
//                break;
////            case insertData:
////                resp = insertData(sqlDeatil, jsonObject);
////                break;
//            case insertDatas:
//                resp = insertDatas(sqlDeatil, jsonObject);
//                break;
//            case updateData:
//                resp = updateData(sqlDeatil, jsonObject);
//                break;
//            case deleteData:
//                resp = deleteData(sqlDeatil, jsonObject);
//                break;
//            case selectData:
//                resp = selectData(sqlDeatil, jsonObject);
//                break;
//            case pageData:
//                resp = pageData(sqlDeatil, jsonObject);
//                break;
//            case getColname:
//                resp = getColname(sqlDeatil, jsonObject);
//                break;
//            case deleteDatas:
//                resp = deleteDatas(sqlDeatil, jsonObject);
//                break;
//            case updateDatas:
//                resp = updateDatas(sqlDeatil, jsonObject);
//                break;
//            case tableJoin:
//                resp = tableJoin(sqlDeatil, jsonObject);
//                break;
//            default:
//                resp = crudMethod(new StringBuilder(sqlDeatil), descprition, jsonObject);
//                break;
//        }
//        System.out.println();


//    }

//    public enum CRUD {
//        createTable, dropTable, insertData, insertDatas, updateData,
//        deleteData, selectData, pageData, getColname, deleteDatas,
//        updateDatas, tableJoin, selectTables;
//
//        public static CRUD toCRUD(String str) {
//            try {
//                return valueOf(str);
//            } catch (Exception ex) {
//                return null;
//            }
//        }
//    }

    //两表连接
    // {"data":"a.sssss as ss,b.uuuuu as uu","name1":"a","name2":"b"，"type":"left/right/inner","condition1":"a.id","condition2":"b.id"}
    // Type = tableJoin
    // SELECT ? from ? ? join ? on ? = ? ;
//    private JSONObject tableJoin(String sql, JSONObject jsonObject) throws SQLException {
//        Connection conn = null;
//        Statement stmt = null;
//
//        JSONObject respo = new JSONObject();
//        JSONArray myJsonArray = new JSONArray();
//
//        StringBuilder sq2 = new StringBuilder("");
//        String sq3;
//        try {
//            if (!isValid(jsonObject)) {
//                respo.put("result", "fail");
//                respo.put("msg", "失败，内容不通过验证！ ");
//                return respo;
//            }
//            sql = sql.replaceFirst("\\?", (String) jsonObject.get("data"));
//            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name1"));
//            sql = sql.replaceFirst("\\?", (String) jsonObject.get("type"));
//            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name2"));
//            sql = sql.replaceFirst("\\?", (String) jsonObject.get("condition1"));
//            sql = sql.replaceFirst("\\?", (String) jsonObject.get("condition2"));
////            sq3 = (String) jsonObject.get("valu");
////            String[] sq4 = sq3.split(",");
////            for(int i=0;i<sq4.length;i++){
////                sq2.append(jsonObject.getString("name")).append(".").append(sq4[i]);
////                sq2.append("=").append(jsonObject.getString("name1")).append(".").append(sq4[i]);
////                sq2.append(" and ");
////            }
////            sq2.deleteCharAt(sq2.length() - 1);
////            sq2.deleteCharAt(sq2.length() - 1);
////            sq2.deleteCharAt(sq2.length() - 1);
////            sq2.deleteCharAt(sq2.length() - 1);
////            sql=sql.replaceFirst("\\?", String.valueOf(sq2));
//            conn = getConnection();
//            stmt = getStatement(conn);
//            logger.debug("sql：" + sql);
//            ResultSet rs = stmt.executeQuery(sql);
//            ResultSetMetaData rsmd = rs.getMetaData();
//            String columnName, columnValue;
//            while (rs.next()) {
//                JSONObject json = new JSONObject();
//                for (int i = 0; i < rsmd.getColumnCount(); i++) {
//                    columnName = rsmd.getColumnName(i + 1);
//                    columnValue = rs.getString(columnName);
//                    json.put(columnName, columnValue);
//                }
//                myJsonArray.add(json);
//            }
//            respo.put("data", myJsonArray);
//            System.out.println("多表查询数据成功");
//            respo.put("result", 1);
//            respo.put("msg", "成功查询" + myJsonArray.size() + "条数据！");
//            rs.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            respo.put("result", "fail");
//            respo.put("msg", e.getMessage());
//        } finally {
//            close(conn, stmt);
//        }
//        return respo;
//    }


//    //新建数据表函数
//    // {"name":"tsee","json1":"VARCHAR(64)","json2":"int"}
//    //  Type=createTable
//    // CREATE TABLE ? ( id  varchar(64) PRIMARY KEY not null , update_date datetime null,create_date datetime null,create_by varchar(64) null,update_by varhcar(64) null,remarks varchar(255),delete_flag char null,?);
//    private JSONObject createTable(String sql, JSONObject jsonObject) throws SQLException {
//        Connection conn = null;
//        Statement stmt = null;
//
//        JSONObject respo = new JSONObject();
//        StringBuilder sq2 = new StringBuilder();
//
//        try {
//            respo = isValidTableName(jsonObject, respo);
//            if (respo.get("result") != null)
//                return respo;
//            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name"));
//            Iterator it = jsonObject.keys();
//            while (it.hasNext()) {
//                String key = it.next().toString();
//                if (!key.equals("name")) {
//                    sq2.append(key).append(" ").append(jsonObject.getString(key)).append(" ,");
//                }
//            }
//            sq2.deleteCharAt(sq2.length() - 1);
//
//            if (!isValid(sq2.toString())) {
//                respo.put("result", "fail");
//                respo.put("msg", "失败，表单内容不通过验证！ ");
//                return respo;
//            }
//            sql = sql.replaceFirst("\\?", String.valueOf(sq2));
//            System.out.println(sql);
//            //sql = "create table student(NO INTEGER not NULL AUTO_INCREMENT ,primary key(NO), name varchar(20))";
//            conn = getConnection();
//            stmt = getStatement(conn);
//            stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
//            logger.debug("创建数据表成功" + "sql：" + sql);
//            respo.put("result", "success");
//            respo.put("msg", "成功创建表\"" + jsonObject.get("name") + "\"");
//        } catch (Exception e) {
//            e.printStackTrace();
//            respo.put("result", "fail");
//            respo.put("msg", e.getMessage());
//        } finally {
//            close(conn, stmt);
//        }
//        return respo;
//    }

//    //删除数据表函数
//    // {"name":"ts发发发e"}
//    //  Type=dropTable
//    //  DROP TABLE ? ;
//    private JSONObject dropTable(String sql, JSONObject jsonObject) throws SQLException {
//        Connection conn = null;
//        Statement stmt = null;
//
//        JSONObject respo = new JSONObject();
//
//        try {
//            respo = isValidTableName(jsonObject, respo);
//            if (respo.get("result") != null)
//                return respo;
//            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name"));
//
//            System.out.println(sql);
//            conn = getConnection();
//            stmt = getStatement(conn);
//            stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
//            logger.debug("删除数据表成功" + "sql：" + sql);
//            respo.put("result", "success");
//            respo.put("msg", "成功删除表\"" + jsonObject.get("name") + "\"");
//        } catch (Exception e) {
//            e.printStackTrace();
//            respo.put("result", "fail");
//            respo.put("msg", e.getMessage());
//        } finally {
//            close(conn, stmt);
//        }
//        return respo;
//    }


//    //删除指定数据
//    // {"name":"lxf","id":"1"}
//    // Type=deleteData
//    // DELETE FROM ? WHERE id = ? ;
//    private JSONObject deleteData(String sql, JSONObject jsonObject) throws SQLException {
//
//        Connection conn = null;
//        Statement stmt = null;
//
//        JSONObject respo = new JSONObject();
//
//        StringBuilder sq2 = new StringBuilder();
//        try {
//            respo = isValidTableName(jsonObject, respo);
//            if (respo.get("result") != null)
//                return respo;
//            sql = sql.replaceFirst("\\?", (String) jsonObject.get("name"));
//            if (!isValid(jsonObject.get("id").toString())) {
//                respo.put("result", "fail");
//                respo.put("msg", "失败，删除数据的id不通过验证！ ");
//                return respo;
//            }
//            sql = sql.replaceFirst("\\?", "\"" + jsonObject.get("id").toString() + "\"");
//            conn = getConnection();
//            stmt = getStatement(conn);
//            logger.debug("sql：" + sql);
//            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
//            if (result != -1) {
//                logger.debug("删除数据成功");
//                respo.put("result", 1);
//                respo.put("msg", "成功删除" + result + "条数据！");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            respo.put("result", "fail");
//            respo.put("msg", e.getMessage());
//        } finally {
//            close(conn, stmt);
//        }
//        return respo;
// /    }

//    //查询数据表列名函数
//    // {"name":"lxf"}
//    //Type=getColname
//    //select COLUMN_NAME from information_schema.COLUMNS where table_name = '?' and table_schema = 'lab';
//    private JSONObject getColname(String sql, JSONObject jsonObject) throws SQLException {
//        Connection conn = null;
//        Statement stmt = null;
//        JSONArray myJsonArray = new JSONArray();
//        JSONObject respo = new JSONObject();
//
//        try {
//            respo = isValidTableName(jsonObject, respo);
//            if (respo.get("result") != null)
//                return respo;
//            sql = sql.replaceFirst("\\?", "\"" + (String) jsonObject.get("name") + "\"");
//
//            System.out.println(sql);
//            conn = getConnection();
//            stmt = getStatement(conn);
//            logger.debug("数据表列名查找成功" + "sql：" + sql.toString());
//            ResultSet rs = stmt.executeQuery(sql.toString());
//            ResultSetMetaData rsmd = rs.getMetaData();
//            String columnName, columnValue;
//            while (rs.next()) {
//                JSONObject json = new JSONObject();
//                for (int i = 0; i < rsmd.getColumnCount(); i++) {
//                    columnName = rsmd.getColumnName(i + 1);
//                    columnValue = rs.getString(columnName);
//                    json.put(columnName, columnValue);
//                }
//                myJsonArray.add(json);
//            }
//            respo.put("data", myJsonArray);
//            System.out.println("查询列名成功");
//            respo.put("result", "success");
//            respo.put("msg", "成功查询" + myJsonArray.size() + "条数据！");
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            respo.put("result", "fail");
//            respo.put("msg", e.getMessage());
//        } finally {
//            close(conn, stmt);
//        }
//        return respo;
//    }

}
