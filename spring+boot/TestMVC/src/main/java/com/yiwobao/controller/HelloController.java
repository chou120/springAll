package com.yiwobao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yiwobao.pojo.Address;
import com.yiwobao.pojo.People;
import com.yiwobao.pojo.Phone;
import com.yiwobao.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    /*@RequestMapping("/hello")
    public String hello(){
        System.out.println("进入控制器的方法");

        //注意：这里返回的只是页面名称，不是完整的页面访问路径
        return "success";
    }
*/
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello-www.yiwobao.com");
    }

    @RequestMapping("/param")
    public String save(@RequestParam(value = "username",defaultValue = "大保健") String name, Integer age){
        System.out.println("用户名："+name);
        System.out.println("年龄："+age);
        return "success";
    }


    /**
     *
     * @param user
     * @return
     */
    @RequestMapping("/paramPojo")
    public String save(User user){
        System.out.println("用户名："+user.getUsername());
        System.out.println("年龄："+user.getAge());
        return "success";
    }


   /* @RequestMapping("/paramPojoAndOtherPojo")
        public String insert(User user){
            System.out.println("用户名："+user.getUsername());
            System.out.println("年龄："+user.getAge());
            System.out.println("省份："+user.getAddress().getProvince());
            System.out.println("城市："+user.getAddress().getCity());
            return "success";
        }
   */
   @RequestMapping("/paramList")
   public String save_List(User user){
       System.out.println("用户名："+user.getUsername());
       System.out.println("年龄："+user.getAge());
       //遍历所有地址信息
       for(Address addr:user.getAddress()){
           System.out.println(addr);
       }
       return "success";
   }
    @RequestMapping("/paramDate")
    public String saveDate(User user){
        System.out.println("用户名："+user.getUsername());
        System.out.println("年龄："+user.getAge());
        System.out.println("生日："+user.getBirthday());
        return "success";
    }


    /**
     *
     * Spring MVC 使用Servlet API
     * */
    @RequestMapping("/paramServletAPI")
    public void update(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session)
            throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.setAttribute("request","一窝宝啊");
        session.setAttribute("session","真的是一窝宝啊");
        session.setAttribute("msg",username+password);

        response.sendRedirect(request.getContextPath()+"/pages/success.jsp");
    }


    /**
     * Model接口的使用
     * @return
     */
    @RequestMapping("/model")
    public String list(Model model){
        model.addAttribute("model","一窝宝啊");
        return "success";
    }
    /**
     * ModelMap类的使用
     * @return
     */
    @RequestMapping("/modelMap")
    public String list(ModelMap modelMap){
        modelMap.addAttribute("modelMap","真的是一窝宝啊");
        return "success";
    }


    @RequestMapping("/forward")
    public String forward(){
        System.out.println("转发字符串....");
        return "forward:/loginInfo.html";
    }

    @RequestMapping("/redirect")
    public String redirect(){
        System.out.println("重定向字符串....");
        return "redirect:http://www.yiwobaoit.com";
    }

    @RequestMapping("/mv")
    public ModelAndView mv(){
        ModelAndView mv = new ModelAndView();
        //设置模型数据
        mv.addObject("model","yiwobao宝宝");
        //设置视图数据
        mv.setViewName("info");/*zou试图解析器  最终路径为: pages/info.jsp  */
        return mv;
    }

    @RequestMapping("/gologin")
    public  String toLogin(){
        System.out.println("进来了...");
        return "Login";
    }

    /**
     * 用来测试json
     * @param user
     * @return
     */

    @RequestMapping("/user/json")
    @ResponseBody //以json格式相应给前端的
    public User jsonToObject(@RequestBody User user){
        System.out.println("--------");
        System.out.println(user);
        return user;
    }

}
