package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import comp3350.go2fit.BuisnessLayer.Exceptions.NoPasswordFoundException;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordToShortException;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordsDontMatchException;
import comp3350.go2fit.BuisnessLayer.PasswordService;
import comp3350.go2fit.tests.utils.TestUtils;

public class PasswordServiceIT extends TestCase {
    private PasswordService pass;
    private File tempDB;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.pass = new PasswordService();
    }


    @Test(expected = NoPasswordFoundException.class)
    public void testForValidatePassword() {
        System.out.println("\nStarting PasswordServiceTest: check for NoPasswordFoundException");

        try {
            pass.validatePassword("abc", "qwe");
        } catch (NoPasswordFoundException e) {
            assert true;
        }

        System.out.println("Finished PasswordServiceTest: check for NoPasswordFoundException");
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
        this.pass = new PasswordService();
    }


    @Test(expected = PasswordsDontMatchException.class)
    public void testForPasswordMatch() {
        System.out.println("\nStarting PasswordServiceTest: check for PasswordsDontMatchException");

        try {
            pass.passwordsMatch("abc", "qwe");
        } catch (PasswordsDontMatchException e) {
            assert true;
        }

        System.out.println("Finished PasswordServiceTest: check for PasswordsDontMatchException");
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
        this.pass = new PasswordService();
    }


    @Test(expected = PasswordToShortException.class)
    public void testForValidatePasswordLength() {
        System.out.println("\nStarting PasswordServiceTest: check for PasswordToShortException");

        pass = new PasswordService();
        try {
            pass.validatePasswordLength("abc");
        } catch (PasswordToShortException e) {
            assert true;
        }

        System.out.println("Finished PasswordServiceTest: check for PasswordToShortException");
    }


    @After
    public void tearDown2()
    {
        //reset DB
        this.tempDB.delete();
    }
}
