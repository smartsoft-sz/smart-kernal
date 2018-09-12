package com.smart.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

/**
 * 简单封装Jackson，实现JSON String<->Java Object的Mapper.
 * <p>
 * 封装不同的输出风格, 使用不同的builder函数创建实例.
 */
public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获得当前时间的零点时间
     *
     * @param date
     * @return
     */
    public static LocalDateTime getDayStart(LocalDateTime date) {
        return date.withNano(0).withSecond(0).withMinute(0).withHour(0);
    }

    /**
     * 得到当前时间周的第一天，从周一开始
     *
     * @return
     */
    public static LocalDateTime getWeekStart(LocalDateTime date) {
        TemporalField fieldISO = WeekFields.of(Locale.CHINA).dayOfWeek();
        return date.with(fieldISO, 1).toLocalDate().atStartOfDay().plusDays(1);

    }

    /**
     * 得到当前周的最后一天，周日为结束
     *
     * @return
     */
    public static LocalDateTime getWeekEnd(LocalDateTime date) {
        TemporalField fieldISO = WeekFields.of(Locale.CHINA).dayOfWeek();
        return date.with(fieldISO, 7).toLocalDate().atStartOfDay().with(LocalTime.MAX).plusDays(1);

    }

    /**
     * 得到该日期是本年度的第几周
     *
     * @return
     */
    public static int getWeekNumberOfYear(LocalDateTime date) {
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        return date.get(woy);
    }

    /**
     * 得到当前月的第一天
     *
     * @return
     */
    public static LocalDateTime getMonthStart(LocalDateTime date) {
        return LocalDate.of(date.getYear(), date.getMonth(), 1).atStartOfDay().with(LocalTime.MIN);

    }

    /**
     * 得到当前月的最后一天
     *
     * @return
     */
    public static LocalDateTime getMonthEnd(LocalDateTime date) {
        return date.with(TemporalAdjusters.lastDayOfMonth());

    }

    /**
     * 得到当前季度的第一天
     *
     * @return
     */
    public static LocalDateTime getQuarterStart(LocalDateTime date) {
        Month monthType = Month.JANUARY;
        switch (getQuarterNumberOfYear(date)) {
            case 1:
                monthType = Month.JANUARY;
                break;
            case 2:
                monthType = Month.APRIL;
                break;
            case 3:
                monthType = Month.JULY;
                break;
            case 4:
                monthType = Month.OCTOBER;
                break;
            default:
                break;
        }
        return LocalDate.of(date.getYear(), monthType, 1).atStartOfDay().with(LocalTime.MIN);
    }

    /**
     * 得到当前季度的最后一天
     *
     * @return
     */
    public static LocalDateTime getQuarterEnd(LocalDateTime date) {
        return getQuarterStart(date).plusMonths(2).with(TemporalAdjusters.lastDayOfMonth());

    }

    /**
     * 得到该日期是本年度的第几个季度
     * @param date
     * @return
     */
    public static int getQuarterNumberOfYear(LocalDateTime date) {
        int month = date.getMonth().getValue();
        int quarterNumber = 0;
        if (month >= 1 && month <= 3) {
            quarterNumber = 1;
        } else if (month >= 4 && month <= 6) {
            quarterNumber = 2;
        } else if (month >= 7 && month <= 9) {
            quarterNumber = 3;
        } else {
            quarterNumber = 4;
        }
        return quarterNumber;
    }

    /**
     * 得到本年度的第一天
     *
     * @return
     */
    public static LocalDateTime getYearStart(LocalDateTime date) {
        return LocalDate.of(date.getYear(), Month.JANUARY, 1).atStartOfDay().with(LocalTime.MIN);
    }

    /**
     * 得到本年度最后一天
     *
     * @return
     */
    public static LocalDateTime getYearEnd(LocalDateTime date) {
        return LocalDate.of(date.getYear(), Month.DECEMBER, 31).atStartOfDay().with(LocalTime.MAX);
    }
}
