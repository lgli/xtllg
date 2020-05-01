package com.tllg.pro.system.user.mapper;


import com.tllg.pro.system.resource.entity.ResourceInfo;
import com.tllg.pro.system.role.entity.RoleBaseInfo;
import com.tllg.pro.system.user.entity.UserBaseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 查询admin
     * @return String
     */
    String selectMain();

    /**
     * 根据用户唯一识别码查询用户
     * @param userSign 登陆唯一识别码
     * @param status 用户当前在系统状态
     * @return UserBaseInfo
     */
    UserBaseInfo selectUserByUserUniqueSign(@Param("userSign") String userSign, @Param("status")String status);

    /**
     * 根据用户唯一识别码查询用户资源菜单
     * @param userSign 登陆唯一识别码
     * @param type 查询类型 为空查询all
     * @return List<ResourceInfo>
     */
    List<ResourceInfo> selectUserResourcesByUserUniqueSign(@Param("userSign") String userSign,
                                                           @Param("type")String type);

    /**
     * 根据用户唯一识别码查询用户角色信息
     * @param userSign 登陆唯一识别码
     * @return List<RoleBaseInfo>
     */
    List<RoleBaseInfo> selectUserRolesByUserUniqueSign(@Param("userSign") String userSign);
}
