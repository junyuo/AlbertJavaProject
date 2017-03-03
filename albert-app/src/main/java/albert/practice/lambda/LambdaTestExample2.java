package albert.practice.lambda;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaTestExample2 {

    public void greetAllBirthdayChildren() {
        List<User> users = createUsers();
        String birthday = "20.02";
        users.stream().filter(user -> user.getBirthday().startsWith(birthday))
                .forEach(user -> sendMessage("Happy birthday, ", user));
    }

    private void sendMessage(String message, User user) {
        log.debug(message.concat(user.getUsername()));
    }

    public List<User> createUsers() {
        User child1 = new User("Peter", "20.02.1990");
        User child2 = new User("Kid", "23.02.2008");
        User child3 = new User("Bruce", "20.02.1980");

        return Arrays.asList(child1, child2, child3);
    }

    public static class User {
        private String username;
        private String birthday;

        public User(String username, String birthday) {
            this.username = username;
            this.birthday = birthday;
        }

        public String getUsername() {
            return username;
        }

        public String getBirthday() {
            return birthday;
        }
    }

}
