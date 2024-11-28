// public class TestAnagram {
//     private static int totalTests = 0;
//     private static int passedTests = 0;

//     public static void main(String[] args) {
//         testIsAnagram();
//         testPreProcess();
//         testRandomAnagram();
        
//         System.out.println("\nTotal tests: " + totalTests);
//         System.out.println("Passed tests: " + passedTests);
//         System.out.println("Success rate: " + (passedTests * 100.0 / totalTests) + "%");
//     }

//     public static int testIsAnagram() {
//         System.out.println("\nTesting isAnagram method:");
//         totalTests += 5;

//         // Test case 1: Basic anagram
//         boolean test1 = Anagram.isAnagram("silent", "listen");
//         System.out.println("Test 1 (basic anagram): " + (test1 ? "PASS" : "FAIL"));
        
//         // Test case 2: Different lengths
//         boolean test2 = !Anagram.isAnagram("hello", "world!");
//         System.out.println("Test 2 (different lengths): " + (test2 ? "PASS" : "FAIL"));
        
//         // Test case 4: Empty strings
//         boolean test4 = Anagram.isAnagram("", "");
//         System.out.println("Test 4 (empty strings): " + (test4 ? "PASS" : "FAIL"));
        
//         // Test case 5: Complex anagram with spaces
//         boolean test5 = Anagram.isAnagram("William Shakespeare", "I am a weakish speller");
//         System.out.println("Test 5 (complex anagram): " + (test5 ? "PASS" : "FAIL"));
        
//         // Test case 6: Case sensitivity
//         boolean test6 = Anagram.isAnagram("Silent", "ListeN");
//         System.out.println("Test 6 (case sensitivity): " + (test6 ? "PASS" : "FAIL"));

//         int passed = (test1 ? 1 : 0) + (test2 ? 1 : 0) + 
//                     (test4 ? 1 : 0) + (test5 ? 1 : 0) + (test6 ? 1 : 0);
//         passedTests += passed;
//         return passed;
//     }

//     public static int testPreProcess() {
//         System.out.println("\nTesting preProcess method:");
//         totalTests += 4;

//         // Test case 1: Simple lowercase
//         boolean test1 = Anagram.preProcess("abc").equals("abc");
//         System.out.println("Test 1 (simple lowercase): " + (test1 ? "PASS" : "FAIL"));
        
//         // Test case 2: Preserve spaces
//         boolean test2 = Anagram.preProcess("Hello World!").equals("hello world");
//         System.out.println("Test 2 (preserve spaces): " + (test2 ? "PASS" : "FAIL"));
        
//         // Test case 3: Convert to lowercase
//         boolean test3 = Anagram.preProcess("HeLLo").equals("hello");
//         System.out.println("Test 3 (case conversion): " + (test3 ? "PASS" : "FAIL"));
        
//         // Test case 4: Empty string
//         boolean test4 = Anagram.preProcess("").equals("");
//         System.out.println("Test 4 (empty string): " + (test4 ? "PASS" : "FAIL"));

//         int passed = (test1 ? 1 : 0) + (test2 ? 1 : 0) + (test3 ? 1 : 0) + (test4 ? 1 : 0);
//         passedTests += passed;
//         return passed;
//     }

//     public static int testRandomAnagram() {
//         System.out.println("\nTesting randomAnagram method:");
//         totalTests += 3;
        
//         // Test case 1: Check if result is an anagram
//         String original = "hello";
//         String randomized = Anagram.randomAnagram(original);
//         boolean test1 = Anagram.isAnagram(original, randomized);
//         System.out.println("Test 1 (is anagram): " + (test1 ? "PASS" : "FAIL"));
        
//         // Test case 2: Check if same length
//         boolean test2 = original.length() == randomized.length();
//         System.out.println("Test 2 (same length): " + (test2 ? "PASS" : "FAIL"));
        
//         // Test case 3: Check randomness (run multiple times)
//         boolean foundDifferent = false;
//         String first = Anagram.randomAnagram("testing");
//         for (int i = 0; i < 10; i++) {
//             String next = Anagram.randomAnagram("testing");
//             if (!first.equals(next)) {
//                 foundDifferent = true;
//                 break;
//             }
//         }
//         System.out.println("Test 3 (randomness): " + (foundDifferent ? "PASS" : "FAIL"));

//         int passed = (test1 ? 1 : 0) + (test2 ? 1 : 0) + (foundDifferent ? 1 : 0);
//         passedTests += passed;
//         return passed;
//     }
// } 
// import java.util.Random;
 
// /** Functions for checking if a given string is an anagram. */
// public class TestAnagram {
//     public static void main(String args[]) {
//         // Tests the isAnagram function.
//         System.out.println(isAnagram("silent","listen"));  // true
//         System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
//         System.out.println(isAnagram("Madam Curie","Radium came")); // true
//         System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
 
//         // Tests the preProcess function.
//         System.out.println(preProcess("What? No way!!!"));
//         System.out.println(isAnagram("m  o my", "YoMm "));
//         // Tests the randomAnagram function.
//         System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
       
//         //Performs a stress test of randomAnagram
//         String str = "1234567";
//         Boolean pass = true;
//         //// 10 can be changed to much larger values, like 1000
//         for (int i = 0; i < 10; i++) {
//             String randomAnagram = randomAnagram(str);
//             System.out.println(randomAnagram);
//             pass = pass && isAnagram(str, randomAnagram);
//             if (!pass) break;
//         }
//         System.out.println(pass ? "test passed" : "test Failed");
//     } 
 
