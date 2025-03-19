package ie.gti.recordsystem.dao;

import ie.gti.recordsystem.dao.mapper.RoleMapper;
import ie.gti.recordsystem.dao.mapper.UserMapper;
import ie.gti.recordsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    private final static UserMapper userMapper = new UserMapper();
    public final static RoleMapper roleMapper = new RoleMapper();

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


//    private

    @Override
    public Optional<User> getUserById(long id) {
        final String SQL_GET_USER_BY_ID =
                """
                        SELECT u.id, u.username, u.password, r.id as role_id, r.name as role_name
                        FROM user u
                        LEFT OUTER JOIN users_roles ur ON u.id = ur.user_id\s
                        LEFT OUTER JOIN role r ON r.id = ur.role_id
                        WHERE u.id=?""";
        return Optional.ofNullable(jdbcTemplate.query(SQL_GET_USER_BY_ID, new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                User user = null;
                int row = 0;
                while (rs.next()) {
                    if (user == null) {
                        user = userMapper.mapRow(rs, row);
                    }
                    assert user != null;
                    user.getRoles().add(roleMapper.mapRow(rs, row));
                    row++;
                }
                return user;
            }
        }, id));
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        final String SQL_GET_USER_BY_NAME =
                """
                        SELECT u.id, u.username, u.password, r.id as role_id, r.name as role_name
                        FROM user u
                        LEFT OUTER JOIN users_roles ur ON u.id = ur.user_id\s
                        LEFT OUTER JOIN role r ON r.id = ur.role_id
                        WHERE u.username=?""";
        return Optional.ofNullable(jdbcTemplate.query(SQL_GET_USER_BY_NAME, new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                User user = null;
                int row = 0;
                while (rs.next()) {
                    if (user == null) {
                        user = userMapper.mapRow(rs, row);
                    }
                    assert user != null;
                    user.getRoles().add(roleMapper.mapRow(rs, row));
                    row++;
                }
                return user;
            }
        }, username));
    }

    @Override
    public List<User> getAllUsers() {
        final String SQL_GET_USER_BY_NAME =
                """
                        SELECT u.id, u.username, u.password, r.id as role_id, r.name as role_name
                        FROM user u
                        LEFT OUTER JOIN users_roles ur ON u.id = ur.user_id\s
                        LEFT OUTER JOIN role r ON r.id = ur.role_id""";
        return jdbcTemplate.query(SQL_GET_USER_BY_NAME, new ResultSetExtractor<List<User>>() {

            @Override
            public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
                Map<Long, User> userMap = new HashMap<>();

                int row = 0;
                while (rs.next()) {
                    long userID = rs.getLong("id");
                    User user = userMap.get(userID);
                    if (user == null)  {
                        user = userMapper.mapRow(rs, row);
                        userMap.put(userID, user);
                    }
                    assert user != null;
                    user.getRoles().add(roleMapper.mapRow(rs, row));
                    row++;
                }
                return new ArrayList<>(userMap.values());
            }
        });
    }

    @Override
    public long insertUser(User user) {
        final String INSERT_USER_SQL = "INSERT INTO user (username, password) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

//        jdbcTemplate.update(INSERT_USER_SQL, user.getUsername(), user.getPassword());
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL, new String[]{"ID"});
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                return ps;
            }
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public boolean deleteUserById(long id) {
        final String DELETE_USER_BY_ID =
                "DELETE FROM user\n" +
                "WHERE user.id = ?";
        return jdbcTemplate.update(DELETE_USER_BY_ID, id) > 0;
    }

    @Override
    public void deleteUsersById(List<Long> ids) {
        final String DELETE_USERS_BY_ID =
                "DELETE FROM user\n" +
                "WHERE user.id = ?";
        jdbcTemplate.batchUpdate(DELETE_USERS_BY_ID, ids, ids.size(), new ParameterizedPreparedStatementSetter<Long>() {
            @Override
            public void setValues(PreparedStatement ps, Long id) throws SQLException {
                ps.setLong(1, id);
            }
        });
    }

    @Override
    public void updateUser(User user) {
        final String UPDATE_USER_SQL = "UPDATE user SET username = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(UPDATE_USER_SQL, user.getUsername(), user.getPassword(), user.getId());
    }

}
