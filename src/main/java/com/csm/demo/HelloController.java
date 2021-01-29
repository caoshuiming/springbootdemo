package com.csm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Max;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 校验逻辑javax.validator定义了一些注解
 */
//@RestController
@Controller
public class HelloController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    WebApplicationContext webApplicationContext;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(HttpSession session){
        return "hello";
    }

    @RequestMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("E:\\a" + File.separator + file.getOriginalFilename()));
        return "success";
    }

    @RequestMapping("user")
    @ResponseBody
    public User user(){
        User user = new User();
        user.setAge(18);
        user.setName("csm");
        user.setNo(1);
        return user;
    }

    @RequestMapping("register")
    @ResponseBody
    public Map register(@Validated User user, BindingResult result){
        Map map = new HashMap();
        if(!user.getEmail().split("@")[0].equals(user.getName())){
            FieldError emailError = new FieldError("user", "email", "邮箱不正确");
            result.addError(emailError);
        }
        List<FieldError> errors = result.getFieldErrors();
        for(FieldError error : errors){
            map.put(error.getField(), error.getDefaultMessage());
        }
        System.out.println(user);
        return map;
    }
}
