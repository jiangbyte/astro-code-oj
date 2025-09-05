package io.charlie.app.core.modular.sys.category.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.charlie.galaxy.pojo.CommonEntity;

import java.io.Serial;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author Charlie Zhang
* @version v1.0
* @date 2025-07-25
* @description 分类表
*/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_category")
@Schema(name = "SysCategory", description = "分类表")
public class SysCategory extends CommonEntity {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    private String id;

    @Schema(description = "名称")
    private String name;
}
