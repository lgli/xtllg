package com.tllg.pro.system.user.entity;

import com.tllg.pro.system.resource.entity.ResourceInfo;
import com.tllg.pro.system.role.entity.RoleBaseInfo;

import java.util.Date;
import java.util.List;

/**
 * @author lgli
 * 用户基本信息类
 */
public class UserBaseInfo {
    /**
     * 主键ID
     */
    private Long userId;

    /**
     * 唯一识别编号
     */
    private String userUniqueSign;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户真实姓名
     */
    private String userName;

    /**
     * 性别
     * 0-男
     * 1-女
     */
    private String userSex;

    /**
     * 出生年月
     */
    private Date userBirthday;

    /**
     * 最高学历
     */
    private String userEducation;

    /**
     * 联系电话
     */
    private String userContact;

    /**
     * 用户状态
     */
    private String userStatus;


    /**
     * 创建者
     */
    private String userCreater;

    /**
     * 创建日期
     */
    private Date userCreateDate;

    /**
     * 更新者
     */
    private Long userUpdater;

    /**
     * 更新时间
     */
    private Date userUpdateDate;

    /**
     * 用户拥有资源数据
     */
    private List<ResourceInfo> userResource;

    /**
     * 用户有拥有角色数据
     */
    private List<RoleBaseInfo> userRoles;



    public List<RoleBaseInfo> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<RoleBaseInfo> userRoles) {
        this.userRoles = userRoles;
    }

    public List<ResourceInfo> getUserResource() {
        return userResource;
    }

    public void setUserResource(List<ResourceInfo> userResource) {
        this.userResource = userResource;
    }

    public Long getUserUpdater() {
        return userUpdater;
    }

    public void setUserUpdater(Long userUpdater) {
        this.userUpdater = userUpdater;
    }

    public Date getUserUpdateDate() {
        return userUpdateDate;
    }

    public void setUserUpdateDate(Date userUpdateDate) {
        this.userUpdateDate = userUpdateDate;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserCreater() {
        return userCreater;
    }

    public void setUserCreater(String userCreater) {
        this.userCreater = userCreater;
    }

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserUniqueSign(String userUniqueSign) {
        this.userUniqueSign = userUniqueSign;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public void setUserEducation(String userEducation) {
        this.userEducation = userEducation;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserUniqueSign() {
        return userUniqueSign;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public String getUserEducation() {
        return userEducation;
    }

    public String getUserContact() {
        return userContact;
    }
}
