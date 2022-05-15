package kruten.overmobile.integrationTests.serviceTests;

import kruten.overmobile.OvermobileApplication;
import kruten.overmobile.entity.User;
import kruten.overmobile.exception.AlreadyExistsException;
import kruten.overmobile.repository.UserRep;
import kruten.overmobile.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = OvermobileApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
public class ServiceIntegrationTest {

    @Autowired
    private UserRep userRep;

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void postUserIntegrationTest() {
        User user1 = new User();
        user1.setId("loan");
        user1.setUserId(1);
        user1.setSum(100);

        userService.postUser(user1);

        User byId = userRep.findById(user1.getId());
        Assertions.assertEquals(byId.getId(), user1.getId());
        Assertions.assertEquals(byId.getUserId(), user1.getUserId());
        Assertions.assertEquals(byId.getSum(), user1.getSum());

    }

    @Test
    @Transactional
    public void postUserThrowExceptionIntegrationTest() {
        User user1 = new User();
        user1.setId("loan");
        user1.setUserId(1);
        user1.setSum(100);

        User user2 = new User();
        user2.setId("loan");
        user2.setUserId(2);
        user2.setSum(500);

        userService.postUser(user1);
        Assertions.assertThrows(AlreadyExistsException.class, () -> userService.postUser(user2));
    }
}