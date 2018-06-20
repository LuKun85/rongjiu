package com.company.core.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Description: 日期
 * @Author: weiwankun
 * @Date: 2018/4/15
 */
public class DateUtility {
    
    private static final long MILLIS_IN_A_SECOND  = 1000;
    
    private static final long SECONDS_IN_A_MINUTE = 60;
    
    private static final long MINUTES_IN_AN_HOUR  = 60;
    
    private static final long HOURS_IN_A_DAY      = 24;
    
    private static final int  DAYS_IN_A_WEEK      = 7;
    
    private static final int  MONTHS_IN_A_YEAR    = 12;
    
    private static final String fullTime = "yyyyMMddHHmmss";
    private static final String date = "yyyyMMdd";
    private static final String time = "HHmmss";
    private static final String lineDate = "yyyy-MM-dd";
    private static final String lineTime = "HH:mm:ss";
    
    /**
     * 判断两个时间是否相同
     *
     * @param date1 等待比较第一个时间
     * @param date2 等待比较第二个时间
     * @return 比较结果
     */
    public static boolean isSameDay(Date date1, Date date2) {
        return DateUtils.isSameDay(date1, date2);
    }
    
    /**
     * 比较两个日历类数据是否相同
     *
     * @param cal1 比较第一个日历类
     * @param cal2 比较第二个日历类
     * @return 比较结果
     */
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        return DateUtils.isSameDay(cal1, cal2);
    }
    
    /**
     * 新增年份
     *
     * @param date 需要新增时间
     * @param year 增加年份
     * @return 增加后年份
     */
    public static Date addYears(Date date, int year) {
        return DateUtils.addYears(date, year);
    }
    
    /**
     * 对时间格式进行格式化
     *
     * @param date 时间类型
     * @return yyyy-MM-dd
     */
    public static String format(Date date) {
        return DateFormatUtils.format(date, DateFormatUtils.ISO_DATE_FORMAT
                .getPattern());
    }
    
    /**
     * 对时间格式进行格式化
     *
     * @param date 时间类型
     * @return yyyy-MM-dd'T'HH:mm:ss
     */
    public static String formatDate(Date date) {
        return DateFormatUtils.format(date, DateFormatUtils.ISO_DATETIME_FORMAT
                .getPattern());
    }
    
    /**
     * 格式化时间
     *
     * @param date    时间参数
     * @param pattern 格式化参数类型
     * @return
     */
    public static String format(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }
    
    /**
     * 格式化时间参数
     *
     * @param date 时间参数
     * @return HH:mm:ss
     */
    public static String formatTime(Date date) {
        return DateFormatUtils.format(date,
                DateFormatUtils.ISO_TIME_NO_T_FORMAT.getPattern());
    }
    
    /**
     * 增加月份
     *
     * @param date  传入时间
     * @param month 需要增加月份
     * @return 增加月份
     */
    public static Date addMonths(Date date, int month) {
        return DateUtils.addMonths(date, month);
    }
    
    /**
     * 增加周
     *
     * @param date   当前时间
     * @param amount 需要增加周
     * @return 增加后时间
     */
    public static Date addWeeks(Date date, int amount) {
        return DateUtils.addWeeks(date, amount);
    }
    
    /**
     * 增加天
     *
     * @param date   当前时间
     * @param amount 需要增加天数
     * @return 增加后时间
     */
    public static Date addDays(Date date, int amount) {
        return DateUtils.addDays(date, amount);
    }
    
    /**
     * 增加小时
     *
     * @param date   当前时间
     * @param amount 增加小时数
     * @return 增加后时间
     */
    public static Date addHours(Date date, int amount) {
        return DateUtils.addHours(date, amount);
    }
    
    /**
     * 增加分钟
     *
     * @param date   当前时间
     * @param amount 增加分钟数
     * @return 增加后时间
     */
    public static Date addMinutes(Date date, int amount) {
        return DateUtils.addHours(date, amount);
    }
    
    /**
     * 增加秒
     *
     * @param date   当前时间
     * @param amount 增加秒数
     * @return 增加后时间
     */
    public static Date addSeconds(Date date, int amount) {
        return DateUtils.addSeconds(date, amount);
    }
    
    /**
     * 添加毫秒
     *
     * @param date   当前时间
     * @param amount 增加毫秒
     * @return 增加后时间
     */
    public static Date addMilliseconds(Date date, int amount) {
        return DateUtils.addMilliseconds(date, amount);
    }
    
    /**
     * 设置年分 修改传入时间年份为amount
     *
     * @param date   当前时间
     * @param amount 设置年份 传入Int类型
     * @return 设置后时间
     */
    public static Date setYears(Date date, int amount) {
        return DateUtils.setYears(date, amount);
    }
    
    /**
     * 设置月份
     *
     * @param date   当前时间
     * @param amount 设置月份 传入Int类型
     * @return 设置月份后时间
     */
    public static Date setMonths(Date date, int amount) {
        return DateUtils.setMonths(date, amount);
    }
    
    /**
     * 设置天数
     *
     * @param date   当前时间
     * @param amount 设置天数 传入Int类型
     * @return 设置后时间
     */
    public static Date setDays(Date date, int amount) {
        return DateUtils.setDays(date, amount);
    }
    
    /**
     * 设置小时数
     *
     * @param date   当前时间
     * @param amount 设置小时 传入Int类型
     * @return 设置后时间
     */
    public static Date setHours(Date date, int amount) {
        return DateUtils.setHours(date, amount);
    }
    
    /**
     * 设置分钟
     *
     * @param date   当前时间
     * @param amount 设置分钟数
     * @return 设置后时间
     */
    public static Date setMinutes(Date date, int amount) {
        return DateUtils.setMinutes(date, amount);
    }
    
    /**
     * 时间日历类转换
     *
     * @param date 时间类型
     * @return 日类类型
     */
    public static Calendar toCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }
    
    /**
     * 设置分钟数
     *
     * @param date   时间类型
     * @param amount 设置分钟数
     * @return 设置后时间
     */
    public static Date round(Date date, int amount) {
        return DateUtils.setMinutes(date, amount);
    }
    
    /**
     * 获取传入时间的周一
     *
     * @param date 当前时间
     * @return 返回传入时间当周星期一
     */
    public static Date getNowWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        cal.add(Calendar.DAY_OF_MONTH, -1); //解决周日会出现 并到下一周的情况
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        
        return cal.getTime();
    }
    
    public static String getNowWeekMondayStr(Date date, String format) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        cal.add(Calendar.DAY_OF_MONTH, -1); //解决周日会出现 并到下一周的情况
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(cal.getTime());
    }
    
    /**
     * 查询当周周日
     *
     * @param date 当前时间
     * @return 当周周日
     */
    public static Date getNowWeekSunday(Date date) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.add(Calendar.WEEK_OF_YEAR, 1);// 一周
        cal.set(Calendar.DAY_OF_WEEK, 1);
        
        return cal.getTime();
    }
    public static String getNowWeekSundayStr(Date date, String format) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.add(Calendar.WEEK_OF_YEAR, 1);// 一周
        cal.set(Calendar.DAY_OF_WEEK, 1);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(cal.getTime());
    }
    
    /**
     * 获取传入时间下周一
     *
     * @param date 当前时间
     * @return 返回下周一日期
     */
    public static Date getNextWeekMonday(Date date) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.add(Calendar.WEEK_OF_YEAR, 1);// 一周
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        
        return cal.getTime();
    }
    
    /**
     * 查询下周周日
     *
     * @param date 当前时间
     * @return 返回下周周日
     */
    public static Date getNextWeekSunday(Date date) {
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.WEEK_OF_YEAR, 1);// 一周
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        
        return cal.getTime();
    }
    
    
    /**
     * 获取传入时间的上周一
     *
     * @param date 当前时间
     * @return 返回上周一时间
     */
    public static Date getLastWeekMonday(Date date) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.add(Calendar.WEEK_OF_YEAR, -1);// 一周
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        
        return cal.getTime();
    }
    public static String getLastWeekMondayStr(Date date, String format) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.add(Calendar.WEEK_OF_YEAR, -1);// 一周
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(cal.getTime());
    }
    /**
     * 查询上周周日
     *
     * @param date 当前时间
     * @return 返回上周周日
     */
    public static Date getLastWeekSunday(Date date) {
        
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.set(Calendar.DAY_OF_WEEK, 1);
        
        return cal.getTime();
    }
    
    public static String getLastWeekSundayStr(Date date, String format) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.set(Calendar.DAY_OF_WEEK, 1);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(cal.getTime());
    }
    /**
     * 返回当月第一天
     *
     * @param date 当前时间
     * @return 返回当月第一天
     */
    public static Date getNowMonthFirstDay(Date date) {
        return setDays(date, 1);
    }


