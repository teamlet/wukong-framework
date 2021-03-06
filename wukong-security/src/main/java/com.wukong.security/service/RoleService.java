package com.wukong.security.service;

import com.wukong.security.model.Role;
import com.wukong.security.model.RoleExample;
import com.wukong.security.dao.RoleMapper;

import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

// 本类内方法指定使用缓存时，默认的名称就是userCache
@Service
@Slf4j
//@CacheConfig(cacheNames="wukong:role")
public class RoleService {
    //利用SpingIOC注入DAO变量
    @Autowired
    private RoleMapper roleMapper;

    @Transactional(readOnly=true)
    public long countByExample(RoleExample example) {
        return roleMapper.countByExample(example);
    }

    @Transactional
    public int deleteByExample(RoleExample example) {
        return roleMapper.deleteByExample(example);
    }

    @Transactional
    public int deleteByPrimaryKey(Integer roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    @Transactional
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Transactional
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Transactional(readOnly=true)
    public List<Role> selectByExample(RoleExample example) {
        return roleMapper.selectByExample(example);
    }

    @Transactional(readOnly=true)
    public Role selectByPrimaryKey(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Transactional
    public int updateByExampleSelective(@Param("record") Role record,@Param("example") RoleExample example) {
        return roleMapper.updateByExampleSelective(record,example);
    }

    @Transactional
    public int updateByExample(@Param("record") Role record,@Param("example") RoleExample example) {
        return roleMapper.updateByExample(record,example);
    }

    @Transactional
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
    @Cacheable(cacheNames="wukong:role" , key = "#userid.toString()")
    public List<Role> selectRolesByUserid(Integer userid){
        return roleMapper.selectRolesByUserid(userid);

    }

}