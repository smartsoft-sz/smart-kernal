package com.smart.core;


import com.smart.model.User;
import com.smart.security.SecurityUtils;
import com.smart.service.UserService;
import com.smart.service.util.HanyuPinyin;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {

    private static String field_name_create_user_id = "createdBy";

    private static String field_name_create_date = "createdDate";

    private static String field_name_update_user_id = "lastModifiedBy";

    private static String field_name_update_date = "lastModifiedDate";

    private static String field_name_version = "version";

    private static String field_name_name = "name";

    private static String field_name_pinyin = "namePinyin";

    private static String field_name_id = "id";

    private static String field_operate_date = "operateDate";

    private static String field_operate_month = "operateMonth";

    private static String field_operate_year = "operateYear";

    private static String field_operate_datetime = "operateDatetime";

    private static String field_operator_name = "operatorName";

    @Autowired
    protected Mapper<T> mapper;

    @Resource
    private UserService userService;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    private boolean isFieldExist(T entity, String fieldName) {
        Field obj = Reflections.getAccessibleField(entity, fieldName);
        if (obj != null) {
            return true;
        }
        return false;
    }

    private void populateAuditInfo(T model, String actionType) {
        Long currentUserId = SecurityUtils.getCurrentUserId();
//        Date currentDate = new Date();
        LocalDateTime currentDate = LocalDateTime.now();
        if("create".equalsIgnoreCase(actionType)) {
            if (isFieldExist(model, field_name_create_date)) {
                LocalDateTime createDate = (LocalDateTime) Reflections.invokeGetter(model, field_name_create_date);
                if (createDate == null) {
                    Reflections.invokeSetter(model, field_name_create_date, currentDate);
                }
            }

            if (isFieldExist(model, field_name_create_user_id)) {
                Long createUserId = (Long) Reflections.invokeGetter(model, field_name_create_user_id);
                if (createUserId == null) {
                    Reflections.invokeSetter(model, field_name_create_user_id, currentUserId);
                }

            }

            if(isFieldExist(model, field_operate_datetime)){
                LocalDateTime operateDatetime = (LocalDateTime) Reflections.invokeGetter(model, field_operate_datetime);
                if(operateDatetime == null){
                    Reflections.invokeSetter(model, field_operate_datetime, currentDate);
                }
            }

            if(isFieldExist(model, field_operate_date)){
                LocalDate operateDate = (LocalDate) Reflections.invokeGetter(model, field_operate_date);
                if(operateDate == null){
                    Reflections.invokeSetter(model, field_operate_date, currentDate.toLocalDate());
                }
            }

            if(isFieldExist(model, field_operate_year)){
                String operateYear = (String) Reflections.invokeGetter(model, field_operate_year);
                if(operateYear == null){
                    Reflections.invokeSetter(model, field_operate_year, String.valueOf(currentDate.getYear()));
                }
            }

            if(isFieldExist(model, field_operate_month)){
                String operateMonth = (String) Reflections.invokeGetter(model, field_operate_month);
                if(operateMonth == null){
                    String year = String.valueOf(currentDate.getYear());
                    String month = String.valueOf(currentDate.getMonthValue());
                    String monthOfYear = "";
                    if(Integer.parseInt(month)>0 && Integer.parseInt(month)<9){
                        monthOfYear = year + "0" +month;
                    }else{
                        monthOfYear = year + month;
                    }
                    Reflections.invokeSetter(model, field_operate_month, monthOfYear);
                }
            }

            if(isFieldExist(model, field_operator_name)){
                String operatorName = (String) Reflections.invokeGetter(model, field_operator_name);
                if(operatorName == null){
                    if(currentUserId != null){
                        User user = userService.findById(currentUserId);
                        Reflections.invokeSetter(model, field_operator_name, "张三");
                    }
                }
            }
        }

        if (isFieldExist(model, field_name_update_date)) {
//            Date udateDate = (Date)Reflections.invokeGetter(model, field_name_update_date);
//            if(udateDate == null){
            Reflections.invokeSetter(model, field_name_update_date, currentDate);
//            }
        }

        if (isFieldExist(model, field_name_update_user_id)) {
//            Long updateUserId = (Long) Reflections.invokeGetter(model, field_name_update_user_id);
//            if (updateUserId == null) {
                Reflections.invokeSetter(model, field_name_update_user_id, currentUserId);
//            }

        }

        if (isFieldExist(model, field_name_version)) {
            if ("update".equalsIgnoreCase(actionType)) {
                Integer version = (Integer) Reflections.invokeGetter(model, field_name_version);
                T currentEntity = mapper.selectByPrimaryKey(model);
                Integer currentVersion = (Integer) Reflections.invokeGetter(currentEntity, field_name_version);

                if (currentEntity == null || (currentVersion != null && !version.equals(currentVersion))) {
                    throw new RuntimeException(String.format("concurrent update for entity: {0}", model));
                }

                Reflections.invokeSetter(model, field_name_version, version + 1);

            } else {
                Reflections.invokeSetter(model, field_name_version, 1);
            }

        }

        if (isFieldExist(model, field_name_name) && isFieldExist(model, field_name_pinyin)) {
            String namePinYin = (String) Reflections.invokeGetter(model, field_name_name);
            namePinYin = HanyuPinyin.getStringPinYin(namePinYin);
            Reflections.invokeSetter(model, field_name_pinyin, namePinYin);
        }

    }

    public Long save(T model) {

        this.populateAuditInfo(model, "create");

        mapper.insertSelective(model);

        if(isFieldExist(model,field_name_id)){
            return (long) Reflections.invokeGetter(model, field_name_id);
        }else{
            return null;
        }
    }

    public int save(List<T> models) {
        models.forEach(model -> {
            this.populateAuditInfo(model, "create");
            Reflections.invokeSetter(model, field_name_version, 1);
        });
        return mapper.insertList(models);
    }

    public void deleteByPK(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

//    public void deleteByIds(String ids) {
//        mapper.deleteByIds(ids);
//    }

    public int updateByPK(T model) {
        this.populateAuditInfo(model, "update");
        return mapper.updateByPrimaryKey(model);
        
    }
    
    public int updateByPKSelective(T model) {
    	this.populateAuditInfo(model, "update");
    	return mapper.updateByPrimaryKeySelective(model);
    }

    public T findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
    
    public T findOne(T entity){
        T result = mapper.selectOne(entity);
        return result;
    }
    
    @Override
    public int count(T entity) {
        int result =  mapper.selectCount(entity);
        return result;
    }
    
    @Override
    public List<T> find(T entity) {
    		List<T> result = mapper.select(entity);
        return result;
    }

//    @Override
//    public T findBy(String fieldName, Object value) throws TooManyResultsException {
//        try {
//            T model = modelClass.newInstance();
//            Field field = modelClass.getDeclaredField(fieldName);
//            field.setAccessible(true);
//            field.set(model, value);
//            return mapper.selectOne(model);
//        } catch (ReflectiveOperationException e) {
//            throw new ServiceException(e.getMessage(), e);
//        }
//    }

//    public List<T> findByIds(String ids) {
//        return mapper.selectByIds(ids);
//    }

    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    public List<T> findAll() {
        return mapper.selectAll();
    }
}
