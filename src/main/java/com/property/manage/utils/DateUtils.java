package com.property.manage.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ClassName: Base64Utils
 * @description: Date工具类
 * @author: sunzhengwei
 * @create: 2020/7/9
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd");;
    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM", "yyyyMMdd","yyyyMMddHHmmss"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 得到当前日期的月份
     */
    public static String getYearMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return sdf.format(cal.getTime());
    }

    /**
     * 得到当前日期的上个月月份
     */
    public static String getLastYearMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return sdf.format(cal.getTime());
    }

    public static String getLastYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -1);
        return sdf.format(cal.getTime());
    }

    public static String getLastYear(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -1);
        int year = cal.get(Calendar.YEAR);
        return String.valueOf(year);
    }

    /**
     * 得到月份的下个月月份
     */
    public static String getNextYearMonth(String month) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = sdf.parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        return sdf.format(cal.getTime());
    }

    /**
     * 月份字符串转换为日期
     */
    public static Date getYearMonth(String month) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = sdf.parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 得到当前日期的后N个月月份
     */
    public static String getNextYearMonth(int n, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        if (date == null)
            date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return sdf.format(cal.getTime());
    }

    /**
     * 得到当前日期的前/后N个月月份
     */
    public static String getNextNMonth(int n, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            Date theDate = sdf.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(theDate);
            cal.add(Calendar.MONTH, n);
            return sdf.format(cal.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    //返回某个日期下几天的日期
    public static Date getNextDay(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
        return cal.getTime();
    }

    //返回某个日期前几天的日期
    public static Date getBeforeDay(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
        return cal.getTime();
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
     * "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = timeMillis / (60 * 60 * 1000) - day * 24;
        long min = (timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60;
        long s = timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60;
        long sss = timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000;
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 将毫秒转换为format格式的字符串
     * @param timeMillis
     * @param format
     * @return
     */
    public static String longConvert2Str(long timeMillis,String format){
        Date date = new Date(timeMillis);
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * 根据用户生日计算年龄;
     * 汇安德: 生日当日不允许投保【万一出现当天不能及时录入保单的情况（生日当天，年龄不 +1）】
     * 假如1990-06-17出生，若今天2019-06-17 算 28，生日当天年龄不+1
     * 1990-06-17出生，若今天2019-06-18 算 29,生日当天年龄 +1
     * 1990-06-17出生，若今天2019-06-16 算 28
     */
    public static int getAgeByBirthday(Date birthday) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow <= dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }

    /**
     * 根据用户生日计算天数
     */
    public static int getDayByBirthday(Date birthday) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int temp = daysOfTwo(Calendar.getInstance().getTime(), birthday);
        return temp;
    }

    /**
     * 根据用户生日计算年龄
     * 年龄：小于3个月按天算，比如：65天。大于3个月小于3年的按月算，比如：24月。大于3年的按岁算：比如：6岁。
     */
    public static String getSpecialAgeByBirthday(Date birthday) {
        if (null != birthday) {
            Calendar cal = Calendar.getInstance();
            if (cal.before(birthday)) {
                throw new IllegalArgumentException(
                        "The birthDay is before Now.It's unbelievable!");
            }
            int temp = daysOfTwo(Calendar.getInstance().getTime(), birthday);
            //小于3个月按天算
            if (temp < 30 * 3) {
                return temp + "天";
            }
            //大于3个月小于3年的按月算
            if (temp >= 30 * 3 && temp < 365 * 3) {
                return temp / 30 + "月";
            }
            //大于3年的按岁算
            if (temp >= 365 * 3) {
                int yearNow = cal.get(Calendar.YEAR);
                int monthNow = cal.get(Calendar.MONTH) + 1;
                int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
                cal.setTime(birthday);
                int yearBirth = cal.get(Calendar.YEAR);
                int monthBirth = cal.get(Calendar.MONTH) + 1;
                int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
                int age = yearNow - yearBirth;
                if (monthNow <= monthBirth) {
                    if (monthNow == monthBirth) {
                        if (dayOfMonthNow <= dayOfMonthBirth) {
                            age--;
                        }
                    } else {
                        age--;
                    }
                }
                return age + "周岁";
            }

        }

        return "";
    }

    /**
     * 根据天数计算年龄
     * 年龄：小于3个月按天算，比如：65天。大于3个月小于3年的按月算，比如：24月。大于3年的按岁算：比如：6岁。
     */
    public static String getSpecialAgeByDay(int day) {
        Calendar tmpCal = Calendar.getInstance();
        tmpCal.set(Calendar.DATE, tmpCal.get(Calendar.DATE) - day);
        Date birthday = tmpCal.getTime();
        Calendar cal = Calendar.getInstance();
        int temp = daysOfTwo(Calendar.getInstance().getTime(), birthday);
        //小于3个月按天算
        if (temp < 30 * 3) {
            return temp + "天";
        }
        //大于3个月小于3年的按月算
        if (temp >= 30 * 3 && temp < 365 * 3) {
            return temp / 30 + "月";
        }
        //大于3年的按岁算
        if (temp >= 365 * 3) {
            int yearNow = cal.get(Calendar.YEAR);
            int monthNow = cal.get(Calendar.MONTH) + 1;
            int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
            cal.setTime(birthday);
            int yearBirth = cal.get(Calendar.YEAR);
            int monthBirth = cal.get(Calendar.MONTH) + 1;
            int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
            int age = yearNow - yearBirth;
            if (monthNow <= monthBirth) {
                if (monthNow == monthBirth) {
                    if (dayOfMonthNow <= dayOfMonthBirth) {
                        age--;
                    }
                } else {
                    age--;
                }
            }
            return age + "周岁";
        }
        return "";
    }

    /**
     * @param firstDate
     * @param secondDate
     * @Description:比较两个时间点 如果secondDate表示的时间等于此 firstDate 表示的时间，则返回 0 值；
     * 如果此 firstDate 的时间在参数<secondDate>表示的时间之前，则返回小于 0 的值；
     * 如果此 firstDate 的时间在参数<secondDate>表示的时间之后，则返回大于 0 的值
     * @ReturnType int
     * @author:
     * @Created 2012 2012-9-20上午08:34:33
     */
    public static int compare(Date firstDate, Date secondDate) {
        Calendar firstCalendar = null;
        /**使用给定的 Date 设置此 Calendar 的时间。**/
        if (firstDate != null) {
            firstCalendar = Calendar.getInstance();
            firstCalendar.setTime(firstDate);
        } else {
            throw new IllegalArgumentException("firstDate为空");
        }
        Calendar secondCalendar = null;
        /**使用给定的 Date 设置此 Calendar 的时间。**/
        if (firstDate != null) {
            secondCalendar = Calendar.getInstance();
            secondCalendar.setTime(secondDate);
        }
        /**
         * 比较两个 Calendar 对象表示的时间值（从历元至现在的毫秒偏移量）。
         * 如果参数表示的时间等于此 Calendar 表示的时间，则返回 0 值；
         * 如果此 Calendar 的时间在参数表示的时间之前，则返回小于 0 的值；
         * 如果此 Calendar 的时间在参数表示的时间之后，则返回大于 0 的值
         * **/
        if (firstCalendar == null) {
            throw new IllegalArgumentException("firstDate为空");
        }
        return firstCalendar.compareTo(secondCalendar);
    }

    /**
     * @param firstDate
     * @param secondDate
     * @return
     * @Description:判断<firstDate>时间点是否在<secondDate>时间点之前 如果此 firstDate 的时间在参数<secondDate>表示的时间之前，则返回小于 0 的值
     * @ReturnType boolean
     * @author:
     * @Created 2012 2012-9-20上午08:40:33
     */
    public static boolean isBefore(Date firstDate, Date secondDate) {
        return compare(firstDate, secondDate) < 0 ? true : false;
    }

    /**
     * @param firstDate
     * @param secondDate
     * @Description:判断<firstDate>时间点是否在<secondDate>时间点之后 如果此 firstDate 的时间在参数<secondDate>表示的时间之后，则返回大于 0 的值
     * @ReturnType boolean
     * @author:
     * @Created 2012 2012-9-20上午08:38:48
     */
    public static boolean isAfter(Date firstDate, Date secondDate) {
        return compare(firstDate, secondDate) > 0 ? true : false;
    }

    /**
     * @param firstDate
     * @param secondDate
     * @Description:比较两个时间点是否相等
     * @ReturnType boolean
     * @author:
     * @Created 2012 2012-9-20上午08:37:30
     */
    public static boolean isEqual(Date firstDate, Date secondDate) {
        return compare(firstDate, secondDate) == 0 ? true : false;
    }

    /**
     * 自己相差的天数
     *
     * @param fDate
     * @param oDate
     * @return
     */
    public static int daysOfTwo(Date fDate, Date oDate) {
        if (null == fDate || null == oDate) {
            return -1;
        }
        long intervalMilli = fDate.getTime() - oDate.getTime();
        return (int) (intervalMilli / (24 * 60 * 60 * 1000));
    }

    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            // System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }

    /**
     * 自己相差的秒数
     *
     * @param fDate
     * @param oDate
     * @return
     */
    public static int sencondsOfTwo(Date fDate, Date oDate) {
        if (null == fDate || null == oDate) {
            return -1;
        }
        long intervalMilli = fDate.getTime() - oDate.getTime();
        return (int) (intervalMilli / (1000));
    }

    /**
     * 根据指定的时间显示格式，将一个Date显示成指定格式的时间字符串。
     *
     * @param date   表示时间的Date对象
     * @param format 表示时间的显示格式字符串：如"yyyyMMdd"或"yyyyMMdd HH:mm"
     * @return 指定格式的时间字符串
     */
    public static String format(Date date, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    /**
     * 将一个Calendar对象转换成指定时间显示格式的字符串
     *
     * @param cal    输入字符串
     * @param format 时间显示格式：如"yyyyMMdd"或"yyyyMMdd HH:mm"，则返回标准时间格式的字符串 "long"，则返回long型值的字符串
     * @return 指定时间显示格式的字符串
     */
    public static String calendarToString(Calendar cal, String format) {
        if (format.equals("long")) {
            return String.valueOf(cal.getTime().getTime());
        }

        return format(cal.getTime(), format);
    }

    /**
     * 将当前时间以时间显示格式的字符串返回
     *
     * @param format 时间显示格式：如"yyyyMMdd"或"yyyyMMdd HH:mm"，则返回标准时间格式的字符串 "long"，则返回long型值的字符串
     * @return 指定的时间显示格式的当前时间字符串
     */
    public static String getCurrentTimeStr(String format) {
        Calendar cl = Calendar.getInstance();
        return calendarToString(cl, format);
    }

    /**
     * 获取当天开始时间
     *
     * @return
     */
    public static Date getDateStartToday() {
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        return (Date) currentDate.getTime().clone();
    }


    /**
     * 获取当天结束时间
     *
     * @return
     */
    public static Date getDateLastToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 比对是不是同一天
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean sameDate(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);
        return cal1.getTime().equals(cal2.getTime());
    }

    /**
     * 获取小时
     *
     * @return
     */
    public static String getTimeMinute() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String curtime = sdf.format(new Date());
        return curtime;
    }
    /**
     * 获取当前月的第一天
     *
     * @return
     */
    public static String getfirstDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String curtime = sdf.format(cal.getTime());
        return curtime;
    }

    /**
     * 获取上个月第一天
     *
     * @return
     */
    public static Date getLastMonthFirstDay() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        // 时
        cal.set(Calendar.HOUR_OF_DAY, 0);
        // 分
        cal.set(Calendar.MINUTE, 0);
        // 秒
        cal.set(Calendar.SECOND, 0);
        // 毫秒
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取上个月最后一天
     *
     * @return
     */
    public static Date getLastMonthLastDay() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH,1); // 先将日期设置为本月的第一天，然后减去一天就变成了上个月的最后一天了
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * 判断时间是上午还是下午
     * @param date
     * @return am/pm
     */
    public static String judgeAmPm(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (Calendar.AM == cal.get(Calendar.AM_PM)) {
            return "am";
        }
        return "pm";
    }

    /**
     * 获取年
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * 取得季度对应每个月的第一天
     * 如["2017-10-01 00:00:00","2017-11-01 00:00:00","2017-12-01 00:00:00"]
     * @param date
     * @return
     */
    public static Date[] getSeasonDate(Date date) {
        Date[] season = new Date[3];

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int nSeason = getSeason(date);
        if (nSeason == 1) {// 第一季度
            c.set(Calendar.MONTH, Calendar.JANUARY);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.FEBRUARY);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.MARCH);
            season[2] = c.getTime();
        } else if (nSeason == 2) {// 第二季度
            c.set(Calendar.MONTH, Calendar.APRIL);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.MAY);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.JUNE);
            season[2] = c.getTime();
        } else if (nSeason == 3) {// 第三季度
            c.set(Calendar.MONTH, Calendar.JULY);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.AUGUST);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.SEPTEMBER);
            season[2] = c.getTime();
        } else if (nSeason == 4) {// 第四季度
            c.set(Calendar.MONTH, Calendar.OCTOBER);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.NOVEMBER);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.DECEMBER);
            season[2] = c.getTime();
        }
        return season;
    }

    /**
     * 1 第一季度 2 第二季度 3 第三季度 4 第四季度
     *
     * @param date
     * @return
     */
    public static int getSeason(Date date) {
        int season = 0;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;
        }
        return season;
    }

    public static int getLastSeason(Date date) {
        int season = 0;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 4;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 1;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 2;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 3;
                break;
            default:
                break;
        }
        return season;
    }

    /**
     * 获取上个季度
     * @param date
     * @return
     */
    public static String getLastSeasonFormat(Date date) {
        int season = 0;
        String yearSeason = "";
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int yearNow = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        c.add(Calendar.YEAR, -1);
        int yearLast = c.get(Calendar.YEAR);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                yearSeason = yearLast + "-S4";
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                yearSeason = yearNow + "-S1";
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                yearSeason = yearNow + "-S2";
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                yearSeason = yearNow + "-S3";
                break;
            default:
                break;
        }
        return yearSeason;
    }

    /**
     * 获取本季度
     * @param date
     * @return
     */
    public static String getSeasonFormat(Date date) {
        String yearSeason = "";
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int yearNow = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        c.add(Calendar.YEAR, -1);
        int yearLast = c.get(Calendar.YEAR);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:

                yearSeason = yearLast + "-S1";
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:

                yearSeason = yearNow + "-S2";
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                yearSeason = yearNow + "-S3";
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:

                yearSeason = yearNow + "-S4";
                break;
            default:
                break;
        }
        return yearSeason;
    }

    public static String getLastSeasonYear(Date date) {
        String yearSeason = "";
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int yearNow = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        c.add(Calendar.YEAR, -1);
        int yearLast = c.get(Calendar.YEAR);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                yearSeason = yearLast + "";
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                yearSeason = yearNow + "";
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                yearSeason = yearNow + "";
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                yearSeason = yearNow + "";
                break;
            default:
                break;
        }
        return yearSeason;
    }

    public static boolean checkIsSeasonBeginMonth(Date date) {
        boolean flag = false;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.APRIL:
            case Calendar.JULY:
            case Calendar.OCTOBER:
                flag = true;
                break;
            default:
                break;
        }
        return flag;
    }

    /**
     * 当前季度的开始时间
     *
     * @return
     */
    public static String getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        String now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 6);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = DateFormatUtils.format(c.getTime(), "yyyy-MM-dd");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }


    /**
     * 取得第几个月
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONDAY);
        return month + 1;
    }

    /**
     * 取得是第几周
     *
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int week = c.get(Calendar.WEEK_OF_YEAR);
        return week - 1;
    }

    /**
     * 取得是第几周(周一设成第一天)
     *
     * @param date
     * @return
     */
    public static int getWeekByChina(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        int week = c.get(Calendar.WEEK_OF_YEAR);
        return week - 1;
    }

    /**
     * 取得是周几
     *
     * @param date
     * @return
     */
    public static int getWeekDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK);
        return day_of_week - 1;
    }

    /**
     * 取得是一月中第几天
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day_of_year = c.get(Calendar.DAY_OF_MONTH);
        return day_of_year;
    }

    /**
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int hour = c.get(Calendar.HOUR);
        return hour;
    }

    /**
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int minute = c.get(Calendar.MINUTE);
        return minute;
    }

    /**
     * @param date
     * @return
     */
    public static int getSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int second = c.get(Calendar.SECOND);
        return second;
    }

    /***
     * 根据传入日期获取日期的开始时间
     *
     * @param date
     * @return
     */
    public static Date getDateStartByDate(Date date) {
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(date);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return (Date) currentDate.getTime().clone();
    }

    /**
     * 取得季度对应每个月的第一天
     * 如["2017-10-01 00:00:00","2017-11-01 00:00:00","2017-12-01 00:00:00"]
     * @param quarter
     * @return
     */
    public static String[] getMonths(String quarter) {
        String[] months = new String[3];
        Calendar c = Calendar.getInstance();
        if (quarter .equals("1") ) {// 第一季度
            c.set(Calendar.MONTH, Calendar.JANUARY);
            months[0] = format(c.getTime(),"MM");
            c.set(Calendar.MONTH, Calendar.FEBRUARY);
            months[1] = format(c.getTime(),"MM");
            c.set(Calendar.MONTH, Calendar.MARCH);
            months[2] = format(c.getTime(),"MM");
        } else if (quarter .equals("2")) {// 第二季度
            c.set(Calendar.MONTH, Calendar.APRIL);
            months[0] = format(c.getTime(),"MM");
            c.set(Calendar.MONTH, Calendar.MAY);
            months[1] = format(c.getTime(),"MM");
            c.set(Calendar.MONTH, Calendar.JUNE);
            months[2] = format(c.getTime(),"MM");
        } else if (quarter .equals("3")) {// 第三季度
            c.set(Calendar.MONTH, Calendar.JULY);
            months[0] = format(c.getTime(),"MM");
            c.set(Calendar.MONTH, Calendar.AUGUST);
            months[1] = format(c.getTime(),"MM");
            c.set(Calendar.MONTH, Calendar.SEPTEMBER);
            months[2] = format(c.getTime(),"MM");
        } else if (quarter .equals("4")) {// 第四季度
            c.set(Calendar.MONTH, Calendar.OCTOBER);
            months[0] = format(c.getTime(),"MM");
            c.set(Calendar.MONTH, Calendar.NOVEMBER);
            months[1] = format(c.getTime(),"MM");
            c.set(Calendar.MONTH, Calendar.DECEMBER);
            months[2] = format(c.getTime(),"MM");
        }
        return months;
    }

    public static String[] getLastSeasonMonths(String quarter, String year) {
        String[] months = new String[3];
        Calendar c = Calendar.getInstance();
        if (quarter .equals("1") ) {// 第一季度
            c.set(Calendar.MONTH, Calendar.JANUARY);
            months[0] = year + format(c.getTime(),"-MM");
            c.set(Calendar.MONTH, Calendar.FEBRUARY);
            months[1] = year + format(c.getTime(),"-MM");
            c.set(Calendar.MONTH, Calendar.MARCH);
            months[2] = year + format(c.getTime(),"-MM");
        } else if (quarter .equals("2")) {// 第二季度
            c.set(Calendar.MONTH, Calendar.APRIL);
            months[0] = year + format(c.getTime(),"-MM");
            c.set(Calendar.MONTH, Calendar.MAY);
            months[1] = year + format(c.getTime(),"-MM");
            c.set(Calendar.MONTH, Calendar.JUNE);
            months[2] = year + format(c.getTime(),"-MM");
        } else if (quarter .equals("3")) {// 第三季度
            c.set(Calendar.MONTH, Calendar.JULY);
            months[0] = year + format(c.getTime(),"-MM");
            c.set(Calendar.MONTH, Calendar.AUGUST);
            months[1] = year + format(c.getTime(),"-MM");
            c.set(Calendar.MONTH, Calendar.SEPTEMBER);
            months[2] = year + format(c.getTime(),"-MM");
        } else if (quarter .equals("4")) {// 第四季度
            year = String.valueOf(Integer.parseInt(year) - 1);
            c.set(Calendar.MONTH, Calendar.OCTOBER);
            months[0] = year + format(c.getTime(),"-MM");
            c.set(Calendar.MONTH, Calendar.NOVEMBER);
            months[1] = year + format(c.getTime(),"-MM");
            c.set(Calendar.MONTH, Calendar.DECEMBER);
            months[2] = year + format(c.getTime(),"-MM");
        }
        return months;
    }

    /**
     * 获取两个日期之间相差的时间 格式："X天X小时X分钟"
     * 小于一天 只显示时分，小于一小时，只显示分钟
     * @return
     */
    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        if(day<=0){
            if(hour<=0){
                if(min>0){
                    return min + "分钟";
                }else {
                    return "0分钟";
                }

            }else {
                return hour + "小时";
            }
        }else {
            return day + "天";
        }
    }

    /**
     * 获取两个时间相差多少分钟
     * @param endDate
     * @param nowDate
     * @return
     */
    public static long getDateDiffMinute(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long diff = endDate.getTime() - nowDate.getTime();
        long diffd = (diff / nd) * 24 * 60;
        long diffh = (diff % nd / nh) * 60;
        long diffm = diff % nd % nh / nm;
        long min = diffd + diffh + diffm;
        return min;
    }

    /**
     * 获取指定日期，加上指定分钟后的 日期
     * @param date
     * @param minute
     * @return
     */
    public static Date getDateAddMinute(Date date, String minute){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, StringUtils.toInteger(minute));
        return calendar.getTime();
    }
    /**
     * 获取指定日期，减去指定分钟后的 日期
     * @param date
     * @param minute
     * @return
     */
    public static Date getDateSubMinute(Date date, String minute){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -StringUtils.toInteger(minute));
        return calendar.getTime();
    }

    /**
     * StringFormatDate,如20180101转化成2018-01-01
     * @param str
     * @return
     */
    public static Date formatDate(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyyMMdd").parse(str);
            String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(parse);
            Date utilDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
//            Date date = new java.sql.Date(utilDate.getTime());
            return utilDate;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * StringFormatDate
     * @param str
     * @return
     */
    public static Date stringFormatDate(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyyMMdd").parse(str);
            String dateString = new SimpleDateFormat("yyyy-MM-dd").format(parse);
            Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            Date date = new java.sql.Date(utilDate.getTime());
            return date;
        } catch (Exception e) {
            return  null;
        }
    }

    public static Date stringFormatDateYearMonth(String str) {
        try {
            Date utilDate = new SimpleDateFormat("yyyy-MM").parse(str);
            Date date = new java.sql.Date(utilDate.getTime());
            return date;
        } catch (Exception e) {
            return  null;
        }
    }
    /**
     * StringFormatDate,如201801转化成2018-01
     * @param str
     * @return
     */
    public static String formatDateYearMonth(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyyMM").parse(str);
            String dateString = new SimpleDateFormat("yyyy-MM").format(parse);
            return dateString;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取指定日期当月的n号
     * @param date
     * @return
     */
    public static String getNDay(Date date,int nDay){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,nDay);//设置为1号,当前日期既为本月第一天
        String curtime = df.format(calendar.getTime());
        return curtime;
    }

    /**
     * 获取指定日期当月的n号
     * @param date
     * @return
     */
    public static Date getNDayNum(Date date,int nDay){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,nDay);//设置为1号,当前日期既为本月第一天
        return calendar.getTime();
    }

    /**
     * 获取指定日期当月的n号
     * @param date
     * @return
     */
    public static Date getNDayMonth(Date date,int nDay){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,nDay);//设置为1号,当前日期既为本月第一天
        return calendar.getTime();
    }

    /**
     * 获取指定日期下月的n号
     * @param date
     * @return
     */
    public static String getNDayNextMonth(Date date,int nDay){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DAY_OF_MONTH,nDay);//设置为1号,当前日期既为本月第一天
        String curtime = df.format(calendar.getTime());
        return curtime;
    }

    /**
     * 获取指定日期上n年或下n年的日期
     * nYear为正数: 下n年
     * nYear为负数：上n年
     * @param date
     * @return
     */
    public static Date getNYearDate(Date date,int nYear){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, nYear);
        return calendar.getTime();
    }

    /**
     * 获取指定日期上n年或下n年的上n月或下n月日期
     * @param date
     * @param nYear
     * nYear为正数: 下n年；nYear为负数：上n年
     * @param nMonth
     * nMonth为正数: 下n月；nMonth为负数：上n月
     * @return
     */
    public static Date getNYearNMonthDate(Date date,int nYear,int nMonth){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, nYear);
        calendar.add(Calendar.MONTH, nMonth);
        return calendar.getTime();
    }

    /**
     * 计算日期所在周的起始日期
     * @param date
     * @return
     */
    public static Date getWeekStartDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置星期一为一周开始的第一天
        calendar.setMinimalDaysInFirstWeek(4);//可以不用设置
        int weekYear = calendar.get(Calendar.YEAR);//获得当前的年
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);//获得当前日期属于今年的第几周
        calendar.setWeekDate(weekYear, weekOfYear, 2);//获得指定年的第几周的开始日期
        Date startDate = calendar.getTime();//创建日期的时间该周的第一天，
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStart = simpleDateFormat.format(starttime);//将时间戳格式化为指定格式*/
        return startDate;
    }

    /**
     * 计算日期所在周的结束日期
     * @param date
     * @return
     */
    public static Date getWeekEndDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置星期一为一周开始的第一天
        calendar.setMinimalDaysInFirstWeek(4);//可以不用设置
        int weekYear = calendar.get(Calendar.YEAR);//获得当前的年
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);//获得当前日期属于今年的第几周
        calendar.setWeekDate(weekYear, weekOfYear, 1);//获得指定年的第几周的结束日期
        Date endDate = calendar.getTime();
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateEnd = simpleDateFormat.format(endDate);*/
        return endDate;
    }

    /**
     * 计算日期所在月的开始日期
     * @param date
     * @return
     */
    public static Date getMonthStartDate(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        return c.getTime();
    }

    /**
     * 计算日期所在月的结束日期
     * @param date
     * @return
     */
    public static Date getMonthEndDate(Date date){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return ca.getTime();
    }


    /**
     * 字符串转换为java.util.Date<br>
     * 支持格式为 yyyy.MM.dd G 'at' hh:mm:ss z 如 '2002-1-1 AD at 22:10:59 PSD'<br>
     * yy/MM/dd HH:mm:ss 如 '2002/1/1 17:55:00'<br>
     * yy/MM/dd HH:mm:ss pm 如 '2002/1/1 17:55:00 pm'<br>
     * yy-MM-dd HH:mm:ss 如 '2002-1-1 17:55:00' <br>
     * yy-MM-dd HH:mm:ss am 如 '2002-1-1 17:55:00 am' <br>
     * yyyyMMdd
     * yyyy-MM-dd
     * @param time String 字符串<br>
     * @return Date 日期<br>
     */
    public static Date stringToDate(String time){
        SimpleDateFormat formatter;
        int tempPos=time.indexOf("AD") ;
        time=time.trim() ;
        formatter = new SimpleDateFormat ("yyyy.MM.dd G 'at' hh:mm:ss z");
        if(tempPos>-1){
            time=time.substring(0,tempPos)+
                    "公元"+time.substring(tempPos+"AD".length());//china
            formatter = new SimpleDateFormat ("yyyy.MM.dd G 'at' hh:mm:ss z");
        }
        tempPos=time.indexOf("-");
        if(time.length()==8){
            formatter = new SimpleDateFormat ("yyyyMMdd");
        }else if(time.length()==10 && time.indexOf("-")>-1){
            formatter = new SimpleDateFormat ("yyyy-MM-dd");
        }
        else if(tempPos>-1&&(time.indexOf(" ")<0)){
            formatter = new SimpleDateFormat ("yyyyMMddHHmmssZ");
        }
        else if((time.indexOf("/")>-1) &&(time.indexOf(" ")>-1)){
            formatter = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
        }
        else if((time.indexOf("-")>-1) &&(time.indexOf(" ")>-1)){
            formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        }
        else if((time.indexOf("/")>-1) &&(time.indexOf("am")>-1) ||(time.indexOf("pm")>-1)){
            formatter = new SimpleDateFormat ("yyyy-MM-dd KK:mm:ss a");
        }
        else if((time.indexOf("-")>-1) &&(time.indexOf("am")>-1) ||(time.indexOf("pm")>-1)){
            formatter = new SimpleDateFormat ("yyyy-MM-dd KK:mm:ss a");
        }
        ParsePosition pos = new ParsePosition(0);
        Date ctime = formatter.parse(time, pos);

        return ctime;
    }


    public static Date getMonthLastDay(String date) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM").parse(date);
            return getMonthEndDate(parse);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getNextYearDate(Date date,int nYear){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, nYear);
        String curtime = df.format(calendar.getTime());
        return curtime;
    }

    public static String getNextMonthDate(Date date,int nYear){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, nYear);
        String curtime = df.format(calendar.getTime());
        return curtime;
    }

    /**
     * 检验日期输入格式
     * sourceDate 要校验的数据
     * format 要检验的格式  yyyy-MM yyyy-MM-dd yyyyMM yyyyMMdd 等等
     * @param sourceDate
     * @param format
     * @return
     */
    public static boolean checkDate(String sourceDate, String format){
        if(sourceDate==null){
            return false;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.setLenient(false);
            dateFormat.parse(sourceDate);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    /**
     * 获取指定日期N天后的日期
     * @param date 指定日期
     * @param dayNo n天
     * @return
     */
    public static Date getDateByDaysNo(Date date, int dayNo) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dayNo);
        return calendar.getTime();
    }

    /**
     * 获取输入日期的前N个月的日期
     * @param str yyyy-mm
     * @return
     */
    public static String getLastNYearMonth(String str, int month) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Date parse = new SimpleDateFormat("yyyy-MM").parse(str);
            Calendar cal = Calendar.getInstance();
            cal.setTime(parse);
            cal.add(Calendar.MONTH, month);
            return sdf.format(cal.getTime());
        }catch(Exception e) {
            return null;
        }
    }

    public static Date stringFormDate(String str) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            /*String dateString = new SimpleDateFormat("yyyy-MM-dd").format(parse);
            Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);*/
            // Date date = new java.sql.Date(utilDate.getTime());
            return date;
        } catch (Exception e) {
            return  null;
        }
    }

    //获取上月的开始时间
    public static Date getBeginDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(getNowYear(date), getNowMonth(date) - 2, 1);
        return getDayStartTime(calendar.getTime());
    }

    //获取上月的结束时间
    public static Date getEndDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(getNowYear(date), getNowMonth(date) - 2, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(date), getNowMonth(date) - 2, day);
        return getDayEndTime(calendar.getTime());
    }

    //获取今年是哪一年
    public static Integer getNowYear(Date date) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }
    //获取本月是哪一月
    public static int getNowMonth(Date date) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }

    // 获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    // 获取某个日期的结束时间
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

    // 获取本周的开始时间
    public static Date getBeginDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    //获取当前日期，年的第一天日期
    public static Date getYearFirstDay(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_YEAR, 1);
        return c.getTime();
    }

    //获取本周的结束时间
    public static Date getEndDayOfWeek(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        cal.add(Calendar.DATE, 6);
        return cal.getTime();
    }

    // 获取本年的开始时间
    public static Date getBeginDayOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear(date));
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);
        return getDayStartTime(cal.getTime());
    }

    // 获取本年的结束时间
    public static Date getEndDayOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear(date));
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        return getDayEndTime(cal.getTime());
    }

    // 获取本周的开始时间
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    public static Date getEndDayBeginOfWeek(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        cal.add(Calendar.DATE, 6);
        return getDayStartTime(cal.getTime());
    }

    // 获取本周的结束时间
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }

    // 获取本月的开始时间
    public static Date getBeginDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        return getDayStartTime(calendar.getTime());
    }

    // 获取本月的结束时间
    public static Date getEndDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth() - 1, day);
        return getDayEndTime(calendar.getTime());
    }

    //获取上月的开始时间
    public static Date getBeginDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(getNowYear(date), getNowMonth(date) - 1, 1);
        return getDayStartTime(calendar.getTime());
    }

    //获取上月的结束时间
    public static Date getEndDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(getNowYear(date), getNowMonth(date) - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(date), getNowMonth(date) - 1, day);
        return getDayEndTime(calendar.getTime());
    }

    // 获取今年是哪一年
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }

    // 获取本月是哪一月
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }

    public static final int daysBetween(Date early, Date late) {

        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        //设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        //得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
                .getTime().getTime() / 1000)) / 3600 / 24;

        return days;
    }


    /**
     * 获取两个日期相差的月数
     */
    public static int getMonthDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if (month1 < month2 || month1 == month2 && day1 < day2) {
            yearInterval--;
        }
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2;
        if (day1 < day2) {
            monthInterval--;
        }
        monthInterval %= 12;
        int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
        return monthsDiff;
    }

    /**
     * 获取季度开始时间
     * @param date
     * @return
     */
    public static Date getCurrentQuarterStartTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 3);
            }
            else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 6);
            }
            else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 9);
            }
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获取年-季
     * @param date
     * @return
     */
    public static String getCurrentQuarter(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH)+1;
        String now = "";
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                now = String.valueOf(currentYear)+"-s1";
            }else if (currentMonth >= 4 && currentMonth <= 6) {
                now = String.valueOf(currentYear)+"-s2";
            }else if (currentMonth >= 7 && currentMonth <= 9) {
                now = String.valueOf(currentYear)+"-s3";
            }else if (currentMonth >= 10 && currentMonth <= 12) {
                now = String.valueOf(currentYear)+"-s4";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获取年-月
     * @param date
     * @return
     */
    public static String getYearMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return sdf.format(cal.getTime());
    }

    /**
     * 获取本季度结束时间
     * @param date
     * @return
     */
    public static Date getCurrentQuarterEndTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = longSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 判断该日期是否是该月的第一天
     * @param date
     * @return
     */
    public static boolean isMonthStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH) == 1;
    }

    /**
     * 判断是否是年初
     * @param date
     * @return
     */
    public static boolean isYearStart(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd=sdf.format(date);
        if(dd.contains("-01-01")){
            return true;
        }
        return false;
    }
    /**
     * 判断是否是季度开始时间
     * @param date
     * @return
     */
    public static boolean isQuarterStart(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd=sdf.format(date);
        if(dd.contains("-01-01") || dd.contains("-04-01") || dd.contains("-07-01") || dd.contains("-10-01")){
            return true;
        }
        return false;
    }

    /**
     * 获取传入日期所在月的最后一天
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    public static Date getLastDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date d = cal.getTime();
        return d;
    }

    public static String getLastYearByNum(Date date, int n) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, n);
        return sdf.format(cal.getTime());
    }

    public static int unAbs(int a) {
        return (a > 0) ? -a : a;
    }

    public static Date getNextYearMonthDay(int n, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (date == null) {
            date = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }


    public static Date getLastDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        Date d = cal.getTime();
        return d;
    }
}
