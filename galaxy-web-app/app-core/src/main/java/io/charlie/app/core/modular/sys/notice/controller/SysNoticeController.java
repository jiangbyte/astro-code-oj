package io.charlie.app.core.modular.sys.notice.controller;

import io.charlie.app.core.modular.sys.notice.param.SysNoticeAddParam;
import io.charlie.app.core.modular.sys.notice.param.SysNoticeEditParam;
import io.charlie.app.core.modular.sys.notice.param.SysNoticeIdParam;
import io.charlie.app.core.modular.sys.notice.param.SysNoticePageParam;
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
import io.charlie.app.core.modular.sys.notice.service.SysNoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @author Charlie Zhang
* @version v1.0
* @date 2025-07-25
* @description 公告表 控制器
*/
@Tag(name = "公告表控制器")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
@Validated
public class SysNoticeController {
    private final SysNoticeService sysNoticeService;

    @Operation(summary = "获取公告分页")
    //@SaCheckPermission("/sys/notice/page")
    @GetMapping("/sys/notice/page")
    public Result<?> page(@ParameterObject SysNoticePageParam sysNoticePageParam) {
        return Result.success(sysNoticeService.page(sysNoticePageParam));
    }

    @Operation(summary = "添加公告")
    //@SaCheckPermission("/sys/notice/add")
    @PostMapping("/sys/notice/add")
    public Result<?> add(@RequestBody @Valid SysNoticeAddParam sysNoticeAddParam) {
        sysNoticeService.add(sysNoticeAddParam);
        return Result.success();
    }

    @Operation(summary = "编辑公告")
    //@SaCheckPermission("/sys/notice/edit")
    @PostMapping("/sys/notice/edit")
    public Result<?> edit(@RequestBody @Valid SysNoticeEditParam sysNoticeEditParam) {
        sysNoticeService.edit(sysNoticeEditParam);
        return Result.success();
    }

    @Operation(summary = "删除公告")
    //@SaCheckPermission("/sys/notice/delete")
    @PostMapping("/sys/notice/delete")
    public Result<?> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空") List<SysNoticeIdParam> sysNoticeIdParam) {
        sysNoticeService.delete(sysNoticeIdParam);
        return Result.success();
    }

    @Operation(summary = "获取公告详情")
    //@SaCheckPermission("/sys/notice/detail")
    @GetMapping("/sys/notice/detail")
    public Result<?> detail(@ParameterObject @Valid SysNoticeIdParam sysNoticeIdParam) {
        return Result.success(sysNoticeService.detail(sysNoticeIdParam));
    }

    @Operation(summary = "获取最新N条公告")
    @GetMapping("/sys/notice/latest")
    public Result<?> latest10() {
        return Result.success(sysNoticeService.latestN(4));
    }
}