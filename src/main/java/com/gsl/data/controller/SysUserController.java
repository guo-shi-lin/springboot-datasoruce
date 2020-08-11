package com.gsl.data.controller;

import com.gsl.data.entity.SysUser;
import com.gsl.data.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户信息表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-08-10 15:07:49
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysUser selectOne(Long id) {
        return this.sysUserService.queryById(id);
    }

    @GetMapping("insert")
    public SysUser insert(SysUser sysUser) {
        return sysUserService.insert(sysUser);
    }
}