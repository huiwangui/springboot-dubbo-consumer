package com.hxjc.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hxjc.springboot.model.Student;
import com.hxjc.springboot.service.StudentService;
import com.hxyc.common.page.Paginator;
import com.hxyc.common.page.PageResult;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public PageResult<Student> getStudent(Paginator paginator, Student student){


        if (null == paginator){
            paginator.setCurrentPage(1);
            paginator.setPageSize(10);
        }

        PageResult<Student> list = studentService.listStudentByCon(student,paginator);

        return list;
    }
}
