package com.smart.service;
import com.smart.model.CodeGroup;
import com.smart.core.Service;

import java.util.List;


/**
 * Created by smartsoft on 2018/09/07.
 */
public interface CodeGroupService extends Service<CodeGroup> {
    /**
     * filter
     *  根据name模糊查询
     *  @param keyword 关键字
     *  @return codeGroup
     */
    List<CodeGroup> filter(String keyword);
}
