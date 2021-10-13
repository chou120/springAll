package com.yiwobao.springboot_09_task;

import com.yiwobao.springboot_09_task.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot09TaskApplicationTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void sendSimpleEmail(){
        String content = "验证码为:"+765432;
        emailService.sendSimpleMail("1208160221@qq.com","祝福邮件",content);
    }

    @Test
    public void sendMimeEmail(){
        String content = "<a href='https://www.yiwobaoit.com/'>你好，欢迎注册网站，请点击链接激活</a>";
        emailService.sendHtmlMail("1208160221@qq.com","激活邮件",content);
    }

    @Test
    public void sendAttachment(){
        emailService.sendAttachmentsMail("1208160221@qq.com","发送附件","这个美女你不喜欢吗？","C:\\Users\\edy\\Desktop\\images\\1号美女.jpg");
    }


}
