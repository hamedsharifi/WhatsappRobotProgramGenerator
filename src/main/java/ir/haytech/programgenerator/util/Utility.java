package ir.haytech.programgenerator.util;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utility {

    public static int generateRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static String convertToTwoDigitsFormat(int value) {
        return String.format("%02d", value);
    }

    public static Date getRandomStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 8);
        cal.set(Calendar.MINUTE, generateRandom(30, 59)); //08:30 to 08:59
        return cal.getTime();
    }

    public static Date getRandomEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 21);
        cal.set(Calendar.MINUTE, generateRandom(0, 30)); //21:15 to 21:30
        return cal.getTime();
    }

    public static Date getRandomLongSleepStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, generateRandom(3, 5)); //12:03 to 12:05
        return cal.getTime();
    }

    public static Date getRandomLongSleepEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, generateRandom(30, 53)); //12:30 to 12:53
        return cal.getTime();
    }

    public static Date addDaysToThisDate(int daysToAdd, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return DateUtils.addDays(cal.getTime(), daysToAdd);
    }
}
