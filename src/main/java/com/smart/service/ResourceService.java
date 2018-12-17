package com.smart.service;
import com.smart.model.Resource;
import com.smart.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/25.
 */
public interface ResourceService extends Service<Resource> {

    List<Resource> getResourcesByPermissionId(Long id);

    List<Resource> filter(String keyword);

}
