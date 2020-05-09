package com.project.cpx.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/21 22:34
 * @Description:
 */
public final class DateUtil {
    private DateUtil() {
    }

    public static final String format(Object date) {
        return format(date, "yyyy-MM-dd");
    }

    public static final String format(Object date, String pattern) {
        if (date == null) {
            return null;
        } else {
            return pattern == null ? format(date) : (new SimpleDateFormat(pattern)).format(date);
        }
    }

    public static Integer getDefaultYear(){
        String re = format(new Date(),"yyyy");
        return Integer.valueOf(re);
    }

    public static Integer getDefaultMonth(){
        String re = format(new Date(),"MM");
        return Integer.valueOf(re);
    }

    public static final String getDate() {
        return format(new Date());
    }

    public static final String getDateTime() {
        return format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    public static final Date addDate(Date date, int field, int amount) {
        if (date == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(field, amount);
            return calendar.getTime();
        }
    }

    public static int calculateNumberOfDays(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = sdf.parse(dateStr);
            Date now = new Date();
            long n1 = now.getTime();
            long n2 = date.getTime();
            if (n1 > n2) {
                long diffTime = n1 - n2;
                int numberOfDays = (int)(diffTime / 86400000L);
                return numberOfDays;
            } else {
                return 0;
            }
        } catch (ParseException var11) {
            return 0;
        }
    }

    public static int getDaysOfMonth(int year, int month) {
        byte days;
        if (month != 1 && month != 3 && month != 5 && month != 7 && month != 9 && month != 10 && month != 12) {
            if (month != 4 && month != 6 && month != 8 && month != 11) {
                if ((year % 4 != 0 || year % 100 == 0) && year % 400 != 0) {
                    days = 28;
                } else {
                    days = 29;
                }
            } else {
                days = 30;
            }
        } else {
            days = 31;
        }

        return days;
    }

    public static int calculateDays() {
        Calendar cd = Calendar.getInstance();
        cd.set(6, 1);
        cd.roll(6, -1);
        int MaxYear = cd.get(6);
        return MaxYear;
    }

