package PageFactory.com.utilities;

import java.util.Random;

public class RandomStringGenerator {

    public static String randomNumGenerator()

    {
        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();
        sb.append("E2E-QA-Challenge-");

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 7;

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        System.out.println ("Random String is: " + randomString);
        return randomString;
    }
}
