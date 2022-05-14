package kruten.overmobile.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kruten.overmobile.entity.User;
import kruten.overmobile.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    UserService userService;
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
        user2.setSum(150);
    }

    @Test
    void postCustomer() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        String json = objectMapper.writeValueAsString(user1);
        mockMvc.perform(post("/add")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
