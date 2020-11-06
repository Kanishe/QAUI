package base;

import services.UserService;

public class UserBase {
    protected UserService userService = new UserService();
    protected String expectedEmail = "Test@mail.ru";
    protected String firstName = "FirstName";
    protected String lastName = "LastName";
    protected String password = "Password";
    protected String phone = "8-999-999-99-99";
    protected Long userId= (long) (Math.random()+1);
    protected Long userStatus = 10L;
    protected String notFoundMessageType = "User not found";
    protected String expectedType = "unknown";
    protected String errorExpectedType = "error";
    protected String userName = "Ads";
}
