package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import comp3350.go2fit.BuisnessLayer.Exceptions.NoUserFoundException;
import comp3350.go2fit.BuisnessLayer.Exceptions.UserExistsException;
import comp3350.go2fit.BuisnessLayer.UserService;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.tests.persistence.UserPersistenceStub;

public class UserServiceTest extends TestCase {
    private UserPersistenceStub db;
    private UserService userService;


    @org.junit.Test
    public void testForFindUser() {
        System.out.println("Starting User Service Test: check findUser");

        db = new UserPersistenceStub();

        UserModel tempData1 = new UserModel();
        tempData1.setId(1);
        tempData1.setName("s");
        tempData1.setPassword("a");
        tempData1.increaseChallengesCompleted();
        tempData1.increaseChallengesCompleted();
        tempData1.setTotalPoints(1200);
        db.add(tempData1);

        userService = new UserService();
        int result = userService.findUser(db.getAllUsers(), "s");
        assertTrue("The return value should be >= 0", result >= 0);
        System.out.println("Finished User Service Test: check findUser");
    }


    @org.junit.Test(expected = NoUserFoundException.class)
    public void testForNoUserFoundException() {
        System.out.println("Starting User Service Test: check no user found exception");

        userService = new UserService();
        db = new UserPersistenceStub();

        try {
            int result = userService.findUser(db.getAllUsers(), "saad");
            System.out.println("User not found at index" + result);
        } catch (NoUserFoundException e) {
            assert  true;
        }

        System.out.println("Finished User Service Test: check no user found exception");
    }


    @org.junit.Test(expected = UserExistsException.class)
    public void testForValidateNoUser() {
        System.out.println("Starting UserService test: check for validate no use exception");

        db = new UserPersistenceStub();

        UserModel tempData1 = new UserModel();
        tempData1.setId(1);
        tempData1.setName("s");
        tempData1.setPassword("a");
        tempData1.increaseChallengesCompleted();
        tempData1.increaseChallengesCompleted();
        tempData1.setTotalPoints(1200);
        db.add(tempData1);

        userService = new UserService();
        try {
            userService.validateNoUser(db.getAllUsers(), "s");
        } catch (UserExistsException e) {
            assert  true;
        }

        System.out.println("Finished UserService test: check for validate no user exception");
    }
}
