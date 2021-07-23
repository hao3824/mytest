package java8;

import org.junit.jupiter.api.Test;


import java.util.Optional;

/**
 * User: lcl
 * Date: 2020-09-29
 */
public class OptionalTest {
    class User{
        String email;
        String name;

        public User(String email,String name){
            this.email = email;
            this.name = name;
        }
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    @Test
    public void test1(){
        User user = new User("aaa@12.com","kang");
        Optional<User> opt = Optional.ofNullable(user);
        User user1;
        opt.ifPresent(u-> System.out.println(user.getEmail().equals(u.getEmail())));
        Optional<User> opt1 = Optional.ofNullable(null);
        opt1.ifPresent(u-> System.out.println(user.getEmail().equals(u.getEmail())));
    }
}
