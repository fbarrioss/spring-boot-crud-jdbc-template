package com.tbp.crud.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tbp.crud.entity.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER_QUERY = "INSERT INTO USER(id,fname,lname,email) values(?,?,?,?)";
    private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE USER SET fname=? WHERE ID=?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USER WHERE ID=?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM USER WHERE ID=?";
    private static final String GET_USERS_QUERY = "SELECT * FROM USER";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(User user) {
        log.debug("Guardando usuario {}", user);
        jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getFname(), user.getLname(), user.getEmail());
        return user;
    }

    @Override
    public User updateUser(User user) {
        log.debug("Actualizando usuario {}", user);
        jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, user.getFname(), user.getId());
        return user;
    }

    @Override
    public User getById(int id) {
        log.debug("Leyendo datos para el usuario {}", id);
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        },id);
    }

    @Override
    public String deleteById(int id) {
        log.debug("Eliminando usuario {}", id);
        jdbcTemplate.update(DELETE_USER_BY_ID, id);
        return "Usuario eliminado con ID: " + id;
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        });
    }
}
