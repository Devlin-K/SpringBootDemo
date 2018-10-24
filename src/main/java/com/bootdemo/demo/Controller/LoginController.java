package com.bootdemo.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.bootdemo.demo.Domain.Person;
import com.bootdemo.demo.Service.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    LoginRepository loginRepository;

    @RequestMapping("/Test")
    public String Test(Model model){
        model.addAttribute("Person",loginRepository.findAll());
        return "hello";
    }

    @RequestMapping("/Index")
    public String Index(){
        return "Index";
    }

    @RequestMapping("/Login")
    public String Login(@RequestBody String param, HttpServletRequest request, Model model){
        List<Person> personList=loginRepository.findAll();
        String UserName = request.getParameter("UserNameL");
        String Password = request.getParameter("passwordL");
//        UserName=personform.getUserName();
//        UserName=request
//        Password=personform.getPassword();
        //model.addAttribute("Person",loginRepository.findAll());

        for (Person Temp:personList
             ) {
            if (Temp.getUserName().equals(UserName)&&Temp.getPassword().equals(Password)){
                model.addAttribute("ps",Temp);
            }else{
                model.addAttribute("ps",null);
            }
        }
        return "login";
    }

    @RequestMapping("/Save")
    public String Save(Model model,@ModelAttribute Person personform){
        Person savePerson=new Person();
        Date date=new Date();
        int Id= (int)(Math.random()*1000);

        savePerson.setId(Id);
        savePerson.setUserName(personform.getUserName());
        savePerson.setAge(personform.getAge());
        savePerson.setSex(personform.getSex());
        savePerson.setCreate_Time(date);
        savePerson.setPassword(personform.getPassword());
        savePerson.setDescribe(personform.getDescribe());
        savePerson.setStatus(true);

        model.addAttribute("Person",loginRepository.save(savePerson));
        return "Save";
    }
//    @GetMapping("/Info")
//    public String LoginForm(Model model){
//        model.addAttribute("Person",new Person());
//        return "Login";
//    }
//
//    @PostMapping("/Info")
//    public String LoginSubmit(@ModelAttribute Person person, ModelMap model){
//
//        model.addAttribute("UserName",person.getUserName());
//        model.addAttribute("Password",person.getPassword());
//        return "First";
//    }
//
//    @RequestMapping("/First")
//    public String First(){
//        return "Yes";
//    }
}
