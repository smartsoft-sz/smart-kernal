package com.smart.bo;

import java.time.LocalDateTime;

/**
 * @Author: Jinmeng Tang
 * @Date: Created in 2018/3/27 下午5:30
 */
public class JobParam {

    private Long interval;
    private LocalDateTime runTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public LocalDateTime getRunTime() {
        return runTime;
    }

    public void setRunTime(LocalDateTime runTime) {
        this.runTime = runTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
