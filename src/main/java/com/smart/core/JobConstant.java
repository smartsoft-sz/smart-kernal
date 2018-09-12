package com.smart.core;

/**
 * @Author: Jinmeng Tang
 * @Date: Created in 2018/3/27 下午4:25
 */
public class JobConstant {

    /**
     * Job运行结果的三种状态-正在运行
     */
    public static final String JOB_RUN_RESULT_STATUS_INPROGRESS = "INPROGRESS";

    /**
     * Job运行结果的三种状态-运行成功
     */
    public static final String JOB_RUN_RESULT_STATUS_SUCCESS = "SUCCESS";

    /**
     * Job运行结果的三种状态-运行失败
     */
    public static final String JOB_RUN_RESULT_STATUS_FAILED = "FAILED";

    /**
     * Job重跑结果的两种种状态-正在运行
     */
    public static final String JOB_RERUN_RESULT_STATUS_INPROGRESS = "INPROGRESS";

    /**
     * Job重跑结果的两种种状态-重跑完成
     */
    public static final String JOB_RERUN_RESULT_STATUS_COMPLETED = "COMPLETED";

    /**
     * Job重跑项的两种种状态-当前重跑项成功
     */
    public static final String JOB_RERUN_RESULT_ITEM_STATUS_SUCCESS = "SUCCESS";

    /**
     * Job重跑项的两种种状态-当前重跑项错误
     */
    public static final String JOB_RERUN_RESULT_ITEM_STATUS_ERROR = "ERROR";

}
