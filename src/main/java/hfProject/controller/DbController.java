package hfProject.controller;

import com.google.gson.Gson;
import hfProject.bean.Student;
import hfProject.mapperservice.MapperStudentService;
import hfProject.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private MapperStudentService mapperStudentService;

    @RequestMapping("/getStuList")
    public String getStuList() {
        List<Student> students = studentService.getStudentList();
        Gson gson = new Gson();
        String result = gson.toJson(students);
        return result;
    }

    @RequestMapping("/getStuListByMybatis")
    public String getStuListMybatis() {
        List<Student> students = mapperStudentService.selectStudentList();
        Gson gson = new Gson();
        String result = gson.toJson(students);
        return result;
    }

    @RequestMapping("/getStuByMybatis/{id}")
    public String getStuMybatis(@PathVariable int id) {
        Student student = mapperStudentService.selectStudentById(id);
        Gson gson = new Gson();
        String result = gson.toJson(student);
        return result;
    }


}
