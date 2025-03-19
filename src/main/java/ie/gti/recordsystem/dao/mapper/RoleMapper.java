package ie.gti.recordsystem.dao.mapper;

import ie.gti.recordsystem.model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = new Role();
        role.setId(rs.getLong("role_id"));
        role.setName(rs.getString("role_name"));
        return role;
    }
}
