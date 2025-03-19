package ie.gti.recordsystem.service;

import ie.gti.recordsystem.dao.UserDao;
import ie.gti.recordsystem.dao.UserRolesDao;
import ie.gti.recordsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

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
        userRolesDao.insertUserRoles(user);
        return id;
    }
}
