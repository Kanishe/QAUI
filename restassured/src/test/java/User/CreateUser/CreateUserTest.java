package User.CreateUser;

import base.UserBase;
import builder.UserBuilder;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import dto.User;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;


public class CreateUserTest extends UserBase {
    Response response;
    UserBuilder userBuilder=new UserBuilder();
    User user;

    @Test
    public void checkCreateUser() {
        user = userBuilder.create(expectedEmail,firstName,
                lastName,password,phone,
                userName,userId,userStatus);
        response = userService.addUserRequest(user,"/user");

        response
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(3000L))
                .body("type", equalTo(expectedType))
                .body("message", comparesEqualTo(userId.toString()));
    }
    @Test
    public void checkCreateUserWithWrongPath() {
        user = userBuilder.create (expectedEmail,firstName,
                lastName,password,phone,
                userName,userId,userStatus);
        response = userService.addUserRequest(user,"/dhsjfsdjh");
    }
}
