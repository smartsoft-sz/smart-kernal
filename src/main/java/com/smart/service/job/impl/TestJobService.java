package com.smart.service.job.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Jinmeng Tang
 * @Date: Created in 2018/3/28 下午2:25
 */
@Service
@Transactional
public class TestJobService  {

    private final Logger log = LoggerFactory.getLogger(TestJobService.class);

    public void process() throws Exception {
        int i = 0;
        while (i < 5) {
            log.info("test job process is running!");
            Thread.sleep(1000);
            i++;
        }
    }

    public void delete() {
        int i = 0;
        while (i < 5) {
            log.info("test job delete is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

}
