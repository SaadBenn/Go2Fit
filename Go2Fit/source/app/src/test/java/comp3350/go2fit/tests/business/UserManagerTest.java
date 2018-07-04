package comp3350.go2fit.tests.business;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Map;

import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.tests.persistence.UserPersistenceStub;

public class UserManagerTest extends TestCase {
    private UserManager db = new UserManager(new UserPersistenceStub());
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


    @Test
    public void testForGetAllUsers() {
        System.out.println("\nStarting testUserManager: check get all users ");
        Map<Integer, UserModel> map;

        map = db.getAllUsers();

        assertTrue("The database should have default users", map.size() >=1);

        System.out.println("Finished testUserManager: check get all users");
    }

    @Test
    public void testForAddUser() {
        System.out.println("Starting testUserManager: check for add users");

        UserModel user = new UserModel();
        user.setCurrentChallenge(2);
        user.setId(3);

        assertTrue(db.addUser(user));

        System.out.println("Finished testUserManager: check for add users");
    }

}
