package ie.gti.recordsystem.dao;

import ie.gti.recordsystem.model.Role;
import ie.gti.recordsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRolesDaoImpl implements UserRolesDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRolesDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertUserRoles(long userID, List<Role> roles) {
        String sql = "INSERT INTO users_roles (user_ID, role_ID) VALUES (?, ?)";

        jdbcTemplate.batchUpdate(sql, roles, roles.size(), new ParameterizedPreparedStatementSetter<Role>() {
            @Override
            public void setValues(PreparedStatement ps, Role role) throws SQLException {
                ps.setLong(1, userID);
                ps.setLong(2, role.getId());
            }
        });
    }

    @Override
    public void deleteUserRoles(long userID, List<Role> roles) {
        final String sql = "DELETE FROM users_roles WHERE user_ID = ? and role_ID = ?";
        jdbcTemplate.batchUpdate(sql, roles, roles.size(), new ParameterizedPreparedStatementSetter<Role>() {
            @Override
            public void setValues(PreparedStatement ps, Role role) throws SQLException {
                ps.setLong(1, userID);
                ps.setLong(2, role.getId());
            }
        });
    }

    @Override
    public void deleteUserRoles(long userID) {
        final String sql = "DELETE FROM users_roles WHERE user_ID = ?";
        jdbcTemplate.update(sql, userID);
    }

}
