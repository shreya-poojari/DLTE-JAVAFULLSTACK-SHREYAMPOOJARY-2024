package org.example;

import static org.junit.Assert.assertTrue;

import org.console.validation.EmployeeValidation;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testName() {
        String input = "Shreya\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(EmployeeValidation.isValidUsername(input.trim()));
    }

    @Test
    public void passName() {
        String input = "Sreya565\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(EmployeeValidation.isValidUsername(input.trim()));
    }

    // Mobile number
    @Test
    public void testMobileNumber() {
        String input = "5252567890\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(EmployeeValidation.isValidContactNumber(Long.valueOf(input.trim())));
    }

    @Test
    public void testMobileFails() {
        String input = "52dfgh8590\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(EmployeeValidation.isValidContactNumber(Long.valueOf(input.trim())));
    }


    // email
    @Test
    public void testEmailId() {
        String input = "shreya123@gmail.com\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(EmployeeValidation.isValidEmail(input.trim()));
    }

    @Test
    public void testEmailIdFails() {
        String input = "shreyapoojary.com\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(EmployeeValidation.isValidEmail(input.trim()));
    }

    @Test
    public void testPincode() {
        String input = "945611\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(EmployeeValidation.isValidEmail(input.trim()));
    }

    //  pin
    @Test
    public void testPincodeFails() {
        String input = "9456\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(EmployeeValidation.isValidEmail(input.trim()));
    }

    // ID
    @Test
    public void testEmployeeID() {
        String input = "91955\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(EmployeeValidation.isValidID(Integer.valueOf(input.trim())));
    }

    @Test
    public void failsEmployeeID() {
        String input = "9195\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertTrue(EmployeeValidation.isValidID(Integer.valueOf(input.trim())));
    }
}



