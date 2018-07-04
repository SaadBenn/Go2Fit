package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.Test;

import comp3350.go2fit.BuisnessLayer.Exceptions.NoPasswordFoundException;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordToShortException;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordsDontMatchException;
import comp3350.go2fit.BuisnessLayer.PasswordService;

public class PasswordServiceTest extends TestCase {
    private PasswordService pass;

    @Test(expected = NoPasswordFoundException.class)
    public void testForValidatePassword() {
        System.out.println("\nStarting PasswordServiceTest: check for NoPasswordFoundException");

        pass = new PasswordService();
        try {
            pass.validatePassword("abc", "qwe");
        } catch (NoPasswordFoundException e) {
            assert true;
        }

        System.out.println("Finished PasswordServiceTest: check for NoPasswordFoundException");
    }


    @Test(expected = PasswordsDontMatchException.class)
    public void testForPasswordMatch() {
        System.out.println("\nStarting PasswordServiceTest: check for PasswordsDontMatchException");

        pass = new PasswordService();
        try {
            pass.passwordsMatch("abc", "qwe");
        } catch (PasswordsDontMatchException e) {
            assert true;
        }

        System.out.println("Finished PasswordServiceTest: check for PasswordsDontMatchException");
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
}
