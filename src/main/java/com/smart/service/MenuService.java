package com.smart.service;
import com.smart.core.Result;
import com.smart.model.Menu;
import com.smart.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/09/03.
 */
public interface MenuService extends Service<Menu> {

    List<Menu> findAllMenusWithRoles();
}
