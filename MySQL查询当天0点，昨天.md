## MySQL查询当天0点，昨天

今天是

```
SELECT NOW();-- 2015-09-28 13:48:12
```

查询当天，格式为YYYY-MM-DD

```
SELECT CURDATE();-- 2015-09-28
```



查询当天，格式为YYYY-MM-DD HH:mm:ss

```
SELECT NOW();-- 2015-09-28 13:42:00
```



查询当天0点，格式为YYYY-MM-DD HH:mm:ss

```
SELECT DATE_FORMAT(CURDATE(),'%Y-%m-%d %H:%i:%s');-- 2015-09-28 00:00:00
```



查询当天早上9点，格式为YYYY-MM-DD HH:mm:ss

```
SELECT DATE_ADD(CURDATE(), INTERVAL 9 HOUR);-- 2015-09-28 09:00:00
```

查询昨天，格式为YYYY-MM-DD

```
SELECT DATE_SUB(CURDATE(),INTERVAL 1 DAY);-- 2015-09-27
```

查询昨天早上9点

```
SELECT DATE_ADD(DATE_SUB(CURDATE(),INTERVAL 1 DAY),INTERVAL 9 HOUR);-- 2015-09-27 09:00:00
```

DATE_ADD(date,INTERVAL expr type)date 参数是合法的日期表达式。expr 参数是您希望增加的时间。

type 参数可以是下列值：

| Type 值            |
| ------------------ |
| MICROSECOND        |
| SECOND             |
| MINUTE             |
| HOUR               |
| DAY                |
| WEEK               |
| MONTH              |
| QUARTER            |
| YEAR               |
| SECOND_MICROSECOND |
| MINUTE_MICROSECOND |
| MINUTE_SECOND      |
| HOUR_MICROSECOND   |
| HOUR_SECOND        |
| HOUR_MINUTE        |
| DAY_MICROSECOND    |
| DAY_SECOND         |
| DAY_MINUTE         |
| DAY_HOUR           |
| YEAR_MONTH         |

```
DATE_SUB(date,INTERVAL expr type)是在某一时间上减时间，用法与DATE_ADD类似
```

[](http://www.wiz.cn/i/47175d95)