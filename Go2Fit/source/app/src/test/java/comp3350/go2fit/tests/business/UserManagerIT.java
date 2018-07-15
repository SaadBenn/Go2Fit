package comp3350.go2fit.tests.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.tests.utils.TestUtils;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class UserManagerIT {
    private UserManager db;
    private File tempDB;
    private UserModel user;


    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.db = new UserManager();
        this.user = new UserModel();
    }


    @Test
    public void testForNull() {
        System.out.println("\nStarting testUserManager: null database");
        assertNotNull(db);
        System.out.println("Finished testUserManager: null database");
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
        this.db = new UserManager();
        this.user = new UserModel();
    }


    @Test
    public void testUpdateUser()
    {
        System.out.println("\nStarting testUserManager: check update ");
        user.setCurrentChallenge(0);
        user.setId(1);
        boolean result = db.updateUser(user);
        assertTrue(result);
        System.out.println("Finished testUserManager: check update");
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
        this.db = new UserManager();
        this.user = new UserModel();
    }


    @Test
    public void testForGetAllUsers() {
        System.out.println("\nStarting testUserManager: check get all users ");
        Map<Integer, UserModel> map;
        map = db.getAllUsers();
        assertTrue("The database should have default users", map.size() >=1);
        System.out.println("Finished testUserManager: check get all users");
    }


    @After
    public void tearDown2()
    {
        //reset DB
        this.tempDB.delete();
    }


    @Before
    public void setUp3() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.db = new UserManager();
        this.user = new UserModel();
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


    @After
    public void tearDown3()
    {
        //reset DB
        this.tempDB.delete();
    }
}
