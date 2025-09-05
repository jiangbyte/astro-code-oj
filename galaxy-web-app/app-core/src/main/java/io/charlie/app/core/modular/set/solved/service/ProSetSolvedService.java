package io.charlie.app.core.modular.set.solved.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.charlie.app.core.modular.set.solved.entity.ProSetSolved;
import io.charlie.app.core.modular.set.solved.param.*;
import io.charlie.app.core.modular.sys.user.entity.SysUser;

import java.util.List;

/**
* @author Charlie Zhang
* @version v1.0
* @date 2025-07-25
* @description 用户题集解决记录表 服务类
*/
public interface ProSetSolvedService extends IService<ProSetSolved> {
    Page<ProSetSolved> page(ProSetSolvedPageParam proSetSolvedPageParam);

    void add(ProSetSolvedAddParam proSetSolvedAddParam);

    void edit(ProSetSolvedEditParam proSetSolvedEditParam);

    void delete(List<ProSetSolvedIdParam> proSetSolvedIdParamList);

    ProSetSolved detail(ProSetSolvedIdParam proSetSolvedIdParam);

    Page<SysUser> userPage(ProSetUserPageParam proSetUserPageParam);

}