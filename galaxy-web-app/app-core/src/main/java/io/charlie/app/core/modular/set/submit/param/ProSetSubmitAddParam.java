package io.charlie.app.core.modular.set.submit.param;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.charlie.galaxy.pojo.CommonEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serial;

/**
* @author Charlie Zhang
* @version v1.0
* @date 2025-07-25
* @description 题单提交 增加参数
*/
@Data
@Schema(name = "ProSetSubmit", description = "题单提交 增加参数")
public class ProSetSubmitAddParam implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "题目ID")
    private String problemId;

    @Schema(description = "题集ID")
    private String problemSetId;

    @Schema(description = "语言")
    private String language;

    @Schema(description = "代码")
    private String code;

    @Schema(description = "执行类型")
    private Boolean submitType;

    @Schema(description = "时间资源")
    private Integer maxTime;

    @Schema(description = "内存资源")
    private Integer maxMemory;

    @Schema(description = "信息")
    private String message;

    @Schema(description = "用例")
    private String testCases;

    @Schema(description = "状态")
    private String status;

    @Schema(description = "相似度")
    private BigDecimal similarity;

    @Schema(description = "相似结果")
    private String similarityResult;

}