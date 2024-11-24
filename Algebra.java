// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int result = x1;
        while (x2 > 0) {
            result++;
            x2--;
        }
        while (x2 < 0) {
            result--;
            x2++;
        }
        return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int result = x1;
        while (x2 > 0) {
            result--;
            x2--;
        }
        while (x2 < 0) {
            result++;
            x2++;
        }
        return result;
    }

	// Returns x1 * x2
	public static int times(int x1, int x2) {
        int result = 0;
        int absX2 = x2 < 0 ? minus(0, x2) : x2;  // Ensure x2 is positive
        for (int i = 0; i < absX2; i++) {
            result = plus(result, x1);
        }
        return x2 < 0 ? minus(0, result) : result; // If x2 is negative, negate the result
    }

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
        int result = 1;
        while (n > 0) {
            result = times(result, x);
            n = minus(n, 1);
        }
        return result;
    }

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result = 0;
        int absX1 = x1 < 0 ? minus(0, x1) : x1;  // Ensure x1 is positive
        int absX2 = x2 < 0 ? minus(0, x2) : x2;  // Ensure x2 is positive
        while (absX1 >= absX2) {
            absX1 = minus(absX1, absX2);
            result++;
        }
        return (x1 < 0) != (x2 < 0) ? minus(0, result) : result; // If signs differ, make result negative
    }


	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int absX1 = x1 < 0 ? minus(0, x1) : x1;
        int absX2 = x2 < 0 ? minus(0, x2) : x2;
        while (absX1 >= absX2) {
            absX1 = minus(absX1, absX2);
        }
        return x1 < 0 ? minus(0, absX1) : absX1; // If x1 is negative, negate the result
    }


	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int low = 0;
        int high = x;
        int result = 0;
        while (low <= high) {
            int mid = div(plus(low, high), 2);
            int midSquared = times(mid, mid);
            if (midSquared == x) {
                return mid;
            }
            if (midSquared < x) {
                low = plus(mid, 1);
                result = mid;  // Update result with the latest valid mid
            } else {
                high = minus(mid, 1);
            }
        }
        return result;
    }
}