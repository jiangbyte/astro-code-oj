package io.charlie.app.core.modular.sys.group.controller;

import io.charlie.app.core.modular.sys.group.param.*;
import io.charlie.app.core.modular.sys.group.service.SysGroupService;
import io.charlie.app.core.modular.sys.user.param.SysUserOptionParam;
import io.charlie.galaxy.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @author Charlie Zhang
* @version v1.0
* @date 2025-07-25
* @description 用户组表 控制器
*/
@Tag(name = "用户组表控制器")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
@Validated
public class SysGroupController {
    private final SysGroupService sysGroupService;

    @Operation(summary = "获取用户组分页")
    //@SaCheckPermission("/sys/group/page")
    @GetMapping("/sys/group/page")
    public Result<?> page(@ParameterObject SysGroupPageParam sysGroupPageParam) {
        return Result.success(sysGroupService.page(sysGroupPageParam));
    }

    @Operation(summary = "添加用户组")
    //@SaCheckPermission("/sys/group/add")
    @PostMapping("/sys/group/add")
    public Result<?> add(@RequestBody @Valid SysGroupAddParam sysGroupAddParam) {
        sysGroupService.add(sysGroupAddParam);
        return Result.success();
    }

    @Operation(summary = "编辑用户组")
    //@SaCheckPermission("/sys/group/edit")
    @PostMapping("/sys/group/edit")
    public Result<?> edit(@RequestBody @Valid SysGroupEditParam sysGroupEditParam) {
        sysGroupService.edit(sysGroupEditParam);
        return Result.success();
    }

    @Operation(summary = "删除用户组")
    //@SaCheckPermission("/sys/group/delete")
    @PostMapping("/sys/group/delete")
    public Result<?> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空") List<SysGroupIdParam> sysGroupIdParam) {
        sysGroupService.delete(sysGroupIdParam);
        return Result.success();
    }

    @Operation(summary = "获取用户组详情")
    //@SaCheckPermission("/sys/group/detail")
    @GetMapping("/sys/group/detail")
    public Result<?> detail(@ParameterObject @Valid SysGroupIdParam sysGroupIdParam) {
        return Result.success(sysGroupService.detail(sysGroupIdParam));
    }

    @Operation(summary = "用户选项列表")
    @GetMapping("/sys/group/options")
    public Result<?> options(@ParameterObject SysGroupOptionParam sysGroupOptionParam) {
        return Result.success(sysGroupService.options(sysGroupOptionParam));
    }
}