package com.tllg.pro.system.role.entity;

import com.tllg.pro.system.resource.entity.ResourceInfo;

import java.util.Date;
import java.util.List;

/**
 * @author lgli
 * 角色实体
 */
public class RoleBaseInfo {

    /**
     * 主键ID
     */
    private Long roleId;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色状态
     * 0-有效
     * 1-无效
     */
    private String roleStatus;

    /**
     * 角色创建者
     */
    private Long roleCreater;

    /**
     * 角色创建时间
     */
    private Date roleCreateDate;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色备注
     */
    private String roleRemark;

    /**
     * 角色更新者
     */
    private Long roleUpdater;

    /**
     * 角色更新时间
     */
    private Date roleUpdateDate;

    /**
     * 父级角色ID
     */
    private Long roleParentId;

    /**
     * 角色拥有资源数据
     */
    private List<ResourceInfo> roleResources;


    public List<ResourceInfo> getRoleResources() {
        return roleResources;
    }

    public void setRoleResources(List<ResourceInfo> roleResources) {
        this.roleResources = roleResources;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public Long getRoleCreater() {
        return roleCreater;
    }

    public void setRoleCreater(Long roleCreater) {
        this.roleCreater = roleCreater;
    }

    public Date getRoleCreateDate() {
        return roleCreateDate;
    }

    public void setRoleCreateDate(Date roleCreateDate) {
        this.roleCreateDate = roleCreateDate;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    public Long getRoleUpdater() {
        return roleUpdater;
    }

    public void setRoleUpdater(Long roleUpdater) {
        this.roleUpdater = roleUpdater;
    }

    public Date getRoleUpdateDate() {
        return roleUpdateDate;
    }

    public void setRoleUpdateDate(Date roleUpdateDate) {
        this.roleUpdateDate = roleUpdateDate;
    }

    public Long getRoleParentId() {
        return roleParentId;
    }

    public void setRoleParentId(Long roleParentId) {
        this.roleParentId = roleParentId;
    }
}