    public static int getDayDiff(String start, String end) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startTime = df.parse(start);
            Date endTime = df.parse(end);
            long interval = endTime.getTime() - startTime.getTime();
            if (interval < 0L) {
                throw new Exception("开始时间 start > 终止时间 end");
            } else {
                int day = (int)(interval / 86400000L);
                return day;
            }
        } catch (ParseException var8) {
            throw new Exception("时间格式应为 yyyy-MM-dd");
        }
    }

    public static int getSecondsDiff(String start, String end) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date startTime = df.parse(start);
            Date endTime = df.parse(end);
            long interval = endTime.getTime() - startTime.getTime();
            if (interval < 0L) {
                throw new Exception("开始时间 start > 终止时间 end");
            } else {
                int minute = (int)(interval / 1000L);
                return minute;
            }
        } catch (ParseException var8) {
            throw new Exception("时间格式应为 yyyy-MM-dd HH:mm:ss");
        }
    }

    public static int getMinuteDiff(String start, String end) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date startTime = df.parse(start);
            Date endTime = df.parse(end);
            long interval = endTime.getTime() - startTime.getTime();
            if (interval < 0L) {
                throw new Exception("开始时间 start > 终止时间 end");
            } else {
                int minute = (int)(interval / 60000L);
                return minute;
            }
        } catch (ParseException var8) {
            throw new Exception("时间格式应为 yyyy-MM-dd HH:mm:ss");
        }
    }

    public static String getDateTime(String pattern) {
        if (null == pattern || "".equals(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dt = sdf.format(new Date());
        return dt;
    }

    public static final Date stringToDate(String date) {
        if (date == null) {
            return null;
        } else {
            String separator = String.valueOf(date.charAt(4));
            String pattern = "yyyyMMdd";
            if (!separator.matches("\\d*")) {
                pattern = "yyyy" + separator + "MM" + separator + "dd";
                if (date.length() < 10) {
                    pattern = "yyyy" + separator + "M" + separator + "d";
                }

                pattern = pattern + " HH:mm:ss.SSS";
            } else if (date.length() < 8) {
                pattern = "yyyyMd";
            } else {
                pattern = pattern + "HHmmss.SSS";
            }

            pattern = pattern.substring(0, Math.min(pattern.length(), date.length()));

            try {
                return (new SimpleDateFormat(pattern)).parse(date);
            } catch (ParseException var4) {
                return null;
            }
        }
    }

    public static Date toDate(String date, String pattern) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.parse(date);
    }

    public static final Integer getBetween(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        long n = end.getTimeInMillis() - start.getTimeInMillis();
        return (int)(n / 1000L);
    }

    public static final Integer getDayBetween(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        start.set(11, 0);
        start.set(12, 0);
        start.set(13, 0);
        start.set(14, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        end.set(11, 0);
        end.set(12, 0);
        end.set(13, 0);
        end.set(14, 0);
        long n = end.getTimeInMillis() - start.getTimeInMillis();
        return (int)(n / 86400000L);
    }

    public static final Integer getMonthBetween(Date startDate, Date endDate) {
        if (startDate != null && endDate != null && startDate.before(endDate)) {
            Calendar start = Calendar.getInstance();
            start.setTime(startDate);
            Calendar end = Calendar.getInstance();
            end.setTime(endDate);
            int year1 = start.get(1);
            int year2 = end.get(1);
            int month1 = start.get(2);
            int month2 = end.get(2);
            int n = (year2 - year1) * 12;
            n = n + month2 - month1;
            return n;
        } else {
            return null;
        }
    }

    public static final Integer getMonthBetweenWithDay(Date startDate, Date endDate) {
        if (startDate != null && endDate != null && startDate.before(endDate)) {
            Calendar start = Calendar.getInstance();
            start.setTime(startDate);
            Calendar end = Calendar.getInstance();
            end.setTime(endDate);
            int year1 = start.get(1);
            int year2 = end.get(1);
            int month1 = start.get(2);
            int month2 = end.get(2);
            int n = (year2 - year1) * 12;
            n = n + month2 - month1;
            int day1 = start.get(5);
            int day2 = end.get(5);
            if (day1 <= day2) {
                ++n;
            }

            return n;
        } else {
            return null;
        }
    }

    public static Long dateTransformInteger(Date date) {
        Long longDate = date.getTime();
        return longDate;
    }

    public static Date integerTransformDate(Long integerDate) {
        try {
            long nowTimeLong = new Long(integerDate);
            DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTimeStr = ymdhmsFormat.format(nowTimeLong);
            return ymdhmsFormat.parse(nowTimeStr);
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static String stringTransformInterDate(Long integerDate) {
        try {
            long nowTimeLong = new Long(integerDate);
            DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTimeStr = ymdhmsFormat.format(nowTimeLong);
            return nowTimeStr;
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static boolean checkDateFormat(String strTime, String pattern) {
        if (strTime.length() != pattern.trim().length()) {
            return false;
        } else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern.trim());
                sdf.parse(strTime);
                return true;
            } catch (Exception var3) {
                return false;
            }
        }
    }

    public static long getTimestamp() {
        Date dateNow = new Date();
        return dateNow.getTime();
    }

    public static String utc2Local(String utcTime, String utcTimePatten, String localTimePatten) {
        SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten);
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUTCDate = null;

        try {
            gpsUTCDate = utcFormater.parse(utcTime);
        } catch (ParseException var7) {
            var7.printStackTrace();
        }

        SimpleDateFormat localFormater = new SimpleDateFormat(localTimePatten);
        localFormater.setTimeZone(TimeZone.getDefault());
        String localTime = localFormater.format(gpsUTCDate.getTime());
        return localTime;
    }

    public static String ymdToDash(String ymd) {
        return ymd.substring(0, 4) + "-" + ymd.substring(4, 6) + "-" + ymd.substring(6);
    }

    public static Date getWeekFirstDay(Integer year, Integer week) {
        Calendar cal = Calendar.getInstance();
        if (week < 1) {
            week = 1;
        }

        if (week > 52) {
            week = 52;
        }

        cal.setFirstDayOfWeek(2);
        cal.set(1, year);
        cal.set(3, week);
        cal.set(7, cal.getFirstDayOfWeek());
        if (cal.get(1) < year) {
            cal.add(7, 1);
        }

        return cal.getTime();
    }

    public static Date getWeekLastDay(Integer year, Integer week) {
        Calendar cal = Calendar.getInstance();
        if (week < 1) {
            week = 1;
        }

        if (week > 52) {
            week = 52;
        }

        cal.setFirstDayOfWeek(2);
        cal.set(1, year);
        cal.set(3, week);
        cal.set(7, cal.getFirstDayOfWeek());
        cal.add(7, 7);
        if (cal.get(1) > year) {
            cal.add(7, -1);
        }

        return cal.getTime();
    }

    public static Date getMonthFirstDay(Integer year, Integer month) {
        Calendar cal = Calendar.getInstance();
        if (month < 1) {
            month = 1;
        }

        if (month > 12) {
            month = 12;
        }

        cal.set(1, year);
        cal.set(2, month - 1);
        cal.set(5, 1);
        return cal.getTime();
    }

    public static Date getMonthLastDay(Integer year, Integer month) {
        Calendar cal = Calendar.getInstance();
        if (month < 1) {
            month = 1;
        }

        if (month > 12) {
            month = 12;
        }

        cal.set(1, year);
        cal.set(2, month - 1);
        cal.set(5, 1);
        cal.add(2, 1);
        cal.add(5, -1);
        return cal.getTime();
    }

    public static String getMonthFirstDayStr(Integer year,Integer month){
        Date d = getMonthFirstDay(year, month);
        return format(d,"yyyy-MM-dd");
    }

    public static String getMonthLastDayStr(Integer year,Integer month){
        Date d = getMonthLastDay(year, month);
        return format(d,"yyyy-MM-dd");
    }

    public static String getMonthFirstDay(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(cale.getTime());
    }

    public static String getMonthLastDay(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return format.format(cale.getTime());
    }

    public interface DATE_PATTERN {
        String HHMMSS = "HHmmss";
        String HH_MM_SS = "HH:mm:ss";
        String YYMMDD = "yyMMdd";
        String YYYYMMDD = "yyyyMMdd";
        String YYYY_MM_DD = "yyyy-MM-dd";
        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
        String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    }
}
