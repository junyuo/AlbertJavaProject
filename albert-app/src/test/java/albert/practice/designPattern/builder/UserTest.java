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
        log.debug("FirstName = " + user.getFirstName());
        log.debug("LastName = " + user.getLastName());
        log.debug("Email = " + user.getEmail());
        assertNotNull(user);
    }

    @Test
    public void testUser2() {
        User2 user2 = new User2.User2Builder().firstName("Albert").lastName("Kuo")
                .email("test@gmail.com").build();
        log.debug("FirstName = " + user2.getFirstName());
        log.debug("LastName = " + user2.getLastName());
        log.debug("Email = " + user2.getEmail());
        assertNotNull(user2);
    }

}
