package com.example.SpringJDBCEx.repo;

import com.example.SpringJDBCEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql = "insert into student (rollno, name, marks) values(?,?,?)";

        int rows = jdbc.update(sql, s.getRollno(),s.getName(),s.getMarks());   //execute update
        System.out.println(rows+"Affected");
    }

    public List<Student> findAll() {
        String sql = "select*from student";
        RowMapper<Student> mapper = (rs, rowNum) -> {
            Student s = new Student();
            s.setRollno(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        };
        return jdbc.query(sql,mapper);
    }
}
