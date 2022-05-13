package kruten.overmobile.service;

import kruten.overmobile.entity.User;
import kruten.overmobile.repository.UserRep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class Service {
    @Mock
    private UserRep userRep;

    private User user1;

    private User user2;

    @BeforeEach
    public void setUp() {
        user1 = new User();
        user1.setId("credit");
        user1.setUserId(1);
        user1.setSum(100);

        user2 = new User();
        user2.setId("credit");
        user2.setUserId(2);
        user2.setSum(500);
    }

//    @Test
//    void
}
