package io.charlie.app.core.modular.auth.param;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 23/07/2025
 * @description 用户名密码登录参数
 */
@Data
public class UsernamePasswordEmailRegisterParam {
    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Schema(description = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Schema(description = "邮箱")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @Schema(description = "验证码")
    private String captchaCode;

    @Schema(description = "验证码编号")
    private String uuid;
}
