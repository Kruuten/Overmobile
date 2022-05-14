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

    /**
     * Можно сделать проще, но решил сделать с отловом ошибок =)
     **/
    @Transactional
    public void postUser(User user) {
        boolean userExists = userRep.existsById(user.getId());
        if (!userExists) {
            userRep.save(user);
            return;
        }
        throw new AlreadyExistsException("Already Exists");

    }

}
