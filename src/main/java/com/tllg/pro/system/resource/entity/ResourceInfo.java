package com.tllg.pro.system.resource.entity;

import java.util.Date;
import java.util.List;

/**
 * @author lgli
 * 资源实体类
 */
public class ResourceInfo {
    /**
     * 主键ID
     */
    private Long resourceId;

    /**
     * 资源编码
     */
    private String resourceCode;

    /**
     * 资源类型
     */
    private String resourceType;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 父级资源ID
     */
    private Long resourceParent;

    /**
     * 状态
     * 0-无效
     * 1-有效
     */
    private String resourceStatus;

    /**
     * 创建者ID
     */
    private Long resourceCreater;

    /**
     * 创建时间
     */
    private Date resourceCreateDate;

    /**
     * 资源图标
     */
    private String resourceIcon;

    /**
     * 资源路径
     */
    private String resourcePath;

    /**
     * 更新者
     */
    private Long resourceUpdater;

    /**
     * 更新时间
     */
    private Date resourceUpdateDate;

    /**
     * 资源排序
     */
    private String resourceOrder;

    /**
     * 子集资源菜单
     */
    private List<ResourceInfo> resourceInfoList;


    public List<ResourceInfo> getResourceInfoList() {
        return resourceInfoList;
    }

    public void setResourceInfoList(List<ResourceInfo> resourceInfoList) {
        this.resourceInfoList = resourceInfoList;
    }

    public String getResourceOrder() {
        return resourceOrder;
    }

    public void setResourceOrder(String resourceOrder) {
        this.resourceOrder = resourceOrder;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Long getResourceParent() {
        return resourceParent;
    }

    public void setResourceParent(Long resourceParent) {
        this.resourceParent = resourceParent;
    }

    public String getResourceStatus() {
        return resourceStatus;
    }

    public void setResourceStatus(String resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public Long getResourceCreater() {
        return resourceCreater;
    }

    public void setResourceCreater(Long resourceCreater) {
        this.resourceCreater = resourceCreater;
    }

    public Date getResourceCreateDate() {
        return resourceCreateDate;
    }

    public void setResourceCreateDate(Date resourceCreateDate) {
        this.resourceCreateDate = resourceCreateDate;
    }

    public String getResourceIcon() {
        return resourceIcon;
    }

    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public Long getResourceUpdater() {
        return resourceUpdater;
    }

    public void setResourceUpdater(Long resourceUpdater) {
        this.resourceUpdater = resourceUpdater;
    }

    public Date getResourceUpdateDate() {
        return resourceUpdateDate;
    }

    public void setResourceUpdateDate(Date resourceUpdateDate) {
        this.resourceUpdateDate = resourceUpdateDate;
    }

}
