package ie.gti.recordsystem.dao;

import ie.gti.recordsystem.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserDao {

    Optional<User> getUserById(int id);

    Optional<User> getUserByUsername(String username);

    List<User> getAllUsers();

    long insertUser(User user);

    boolean deleteUserById(long id);


    void deleteUsersById(List<Long> ids);

//    List<User> getAllUsers();



}
