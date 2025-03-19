package ie.gti.recordsystem.dao;

import ie.gti.recordsystem.model.Role;
import ie.gti.recordsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserRolesDaoImpl implements UserRolesDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRolesDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertUserRoles(User user) {
        String sql = "INSERT INTO users_roles (user_ID, role_ID) VALUES (?, ?)";

        jdbcTemplate.batchUpdate(sql, user.getRoles(), user.getRoles().size(), new ParameterizedPreparedStatementSetter<Role>() {
            @Override
            public void setValues(PreparedStatement ps, Role role) throws SQLException {
                ps.setLong(1, user.getId());
                ps.setLong(2, role.getId());
            }
        });
    }

}
