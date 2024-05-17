package com.samCode.SpringJDBCDemo.repository;

import com.samCode.SpringJDBCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AlienRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien){
        String sql = "Insert into alien (id, name, tech) values (?,?,?)";
        int rows = template.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println(rows + "Rows affected");
    }

    public List<Alien> findAll(){
        return new ArrayList<Alien>();
    }
}
