package ie.gti.recordsystem.dao;

import ie.gti.recordsystem.dao.mapper.UserMapper;
import ie.gti.recordsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_USER = "select * from people where id = ?";

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUserById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] {id}, new UserMapper());
    }

}
