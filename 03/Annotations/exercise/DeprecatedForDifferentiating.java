package exercise;

class LegacyAPI {
 @Deprecated
 public void oldFeature() {
     System.out.println("This is the old feature. It is deprecated and should not be used.");
 }
 
 public void newFeature() {
     System.out.println("This is the new feature. Please use this.");
 }
}

public class DeprecatedForDifferentiating {
 public static void main(String[] args) {
     LegacyAPI legacyAPI = new LegacyAPI();
     
     legacyAPI.oldFeature(); 
     
     legacyAPI.newFeature(); 
 }
}
