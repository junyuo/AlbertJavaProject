package albert.practice.designPattern.builder;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserTest {

    @Test
    public void testUser() {
        User user = new User.UserBuilder().firstName("Albert").lastName("Kuo")
                .email("test@gmail.com").build();
        log.debug("user = " + user.toString());
        assertNotNull(user);
    }

    @Test
    public void testUser2() {
        User2 user2 = new User2.User2Builder().firstName("Albert").lastName("Kuo")
                .email("test@gmail.com").build();
        log.debug("user2 = " + user2.toString());
        assertNotNull(user2);
    }

}
