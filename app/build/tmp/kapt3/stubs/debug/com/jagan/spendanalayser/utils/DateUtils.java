package com.jagan.spendanalayser.utils;

import java.lang.System;

/**
 * Created by jaganmohana on 2019-11-19.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/jagan/spendanalayser/utils/DateUtils;", "", "()V", "Companion", "app_debug"})
public final class DateUtils {
    private static final java.lang.String DATE_FORMAT = "dd-MMM-yyyy hh:mm a";
    private static final java.lang.String DATE_FORMAT_WITHOUT_TIME = "dd-MMM-yyyy";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TODAY = "Today";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String YESTERDAY = "Yesterday";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] months = null;
    public static final com.jagan.spendanalayser.utils.DateUtils.Companion Companion = null;
    
    public DateUtils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0006\u0010\u000e\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u001e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0004J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u001a\u001a\u00020\u0015J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0#J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\'\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0004J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0004H\u0002J\u001a\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u00a8\u00060"}, d2 = {"Lcom/jagan/spendanalayser/utils/DateUtils$Companion;", "", "()V", "DATE_FORMAT", "", "DATE_FORMAT_WITHOUT_TIME", "TODAY", "YESTERDAY", "months", "", "getMonths", "()[Ljava/lang/String;", "[Ljava/lang/String;", "currentDate", "formatDate", "date", "Ljava/util/Date;", "format", "getCalendar", "Ljava/util/Calendar;", "getCurrentDay", "", "getCurrentMonth", "getCurrentYear", "getDate", "month", "year", "min", "", "getDatesForMonth", "", "Lcom/jagan/spendanalayser/model/DateItem;", "getLatestMonthInYear", "getMonthFromDate", "getRecentYears", "", "getTimeFromDate", "dateStr", "getYearFromDate", "isToday", "isYesterday", "parseDate", "parseExpenseDate", "Lcom/jagan/spendanalayser/model/ExpenseDate;", "strDate", "readableDate", "strMonth", "intMonth", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String[] getMonths() {
            return null;
        }
        
        private final java.util.Calendar getCalendar() {
            return null;
        }
        
        private final java.lang.String currentDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String formatDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String formatDate(@org.jetbrains.annotations.Nullable()
        java.util.Date date) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTimeFromDate(@org.jetbrains.annotations.NotNull()
        java.lang.String dateStr) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.jagan.spendanalayser.model.DateItem> getDatesForMonth(int month, int year) {
            return null;
        }
        
        private final boolean isYesterday(java.lang.String dateStr) {
            return false;
        }
        
        public final boolean isToday(@org.jetbrains.annotations.NotNull()
        java.lang.String dateStr) {
            return false;
        }
        
        private final java.util.Date parseDate(java.lang.String dateStr, java.lang.String format) {
            return null;
        }
        
        private final java.lang.String formatDate(java.util.Date date, java.lang.String format) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String readableDate(@org.jetbrains.annotations.NotNull()
        java.lang.String dateStr) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.jagan.spendanalayser.model.DateItem> getMonths(int year) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.jagan.spendanalayser.model.DateItem> getRecentYears() {
            return null;
        }
        
        public final int getYearFromDate(@org.jetbrains.annotations.NotNull()
        java.lang.String date) {
            return 0;
        }
        
        public final int getMonthFromDate(@org.jetbrains.annotations.NotNull()
        java.lang.String date) {
            return 0;
        }
        
        public final int getYearFromDate(@org.jetbrains.annotations.NotNull()
        java.util.Date date) {
            return 0;
        }
        
        public final int getMonthFromDate(@org.jetbrains.annotations.NotNull()
        java.util.Date date) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jagan.spendanalayser.model.ExpenseDate parseExpenseDate(@org.jetbrains.annotations.NotNull()
        java.util.Date date) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jagan.spendanalayser.model.ExpenseDate parseExpenseDate(@org.jetbrains.annotations.NotNull()
        java.lang.String strDate) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String strMonth(int intMonth) {
            return null;
        }
        
        public final int getCurrentYear() {
            return 0;
        }
        
        public final int getCurrentMonth() {
            return 0;
        }
        
        public final int getCurrentDay() {
            return 0;
        }
        
        public final int getLatestMonthInYear(int year) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Date getDate(int month, int year, boolean min) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}