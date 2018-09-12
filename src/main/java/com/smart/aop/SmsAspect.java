package com.smart.aop;

//import com.yg.model.order.Order;
//import com.yg.model.order.OrderStFlow;
//import com.yg.service.SmsConfigService;
//import com.yg.service.order.OrderService;
//import Constants;
//import com.yg.service.wx.WXCommonService;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
     * @Author: zhang kun
     * @Date: Created in 2018年4月10日09:37:15
     */
    @Component
    @Aspect
    public class SmsAspect {

//        private static final Logger logger = LoggerFactory.getLogger(SmsAspect.class);
//
//        @Resource
//        private SmsConfigService smsConfigService;
//
//        @Resource
//        private WXCommonService wxCommonService;
//
//        @Resource
//        private OrderService orderService;
//
//        @Pointcut("execution(* com.yg.service.order.OrderStFlowService.saveFilter(..))")
//        public void smsPoint() {}
//
//        @Before("smsPoint()")
//        public void before(JoinPoint joinPoint) {
//            logger.info("create开始前通知");
//        }
//
//        @AfterReturning("smsPoint()")
//        public void afterReturning(JoinPoint joinPoint) {
//            logger.info("create结束后通知");
//            Object[] objects = joinPoint.getArgs();
//            if(objects != null){
//                OrderStFlow orderStFlow = (OrderStFlow) objects[0];
//                Order order = orderService.findByOrderNum(orderStFlow.getOrderNum());
//                int procStatus = orderStFlow.getProcStatus();
//                    switch (procStatus) {
//                        case 1:
//                            if(order.getCubId() != null){
//                                if(orderStFlow.getMsg().equals("已下单")){
//                                    smsConfigService.sendSendCodeSMS(orderStFlow);
//                                    wxCommonService.sendStoreCodeToUser(order);
//                                }
//                            }
//                            break;
//                        case 2:
//                            if(order.getCubId() != null){
//                                wxCommonService.storeSucessNotice(order);
//                            }else {
//                                wxCommonService.newOrderTemplateToCustome(order);
//                            }
//                            wxCommonService.newOrderTemplatePick(order);
//                            break;
//                        case 3:
//                            if(order.getUserId() != null && order.getCubId() == null){
//                                wxCommonService.pickUpToHome(order);
//                            }
//                            break;
//                        case 4:
//                            if(order.getCubId() != null){
//                                wxCommonService.pickSuccessNotice(order);
//                            }
//                            break;
//                        case 6:
//                            smsConfigService.putStorageAndPayment(orderStFlow, order.getActTAmt());
//                            wxCommonService.orderPriceChange(order);
//                            break;
//                        case 7:
//                            wxCommonService.newOrderTemplateSend(order);
//                            break;
//                        case 8:
//                            if(order.getUserId() != null &&order.getCubId() ==null){
//                                wxCommonService.sendToHome(order);
//                            }
//                            break;
//                        case 9:
//                            if(order.getCubId() != null){
//                                if(order.getPayStatus().equals(Constants.OrderPayStatus.SUCCESS) || order.getStatus().equals(Constants.OrderStatus.ABOLISHED)){
//                                    smsConfigService.sendTakeCodeSMS(orderStFlow);
//                                    wxCommonService.sendPickCodeToUser(order);
//                                }else {
//                                    smsConfigService.paymentAndTakeOrder(orderStFlow);
//                                    wxCommonService.paymentNotice(order);
//                                }
//                            }else {
//                                if(!order.getPayStatus().equals(Constants.OrderPayStatus.SUCCESS) && !order.getStatus().equals(Constants.OrderStatus.ABOLISHED)){
//                                    wxCommonService.paymentNotice(order);
//                                }
//                            }
//                            break;
//                        case 10:
//                            if(order.getProcStatus().equals(Constants.ProcessStatus.PROCESS_LOADING_SENDER)){
//                                smsConfigService.sendTakeCodeSMS(orderStFlow);
//                                wxCommonService.sendPickCodeToUser(order);
//                            }
//                            break;
//                        case 11:
//                            wxCommonService.orderFinishNotice(order);
//                            break;
//                        case 12:
//                            wxCommonService.cancelOrderTemplateToDispatch(order);
//                            wxCommonService.cancelOrderTemplateToUser(order);
//                            break;
//                        case 13:
//                            wxCommonService.orderAbolishNotice(order);
//                            break;
//                        default:
//                            logger.info("此状态无需发送手机信息");
//                            break;
//                    }
//
//            }else{
//                logger.info("插入状态为空！");
//            }
//        }
//
//        @AfterThrowing(throwing="e",pointcut="smsPoint()")
//        public void afterThrowing(Throwable e) {
//            logger.info("create出错后通知");
//        }
}