//    ==========================
    
    /**
     * 计算指定日期的前一天
     *
     * @param date
     * @return
     */
    public static Date getPrevDay(Date date) {
        return DateUtils.addDays(date, -1);
    }
    
    public static Date getPrevDayn(Date date, int n) {
        return DateUtils.addDays(date, -n);
    }
    
    public static String getPrevDaynStr(Date date, int n, String format) {
        Date d = DateUtils.addDays(date, -n);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(d.getTime());
    }
    
    public static String getPrevDayn(String date, String format, int n) {
        try {
            String parseString = parseString(date, format);
            Date parseDate = parseDate(parseString);
            Date prevDayn = getPrevDayn(parseDate, n);
            return parseString(prevDayn, format);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }
    
    
    /**
     * 获取今天 时间格式
     */
    public static String getCurrentTime() {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(time);
        return dateFormat.format(now.getTime());
    }
    
    /**
     * 获取今天 日期格式
     */
    public static Date getToday() {
        Calendar now = Calendar.getInstance();
        return now.getTime();
    }
    
    /**
     * 获取今天字符串
     */
    public static String getTodayStr() {
        return "20180416";
    
//        Calendar now = Calendar.getInstance();
//        SimpleDateFormat dateFormat = new SimpleDateFormat(date);
//        return dateFormat.format(now.getTime());
    }
    
    /**
     * 获取昨天 日期格式
     */
    public static Date getYesterday() {
        Calendar now = Calendar.getInstance();
        return DateUtils.addDays(now.getTime(), -1);
    }
    /**
     * 获取昨天 字符串
     */
    public static String getYesterdayStr() {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(date);
        Date yesterday = DateUtils.addDays(now.getTime(), -1);
        return dateFormat.format(yesterday);
    }
    
    /**
     * 计算指定日期的后一天
     *
     * @param date
     * @return
     */
    public static Date getNextDay(Date date) {
        return DateUtils.addDays(date, 1);
    }
    
    
    /**
     * 判断date1是否在date2之后，忽略时间部分
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isDateAfter(Date date1, Date date2) {
        Date theDate1 = DateUtils.truncate(date1, Calendar.DATE);
        Date theDate2 = DateUtils.truncate(date2, Calendar.DATE);
        return theDate1.after(theDate2);
    }
    
    /**
     * 判断date1是否在date2之前，忽略时间部分
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isDateBefore(Date date1, Date date2) {
        return isDateAfter(date2, date1);
    }
    
    /**
     * 判断time1是否在time2之后，忽略日期部分
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isTimeAfter(Date time1, Date time2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(time1);
        calendar1.set(1900, 1, 1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(time2);
        calendar2.set(1900, 1, 1);
        return calendar1.after(calendar2);
    }
    
    /**
     * 判断time1是否在time2之前，忽略日期部分
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isTimeBefore(Date time1, Date time2) {
        return isTimeAfter(time2, time1);
    }
    
    /**
     * 将字符串形式的日期表示解析为日期对象
     *
     * @param dateString
     * @return
     */
    public static Date parseDate(String dateString) {
        try {
            return DateUtils.parseDate(dateString,
                    new String[]{"yyyy-MM-dd", "yyyy-M-d", "yyyy-MM-d", "yyyy-M-dd", "yyyyMMdd",
                            "yyyyMMd", "yyyyMd", "yyyyMdd"});
        } catch (ParseException e) {
            return null;
        }
    }
    
    public static String parseString(Date date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format); // 格式日期
            TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai"); // 时区
            sdf.setTimeZone(timezone);
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static String parseString(String date, String format) {
        Date parseDate = parseDate(date);
        return parseString(parseDate, format);
    }
    
    public static String parseDateTimeString(String date, String format) {
        Date parseDate = parseDateTime(date);
        return parseString(parseDate, format);
    }
    
    /**
     * 将字符串形式的时间表示解析为日期时间对象
     *
     * @param timeString
     * @return
     */
    public static Date parseTime(String timeString) {
        try {
            return DateUtils.parseDate(timeString,
                    new String[]{"hh:mm:ss", "h:m:s", "hh:mm", "h:m"});
        } catch (ParseException e) {
            return null;
        }
    }
    
    /**
     * 将字符串形式的日期时间表示解析为时间对象
     *
     * @param timeString
     * @return
     */
    public static Date parseDateTime(String timeString) {
        try {
            return DateUtils.parseDate(timeString,
                    new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-M-d H:m:s", "yyyy-MM-dd H:m:s",
                            "yyyy-M-d HH:mm:ss", "yyyyMMddHHmmss"});
        } catch (ParseException e) {
            return null;
        }
    }
    
    public static Date ParseDateTimeFormat(String time, String format) {
        try {
            return DateUtils.parseDate(time, format);
        } catch (ParseException e) {
            return null;
        }
    }
    
    /**
     * 计算两个日期之间包含的星期X的天数。
     *
     * @param fromDate  起始日期
     * @param toDate    结束日期
     * @param dayOfWeek 星期，例如星期三，星期四
     * @return
     */
    public static int getWeekDaysBetween(Date fromDate, Date toDate, int dayOfWeek) {
        int result = 0;
        Date firstDate = getFirstWeekdayBetween(fromDate, toDate, dayOfWeek);
        if (firstDate == null) {
            return 0;
        }
        Calendar aDay = Calendar.getInstance();
        aDay.setTime(firstDate);
        while (aDay.getTime().before(toDate)) {
            result++;
            aDay.add(Calendar.DATE, DAYS_IN_A_WEEK);
        }
        return result;
    }
    
    /**
     * 获取在两个日期之间的第一个星期X
     *
     * @param fromDate  起始日期
     * @param toDate    结束日期
     * @param dayOfWeek 星期，例如星期三，星期四
     * @return
     */
    public static Date getFirstWeekdayBetween(Date fromDate, Date toDate, int dayOfWeek) {
        Calendar aDay = Calendar.getInstance();
        aDay.setTime(fromDate);
        while (aDay.getTime().before(toDate)) {
            if (aDay.get(Calendar.DAY_OF_WEEK) == dayOfWeek) {
                return aDay.getTime();
            }
            aDay.add(Calendar.DATE, 1);
        }
        return null;
    }
    
    /**
     * 取得参数year指定的年份的总天数
     *
     * @param year
     * @return
     */
    public static int getDaysInYear(int year) {
        Calendar aDay = Calendar.getInstance();
        aDay.set(year, 1, 1);
        Date from = aDay.getTime();
        aDay.set(year + 1, 1, 1);
        Date to = aDay.getTime();
        return getDayDiff(from, to);
    }
    
    /**
     * 取得指定年月的总天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getDaysInMonth(int year, int month) {
        Calendar aDay = Calendar.getInstance();
        aDay.set(year, month, 1);
        Date from = aDay.getTime();
        if (month == Calendar.DECEMBER) {
            aDay.set(year + 1, Calendar.JANUARY, 1);
        } else {
            aDay.set(year, month + 1, 1);
        }
        Date to = aDay.getTime();
        return getDayDiff(from, to);
    }
    
    /**
     * 获得指定日期的年份
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        return getFieldValue(date, Calendar.YEAR);
    }
    
    /**
     * 获得指定日期的月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        return getFieldValue(date, Calendar.MONTH) + 1;
    }
    
    /**
     * 获得指定日期是当年的第几天
     *
     * @param date
     * @return
     */
    public static int getDayOfYear(Date date) {
        return getFieldValue(date, Calendar.DAY_OF_YEAR);
    }
    
    /**
     * 获得指定日期是当月的第几天
     *
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        return getFieldValue(date, Calendar.DAY_OF_MONTH);
    }
    
    /**
     * 获得指定日期是当周的第几天
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        return getFieldValue(date, Calendar.DAY_OF_WEEK);
    }
    
    private static int getFieldValue(Date date, int field) {
        if (date == null) {
            throw new InvalidParameterException("date cannot be null!");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(field);
    }
    
    /**
     * 获得指定日期之后一段时期的日期。例如某日期之后3天的日期等。
     *
     * @param origDate 基准日期
     * @param amount   时间数量
     * @param timeUnit 时间单位，如年、月、日等。用Calendar中的常量代表
     * @return
     */
    public static final Date dateAfter(Date origDate, int amount, int timeUnit) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(origDate);
        calendar.add(timeUnit, amount);
        return calendar.getTime();
    }
    
    /**
     * 获得指定日期之前一段时期的日期。例如某日期之前3天的日期等。
     *
     * @param origDate 基准日期
     * @param amount   时间数量
     * @param timeUnit 时间单位，如年、月、日等。用Calendar中的常量代表
     * @return
     */
    public static final Date dateBefore(Date origDate, int amount, int timeUnit) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(origDate);
        calendar.add(timeUnit, -amount);
        return calendar.getTime();
    }
    
    public static final void midnight(Date d) {
        d.setHours(0);
        d.setMinutes(0);
        d.setSeconds(0);
    }
    
    public static final void lastSecond(Date d) {
        d.setHours(23);
        d.setMinutes(59);
        d.setSeconds(59);
        
    }
    
    /**
     * 最小日期，设定为1000年1月1日
     */
    public static final Date  MIN_DATE            = date(1000, 1, 1);
    
    /**
     * 最大日期，设定为8888年1月1日
     */
    public static final Date  MAX_DATE            = date(8888, 1, 1);
    
    /**
     * 根据年月日构建日期对象。注意月份是从1开始计数的，即month为1代表1月份。
     *
     * @param year
     *            年
     * @param month
     *            月。注意1代表1月份，依此类推。
     */
    public static Date date(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, date, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    
    /**
     * 计算两个日期（不包括时间）之间相差的周年数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getYearDiff(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new InvalidParameterException("date1 and date2 cannot be null!");
        }
        if (date1.after(date2)) {
            throw new InvalidParameterException("date1 cannot be after date2!");
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        int year1 = calendar.get(Calendar.YEAR);
        int month1 = calendar.get(Calendar.MONTH);
        int day1 = calendar.get(Calendar.DATE);
        
        calendar.setTime(date2);
        int year2 = calendar.get(Calendar.YEAR);
        int month2 = calendar.get(Calendar.MONTH);
        int day2 = calendar.get(Calendar.DATE);
        
        int result = year2 - year1;
        if (month2 < month1) {
            result--;
        } else if (month2 == month1 && day2 < day1) {
            result--;
        }
        return result;
    }
    
    /**
     * 计算两个日期（不包括时间）之间相差的整月数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthDiff(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new InvalidParameterException("date1 and date2 cannot be null!");
        }
        if (date1.after(date2)) {
            throw new InvalidParameterException("date1 cannot be after date2!");
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        int year1 = calendar.get(Calendar.YEAR);
        int month1 = calendar.get(Calendar.MONTH);
        int day1 = calendar.get(Calendar.DATE);
        
        calendar.setTime(date2);
        int year2 = calendar.get(Calendar.YEAR);
        int month2 = calendar.get(Calendar.MONTH);
        int day2 = calendar.get(Calendar.DATE);
        
        int months = 0;
        if (day2 >= day1) {
            months = month2 - month1;
        } else {
            months = month2 - month1 - 1;
        }
        return (year2 - year1) * MONTHS_IN_A_YEAR + months;
    }
    
    /**
     * 统计两个日期之间包含的天数。包含date1，但不包含date2
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDayDiff(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new InvalidParameterException("date1 and date2 cannot be null!");
        }
        Date startDate = DateUtils.truncate(date1, Calendar.DATE);
        Date endDate = DateUtils.truncate(date2, Calendar.DATE);
        if (startDate.after(endDate)) {
            throw new InvalidParameterException("date1 cannot be after date2!");
        }
        long millSecondsInOneDay = HOURS_IN_A_DAY * MINUTES_IN_AN_HOUR * SECONDS_IN_A_MINUTE
                * MILLIS_IN_A_SECOND;
        return (int) ((endDate.getTime() - startDate.getTime()) / millSecondsInOneDay);
    }
    
    /**
     * 计算time2比time1晚多少分钟，忽略日期部分
     *
     * @param time1
     * @param time2
     * @return
     */
    public static int getMinuteDiffByTime(Date time1, Date time2) {
        long startMil = 0;
        long endMil = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time1);
        calendar.set(1900, 1, 1);
        startMil = calendar.getTimeInMillis();
        calendar.setTime(time2);
        calendar.set(1900, 1, 1);
        endMil = calendar.getTimeInMillis();
        return (int) ((endMil - startMil) / MILLIS_IN_A_SECOND / SECONDS_IN_A_MINUTE);
    }
    
    /**
     * @Description: 切换日期格式
     * @Author: weiwankun
     * @Date: 2018/4/16
     */
    public static String getTimeStamp(String datetime) {
    
        try {
            Date date = new SimpleDateFormat("yyyyMMdd HHmmss").parse(datetime);
            long unixTimestamp = date.getTime();
            return String.valueOf(unixTimestamp);
            
        } catch (Exception e) {
            return null;
        }
    }
    
}
