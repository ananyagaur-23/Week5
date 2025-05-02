package advanced;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


public class EncryptCSV {
	private static final String SECRET_KEY = "1234567890123456"; 

    public static String encrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeBase64String(encryptedBytes); 
    }

    public static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.decodeBase64(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static void encryptAndWriteCSV(String jsonFile, String csvFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
            JSONArray jsonArray = new JSONArray(sb.toString());

            JSONObject first = jsonArray.getJSONObject(0);
            List<String> headers = new ArrayList<>(first.keySet());
            writer.write(String.join(",", headers));
            writer.newLine();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                List<String> row = new ArrayList<>();
                
                String name = obj.getString("name");
                String email = encrypt(obj.getString("email"));
                String salary = encrypt(obj.getString("salary"));
                
                row.add(String.valueOf(obj.getInt("id"))); 
                row.add(name);
                row.add(email); 
                row.add(salary); 

                writer.write(String.join(",", row));
                writer.newLine();
            }
            System.out.println("CSV written with encrypted data.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void decryptAndReadCSV(String csvFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];
                String name = columns[1];
                String encryptedEmail = columns[2];
                String encryptedSalary = columns[3];

                String email = decrypt(encryptedEmail);
                String salary = decrypt(encryptedSalary);

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Salary: " + salary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonInput = "students.json";  
        String csvOutput = "students_encrypted.csv"; 
        encryptAndWriteCSV(jsonInput, csvOutput);

        decryptAndReadCSV(csvOutput);
    }
}
