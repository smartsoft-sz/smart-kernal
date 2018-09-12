package com.smart.service.util;

import org.apache.commons.text.RandomStringGenerator;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

/**
 * Utility class for generating random Strings.
 */
public final class RandomUtil {

    private static final int DEF_COUNT = 20;
    private static final int DEF_COUNT_4 = 4;
    private static final int DEF_COUNT_6 = 6;

    private static RandomStringGenerator alphanumericGen = new RandomStringGenerator.Builder()
            .withinRange('0', 'z')
            .filteredBy(LETTERS, DIGITS)
            .build();
    private static RandomStringGenerator numericGen = new RandomStringGenerator.Builder()
            .withinRange('0', '9')
            .build();

    private RandomUtil() {
    }
    
    public static String generateRandomNumber(int numOfDigit) {
    	return numericGen.generate(numOfDigit);
    }

    /**
     * Generate a password.
     *
     * @return the generated password
     */
    public static String generatePassword() {
        return alphanumericGen.generate(DEF_COUNT);
    }

    /**
     * Generate an activation key.
     *
     * @return the generated activation key
     */
    public static String generateActivationKey() {
        return alphanumericGen.generate(DEF_COUNT);
//        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

    /**
     * Generate a reset key.
     *
     * @return the generated reset key
     */
    public static String generateResetKey() {
        return alphanumericGen.generate(DEF_COUNT);
//        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }


    public static String generateVerifyCode() {
        return numericGen.generate(DEF_COUNT_6);
    }

    //生成一个垛码 先写在这里好了
    public static String generateStackNum(){
        String stackNum = "D" + System.currentTimeMillis();
        return stackNum;
    }

    //生成一个箱码
    public static String generatePackNum(){
        String packNum = "X" + System.currentTimeMillis();
        return packNum;
    }

    //生成一个BATCH_NUM
    public static String generateBatchNum(){
        String batchNum = "B" + System.currentTimeMillis();
        return batchNum;
    }
}
