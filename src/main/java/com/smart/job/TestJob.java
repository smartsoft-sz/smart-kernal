package com.smart.job;

import com.smart.service.job.impl.TestJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Jinmeng Tang
 * @Date: Created in 2018/3/28 下午3:17
 */
@Service
//@Profile({"sit", "prod"})
public class TestJob {

    private final Logger log = LoggerFactory.getLogger(TestJob.class);

    @Resource
    private TestJobService testJobService;


    public void testJob() {
        log.info("start to handle test job");
        try {
            testJobService.process();
        }catch (Exception e) {
            e.printStackTrace();
            log.error("error occured when handle test job",e);
        }
        log.info("end to handle test job");
    }
}
