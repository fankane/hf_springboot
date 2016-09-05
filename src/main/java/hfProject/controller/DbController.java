package hfProject.controller;

import com.google.gson.Gson;
import hfProject.bean.Student;
import hfProject.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hf on 16/9/5.
 */
@RestController
@RequestMapping("/db")
public class DbController {

    private static final Logger logger = LoggerFactory.getLogger(DbController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping("getStuList")
    public String getStuList() {
        List<Student> students = studentService.getStudentList();
        Gson gson = new Gson();
        String result = gson.toJson(students);
        return result;
    }


}
