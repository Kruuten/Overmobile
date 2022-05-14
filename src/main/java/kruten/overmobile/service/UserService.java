package kruten.overmobile.service;

import kruten.overmobile.entity.User;
import kruten.overmobile.exception.AlreadyExistsException;
import kruten.overmobile.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRep userRep;

    @Transactional
    public User postUser(User user) {
        User checkUser = userRep.findById(user.getId());
        if (checkUser == null)
            checkUser = userRep.save(user);
        else throw new AlreadyExistsException("Already Exists");
        return checkUser;

    }
}
