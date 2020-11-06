package builder;

import dto.User;

public class UserBuilder {
    public User create (String expectedEmail,
                        String firstName,String lastName,
                        String password, String phone,
                        String username, long id,
                        long userStatus){
        return User.builder()
                .email(expectedEmail)
                .firstName(firstName)
                .lastName(lastName)
                .password(password)
                .phone(phone)
                .username(username)
                .id(id)
                .userStatus(userStatus)
                .build();
    }

}
