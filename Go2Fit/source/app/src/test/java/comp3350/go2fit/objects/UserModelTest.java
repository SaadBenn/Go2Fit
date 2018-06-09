package comp3350.go2fit.objects;
import junit.framework.TestCase;
import comp3350.go2fit.Models.UserModel;
import org.junit.Test;

public class UserModelTest extends TestCase {

    @Test
    public void testUserModel1()
    {
        UserModel userModel;

        System.out.println("\nStarting testUserModel");

        userModel = new UserModel();
        // test for valid data
        System.out.println("Testing valid data in the UserModel class.");
        userModel.setName("Beast mode challenge");
        assertTrue(userModel.getName() instanceof String);
        assertEquals("Beast mode challenge", userModel.getName());

        userModel.setId(1);
        userModel.setCurrentChallenge(12);

        assertEquals(1, userModel.getId());
        assertEquals(12, userModel.getCurrentChallenge());

        // test for null object
        assertNotNull(userModel);
        System.out.println("UserModel object is not null");

        // test invalid data
        System.out.println("Testing invalid data in the UserModel class.");
        assertNotSame(-1, userModel.getCurrentChallenge());
        assertFalse(userModel.getId() < 0);

        System.out.println("Finished testUserModel");
    }
}
