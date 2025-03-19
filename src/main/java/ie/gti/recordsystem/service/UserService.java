package ie.gti.recordsystem.service;

import ie.gti.recordsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    long insertUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

}
