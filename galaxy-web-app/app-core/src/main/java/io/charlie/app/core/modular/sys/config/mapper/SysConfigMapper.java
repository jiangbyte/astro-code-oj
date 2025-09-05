package io.charlie.app.core.modular.sys.config.mapper;

import io.charlie.app.core.modular.sys.config.entity.SysConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Charlie Zhang
* @version v1.0
* @date 2025-07-25
* @description 系统配置表 Mapper 接口
*/
@Mapper
//@CacheNamespace(implementation = MybatisPlusRedisCache.class, eviction = MybatisPlusRedisCache.class)
public interface SysConfigMapper extends BaseMapper<SysConfig> {

}
