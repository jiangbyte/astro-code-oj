package io.charlie.web.oj.modular.sys.article.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.charlie.web.oj.modular.sys.article.entity.SysArticle;
import io.charlie.web.oj.modular.sys.article.param.SysArticleAddParam;
import io.charlie.web.oj.modular.sys.article.param.SysArticleEditParam;
import io.charlie.web.oj.modular.sys.article.param.SysArticleIdParam;
import io.charlie.web.oj.modular.sys.article.param.SysArticlePageParam;

import java.util.List;

/**
* @author Charlie Zhang
* @version v1.0
* @date 2025-09-20
* @description 系统文章表 服务类
*/
public interface SysArticleService extends IService<SysArticle> {
    Page<SysArticle> page(SysArticlePageParam sysArticlePageParam);

    void add(SysArticleAddParam sysArticleAddParam);

    void edit(SysArticleEditParam sysArticleEditParam);

    void delete(List<SysArticleIdParam> sysArticleIdParamList);

    SysArticle detail(SysArticleIdParam sysArticleIdParam);

}