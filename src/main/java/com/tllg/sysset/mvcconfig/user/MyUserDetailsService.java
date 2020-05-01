package com.tllg.sysset.mvcconfig.user;

import com.tllg.common.StaticEnum;
import com.tllg.pro.system.resource.entity.ResourceInfo;
import com.tllg.pro.system.role.entity.RoleBaseInfo;
import com.tllg.pro.system.user.entity.UserBaseInfo;
import com.tllg.pro.system.user.entity.UserBaseSys;
import com.tllg.pro.system.user.mapper.UserMapper;
import com.tllg.util.UtilBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义UserDetailsService认证服务
 * UserDetailsService接口用于返回用户相关数据。它有loadUserByUsername()方法，根据username查询用户实体，
 * 可以实现该接口覆盖该方法，实现自定义获取用户过程。该接口实现类被DaoAuthenticationProvider 类使用，用于认证过程中载入用户信息。
 * 实现UserDetailsService，loadUserByUsername方法由springSecurity内部调用实现认证
 * @author lgli
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    protected UserMapper userMapper;


    /**
     * 自定义验证方法
     * @param name 传入用户名
     * @return UserDetails
     * @throws UsernameNotFoundException 异常
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        if(UtilBase.STRING.isBlank(name)){
            throw new UsernameNotFoundException("请传入用户名");
        }
        logger.info("传入用户名为{}的试图登录",name);
        UserBaseInfo user = userMapper.selectUserByUserUniqueSign(name, "0");
        if(user == null){
            throw new UsernameNotFoundException("无效用户");
        }
        UserBaseSys userBaseSys = new UserBaseSys(user);
        //获取用户角色
        userBaseSys.setUserResource((List<ResourceInfo>)dealWithCascade(
                userMapper.selectUserResourcesByUserUniqueSign(name, StaticEnum.ZERO.getValue()),ResourceInfo.class
        ));
        //获取用户资源
        userBaseSys.setUserRoles((List<RoleBaseInfo >)dealWithCascade(
                userMapper.selectUserRolesByUserUniqueSign(name),RoleBaseInfo.class
        ));
        logger.info("获取到用户数据，返回userDetail");
        return userBaseSys;
    }

    /**
     * 处理级联数据
     * @param object 数据对象
     * @return Object 返回数据对象级联
     */
    private Object dealWithCascade(Object object,Class<?> classes){
        boolean isEmpty = null == classes || null == object;
        if(isEmpty){
            return null;
        }
        if ("ResourceInfo".equals(classes.getSimpleName())){
            //资源菜单
            return dealWithCascadeResource(object, new ArrayList<>());
        }else if("RoleBaseInfo".equals(classes.getSimpleName())){
            //角色菜单
            return dealWithCascadeRole(object);
        }
        return null;
    }

    /**
     * 角色信息的处理
     * @param object 角色信息数据
     * @return Object
     */
    private Object dealWithCascadeRole(Object object) {

        return null;
    }

    /**
     * 资源菜单的处理，资源菜单拼装
     * @param object 查询的资源菜单数据
     * @param resource 需要返回的资源菜单数据
     * @return Object
     */
    private Object dealWithCascadeResource(Object object,List<ResourceInfo> resource) {
        if(object instanceof List){
            List<ResourceInfo> list;
            list = (List<ResourceInfo>) object;
            //先排序，方便数据处理
            list = sortListOfResource(new ArrayList<>(),new ArrayList<>(),list);
            for (ResourceInfo res : list){
                if(null != res.getResourceParent()){
                    //有父级资源，找到父级资源，并组装到父级资源上
                    dealWithCascadeResourceRecursion(res,resource);
                }else{
                    //没有父级资源，则独立成为父级资源
                    if (!resource.contains(res)){
                        resource.add(res);
                    }
                }
            }
            return resource;
        }
        return null;
    }

    /**
     * 数据排序处理
     * @param result 排序结果
     * @param addId 已添加的数据
     * @param list 待排序数据
     * @return List
     */
    private List<ResourceInfo> sortListOfResource(List<ResourceInfo> result,List<Long> addId,
            List<ResourceInfo> list) {
        List<ResourceInfo> wait = new ArrayList<>();
        for(ResourceInfo info : list){
            if (null == info.getResourceParent()){
                result.add(info);
                addId.add(info.getResourceId());
            }else{
                if(addId.contains(info.getResourceParent())){
                    result.add(info);
                    addId.add(info.getResourceId());
                }else{
                    wait.add(info);
                }
            }
        }
        if(!wait.isEmpty()){
            sortListOfResource(result, addId, wait);
        }
        return result;
    }

    /**
     * 递归处理
     * @param res 资源
     * @param resource 资源list
     */
    private void dealWithCascadeResourceRecursion(ResourceInfo res, List<ResourceInfo> resource) {
        if(null == resource){
           return;
        }
        for(ResourceInfo ress : resource){
            if(ress.getResourceId().equals(res.getResourceParent())){
                List<ResourceInfo> rif = new ArrayList<>();
                boolean isHas = null != ress.getResourceInfoList() && !ress.getResourceInfoList().isEmpty();
                if(isHas){
                    rif.addAll(ress.getResourceInfoList());
                }
                rif.add(res);
                ress.setResourceInfoList(rif);
            }else{
                dealWithCascadeResourceRecursion(res,ress.getResourceInfoList());
            }
        }
    }


}
