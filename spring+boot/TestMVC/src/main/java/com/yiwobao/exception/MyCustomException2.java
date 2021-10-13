package com.yiwobao.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyCustomException2 {
    @ExceptionHandler
    public ModelAndView handlerError(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("errorMsg","我应该显示404");
        return mv;
    }
}
