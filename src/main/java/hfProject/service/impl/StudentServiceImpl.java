package hfProject.service.impl;

import hfProject.bean.Student;
import hfProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hf on 16/9/5.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getStudentList() {
        String sql = "SELECT `id`,`name`, `age`, `phone`, `stu_no` FROM student";
        return (List<Student>) jdbcTemplate.query(sql,new RowMapper<Student>(){

           @Override
           public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
               Student stu = new Student();
               stu.setId(rs.getLong("id"));
               stu.setAge(rs.getInt("age"));
               stu.setName(rs.getString("name"));
               stu.setPhone(rs.getString("phone"));
               stu.setStuNo(rs.getString("stu_no"));
               return stu;
           }
        });
    }
}
