package com.smart.core;

public abstract class AbstractKeySeq {

    /** 区间最大值 */
    protected long intervalMax = 0;

    /** 每次增加量 */
    protected long interval = 999;

    /** 预定的最大值 */
    protected long maxNum = 999999999;

    /** 序列号 */
    protected long serialNum = -1;

    public AbstractKeySeq() {}
      
    public AbstractKeySeq(int interval, int maxNum) {
        this.interval = interval;  
        this.maxNum = maxNum;  
    }

    /**
     * 根据keyName，生成对应的key
     *
     * @param keyName
     * @return
     */
    public synchronized long generateKey(String keyName) {
        if (serialNum == -1) {  
            serialNum = initStartNum(keyName); // 已经使用的序列号一定 小于 缓存的序列号
            intervalMax = serialNum + interval;  
            updateStartNum(keyName, intervalMax);
            return serialNum;  
        }  
        if (isMax(serialNum)) { // 达到预定的最大值  
            resetSerialNum(keyName);
            return serialNum;  
        }  
        serialNum++;  
        if (serialNum >= (intervalMax - 1)) { // 到达区间最大值  
            intervalMax += interval;  
            updateStartNum(keyName, intervalMax);
        }  
        return serialNum;  
    }  
      
    /** 
     * 初始化序列号，从缓存系统中来，比如数据库、文件等 
     * @return 初始序列号 
     */
    public abstract Long initStartNum(String keyName);
      
    /** 
     * 根据keyName，更新区间最大值到缓存系统，比如数据库、文件中。
     *
     * @param keyName
     * @param intervalMax 区间最大值 
     */
    public abstract void updateStartNum(String keyName, long intervalMax);
      
    /**
     * 根据keyName，重置序列号，从1开始
     *
     * @param keyName
     */
    protected void resetSerialNum(String keyName) {
        this.serialNum = 1;  
        intervalMax = serialNum + interval;  
        updateStartNum(keyName, intervalMax);
    }  
      
    /** 
     * 是否是最大值 
     * @param num 
     * @return 
     */  
    private boolean isMax(long num) {
        return num >= maxNum;  
    }  
      
    public long getInterval() {
        return this.interval;  
    }  
      
    public long getMaxNum() {
        return this.maxNum;  
    }  

}  