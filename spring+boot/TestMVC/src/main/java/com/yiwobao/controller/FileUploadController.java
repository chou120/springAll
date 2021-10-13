package com.yiwobao.controller;

import com.yiwobao.pojo.FileDomain;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class FileUploadController {
    // 得到一个用来记录日志的对象，这样在打印信息时能够标记打印的是哪个类的信息
    private static final Log logger = LogFactory.getLog(FileUploadController.class);
    @RequestMapping("getFileUpload")
    public String getFileUpload() {
        return "fileUpload";
    }
    /**
     * 单文件上传
     */
    @RequestMapping("/fileupload")
    public ModelAndView oneFileUpload( FileDomain fileDomain, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        String realpath = request.getServletContext().getRealPath("uploadfiles");
        String fileName = fileDomain.getMyfile().getOriginalFilename();
        File targetFile = new File(realpath, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 上传的文件在tomcat里面
        try {
            fileDomain.getMyfile().transferTo(targetFile);
            /**
             *
             *      C:\Download\apache-tomcat-9.0.50-windows-x64\apache-tomcat-9.0.50\webapps\TestMVC_war\uploadfiles
             */
            //后期可以教学生尝试上传到oss
            logger.info("成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("showFile");
        modelAndView.addObject("fileDomain",fileDomain);
        return modelAndView;
    }
}
