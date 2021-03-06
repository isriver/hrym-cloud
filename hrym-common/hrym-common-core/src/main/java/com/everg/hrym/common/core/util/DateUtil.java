package com.everg.hrym.common.core.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mj on 2017/6/25.
 */
public class DateUtil {
    
    public static final String DATE_DIVISION = "-";
    
    public static final String TIME_PATTON_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_PATTON_DEFAULT1 = "yyyy年MM月dd日 HH:mm:ss";
    public static final String DATE_PATTON_DEFAULT = "yyyy-MM-dd";
    public static final String DATE_PATTON_DEFAULT2 = "yyyy.MM.dd";
    public static final String TIME_PATTON_DEFAULT3 = "yyyy-MM-dd HH:mm";
    public static final String DATA_PATTON_YYYYMMDD = "yyyyMMdd";
    public static final String DATA_PATTON_YYYYMMDD2 = "yyyy年MM月dd日";
    public static final String DATA_PATTON_YYYYMMDD3 = "yyMMdd";
    public static final String DATA_PATTON_YYYYMM = "yyyyMM";
    public static final String DATA_PATTON_YYYYMM2 = "yyyy-MM";
    public static final String DATA_PATTON_YYYYMM3 = "yyyy";
    public static final String DATA_PATTON_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String TIME_PATTON_HHMMSS = "HH:mm:ss";
    public static final String TIME_PATTON_MMDDHHMMSS = "MM-dd HH:mm:ss";
    public static final String TIME_PATTON_MMdd = "MM月dd";
    public static final String TIME_PATTON_MMdd1 = "MM月dd日";
    
    public static final String TIME_PATTON_MMdd2 = "MM-dd";
    public static final String TIME_PATTON_MMdd3 = "MM.dd";
    public static final String TIME_PATTON_MMdd4 = "M.d";
    public static final String DATA_PATTON_MM = "MM";
    public static final String TIME_PATTON_DEFAULT_T = "yyyy/MM/dd HH:mm:ss";
    
    public static final String TIME_PATTON_HHMM = "HH:mm";
    
    public static final int ONE_SECOND = 1000;
    public static final int ONE_MINUTE = 60 * ONE_SECOND;
    public static final int ONE_HOUR = 60 * ONE_MINUTE;
    public static final long ONE_DAY = 24 * ONE_HOUR;
    
    
    /**
     * 获取当前系统时间
     *
     * @return
     */
    public static int currentSecond() {
        return Long.valueOf(System.currentTimeMillis() / 1000).intValue();
    }
    
    /**
     * 将linux时间转化为window时间
     *
     * @param unixSecond
     * @return
     */
    public static Date formatIntDate(Integer unixSecond) {
        Date date = new Date();
        if (unixSecond != null) {
            date.setTime(unixSecond.longValue() * 1000L);
        }
        return date;
    }
    
    /**
     * 日期格式化
     *
     * @param date
     * @param format yyyyMMddHHmmss 或 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getFormatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    
    /**
     * 时间转换
     *
     * @param time
     * @return
     * @time Apr 7, 2015 3:48:31 PM
     * @version 0.1
     * @since 0.1
     */
    public static String timestampToDates(Integer time, String formatPatton) {
        if (null == time) {
            time = 0;
        }
        SimpleDateFormat format = new SimpleDateFormat(formatPatton);
        Date date = new Date(time * 1000L);
        String dateStr = format.format(date);
        return dateStr;
    }
    
