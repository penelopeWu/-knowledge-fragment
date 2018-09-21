 
 
 
 
    /** 日期格式字符串常量 */
 public static final String PATTERN_DATE_YMD_FORMAT_DASH = "yyyy-MM-dd";
 
 
 
 private static final SimpleDateFormat sdf_date_format_dash = new SimpleDateFormat(
        PATTERN_DATE_YMD_FORMAT_DASH);
 

 
 
 /**
     * 比较两个日期相差的天数
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static int getMargin(String date1, String date2) {
        int margin;
        try {
            ParsePosition pos = new ParsePosition(0);
            ParsePosition pos1 = new ParsePosition(0);
            Date dt1 = sdf_date_format_dash.parse(date1, pos);
            Date dt2 = sdf_date_format_dash.parse(date2, pos1);
            long l = dt1.getTime() - dt2.getTime();
            margin = (int) (l / (24 * 60 * 60 * 1000));
            return margin;
        } catch (Exception e) {
            logger.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    public static int getMargin(Date date1, Date date2) {
        try {
            long l = date1.getTime() - date2.getTime();
            return (int) (l / (24 * 60 * 60 * 1000));
        } catch (Exception e) {
            logger.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    public static long getMarginTime(Date date1, Date date2) {
        long margin;
        try {
            margin = date1.getTime() - date2.getTime();
            return margin;
        } catch (Exception e) {
            logger.debug("DateUtil.getMarginTime():" + e.toString());
            return 0;
        }
    }

    public static double getDoubleMargin(String date1, String date2) {
        double margin;
        try {
            ParsePosition pos = new ParsePosition(0);
            ParsePosition pos1 = new ParsePosition(0);
            Date dt1 = sdf_datetime_format.parse(date1, pos);
            Date dt2 = sdf_datetime_format.parse(date2, pos1);
            long l = dt1.getTime() - dt2.getTime();
            margin = (l / (24 * 60 * 60 * 1000.00));
            return margin;
        } catch (Exception e) {
            logger.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }
