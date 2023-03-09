import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class CheckIfInpIsDouble {
    @Test
    void checkIfDouble(){
        /* Testing if my new function "checkIfPriceIsDouble" functions as intended. It should do the following:
        1. Take in a String
        2. Assess if the String is a double.
        3. If it is, return the String.
        4. If it throws an exception (a.k.a. is not a Double), it should allow the user to try and input information again.
         */

        System.out.println("Please input the same price each time, in the exact same format.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("First Price");
        String firstInp = scanner.nextLine();

        System.out.println("Second Price");
        String userInp = CreateRecord.checkIfPriceIsDouble();

        //This checks that something was returned.
        Assertions.assertNotNull(userInp);
        //The first one checks that they're of the same type and that the value is not in any way altered during in the function.
        Assertions.assertEquals(firstInp, userInp);


    }

}
