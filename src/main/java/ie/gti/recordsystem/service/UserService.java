package ie.gti.recordsystem.service;

import ie.gti.recordsystem.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    long insertUser(User user);

}
