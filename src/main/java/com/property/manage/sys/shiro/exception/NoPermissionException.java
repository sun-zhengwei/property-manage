package com.property.manage.sys.shiro.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: NoPermissionException
 * @description:
 * @author: sunzhengwei
 * @create: 2020/7/13 11:00
 */
@ControllerAdvice
public class NoPermissionException {
    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public ModelAndView handleShiroException(Exception ex) {
        ModelAndView mv = new ModelAndView("/demoproject/demo/notRole");
        return mv;
    }

    @ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public ModelAndView AuthorizationException(Exception ex) {
        ModelAndView mv = new ModelAndView("/demoproject/demo/notRole");
        return mv;
    }
}
