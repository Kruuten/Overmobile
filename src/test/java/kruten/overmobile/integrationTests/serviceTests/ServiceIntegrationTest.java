package kruten.overmobile.integrationTests.serviceTests;

import kruten.overmobile.entity.User;
import kruten.overmobile.repository.UserRep;
import kruten.overmobile.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRep userRep;

    private User user1;

    private User user2;


    @BeforeEach
    public void setUp() {
        user1 = new User();
        user1.setId("debit");
        user1.setUserId(10);
        user1.setSum(1000);

        user2 = new User();
        user2.setId("debit");
        user2.setUserId(2);
        user2.setSum(500);
    }

    @Test
    public void postUserIntegrationTest() throws Exception {
        userRep.save(user1);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/add"));
        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void postUserThrowExceptionIntegrationTest() throws Exception {
        userRep.save(user2);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/add"));
    }


}