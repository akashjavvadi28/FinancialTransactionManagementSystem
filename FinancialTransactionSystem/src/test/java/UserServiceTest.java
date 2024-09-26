import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void testUserRegistration() {
        UserService userService = new UserService();
        boolean result = userService.registerUser("testUser", "password123");
        assertTrue(result);
    }
    // Add more test cases for login and balance check
}