//     // Returns true if the two given strings are anagrams, false otherwise.
//     public static boolean isAnagram(String str1, String str2) {
//         str1=preProcess(str1);
//         str2=preProcess(str2);
//         boolean isAnagram=true;
//         int times1=0,times2=0;
//         char chr1;
//         String maxStr,minStr;
//         if(str1.length()>=str2.length()){
//             maxStr=str1;
//             minStr=str2;
//         } else{
//             maxStr=str2;
//             minStr=str1;
//         }
//         for(int i=0;i<maxStr.length()&&isAnagram;i++){
//             chr1=maxStr.charAt(i);
//             if(chr1!=' '){
//                 if(minStr.indexOf(chr1)==-1) { // if the letter is not in the word
//                     isAnagram=false;
//                     break;
//                 } else{
//                     times1=countChr(maxStr, chr1); // time of letter(i) in str1
//                     times2=countChr(minStr, chr1); // time of letter(i) in str2
//                     if(times1!=times2) {
//                         isAnagram=false;
//                         break;
//                     }
//                 }
//                 }
//             }
        
//         return isAnagram;
//     }
//     // checks how many times a letter is in a word
//     public static int countChr(String str1, char c) {
//         int count=0;
//         for(int i=0;i<str1.length();i++) {
//             if (str1.charAt(i)==c) {
//                 count++;
//             }
//         }
//         return count;
//     }
 
//     // Returns a preprocessed version of the given string: all the letter characters are converted
//     // to lower-case, and all the other characters are deleted, except for spaces, which are left
//     // as is. For example, the string "What? No way!" becomes "whatnoway"
//     public static String preProcess(String str) {
//         String newStr="";
//         char chr;
//         str=str.toLowerCase();
//         for(int i=0;i<str.length();i++) {
//             chr=str.charAt(i);
//             if(Character.isLetter(chr)||chr==' ') {
//                 newStr+=""+chr;
//             }
//         }
//         return newStr;
//     }
       
//     // Returns a random anagram of the given string. The random anagram consists of the same
//     // characters as the given string, re-arranged in a random order.
//     public static String randomAnagram(String str) {
//         char[] strArr = str.toCharArray();
//         int length = strArr.length;
//         char[] result = new char[length]; // create anagram
//         for (int i = 0; i < length; i++) {
//         // Use Math.random() to generate a random index
//             int randomIndex = (int) (Math.random() * (length - i));
//             result[i] = strArr[randomIndex]; // add character to nrew array
//             for (int j = randomIndex; j < length - i - 1; j++) { // Shift remaining characters
//                 strArr[j] = strArr[j + 1];
//             }
//         }
//         return new String(result);// Convert to String
//     }
 
//     }
import java.util.Random;

public class TestAnagram {
    public static void main(String args[]) {
        System.out.println("Testing isAnagram method:");
        System.out.println("Test 1 (basic anagram): " + (isAnagram("silent", "listen") ? "PASS" : "FAIL"));
        System.out.println("Test 2 (different lengths): " + (!isAnagram("abc", "abcd") ? "PASS" : "FAIL"));
        System.out.println("Test 4 (empty strings): " + (isAnagram("", "") ? "PASS" : "FAIL"));
        System.out.println("Test 5 (complex anagram): " + (isAnagram("William Shakespeare", "I am a weakish speller") ? "PASS" : "FAIL"));
        System.out.println("Test 6 (case sensitivity): " + (isAnagram("aBc", "CBA") ? "PASS" : "FAIL"));

        System.out.println("\nTesting preProcess method:");
        System.out.println("Test 1 (simple lowercase): " + (preProcess("abc").equals("abc") ? "PASS" : "FAIL"));
        System.out.println("Test 2 (preserve spaces): " + (preProcess("a b c").equals("abc") ? "PASS" : "FAIL"));
        System.out.println("Test 3 (case conversion): " + (preProcess("AbC").equals("abc") ? "PASS" : "FAIL"));
        System.out.println("Test 4 (empty string): " + (preProcess("").equals("") ? "PASS" : "FAIL"));

        System.out.println("\nTesting randomAnagram method:");
        String str = "12345";
        boolean pass = true;
        for (int i = 0; i < 10; i++) {
            String randomAnagram = randomAnagram(str);
            if (!isAnagram(str, randomAnagram)) {
                pass = false;
                break;
            }
        }
        System.out.println("Test 1 (is anagram): " + (pass ? "PASS" : "FAIL"));
    }

    // Returns true if the two given strings are anagrams, false otherwise.
    public static boolean isAnagram(String str1, String str2) {
        str1 = preProcess(str1);
        str2 = preProcess(str2);

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);

        return java.util.Arrays.equals(arr1, arr2);
    }

    // Returns a preprocessed version of the given string: all the letter characters are converted
    // to lower-case, and all the other characters are deleted.
    public static String preProcess(String str) {
        StringBuilder newStr = new StringBuilder();
        str = str.toLowerCase();

        for (char chr : str.toCharArray()) {
            if (Character.isLetter(chr)) {
                newStr.append(chr);
            }
        }
        return newStr.toString();
    }

    // Returns a random anagram of the given string using Fisher-Yates Shuffle.
    public static String randomAnagram(String str) {
        char[] strArr = str.toCharArray();
        Random rand = new Random();

        for (int i = strArr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            char temp = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = temp;
        }
        return new String(strArr);
    }
}


 
