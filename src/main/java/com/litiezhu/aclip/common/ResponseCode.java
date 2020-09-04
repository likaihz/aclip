package com.litiezhu.aclip.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Li Kai
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILEEGAL_ARGUMENT(2, "ILEEGAL_ARGUMENT");

    private final int code;
    private final String desc;

}