    /**
     * 【将字符串转为unix时间戳 按照指定格式】
     *
     * @param userTime
     * @param format
     * @return
     */
    public static int getTimeFormat(String userTime, String format) {
        int reTime = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d;
        try {
            d = sdf.parse(userTime);
            long l = d.getTime();
            String str = String.valueOf(l);
            reTime = Integer.parseInt(str.substring(0, 10));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reTime;
    }
    
    /**
     * 获取当前日期前一天时间
     *
     * @return
     */
    public static String getBeforeDate() {
        Date dNow = new Date();                    //当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);                        //把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1);    //设置为前一天
        dBefore = calendar.getTime();            //得到前一天的时间
        SimpleDateFormat sdf = new SimpleDateFormat(DATA_PATTON_YYYYMMDD); //设置时间格式
        String beforeDate = sdf.format(dBefore);    //格式化前一天
        return beforeDate;
    }
    
    /**
     * 获取当前日期后一天时间
     *
     * @return
     */
    public static String getNextDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATA_PATTON_YYYYMMDD);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date date = calendar.getTime();
        String nextDate = sdf.format(date);
        return nextDate;
    }
    
    /**
     * 获取指定日期的linux时间戳
     *
     * @param date
     * @param format yyyyMMdd 或者  yyyyMMddHHmmss
     * @return
     * @throws ParseException
     */
    public static int getDateToLinuxTime(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) (d.getTime() / 1000);
    }
    
    /**
     * 获取指定日期的linux时间戳 long类型返回
     *
     * @param date
     * @param format yyyyMMdd 或者  yyyyMMddHHmmss
     * @return
     * @throws ParseException
     */
    public static long DateToLinuxTime(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (d.getTime() / 1000);
    }
    
    /**
     * 根据日期字符串返回日期类型数据
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTON_DEFAULT);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    
    public static Date strToDateCom(String strDate, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    
    /**
     * 根据时间和格式返回时间字符串
     *
     * @return DATE<br>
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
    
    /**
     *显示当前时间的小时 int 2012101212
     *
     * @return DATE<br>
     */
