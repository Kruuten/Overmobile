package kruten.overmobile.repository;

import kruten.overmobile.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRep extends MongoRepository<User, Long> {
    boolean existsById(String id);
    User findById(String id);
}
