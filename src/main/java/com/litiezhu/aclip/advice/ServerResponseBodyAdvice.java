package com.litiezhu.aclip.advice;

import com.litiezhu.aclip.common.AClipException;
import com.litiezhu.aclip.common.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Li Kai
 */
@ControllerAdvice
@Slf4j
public class ServerResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public ServerResponse beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if (o instanceof ServerResponse) {
            return (ServerResponse) o;
        } else if (o == null && MediaType.APPLICATION_JSON.equals(mediaType)) {
            return ServerResponse.createBySuccessMessage("成功");
        } else {
            return ServerResponse.createBySuccess(o);
        }
    }

    @ExceptionHandler(AClipException.class)
    @ResponseBody
    public ServerResponse handleAClipException(AClipException e) {
        log.error(e.getMessage(), e);
        return ServerResponse.createByErrorCodeMessage(e.getErrorCode(), e.getMessage());
    }
}
