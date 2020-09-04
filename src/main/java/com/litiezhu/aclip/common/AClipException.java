package com.litiezhu.aclip.common;

import lombok.Data;

/**
 * @author Li Kai
 */
@Data
public class AClipException extends RuntimeException {
    /**
     * 错误码
     */
    private int errorCode;

    public AClipException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }
}
