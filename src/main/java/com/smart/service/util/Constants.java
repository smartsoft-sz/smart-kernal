package com.smart.service.util;

public interface Constants {

    /**
     * Job运行结果的三种状态-正在运行
     */
     String JOB_RUN_RESULT_STATUS_INPROGRESS = "INPROGRESS";

    /**
     * Job运行结果的三种状态-运行成功
     */
     String JOB_RUN_RESULT_STATUS_SUCCESS = "SUCCESS";

    /**
     * Job运行结果的三种状态-运行失败
     */
    String JOB_RUN_RESULT_STATUS_FAILED = "FAILED";

    /**
     * Job重跑结果的两种种状态-正在运行
     */
    String JOB_RERUN_RESULT_STATUS_INPROGRESS = "INPROGRESS";

    /**
     * Job重跑结果的两种种状态-重跑完成
     */
    String JOB_RERUN_RESULT_STATUS_COMPLETED = "COMPLETED";

    /**
     * Job重跑项的两种种状态-当前重跑项成功
     */
    String JOB_RERUN_RESULT_ITEM_STATUS_SUCCESS = "SUCCESS";

    /**
     * Job重跑项的两种种状态-当前重跑项错误
     */
    String JOB_RERUN_RESULT_ITEM_STATUS_ERROR = "ERROR";

    interface UserStatus {
        String ACTIVE = "A"; //已激活
        String INACTIVE = "I"; //已跑路
        String PENDDING = "P"; //待激活
    }

    interface FuncCode{
        String ONLY_ONE = "只要有你";
    }

    interface NormalStatusInt {
        int ACTIVE = 1;
        int INACTIVE = 0;
    }

    interface Code{

    }

    interface CodeGroupType{

    }



    //用户类型
    interface UserType {
        String ADMIN = "1";  // 平台运营人员

    }

    interface BeanName {
        String MATERIAL_SERVICE="baseMaterialServiceImpl";
        String WAREHOUSE_SERVICE = "baseWarehouseServiceImpl";
        String CODE_SERVICE = "codeServiceImpl";
    }

    interface StackAndPackNumType{
        String STACKNUMTYPE = "D";
        String PACKNUMTYPE = "X";
    }

    interface WaitingRevise{
    }

    interface WarehouseType{
        String SEMIPRODUCT = "SEMI_PRODUCT";
        String PRODUCT = "PRODUCT";
    }

    interface MaterialNumType{
        String SEMIPRODUCT = "2";
        String PRODUCT = "1";
    }

    String KEY_SEQ_NAME_BATCH = "BATCH_KEY";
}
