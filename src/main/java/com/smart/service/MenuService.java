package com.smart.service;
import com.smart.bo.MenuBO;
import com.smart.core.Result;
import com.smart.model.Menu;
import com.smart.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018/09/03.
 */
public interface MenuService extends Service<Menu> {

    List<Menu> findAllMenusWithPermissions();

    void addMenu(Menu menu);

    void deleteMenu(Long id);

    void updateMenu(Menu menu);

    Menu findMenuDetial(Long id);

    Map<Long,List<MenuBO>> listMenuBO();
}
