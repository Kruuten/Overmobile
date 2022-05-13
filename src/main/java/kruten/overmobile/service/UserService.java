package kruten.overmobile.service;

import kruten.overmobile.entity.User;
import kruten.overmobile.exception.AlreadyExistException;
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
        User optional = userRep.findById(user.getId());
        if (optional == null)
            optional = userRep.save(user);
        else throw new AlreadyExistException("Already Exists");
        return optional;
    }
}
