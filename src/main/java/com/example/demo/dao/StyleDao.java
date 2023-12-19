package com.example.demo.dao;

import com.example.demo.model.PostStyleReq;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class StyleDao {
    private JdbcTemplate jdbcTemplate;

    public StyleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // INSERT
    public int insert(PostStyleReq postStyleReq) {
        String sql = "INSERT INTO style(style_idx, name, description) VALUES(?, ?, ?)";
        Object[] sqlParams = new Object[]{postStyleReq.getStyle_idx(),
                postStyleReq.getName(),
                postStyleReq.getDescription()
        };
        return jdbcTemplate.update(sql, sqlParams);
    }

    // UPDATE
    public void update(PostStyleReq postStyleReq) {
        String sql = "UPDATE style SET name = ? WHERE style_idx = ?";
        Object[] sqlParams = new Object[]{postStyleReq.getStyle_idx(),
                postStyleReq.getName()
        };
        jdbcTemplate.update(sql, sqlParams);
    }

    // DELETE
    public void delete(PostStyleReq postStyleReq) {
        String sql = "DELETE FROM style WHERE style_idx = ?";
        Object[] sqlParams = new Object[]{
                postStyleReq.getStyle_idx()
        };
        jdbcTemplate.update(sql, sqlParams);
    }
}