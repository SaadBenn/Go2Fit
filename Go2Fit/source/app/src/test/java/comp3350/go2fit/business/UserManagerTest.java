package comp3350.go2fit.business;

import junit.framework.TestCase;
import org.junit.Test;

import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;

public class UserManagerTest extends TestCase {
    private UserManager db = new UserManager();
    private UserModel user;

    @Test
    public void testForNull() {
        System.out.println("\nStarting testUserManager: null database");
        assertNotNull(db);
        System.out.println("Finished testUserManager: null database");
    }

    @Test
    public void testGetUser()
    {

        System.out.println("\nStarting testUserManager: check get user for null");
        user = db.getUser(0);
        assertNotNull(user);
        System.out.println("Finished testUserManager: check get user for null");
    }

    @Test
    public void testUpdateUser()
    {

        System.out.println("\nStarting testUserManager: check update ");
        UserModel user = new UserModel();
        user.setCurrentChallenge(0);
        user.setId(1);

        boolean result = db.updateUser(user);
        assertTrue(result);

        System.out.println("Finished testUserManager: check update");
    }

}
