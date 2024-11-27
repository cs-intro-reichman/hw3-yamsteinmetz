// // Implements algebraic operations and the square root function without using 
// // the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// // Math.sqrt. All the functions in this class operate on int values and
// // return int values.

// public class Algebra {
// 	public static void main(String args[]) {
// 	    // Tests some of the operations


// 	     System.out.println(plus(2,3));   // 2 + 3
// 	     System.out.println(minus(7,2));  // 7 - 2
//    		 System.out.println(minus(2,7));  // 2 - 7
//  		 System.out.println(times(3,4));  // 3 * 4
//    		 System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
//    		 System.out.println(pow(5,3));      // 5^3
//    		 System.out.println(pow(3,5));      // 3^5
//    		 System.out.println(div(12,3));   // 12 / 3    
//    		 System.out.println(div(5,5));    // 5 / 5  
//    		 System.out.println(div(25,7));   // 25 / 7
//    		 System.out.println(mod(25,7));   // 25 % 7
//    		 System.out.println(mod(120,6));  // 120 % 6    
//    		 System.out.println(sqrt(36));
// 		 System.out.println(sqrt(263169));
//    		 System.out.println(sqrt(76123));



// 		////// OUR tests

// 		// int a;
// 		// a = plus(3,8);
// 		// System.out.println(a);

// 		// a = minus(10,6);
// 		// System.out.println(a);


// 		// System.out.println(times(9,9));

// 		// System.out.println(pow(2,5));


// 		// System.out.println(div(20,5));
// 		// System.out.println(div(31,3));


// 		// System.out.println(mod(20,8));

// 		// System.out.println(sqrt(121));
// 		// System.out.println(sqrt(120));

// 	}  

// 	// Returns x1 + x2
// 	public static int plus(int x1, int x2) {
// 		for(int i=0; i<x2; i++) {
// 			x1++;
// 		}
// 		return x1;
// 	}


	

		
// 	// Returns x1 - x2
// 	public static int minus(int x1, int x2) {
// 		for(int i=0; i<x2; i++) {
// 			x1--;
// 		}
// 		return x1;
// 	}
		



// 	// Returns x1 * x2
// 	public static int times(int x1, int x2) {
// 		int x3;
// 		x3 = 0;
// 		for (int i = 0; i<x2; i++){
// 			x3 = plus(x3, x1);
// 		}
// 		return x3;
// 	}
    


// 	// Returns x^n (for n >= 0)
// 	public static int pow(int x, int n) {
// 		int x3;
// 		x3 = 1;
// 		for (int i = 0; i<n; i++){
// 			x3 = times(x3, x);
// 		}
// 		return x3;
// 	}
    


// 	// Returns the integer part of x1 / x2 
// 	public static int div(int x1, int x2) {
// 		int count = 0;
// 		int x3 = 0;
// 		while(x3 < x1) {
// 			x3 = plus(x3,x2);
// 			count ++;
// 		}

// 		if(x3 == x1){
// 			return count;
// 		}
// 		return minus(count,1);
// 	}
	


// 	// Returns x1 % x2
// 	public static int mod(int x1, int x2) {
// 		int x3 = 0;
// 		while (x3<x1){
// 			x3 = plus(x3,x2);
// 		}
// 		x3 = minus(x3,x2);
// 		return minus(x1,x3);
// 	 }



// 	// Returns the integer part of sqrt(x) 
// 	public static int sqrt(int x) {
// 		int count = 0;

// 		while(times(count,count) < x) {
// 			count ++;
// 		}
// 		if (times(count,count) == x){
// 			return count;
// 		}
// 		return count-1;
//     }
// }
public class Algebra {
    public static void main(String args[]) {
        System.out.println(plus(2, 3)); // 2 + 3
        System.out.println(minus(7, 2)); // 7 - 2
        System.out.println(minus(2, 7)); // 2 - 7
        System.out.println(times(3, 4)); // 3 * 4
        System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
        System.out.println(pow(5, 3)); // 5^3
        System.out.println(pow(3, 5)); // 3^5
        System.out.println(div(12, 3)); // 12 / 3
        System.out.println(div(5, 5)); // 5 / 5
        System.out.println(div(25, 7)); // 25 / 7
        System.out.println(mod(25, 7)); // 25 % 7
        System.out.println(mod(120, 6)); // 120 % 6
        System.out.println(sqrt(36)); // 6
        System.out.println(sqrt(263169)); // 513
        System.out.println(sqrt(76123)); // Approximate
    }

    public static int plus(int x1, int x2) {
        for (int i = 0; i < x2; i++) {
            x1++;
        }
        return x1;
    }

    public static int minus(int x1, int x2) {
        for (int i = 0; i < x2; i++) {
            x1--;
        }
        return x1;
    }

    public static int times(int x1, int x2) {
        int x3 = 0;
        for (int i = 0; i < x2; i++) {
            x3 = plus(x3, x1);
        }
        return x3;
    }

    public static int pow(int x, int n) {
        int x3 = 1;
        for (int i = 0; i < n; i++) {
            x3 = times(x3, x);
        }
        return x3;
    }

    public static int div(int x1, int x2) {
        if (x2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        int count = 0;
        int x3 = 0;
        while (plus(x3, x2) <= x1) {
            x3 = plus(x3, x2);
            count++;
        }
        return count;
    }

    public static int mod(int x1, int x2) {
        if (x2 == 0) {
            throw new ArithmeticException("Modulo by zero");
        }
        int x3 = 0;
        while (plus(x3, x2) <= x1) {
            x3 = plus(x3, x2);
        }
        return minus(x1, x3);
    }

    public static int sqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Square root of negative number");
        }
        int count = 0;
        while (times(count, count) <= x) {
            count++;
        }
        return minus(count, 1);
    }
}
