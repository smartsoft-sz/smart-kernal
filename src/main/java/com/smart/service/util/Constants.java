package com.smart.service.util;

public interface Constants {

    interface UserStatus {
        String ACTIVE = "A"; //已激活
        String INACTIVE = "I"; //已跑路
        String PENDDING = "P"; //待激活
    }

    interface FuncCode{
        String ONLY_ONE = "只要有你";
    }

    interface Code{
        String SEMI_PRODUCT = "SEMI_PRODUCT";  //半成品
        String PRODUCT = "PRODUCT";    //成品
        String ACCUMULATED = "ACCUMULATED";   //已码垛
        String SEMI_IN = "SEMI_IN";      //已入半成品库
        String SEMI_OUT = "SEMI_OUT";      //已出半成品库
        String PACKING = "PACKING";        //已包装
        String PROD_IN = "PROD_IN";         //已入成品库
        String PROD_OUT = "PROD_OUT";        //已出成品库
        String PENDINGAPPROVE = "PENDINGAPPROVE";   //等待批准
        String DOWNGRADE = "DOWNGRADE";       //降级
        String BACK = "BACK";              //退回农厂
    }

    interface CodeGroupType{
        String TIDE = "TIDE";     //潮次
        String TIDE_DAY = "TIDE_DAY";      //潮次天数
        String MATERIAL_TYPE = "MATERIAL_TYPE";     //物料类型
        String PROCESS_STATUS = "PROCESS_STATUS";    //追溯的流转状
        String STATUS_TYPE = "A_I_STATUS";//状态类型
    }

    //物料类型
    interface MaterialType{
        String SEMI_PRODUCT = "SEMI_PRODUCT";  //半成品
        String PRODUCT = "PRODUCT";    //成品
    }

    //用户类型
    interface UserType {
        String ADMIN = "1";  // 平台运营人员
        String PICKERTEAMLEADER = "2"; // 采菇组长
    }

    //单位类型
    interface UomType{
        String KG = "KG";
        String PACK = "筐";
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
