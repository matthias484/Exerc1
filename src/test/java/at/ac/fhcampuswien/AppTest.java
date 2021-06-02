package at.ac.fhcampuswien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class AppTest {



    @Test //too short
    public void invalidLength(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("2less()");
        assertFalse(passwordIsValid);
    }
    @Test //too long
    public void invalidLength2(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("ThisPasswordIsTooLong(123456789)");
        assertFalse(passwordIsValid);
    }
    @Test //no upper case letter
    public void upperLowerCase(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("(password1)");
        assertFalse(passwordIsValid);
    }

    @Test //no lower case letter
    public void upperLowerCase2(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("(PASSWORD1)");
        assertFalse(passwordIsValid);
    }
    @Test // numberst must exist
    public void existingNumbers(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("(Password)");
        assertFalse(passwordIsValid);
    }
    @Test // ()#$?!%/@ must exist, other special chars are not valid
    public void specialChars(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("Password1");
        assertFalse(passwordIsValid);
    }
    @Test // not more than 2 numbers continuous (e.g. 1,2,3)
    public void continuousNumbers(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("Password(12345)");
        assertFalse(passwordIsValid);
    }
    @Test // a number not more than 4 times in a row (e.g. 1,1,1,1)
    public void numbersInARow(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("Password(1111)");
        assertFalse(passwordIsValid);
    }

    @Test // between 8 & 25 digits
    public void lengthTrue(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("(RightLength1@");
        assertTrue(passwordIsValid);
    }

    @Test //must exist of upper  case letters
    public void upperLowerCaseTrue(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("(Password1)");
        assertTrue(passwordIsValid);
    }

    @Test // numbers must exist
    public void existingNumbersTrue(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("(Password1298)");
        assertTrue(passwordIsValid);
    }
    @Test // ()#$?!%/@ must exist, other special chars are not valid
    public void specialCharsTrue(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("@Password1");
        assertTrue(passwordIsValid);
    }
    @Test // not more than 2 numbers continuous (e.g. 1,2,3)
    public void continuousNumbersTrue(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("Password(12)");
        assertTrue(passwordIsValid);
    }
    @Test // a number not more than 4 times in a row (e.g. 1,1,1,1)
    public void numbersInARowTrue(){
        App app = new App();
        boolean passwordIsValid = app.checkPassword("Password(111222333)");
        assertTrue(passwordIsValid);
    }


}
