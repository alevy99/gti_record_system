package ie.gti.recordsystem.service;

import ie.gti.recordsystem.dao.UserDao;
import ie.gti.recordsystem.dao.UserRolesDao;
import ie.gti.recordsystem.model.Role;
import ie.gti.recordsystem.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDao userDao;

    private final UserRolesDao userRolesDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserRolesDao userRolesDao) {
        super();
        this.userDao = userDao;
        this.userRolesDao = userRolesDao;
    }

    @Transactional
    @Override
    public long insertUser(User user) {
        long id = userDao.insertUser(user);
        user.setId(id);
        userRolesDao.insertUserRoles(user.getId(), user.getRoles());
        return id;
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.getUserById(user.getId()).ifPresentOrElse(userDB -> {
            userDao.updateUser(user);

            logger.info("New roles: {}", user.getRoles().stream()
                    .map(Role::getName)
                    .collect(Collectors.joining(", ")));

            List<Role> currentRoles = userDB.getRoles();

            logger.info("Current roles: {}", currentRoles.stream()
                    .map(Role::getName)
                    .collect(Collectors.joining(", ")));

            List<Role> rolesToInsert = new ArrayList<>(user.getRoles());
            rolesToInsert.removeAll(currentRoles);

            logger.info("Roles to insert: {}", rolesToInsert.stream()
                    .map(Role::getName)
                    .collect(Collectors.joining(", ")));

            userRolesDao.insertUserRoles(user.getId(), rolesToInsert);

            List<Role> rolesToDelete = new ArrayList<>(currentRoles);
            rolesToDelete.removeAll(user.getRoles());

            logger.info("Roles to delete: {}", rolesToInsert.stream()
                    .map(Role::getName)
                    .collect(Collectors.joining(", ")));

            userRolesDao.deleteUserRoles(user.getId(), rolesToDelete);

        }, () -> {
            throw new RuntimeException("User was not found: ID = " + user.getId());
        });
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        // Roles are deleted first
        userRolesDao.deleteUserRoles(id);
        userDao.deleteUserById(id);
    }
}
