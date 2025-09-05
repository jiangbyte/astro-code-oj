package io.charlie.app.core.modular.sys.dict.param;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
* @author Charlie Zhang
* @version v1.0
* @date 2025-07-27
* @description 系统字典
*/
@Data
public class SysDictOptionParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String keyword;

}