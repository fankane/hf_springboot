package hfProject.mapperservice;

import hfProject.bean.Student;
import hfProject.service.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hf on 16/9/5.
 */
@Service
public class MapperStudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> selectStudentList() {
        return studentMapper.selectStudentList();
    }

    public Student selectStudentById(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
