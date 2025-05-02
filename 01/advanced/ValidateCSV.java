package advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCSV {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    private static final String PHONE_REGEX = "^[0-9]{10}$";

    public static void main(String[] args) {
        String csvFile = "details.csv";
        String line;
        String delimiter = ",";  

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(delimiter);
                
                String email = columns[0].trim(); 
                String phoneNumber = columns[1].trim(); 
                
                if (!isValidEmail(email)) {
                    System.out.println("Invalid email: " + email + " in row: " + line);
                }
                
                if (!isValidPhoneNumber(phoneNumber)) {
                    System.out.println("Invalid phone number: " + phoneNumber + "\nin row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
