package kruten.overmobile.service;

import kruten.overmobile.entity.User;
import kruten.overmobile.exception.AlreadyExistsException;
import kruten.overmobile.repository.UserRep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class ServiceLayerTest {
    @Mock
    private UserRep userRep;

    @InjectMocks
    private UserService userService;

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

    @Test
    void postCustomer() {
        Mockito.when(userRep.save(user1)).thenReturn(user1);
        Assertions.assertEquals(user1, userService.postUser(user1));
    }

    @Test
    void postCustomerThrowExceptionTest() {
        Mockito.when(userRep.findById(user2.getId())).thenReturn(user2);
        Assertions.assertThrows(AlreadyExistsException.class, () -> userService.postUser(user2));
    }
}
