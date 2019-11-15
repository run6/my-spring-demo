package com.idanchuang.shop.user.exception;

import com.idanchuang.shop.user.utils.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Slf4j
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    /**
     * http请求的方法不正确
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ReturnResult httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        return ReturnResult.error("错误的请求方式");
    }

    /**
     * 验证器未校验通过
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ReturnResult MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> errors =e.getBindingResult().getAllErrors();
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
        return ReturnResult.error(errorMsg.toString());
    }
}



