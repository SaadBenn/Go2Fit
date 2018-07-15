package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.io.IOException;

import comp3350.go2fit.BuisnessLayer.Exceptions.NoUserFoundException;
import comp3350.go2fit.BuisnessLayer.Exceptions.UserExistsException;
import comp3350.go2fit.BuisnessLayer.UserService;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.tests.persistence.UserPersistenceStub;
import comp3350.go2fit.tests.utils.TestUtils;

public class UserServiceIT extends TestCase{

    private File tempDB;
    private UserPersistenceStub db;
    private UserService userService;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.db = new UserPersistenceStub();
        this.userService = new UserService();
    }

    @org.junit.Test
    public void testForFindUser() {
        System.out.println("Starting User Service Test: check findUser");

        UserModel tempData1 = new UserModel();
        tempData1.setId(1);
        tempData1.setName("s");
        tempData1.setPassword("a");
        tempData1.increaseChallengesCompleted();
        tempData1.increaseChallengesCompleted();
        tempData1.setTotalPoints(1200);
        db.add(tempData1);

        int result = userService.findUser(db.getAllUsers(), "s");
        assertTrue("The return value should be >= 0", result >= 0);
        System.out.println("Finished User Service Test: check findUser");
    }


    @After
    public void tearDown()
    {
        //reset DB
        this.tempDB.delete();
    }


    @Before
    public void setUp1() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.db = new UserPersistenceStub();
        this.userService = new UserService();
    }


    @org.junit.Test(expected = NoUserFoundException.class)
    public void testForNoUserFoundException() {
        System.out.println("Starting User Service Test: check no user found exception");

        try {
            int result = userService.findUser(db.getAllUsers(), "saad");
            System.out.println("User not found at index" + result);
        } catch (NoUserFoundException e) {
            assert  true;
        }

        System.out.println("Finished User Service Test: check no user found exception");
    }


    @After
    public void tearDown1()
    {
        //reset DB
        this.tempDB.delete();
    }


    @Before
    public void setUp2() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.db = new UserPersistenceStub();
        this.userService = new UserService();
    }


    @org.junit.Test(expected = UserExistsException.class)
    public void testForValidateNoUser() {
        System.out.println("Starting UserService test: check for validate no use exception");

        UserModel tempData1 = new UserModel();
        tempData1.setId(1);
        tempData1.setName("s");
        tempData1.setPassword("a");
        tempData1.increaseChallengesCompleted();
        tempData1.increaseChallengesCompleted();
        tempData1.setTotalPoints(1200);
        db.add(tempData1);

        try {
            userService.validateNoUser(db.getAllUsers(), "s");
        } catch (UserExistsException e) {
            assert  true;
        }

        System.out.println("Finished UserService test: check for validate no user exception");
    }


    @After
    public void tearDown2()
    {
        //reset DB
        this.tempDB.delete();
    }
}
