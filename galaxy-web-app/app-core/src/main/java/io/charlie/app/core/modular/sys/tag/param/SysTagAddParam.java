package io.charlie.app.core.modular.sys.tag.param;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serial;

/**
* @author Charlie Zhang
* @version v1.0
* @date 2025-07-25
* @description 标签 增加参数
*/
@Data
@Schema(name = "SysTag", description = "标签 增加参数")
public class SysTagAddParam implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Schema(description = "名称")
    private String name;

}