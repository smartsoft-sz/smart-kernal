package com.smart.model;

import javax.persistence.*;

@Table(name = "tbl_menu_permission")
public class MenuPermission {
    @Id
    @Column(name = "menu_id")
    private Long menuId;

    @Id
    @Column(name = "permission_id")
    private Long permissionId;

    /**
     * @return menu_id
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}