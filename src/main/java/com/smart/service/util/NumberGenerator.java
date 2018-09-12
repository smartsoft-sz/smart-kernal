package com.smart.service.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NumberGenerator {

    private static long count = 1;

    public static String generateBalanceAcctNum() {
        DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String code = LocalDateTime.now().format(dfm);
        return code;
    }

    public static String generatePointsAcctNum() {
        DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String code = LocalDateTime.now().format(dfm);
        return code;
    }

    public static String generateOrderNum() {
        DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String code = LocalDateTime.now().format(dfm);
        return code;
    }

    private static String barcode_prefix = "25";
    
    private static int barcode_mod_value = 10;
    
    public static String generateBarcodeNum() {
        LocalDateTime curDate = LocalDateTime.now();
        int year = curDate.getYear();
        int month = curDate.getMonthValue();
        int day = curDate.getDayOfMonth();
        int hour = curDate.getHour();
        int minutes = curDate.getMinute();
        int seconds = curDate.getSecond();
        
        String code = barcode_prefix + enCodeNumber(year,barcode_mod_value) + enCodeNumber(month,barcode_mod_value)+
        		enCodeNumber(day,barcode_mod_value)+enCodeNumber(hour,barcode_mod_value)+enCodeNumber(minutes,barcode_mod_value)+
        		enCodeNumber(seconds,barcode_mod_value)+RandomUtil.generateRandomNumber(3);
//        enCodeNumber(id.intValue(), barcode_mod_value);
//        int num1 = id.intValue()%barcode_mod_value;
//        int num2 = id.intValue()%7;
        return code;
    }
    
    private static int enCodeNumber(int numValue, int modValue) {
    	int sqrtValue = (int)Math.sqrt(numValue);
    	
    	int randomValue = (int)(Math.random()*10);

    	return ((sqrtValue*randomValue)%modValue);
    }
   

    public static String generateCubPackSerialNum() {
        String code = String.valueOf(count);
        if (count < 10){
            code = "0"+code;
        }
        count++;
        return code;
    }

    public static void main(String[] args) {
    	for(int i = 0; i<30; i++) {
    		System.out.println(generateBarcodeNum());
    	}
    }
}
