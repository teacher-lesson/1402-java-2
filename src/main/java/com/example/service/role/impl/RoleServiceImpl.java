package com.example.service.role.impl;

import com.example.dao.role.RoleDao;
import com.example.domain.role.Role;
import com.example.dto.role.RoleDto;
import com.example.service.BaseService;
import com.example.service.role.RoleMapper;
import com.example.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseService<RoleDto, Role, Integer> implements RoleService {

    private final RoleDao roleDao;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao, RoleMapper roleMapper) {
        this.roleDao = roleDao;
        this.roleMapper = roleMapper;
    }

    @Override
    protected RoleDao getDao() {
        return roleDao;
    }

    @Override
    protected RoleMapper getMapper() {
        return roleMapper;
    }
}
