package io.charlie.app.core.modular.sys.role.controller;

import io.charlie.galaxy.result.Result;
import io.charlie.app.core.modular.sys.role.param.SysRolePageParam;
import io.charlie.app.core.modular.sys.role.param.SysRoleAddParam;
import io.charlie.app.core.modular.sys.role.param.SysRoleEditParam;
import io.charlie.app.core.modular.sys.role.param.SysRoleIdParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.charlie.app.core.modular.sys.role.service.SysRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @author Charlie Zhang
* @version v1.0
* @date 2025-07-25
* @description 角色表 控制器
*/
@Tag(name = "角色表控制器")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
@Validated
public class SysRoleController {
    private final SysRoleService sysRoleService;

    @Operation(summary = "获取角色分页")
    //@SaCheckPermission("/sys/role/page")
    @GetMapping("/sys/role/page")
    public Result<?> page(@ParameterObject SysRolePageParam sysRolePageParam) {
        return Result.success(sysRoleService.page(sysRolePageParam));
    }

    @Operation(summary = "添加角色")
    //@SaCheckPermission("/sys/role/add")
    @PostMapping("/sys/role/add")
    public Result<?> add(@RequestBody @Valid SysRoleAddParam sysRoleAddParam) {
        sysRoleService.add(sysRoleAddParam);
        return Result.success();
    }

    @Operation(summary = "编辑角色")
    //@SaCheckPermission("/sys/role/edit")
    @PostMapping("/sys/role/edit")
    public Result<?> edit(@RequestBody @Valid SysRoleEditParam sysRoleEditParam) {
        sysRoleService.edit(sysRoleEditParam);
        return Result.success();
    }

    @Operation(summary = "删除角色")
    //@SaCheckPermission("/sys/role/delete")
    @PostMapping("/sys/role/delete")
    public Result<?> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空") List<SysRoleIdParam> sysRoleIdParam) {
        sysRoleService.delete(sysRoleIdParam);
        return Result.success();
    }

    @Operation(summary = "获取角色详情")
    //@SaCheckPermission("/sys/role/detail")
    @GetMapping("/sys/role/detail")
    public Result<?> detail(@ParameterObject @Valid SysRoleIdParam sysRoleIdParam) {
        return Result.success(sysRoleService.detail(sysRoleIdParam));
    }
}