//	public static Integer getHourFromDate() {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//
//		return Integer.valueOf(dateFormat.format(new Date()).substring(0, 10));
//	}
    
    /**
     * 根据格式返回当前时间字符串
     *
     * @param format
     * @return
     */
    public static String getCurrentDateByFormat(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }
    
    /**
     * 返回当前时间Date对象
     *
     * @return
     */
    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();
        
        return currDate;
    }
    
    /**
     * 根据格式'yyyy-MM-dd'返回当前时间字符串
     *
     * @return
     */
    public static String getCurrentDateStr() {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();
        
        return format(currDate);
    }
    
    /**
     * 根据格式返回当前时间字符串
     *
     * @param strFormat
     * @return
     */
    public static String getCurrentDateStr(String strFormat) {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();
        
        return format(currDate, strFormat);
    }
    
    /**
     * 将时间字符串转换为"yyyy-MM-dd"类型的Date返回
     *
     * @param dateValue
     * @return
     */
    public static Date parseDate(String dateValue) {
        return parseDate(DATE_PATTON_DEFAULT, dateValue);
    }
    
    /**
     * 根据时间格式转换成date返回
     *
     * @param format
     * @param dateValue
     * @return
     */
    public static Date parseDateForFormat(String format, String dateValue) {
        return parseDate(format, dateValue);
    }
    
    /**
     * 将时间字符串的Object对象转换为"yyyy-MM-dd"类型的Date返回
     *
     * @param object
     * @return
     */
    public static Date parseDate(Object object) {
        return parseDate(DATE_PATTON_DEFAULT, (String) object);
    }
    
    /**
     * 将时间字符串对象转换为"yyyy-MM-dd HH:mm:ss"类型的Date返回
     *
     * @param dateValue
     * @return
     */
    public static Date parseDateTime(String dateValue) {
        return parseDate(TIME_PATTON_DEFAULT, dateValue);
    }
    
    /**
     * 将时间字符串对象转换为指定格式类型的Date返回 默认："yyyy-MM-dd HH:mm:ss"
     *
     * @param strFormat
     * @param dateValue
     * @return
     */
    public static Date parseDate(String strFormat, String dateValue) {
        if (dateValue == null)
            return null;
        
        if (strFormat == null)
            strFormat = TIME_PATTON_DEFAULT;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
        Date newDate = null;
        
        try {
            newDate = dateFormat.parse(dateValue);
        } catch (ParseException pe) {
            newDate = null;
        }
        
        return newDate;
    }
    
    /**
     * 将时间转换格式为"yyyy-MM-dd"的字符串
     *
     * @param aTs_Datetime
     * @return
     */
    public static String format(Date aTs_Datetime) {
        return format(aTs_Datetime, DATE_PATTON_DEFAULT);
    }
    
    /**
     * 将时间转换格式为"yyyy.MM.dd"的字符串
     *
     * @param aTs_Datetime
     * @return
     */
    public static String format2(Date aTs_Datetime) {
        return format(aTs_Datetime, DATE_PATTON_DEFAULT2);
    }
    
    /**
     * 将时间转换格式为"MM-dd HH:mm:ss"的字符串
     *
     * @param aTs_Datetime
     * @return
     */
    public static String format3(Date aTs_Datetime) {
        return format(aTs_Datetime, TIME_PATTON_MMDDHHMMSS);
    }
    
    /**
     * 将时间转换格式为"MM月dd"的字符串
     *
     * @param aTs_Datetime
     * @return
     */
    public static String format4(Date aTs_Datetime) {
        return format(aTs_Datetime, TIME_PATTON_MMdd);
    }
    
    /**
     * 将时间转换格式为"HH:mm"的字符串
     *
     * @param dateTime
     * @return
     */
    public static String format5(Date dateTime) {
        return format(dateTime, TIME_PATTON_HHMM);
    }
    
    /**
     * 将时间转换格式为"yyyy-MM-dd HH:mm:ss"的字符串
     *
     * @param aTs_Datetime
     * @return
     */
    public static String formatTime(Date aTs_Datetime) {
        return format(aTs_Datetime, TIME_PATTON_DEFAULT);
    }
    
    /**
     * 将时间转换格式为"yyyyMM"的字符串
     *
     * @param aTs_Datetime
     * @return
     * @author xiaoli
     * @data 2016年3月23日
     */
    public static String formatTime5(Date aTs_Datetime) {
        return format(aTs_Datetime, DATA_PATTON_YYYYMM);
    }
    
    /**
     * 将给定的时间转化为给定的字符串格式 一般不带"HH:mm:ss"
     *
     * @param aTs_Datetime
     * @param as_Pattern
     * @return
     */
    public static String format(Date aTs_Datetime, String as_Pattern) {
        if (aTs_Datetime == null || as_Pattern == null)
            return null;
        
        SimpleDateFormat dateFromat = new SimpleDateFormat();
        dateFromat.applyPattern(as_Pattern);
        
        return dateFromat.format(aTs_Datetime);
    }
    
    
    /**
     * 将给定的时间转化为给定的字符串格式 一般带"HH:mm:ss"
     *
     * @param aTs_Datetime
     * @param as_Format
     * @return
     */
    public static String formatTime(Date aTs_Datetime, String as_Format) {
        if (aTs_Datetime == null || as_Format == null)
            return null;
        
        SimpleDateFormat dateFromat = new SimpleDateFormat();
        dateFromat.applyPattern(as_Format);
        
        return dateFromat.format(aTs_Datetime);
    }
    
    public static String getFormatTime(Date dateTime) {
        return formatTime(dateTime, TIME_PATTON_HHMMSS);
    }
    
    /**
     * Timestamp:它允许 JDBC API 将该类标识为 SQL TIMESTAMP 值
     *
     * @param aTs_Datetime
     * @param as_Pattern
     * @return
     */
    public static String format(Timestamp aTs_Datetime, String as_Pattern) {
        if (aTs_Datetime == null || as_Pattern == null)
            return null;
        
        SimpleDateFormat dateFromat = new SimpleDateFormat();
        dateFromat.applyPattern(as_Pattern);
        
        return dateFromat.format(aTs_Datetime);
    }
    
    
    /**
     * 计算连个时间间隔的天数，包括当前天数
     *
     * @param bDate
     * @param eDate
     * @return
     */
    public static double daysOfTwoDate(Date bDate, Date eDate) {
        
        GregorianCalendar bg = new GregorianCalendar();
        GregorianCalendar eg = new GregorianCalendar();
        
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR, 1900);//
        calendar1.set(Calendar.MONTH, 0);
        calendar1.set(Calendar.DATE, 1);
        
        Date tempDate = DateUtil.formatDateNoHour(calendar1.getTime());
        
        if (bDate == null || eDate == null || bDate.before(eDate)
                || bDate.equals(tempDate)) {
            return 0;
        }
        bg.setTime(bDate);
        eg.setTime(eDate);
        
        double elapsed = 0;
        GregorianCalendar bgc, egc;
        
        if (eg.after(bg)) {
            egc = (GregorianCalendar) eg.clone();
            bgc = (GregorianCalendar) bg.clone();
        } else {
            egc = (GregorianCalendar) bg.clone();
            bgc = (GregorianCalendar) eg.clone();
        }
        
        bgc.clear(Calendar.MILLISECOND);
        bgc.clear(Calendar.SECOND);
        bgc.clear(Calendar.MINUTE);
        bgc.clear(Calendar.HOUR_OF_DAY);
        bgc.clear(Calendar.AM_PM);
        bgc.clear(Calendar.HOUR);
        
        egc.clear(Calendar.MILLISECOND);
        egc.clear(Calendar.SECOND);
        egc.clear(Calendar.MINUTE);
        egc.clear(Calendar.HOUR_OF_DAY);
        bgc.clear(Calendar.AM_PM);
        bgc.clear(Calendar.HOUR);
        
        while (bgc.before(egc)) {
            bgc.add(Calendar.DATE, 1);
            elapsed++;
        }
        return elapsed;
        
    }
    
    /**
     * 返回不带HH:mm:ss的时间
     *
     * @param date
     * @return
     */
    public static Date formatDateNoHour(Date date) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.clear(Calendar.MILLISECOND);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.HOUR_OF_DAY);
        calendar.clear(Calendar.AM_PM);
        calendar.clear(Calendar.HOUR);
        return calendar.getTime();
        
    }
    
    /**
     * 创建不带HH:mm:ss的当前时间
     *
     * @return
     */
    public static Calendar getCurrentDateNoHour() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear(Calendar.MILLISECOND);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.HOUR_OF_DAY);
        calendar.clear(Calendar.AM_PM);
        calendar.clear(Calendar.HOUR);
        return calendar;
    }
    
    /**
     * 添加月份
     *
     * @param bDate
     * @param months
     * @return
     */
    public static Date getDateAfterMonths(Date bDate, int months) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(bDate);
        rightNow.add(Calendar.MONTH, months);
        return rightNow.getTime();
    }
    
    /**
     * 获取时间
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);//
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, day);
        
        return calendar.getTime();
    }
    
    /**
     * 根据格式输出时间字符串
     *
     * @param date
     * @param style
     * @return
     */
    public static String formatDateByStyle(Date date, String style) {
        if (date == null) {
            
            return "1900-01-01";
        }
        SimpleDateFormat fmt = new SimpleDateFormat(style);
        return fmt.format(date);
        
    }
    
    /**
     * 获取当前月份的第一天
     *
     * @param date
     * @return
     */
    public static Date getMinDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int minDate = cal.getActualMinimum(Calendar.DATE);
        cal.set(Calendar.DATE, minDate);
        return formatDateNoHour(cal.getTime());
        
    }
    
    /**
     * 获取当前月份的最后一天
     *
     * @param date
     * @return
     */
    public static Date getMaxDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int maxDate = cal.getActualMaximum(Calendar.DATE);
        cal.set(Calendar.DATE, maxDate);
        
        return formatDateNoHour(cal.getTime());
    }
    
    public static Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH,
                cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
    
    public static Date getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }
    
    /**
     * 得到 当前时间的 13位毫秒数
     *
     * @return
     */
    public static Long getTImes() {
        Date d = new Date();
        Long s = Long.valueOf(d.getTime());
        return s;
    }
    
    /**
     * 获取当前14位时间
     *
     * @return
     */
    public static String getDateTime() {
        SimpleDateFormat fmt = new SimpleDateFormat(TIME_PATTON_DEFAULT);
        Date date = new Date();
        String nowTime = fmt.format(date);
        return nowTime;
    }
    
    /**
     * 获取当前月份的后一个月份
     *
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedMonthAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMM").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        c.set(Calendar.MONTH, month + 1);
        String dayBefore = new SimpleDateFormat("yyyyMM").format(c.getTime());
        return dayBefore;
    }
    
    /**
     * 获取当前月份的前一个月
     *
     * @param specifiedDay
     * @return
     * @author xiaoli
     * @data 2016年3月23日
     */
    public static String getSpecifiedMonthBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMM").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        c.set(Calendar.MONTH, month - 1);
        String dayBefore = new SimpleDateFormat("yyyyMM").format(c.getTime());
        return dayBefore;
    }
    /**
     * 获取当前月份的前一个月
     *
     * @param specifiedDay
     * @return
     * @author xiaoli
     * @data 2016年3月23日
     */
    public static String getSpecifiedMonthBefore(String specifiedDay,String format) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat(format).parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        c.set(Calendar.MONTH, month - 1);
        String dayBefore = new SimpleDateFormat(format).format(c.getTime());
        return dayBefore;
    }
    
    /**
     * 获取N个小时之后的时间
     *
     * @param date
     */
    public static Date getNextTime(Date date, float n) {
        long curren = date.getTime();
        curren += n * 60 * 60 * 1000;
        Date da = new Date(curren);
        return da;
    }
    
    /**
     * 获取某个时间n分钟后的时间
     *
     * @param date
     * @param n
     * @return
     * @author xiaoli<xiaoli   @   zjyushi.com>
     * @date 2015年10月14日
     */
    public static Date getAfterMinTime(Date date, int n) {
        long curren = date.getTime();
        curren += n * 60 * 1000;
        Date da = new Date(curren);
        return da;
    }
    
    /**
     * 获取两个时间之间的时间差
     *
     * @param nowTime
     * @param lastTime
     * @return 返回格式：00天00时00分00秒
     */
    public static String getTimeCha(Date nowTime, Date lastTime) {
        if (nowTime.getTime() <= lastTime.getTime()) {
            long diff = lastTime.getTime() - nowTime.getTime();
            long day = diff / (24 * 60 * 60 * 1000);
            long hour = (diff / (60 * 60 * 1000) - day * 24);
            long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            StringBuffer strbuff = new StringBuffer();
            if (day > 0 && day < 10) {
                strbuff.append("0" + day + "天");
            } else if (day >= 10) {
                strbuff.append(day + "天");
            }
            if (hour < 10) {
                strbuff.append("0" + hour + "时");
            } else {
                strbuff.append(hour + "时");
            }
            if (min < 10) {
                strbuff.append("0" + min + "分");
            } else {
                strbuff.append(min + "分");
            }
            if (s < 10) {
                strbuff.append("0" + s + "秒");
            } else {
                strbuff.append(s + "秒");
            }
            return strbuff.toString();
        } else {
            return "0";
        }
    }
    
    /**
     * 时间段比较
     *
     * @param beginTime
     * @param endTime
     * @return -1-未开始；0-进行中；1-已结束
     */
    public static int checkTime(Date beginTime, Date endTime) {
        int flag = 0;
        Date date = parseDate(format(new Date()));
        if (endTime.getTime() < beginTime.getTime()) {
            Date d = endTime;
            endTime = beginTime;
            beginTime = d;
        }
        if (date.getTime() < beginTime.getTime()) {//未开启
            flag = -1;
        } else if (endTime.getTime() < date.getTime()) {//已结束
            flag = 1;
        } else if (beginTime.getTime() <= date.getTime() && date.getTime() <= endTime.getTime()) {
            flag = 0;
        }
        return flag;
    }
    
    /**
     * 获取目标时间的之前/之后几小时的时间
     *
     * @param date
     * @param hours
     * @return
     */
    public static Date getNextHourseTime(Date date, int hours) {
        Calendar dar = Calendar.getInstance();
        dar.setTime(date);
        dar.add(Calendar.HOUR_OF_DAY, hours);
        return dar.getTime();
    }

    /**
     * 获取当前时间与某个时间的间隔
     *
     * @param time
     * @return
     * @author xiaoli<xiaoli   @   zjyushi.com>
     * @date 2015年9月10日
     */
    public static Long getTimeInterval(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //给定的时间
            Date d = format.parse(time);
            //当前时间处理
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            //给定时间处理
            Calendar setCal = Calendar.getInstance();
            setCal.setTime(d);
            setCal.set(Calendar.HOUR_OF_DAY, 0);
            setCal.set(Calendar.MINUTE, 0);
            setCal.set(Calendar.SECOND, 0);
            setCal.set(Calendar.MILLISECOND, 0);
            System.out.println(cal.getTimeInMillis());
            System.out.println(setCal.getTimeInMillis());
            long dayDiff = (cal.getTimeInMillis() - setCal.getTimeInMillis()) / (1000 * 60 * 60 * 24);
            return dayDiff;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }

    /**
     * 获取同一天时间内的分钟数
     *
     * @param nowTime
     * @param lastTime
     * @return
     * @author xiaoli<xiaoli   @   zjyushi.com>
     * @date 2015年9月10日
     */
    public static String getTimeChaHour(Date nowTime, Date lastTime) {
        String str = "";
        if (nowTime.getTime() <= lastTime.getTime()) {
            long diff = lastTime.getTime() - nowTime.getTime();
            long day = diff / (24 * 60 * 60 * 1000);
            long hour = (diff / (60 * 60 * 1000) - day * 24);
            long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            if (day >= 1) {
                String nowTimeStr = DateUtil.formatDateByStyle(nowTime, DateUtil.DATA_PATTON_YYYYMMDD2);
                Integer now = DateUtil.getDateToLinuxTime(nowTimeStr, DateUtil.DATA_PATTON_YYYYMMDD2);
                Date sd = DateUtil.formatIntDate(now);
                diff = lastTime.getTime() - sd.getTime();
                day = diff / (24 * 60 * 60 * 1000);
            }
            if (day == 1) {
                str = "昨天";
            } else if (day == 2) {
                str = "前天";
            } else if (day > 2) {
                str = day + "天前";
            } else if (day == 0 && hour > 0) {
                str = hour + "小时前";
            } else if (day == 0 && hour == 0 && min > 0) {
                str = min + "分钟前";
            } else {
                str = s + "秒前";
            }
        }
        return str;
    }

    /**
     * 获取同一天时间内的分钟数
     *
     * @param nowTime
     * @param lastTime
     * @return
     * @author xiaoli<xiaoli   @   zjyushi.com>
     * @date 2015年9月10日
     */
    public static String getTimeStrForWechat(Date nowTime, Date lastTime) {
        String str = "";
        if (nowTime.getTime() <= lastTime.getTime()) {
            long diff = lastTime.getTime() - nowTime.getTime();
            long day = diff / (24 * 60 * 60 * 1000);
            long hour = (diff / (60 * 60 * 1000) - day * 24);
            long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            if (day == 1) {
                str = "昨天";
            } else if (day == 2) {
                str = "前天";
            } else if (day > 2) {
                str = format(nowTime, DATA_PATTON_YYYYMMDD2);
            } else if (day == 0 && hour > 0) {
                str = hour + "小时前";
            } else if (day == 0 && hour == 0 && min > 0) {
                str = min + "分钟前";
            } else {
                str = "1分钟内";
            }
        }
        return str;
    }

    /**
     * 获取当前日期前一天
     *
     * @return
     */
    public static String getBeforeDateFormat(String format) {
        Date dNow = new Date();                    //当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);                        //把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1);    //设置为前一天
        dBefore = calendar.getTime();            //得到前一天的时间
        SimpleDateFormat sdf = new SimpleDateFormat(format); //设置时间格式
        String beforeDate = sdf.format(dBefore);    //格式化前一天
        return beforeDate;
    }

    /**
     * 获取当前时间的前n天
     *
     * @param n
     * @param n
     * @return
     * @xiaoli<xiaoli@zjyushi.com>
     * @data 2016年3月16日
     */
    public static String getBeforeDateFormat(int n) {
        Date dNow = new Date();                    //当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);                        //把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -n);    //设置为前n天
        dBefore = calendar.getTime();            //得到前一天的时间
        SimpleDateFormat sdf = new SimpleDateFormat(DATA_PATTON_YYYYMMDD); //设置时间格式
        String beforeDate = sdf.format(dBefore);    //格式化前一天
        return beforeDate;
    }

    /**
     * 获取某个时间的前n天
     *
     * @param n
     * @param date
     * @return
     * @xiaoli<xiaoli@zjyushi.com>
     * @data 2016年3月16日
     */
    public static String getBeforeDateFormat(String date, int n) {
        Date dNow = parseDateForFormat(DATA_PATTON_YYYYMMDD, date);
//        Date dNow = new Date();  					//当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);                        //把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -n);    //设置为前n天
        dBefore = calendar.getTime();            //得到前一天的时间
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTON_DEFAULT); //设置时间格式
        String beforeDate = sdf.format(dBefore);    //格式化前一天
        return beforeDate;
    }

    public static String getBeforeDateFormatNew(String date, int n, String dateFormat) {
        Date dNow = parseDateForFormat(dateFormat, date);
//        Date dNow = new Date();  					//当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);                        //把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -n);    //设置为前n天
        dBefore = calendar.getTime();            //得到前一天的时间
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat); //设置时间格式
        String beforeDate = sdf.format(dBefore);    //格式化前一天
        return beforeDate;
    }

    /**
     * 获取当前时间n天后
     *
     * @param n
     * @return
     * @xiaoli<xiaoli@zjyushi.com>
     * @data 2016年3月16日
     */
    public static String getAfterDateFormat(int n) {
        Date dNow = new Date();                    //当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);                        //把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, n);    //设置为后一天
        dBefore = calendar.getTime();            //得到前一天的时间
        SimpleDateFormat sdf = new SimpleDateFormat(DATA_PATTON_YYYYMMDDHHMMSS); //设置时间格式
        String beforeDate = sdf.format(dBefore);    //格式化前一天
        return beforeDate;
    }

    /**
     * 获取某天date的n天后
     *
     * @param date
     * @param n
     * @return
     * @xiaoli<xiaoli@zjyushi.com>
     * @data 2016年3月16日
     */
    public static String getAfterDateFormat(String date, int n) {
        Date dNow = parseDateForFormat(DATA_PATTON_YYYYMMDD, date);                //当前时间
        Date dBefore = parseDateForFormat(DATA_PATTON_YYYYMMDD, date);
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);                        //把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, n);    //设置为后一天
        dBefore = calendar.getTime();            //得到前一天的时间
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTON_DEFAULT); //设置时间格式
        String beforeDate = sdf.format(dBefore);    //格式化前一天
        return beforeDate;
    }

    public static String getAfterDateFormat_new(String date, int n) {
        Date dNow = parseDateForFormat(DATA_PATTON_YYYYMMDD, date);                //当前时间
        Date dBefore = parseDateForFormat(DATA_PATTON_YYYYMMDD, date);
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);                        //把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, n);    //设置为后一天
        dBefore = calendar.getTime();            //得到前一天的时间
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTON_DEFAULT); //设置时间格式
        String beforeDate = sdf.format(dBefore);    //格式化前一天
        return beforeDate;
    }


    /**
     * 获取之后的n天
     *
     * @param date
     * @param days
     * @return
     */
    public static Date getDateAfterDay(Date date, int days) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DATE, days);
        rightNow.clear(Calendar.MILLISECOND);
        rightNow.clear(Calendar.SECOND);
        rightNow.clear(Calendar.MINUTE);
        rightNow.clear(Calendar.HOUR_OF_DAY);
        rightNow.clear(Calendar.AM_PM);
        rightNow.clear(Calendar.HOUR);
        return rightNow.getTime();

    }

    /**
     * 获取当前时间的年月日
     *
     * @return
     * @xiaoli<xiaoli@zjyushi.com>
     * @data 2016年3月16日
     */
    public static String getNowDate() {
        Date date = getStartDate();
        String d = formatDate(date, DATA_PATTON_YYYYMMDDHHMMSS);
        return d;
    }

    /**
     * 获取当日 00:00:00
     *
     * @return
     */
    public static Date getStartDate() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取当日 24:00:00
     *
     * @return
     */
    public static Date getEndDate() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 24);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取制定时间n天后的时间
     *
     * @param n
     * @return
     */
    public static String getAfterAnyDay(String date, double n, String formatPatton) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(formatPatton);
        Date date1 = null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        // 开始的日期相对于1970年1月1日的毫秒数+天数的毫秒数
        long addMill = date1.getTime() + (long) n * 24 * 3600 * 1000;
        cal.setTimeInMillis(addMill);

        return dateFormat.format(cal.getTime());
    }

    /**
     * 获取两个日期之间的间隔天数
     *
     * @param startTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    public static int daysBetween(Integer startTime, Integer endTime) throws ParseException {
        String smdate = DateUtil.timestampToDates(startTime, DateUtil.DATA_PATTON_YYYYMMDD2);
        String bdate = DateUtil.timestampToDates(endTime, DateUtil.DATA_PATTON_YYYYMMDD2);

        SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.DATA_PATTON_YYYYMMDD2);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 获取当前时间距当日某一时刻间的时间差毫秒数
     *
     * @return
     */
    public static int getHours(String time) {
        //获取当前时间
        String str = DateUtil.getCurrentDateByFormat(DateUtil.TIME_PATTON_HHMMSS);
        long from = DateUtil.DateToLinuxTime(str, DateUtil.TIME_PATTON_HHMMSS);
        long to = DateUtil.DateToLinuxTime(time, DateUtil.TIME_PATTON_HHMMSS);
        int hours = (int) (to - from);
        return hours;
    }


    /**
     * 判断时间段是不是同一年
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isSameDate(Integer time1, Integer time2) {

        String strTime1 = DateUtil.timestampToDates(time1, TIME_PATTON_DEFAULT);
        String strTime2 = DateUtil.timestampToDates(time2, TIME_PATTON_DEFAULT);

        DateFormat format2 = new SimpleDateFormat(TIME_PATTON_DEFAULT);
        
        Date date1 = null;
        Date date2 = null;
        try {
            
            date1 = format2.parse(strTime1);
            date2 = format2.parse(strTime2);
            
        } catch (ParseException e) {
            
            e.printStackTrace();
        }
        
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
    
    /**
     * 日期转星期
     *
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    
    /**
     * 当前日期转星期
     *
     * @return
     */
    public static String dateToWeek() {
        SimpleDateFormat f = new SimpleDateFormat();
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    
    /**
     * 获取系统时间年份
     *
     * @return
     */
    public static Integer getYear() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.YEAR);
    }
    
    /**
     * 获取系统时间月份
     *
     * @return
     */
    public static Integer getMonth() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.MONTH) + 1;
    }
    
    /**
     * 获取系统时间年月日  20190323
     *
     * @return
     */
    public static Integer getYMD() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(date);
        return Integer.valueOf(format);
    }
    
    /**
     * 获取系统时间年份
     *
     * @return
     */
    public static Integer getYear(String date) {
        Date date1 = parseDate(DATE_PATTON_DEFAULT, date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        return calendar.get(Calendar.YEAR);
    }
    /**
     * 获取系统时间年份
     *
     * @return
     */
    public static Integer getYear(String date,String formcat) {
        Date date1 = parseDate(formcat, date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        return calendar.get(Calendar.YEAR);
    }
    
    /**
     * 获取系统时间月份
     *
     * @return
     */
    public static Integer getMonth(String date,String format) {
        Date date1 = parseDate(format, date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        return calendar.get(Calendar.MONTH)+1;
    }
    
    
    /**
     * 获取本周一 0:00 时间戳
     *
     * @return
     */
    public static int getTimesWeekmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return (int) (cal.getTimeInMillis() / 1000);
    }
    
    /**
     * 获取上一周，下一周，本周的时间戳《0：00》
     *
     * @return
     */
    public static int getTimesWeekmorning(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, n * 7);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return (int) (cal.getTimeInMillis() / 1000);
    }
    
    /**
     * 获取某个时间的周6和周日《周一为第一天》
     *
     * @return
     */
    public static Map<String, Object> getDataPattonYyyymm(String date) {
        
        Map<String, Object> map = new HashMap<>();
        String saturday = null;
        String sunday = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
            Calendar cal = Calendar.getInstance();
            Date time = sdf.parse(date);
            cal.setTime(time);
            System.out.println("要计算日期为:" + sdf.format(cal.getTime())); //输出要计算日期
            
            //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
//            if (1 == dayWeek) {
//                cal.add(Calendar.DAY_OF_MONTH, -1);
//            }
            cal.setFirstDayOfWeek(Calendar.SUNDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期天
            int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
            //周日
            cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
            sunday = sdf.format(cal.getTime());
            map.put("sunday", sunday);
            //周6
            cal.add(Calendar.DATE, 6);
            saturday = sdf.format(cal.getTime());
            map.put("saturday", saturday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return map;
    }
    /**
     * 获取某个时间的周6和周日《周一为第一天》
     *
     * @return
     */
    public static Map<String, Object> getDataPattonYyyymm(String date,String format) {
        
        Map<String, Object> map = new HashMap<>();
        String saturday = null;
        String sunday = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format); //设置时间格式
            Calendar cal = Calendar.getInstance();
            Date time = sdf.parse(date);
            cal.setTime(time);
            System.out.println("要计算日期为:" + sdf.format(cal.getTime())); //输出要计算日期
            
            //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
//            if (1 == dayWeek) {
//                cal.add(Calendar.DAY_OF_MONTH, -1);
//            }
            cal.setFirstDayOfWeek(Calendar.SUNDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期天
            int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
            //周日
            cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
            sunday = sdf.format(cal.getTime());
            map.put("sunday", sunday);
            //周6
            cal.add(Calendar.DATE, 6);
            saturday = sdf.format(cal.getTime());
            map.put("saturday", saturday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return map;
    }
    
    public static void main(String[] args) {
        
        System.out.println(getMonth("2019-05-22",DateUtil.DATE_PATTON_DEFAULT));
//        Map<String,Object> map = getDataPattonYyyymm("2019-03-18");
//        String a = (String) map.get("sunday");
//        String a1 = (String) map.get("monDay");
//        System.out.println(a);
//        System.out.println(a1);
        
    }
    
}