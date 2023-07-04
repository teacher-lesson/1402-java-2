package com.example.dao.user;

import com.example.dao.Dao;
import com.example.model.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;

@Repository
public class UserDao implements Dao<User, Integer> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @SneakyThrows
    public void insert(User user) {
        jdbcTemplate.update("insert into users (first_name, last_name, username) VALUES (?,?,?)", user.getFirstName(), user.getLastName(), user.getUsername());
    }

    @Override
    public User select(Integer id) {
        return jdbcTemplate.queryForObject("select * from users where id=?", (rs, rowNum) -> new User(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("username")
        ), id);
    }

    @Override
    public Stream<User> selectAll() {
        return jdbcTemplate.queryForStream("select * from users", (rs, rowNum) -> new User(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("username")
        ));
}


}
