package comp3350.go2fit.tests.business;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;


import java.util.Map;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ProgressManager;
import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;
import comp3350.go2fit.PersistenceLayer.UserPersistence;
import comp3350.go2fit.tests.persistence.UserPersistenceStub;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserManagerTest extends TestCase {
    private UserManager db = new UserManager(new UserPersistenceStub());
    private UserModel user;
    private UserPersistence userPersistence;
    private UserManager userManager1;

    @Before
    public void setUp() {
        userPersistence = mock(UserPersistence.class);
        userManager1 = new UserManager(userPersistence);
    }

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

    @Test
    public void testChallengeFailed(){
        System.out.println("Testing failed challenge:");

        UserModel user = new UserModel();
        user.setCurrentChallenge(2);
        user.setId(0);

        when(userPersistence.getUser(0)).thenReturn(user);

        TrackProgressModel data = new TrackProgressModel();
        data.setDistance(100);
        data.setCalories(20);
        data.setNumSteps(10);
        data.setPercentageComplete(2);
        data.setUserId(0);
        data.setId(0);

        assertTrue(userManager1.failedChallenge());

        verify(userPersistence).getUser(0);

        System.out.println("Finished testing failed challenge.");
    }

    @Test
    public void testStartChallenge()
    {
        System.out.println("Testing start challenge:");

        UserModel user = new UserModel();
        user.setCurrentChallenge(0);
        user.setId(0);

        when(userPersistence.getUser(0)).thenReturn(user);

        assertTrue(userManager1.startChallenge(0));

        verify(userPersistence).getUser(0);

        System.out.println("Finished testing start challenge.");
    }

    @Test
    public void testValidatePoints()
    {
        System.out.println("Starting validate points test");

        UserModel user = new UserModel();
        user.setCurrentChallenge(0);
        user.setId(0);

        when(userPersistence.getUser(0)).thenReturn(user);

        int pointsRequired = 0;

        assertTrue(userManager1.validatePoints(pointsRequired));

        verify(userPersistence).getUser(0);

        System.out.println("Finished validate points test");
    }
    @Test
    public void testValidateNotEnoughPoints()
    {
        System.out.println("Starting validate not enough points test");

        UserModel user = new UserModel();
        user.setCurrentChallenge(0);
        user.setId(0);

        when(userPersistence.getUser(0)).thenReturn(user);

        int pointsRequired = 100000;

        assertFalse(userManager1.validatePoints(pointsRequired));

        verify(userPersistence).getUser(0);

        System.out.println("Finished validate not enough points test");
    }
}