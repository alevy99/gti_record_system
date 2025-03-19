package ie.gti.recordsystem.dao;

import ie.gti.recordsystem.model.User;
import ie.gti.recordsystem.model.UserRoles;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesDao {

    void insertUserRoles(User user);
}
