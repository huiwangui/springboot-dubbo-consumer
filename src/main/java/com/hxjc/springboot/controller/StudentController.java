package com.hxjc.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hxjc.springboot.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * creater: 13116
 * create time: 2019/10/13
 * describe:
 */
@RestController
public class StudentController {

    @Reference(version = "1.0.0") //等同 <dubbo:reference id= />
    StudentService studentService;

    @RequestMapping("/boot/student")
    public Object getStudent(@RequestParam("id") Integer id){
        return studentService.getStudent(id);
    }
}
