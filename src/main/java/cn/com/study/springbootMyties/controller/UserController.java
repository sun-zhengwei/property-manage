package cn.com.study.springbootMyties.controller;


import cn.com.study.springbootMyties.entity.UserEntity;
import cn.com.study.springbootMyties.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demoproject/test")
public class UserController {

    @Autowired
    private UserService testService ;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public UserEntity test(@PathVariable Integer id){
        System.out.println("id:" + id);
        return testService.getById(id);
    }

}
