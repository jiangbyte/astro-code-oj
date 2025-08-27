package io.charlie.app.core.modular.problem.solved.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.charlie.app.core.modular.problem.solved.entity.ProSolved;
import io.charlie.app.core.modular.problem.solved.param.ProSolvedAddParam;
import io.charlie.app.core.modular.problem.solved.param.ProSolvedEditParam;
import io.charlie.app.core.modular.problem.solved.param.ProSolvedIdParam;
import io.charlie.app.core.modular.problem.solved.param.ProSolvedPageParam;

import java.math.BigDecimal;
import java.util.List;

/**
* @author Charlie Zhang
* @version v1.0
* @date 2025-07-25
* @description 用户解决表 服务类
*/
public interface ProSolvedService extends IService<ProSolved> {
    Page<ProSolved> page(ProSolvedPageParam proSolvedPageParam);

    void add(ProSolvedAddParam proSolvedAddParam);

    void edit(ProSolvedEditParam proSolvedEditParam);

    void delete(List<ProSolvedIdParam> proSolvedIdParamList);

    ProSolved detail(ProSolvedIdParam proSolvedIdParam);

    // 获取用户已解决题目
    String getUserSolvedProblem();

    // 获得平均通过率
    BigDecimal getAveragePassRate();
}