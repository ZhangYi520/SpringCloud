package com.zy.common.base.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    public static Date getTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d = null;
        Time sqldate = new Time(d.getTime());
        return sqldate;
    }

    // 时分秒转换成sqldate
    public static Time gettime(String date) {
        String str = date;
        SimpleDateFormat format = new SimpleDateFormat("hh:MM:ss");
        Date d = null;
        try {
            System.out.println(str);
            d = format.parse(str);
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Time sqldate = new Time(d.getTime());
        return sqldate;
    }

    // 时分秒转换成時間戳
    public static Long getTimestamp(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format2 = format.format(new Date());
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date parse = format1.parse(format2 + " " + date);
            return parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    // 转换成sqldate
    public static java.sql.Date getdate(String date) {
        String str = date;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = format.parse(str);
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date sqldate = new java.sql.Date(d.getTime());
        return sqldate;
    }

    // 转换成date
    public static Date getdateByString(String date) {
        date = date.substring(0, 19);
        String str = date;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }


    // 转换成date
    public static Date getDateByString(String date) {
        String str = date;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    // 当前时间sqldate
    public static java.sql.Date getnewdate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date sqldate = new java.sql.Date(d.getTime());
        return sqldate;
    }

    // 当前时间的字符串
    public static String getStrdate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        return str;
    }

    public static String getStrdate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    // 当前时分秒的字符串
    public static String getStrtime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    public static Time getnewtime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        Date d = null;
        try {
            d = format.parse(str);
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Time sqldate = new Time(d.getTime());
        return sqldate;
    }

    /**
     * 获取开始时间和结束时间的时分秒
     *
     * @param type 0 ：开始时间 00:00:00 1 ：结束时间 23:59:59
     * @param date 时间字符串
     * @return
     */
    public static Date timeTran(int type, String date) {
        date = date.trim();
        date = date.substring(0, 10) + " 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            d = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeSlot(type, d);
    }


    /**
     * 获取开始时间和结束时间的时分秒
     *
     * @param type 0 ：开始时间 00:00:00 1 ：结束时间 23:59:59
     * @param date
     * @return
     */
    public static Date timeSlot(int type, Date date) {
        String formatTo = "";
        formatTo = type == 0 ? "yyyy-MM-dd 00:00:00" : "yyyy-MM-dd 23:59:59";
        SimpleDateFormat format = new SimpleDateFormat(formatTo);
        String str = format.format(date);
        Date d = null;
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            d = sf.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public static Boolean isWeekend(Date currentTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentTime);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }

    }

    public static List getDayListOfMonth(int j) {
        List list = new ArrayList();
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        int year = aCalendar.get(Calendar.YEAR);// 年份
        int month = aCalendar.get(Calendar.MONTH) + 1 + j;// 月份
        int day = aCalendar.getActualMaximum(Calendar.DATE);

        String months = month + "";
        if (month < 10) {
            months = "0" + month;
        }
        for (int i = 1; i <= day; i++) {
            String days = i + "";
            if (i < 10) {
                days = "0" + i;
            }
            String aDate = String.valueOf(year) + "-" + months + "-" + days;

            list.add(aDate);
        }
        return list;
    }

    /**
     * 获取当前时间-两个月后的时间集合
     *
     * @return List
     */
    public static List<Date> getDatesBetweenTwoDateByNow() {
        Calendar c = Calendar.getInstance();
        Date beginDate = c.getTime();

        c.add(Calendar.MONTH, 2);
        Date endDate = c.getTime();
        return getDatesBetweenDate(beginDate, endDate);
    }

    /**
     * 获取当前月一号-第二个月最后一天的时间集合
     *
     * @return
     */
    public static List<Date> getDatesBetweenTwoDateByMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        Date beginDate = c.getTime();

        c.setTime(new Date());
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endDate = c.getTime();
        return DateUtil.getDatesBetweenDate(beginDate, endDate);
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format  格式
     * @return
     */
    public static String timeStampToDate(String seconds, String format) {
        if ("".equals(seconds) || seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * 获取两时间之间的集合
     *
     * @return
     */
    public static List<Date> getDatesBetweenDate(Date beginDate, Date endDate) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(beginDate);// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(cal.getTime());
            } else {
                break;
            }
        }
        if (beginDate.getTime() != endDate.getTime()) {
            lDate.add(endDate);// 把结束时间加入集合
        }
        return lDate;
    }


    public static Date getDateToDateNum(Date date, int dayNum) {
//			System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(date));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, dayNum);//天数可正可负：88或者-88
//			System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()));
        return cal.getTime();
    }

    /**
     * 当前时间的周一时间和周末时间
     */
    public static String firstDayTime() {
        //11.当前时间的周一时间和周末时间 setfirstdayofweek（）方法
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd ");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return format.format(c.getTime()) + " 00:00:00";
        //System.out.println(weekStart);
        /*Calendar ca = Calendar.getInstance();
        ca.setFirstDayOfWeek(Calendar.MONDAY);
    	ca.set(Calendar.DAY_OF_WEEK, ca.getFirstDayOfWeek() + 6); // Sunday  
    	String weekEnd = format.format(ca.getTime())+" 23:59:59";  
    	System.out.println(weekEnd); */
    }


    /**
     * 获取相隔天数的时间
     *
     * @param from 时间Date 为null默认为new Date();
     * @param day  相隔多少天，正数是以后，负数是以前
     * @return
     */
    public static Date getTimeDays(Date from, int day) {
        Long SUNDAY = 24 * 60 * 60 * 1000L;
        if (from == null) {
            from = new Date();
        }
        Long num = from.getTime();
        num = num + (SUNDAY * day);
        Date to = new Date(num);
        return to;
    }

    //获取当天的开始时间
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    //获取当天的结束时间
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    //获取昨天的开始时间
    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    //获取昨天的结束时间
    public static Date getEndDayOfYesterDay() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    //获取明天的开始时间
    public static Date getBeginDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }

    //获取明天的结束时间
    public static Date getEndDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    //获取本周的开始时间
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

    //获取本周的结束时间
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }

    //获取本月的开始时间
    public static Date getBeginDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        return getDayStartTime(calendar.getTime());
    }

    //获取本月的结束时间
    public static Date getEndDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth() - 1, day);
        return getDayEndTime(calendar.getTime());
    }

    //获取本年的开始时间
    public static Date getBeginDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        // cal.set
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);

        return getDayStartTime(cal.getTime());
    }

    //获取本年的结束时间
    public static Date getEndDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        return getDayEndTime(cal.getTime());
    }

    //获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    //获取某个日期的结束时间
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

    //获取今年是哪一年
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }

    //获取本月是哪一月
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }

    //判断两个日期是否为同一天
    public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                .get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }


    //判断两个日期是否为同一天
    public static boolean isSameDateByTime(Date date1, Date date2) {
        if (date1 == null || date2 == null) return false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str1 = format.format(date1);
        String str2 = format.format(date2);
        return str1.equals(str2);
    }

    /**
     * 格式为时间戳字符串
     *
     * @param date 时间
     * @return yyyy-MM-dd HH:mm:ss Date
     */
    public static String formatDateTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 格式为时间戳字符串
     *
     * @param date 时间
     * @return yyyy-MM-dd Date
     */
    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 两个时间相差多少分钟
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static double getDateSubtraction(Date startTime, Date endTime) {
        double minute = 0;
        long time1 = startTime.getTime();
        long time2 = endTime.getTime();

        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        minute = (diff / (60 * 1000));
        return minute;
    }


    /**
     * 判断当前时间是否大于某一个时间
     *
     * @return
     */
    public static boolean nowAfterDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date ten = null;
        Date now = null;
        try {
            ten = format.parse(format.format(date));
            now = format.parse(format.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ten.before(now);
    }

    //格式化时间获取毫秒数
    public static long getTimeLong(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(date);
        Date da = null;
        try {
            da = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return da.getTime();
    }
    
    /**
     * 
     * 描述:获取下一个月的第一天.
     * 
     * @return
     */
    public static Date getPerFirstDayOfMonth() {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
       // return dft.format(time);
    }
    
}
