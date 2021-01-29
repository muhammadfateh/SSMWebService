package com.webapp.template;

import com.webapp.template.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemplateApplicationTests {
    UserService userService;

    @Test
    void createUserTest() {
        userService = new UserService();
        userService.signIn("Gull", "1234567");
}

}
