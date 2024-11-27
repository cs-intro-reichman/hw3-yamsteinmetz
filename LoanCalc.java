// // Computes the periodical payment necessary to pay a given loan.
// public class LoanCalc {
	
// 	static double epsilon = 0.001;  // Approximation accuracy
// 	static int iterationCounter;    // Number of iterations 
	
// 	// Gets the loan data and computes the periodical payment.
//     // Expects to get three command-line arguments: loan amount (double),
//     // interest rate (double, as a percentage), and number of payments (int).  
// 	public static void main(String[] args) {		
// 		// Gets the loan data
// 		double loan = Double.parseDouble(args[0]);
// 		double rate = Double.parseDouble(args[1]);
// 		int n = Integer.parseInt(args[2]);
// 		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

// 		// Computes the periodical payment using brute force search
// 		System.out.print("\nPeriodical payment, using brute force: ");
// 		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
// 		System.out.println("number of iterations: " + iterationCounter);

// 		// Computes the periodical payment using bisection search
// 		System.out.print("\nPeriodical payment, using bi-section search: ");
// 		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
// 		System.out.println("number of iterations: " + iterationCounter);
// 	}

// 	// Computes the ending balance of a loan, given the loan amount, the periodical
// 	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
// 	private static double endBalance(double loan, double rate, int n, double payment) {	
// 		double balance = loan;
//         for (int i = 0; i < n; i++) {
//             balance = (balance - payment) * (1 + rate);  
//         }
//         return balance;
//     }
	
// 	// Uses sequential search to compute an approximation of the periodical payment
// 	// that will bring the ending balance of a loan close to 0.
// 	// Given: the sum of the loan, the periodical interest rate (as a percentage),
// 	// the number of periods (n), and epsilon, the approximation's accuracy
// 	// Side effect: modifies the class variable iterationCounter.
//     public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
// 		double payment = loan / n;  
//         iterationCounter = 0;  

        
//         while (endBalance(loan, rate, n, payment) > epsilon) {
//             payment += epsilon;  
//             iterationCounter++;
//         }

//         return payment;
//     }
    
//     // Uses bisection search to compute an approximation of the periodical payment 
// 	// that will bring the ending balance of a loan close to 0.
// 	// Given: the sum of the loan, the periodical interest rate (as a percentage),
// 	// the number of periods (n), and epsilon, the approximation's accuracy
// 	// Side effect: modifies the class variable iterationCounter.
//     public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
// 		double low = loan / n; 
//         double high = loan * (1 + rate);  
//         double payment = 0;
//         iterationCounter = 0;  

    
//         while ((high - low) > epsilon) {
//             payment = (low + high) / 2;   
//             double balance = endBalance(loan, rate, n, payment);

//             if (balance > 0) {
//                 low = payment;  
//             } else {
//                 high = payment;  
//             }

//             iterationCounter++;
//         }

//         return payment;
//     }
// }

public class LoanCalc {

    static double epsilon = 0.001; // דיוק החישוב
    static int iterationCounter;  // מונה איטרציות

    public static void main(String[] args) {
        // קלט: סכום ההלוואה, שיעור ריבית שנתי (באחוזים), מספר התשלומים
        double loan = Double.parseDouble(args[0]);
        double annualRate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);

        // חישוב שיעור ריבית חודשי
        double monthlyRate = annualRate / 100 / 12;

        System.out.println("Loan = " + loan + ", interest rate = " + annualRate + "%, periods = " + n);

        // פיתרון באמצעות חיפוש גס
        iterationCounter = 0; // איפוס המונה
        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) bruteForceSolver(loan, monthlyRate, n, epsilon));
        System.out.println("Number of iterations: " + iterationCounter);

        // פיתרון באמצעות חיפוש בינארי
        iterationCounter = 0; // איפוס המונה
        System.out.print("\nPeriodical payment, using bi-section search: ");
        System.out.println((int) bisectionSolver(loan, monthlyRate, n, epsilon));
        System.out.println("Number of iterations: " + iterationCounter);
    }

    /**
     * חישוב יתרה סופית של הלוואה.
     *
     * @param loan    סכום ההלוואה.
     * @param rate    שיעור ריבית חודשי (עשרוני).
     * @param n       מספר התשלומים.
     * @param payment התשלום החודשי הקבוע.
     * @return יתרה סופית אחרי n תשלומים.
     */
    private static double endBalance(double loan, double rate, int n, double payment) {
        double balance = loan;
        for (int i = 0; i < n; i++) {
            balance = balance * (1 + rate) - payment;
        }
        return balance;
    }

    /**
     * חיפוש גס עבור התשלום התקופתי.
     *
     * @param loan    סכום ההלוואה.
     * @param rate    שיעור ריבית חודשי (עשרוני).
     * @param n       מספר התשלומים.
     * @param epsilon דיוק החישוב.
     * @return התשלום התקופתי שמביא את היתרה לכמעט אפס.
     */
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        double payment = 0.0;
        iterationCounter = 0;

        while (true) {
            double balance = endBalance(loan, rate, n, payment);
            if (Math.abs(balance) < epsilon) {
                return payment;
            }
            payment += epsilon; // העלאת התשלום
            iterationCounter++;

            // בדיקה למניעת לולאה אינסופית
            if (payment > loan * (1 + rate)) {
                throw new IllegalArgumentException("Solution not converging with brute force.");
            }
        }
    }

    /**
     * חיפוש בינארי עבור התשלום התקופתי.
     *
     * @param loan    סכום ההלוואה.
     * @param rate    שיעור ריבית חודשי (עשרוני).
     * @param n       מספר התשלומים.
     * @param epsilon דיוק החישוב.
     * @return התשלום התקופתי שמביא את היתרה לכמעט אפס.
     */
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        double low = loan / n;               // הגבול התחתון לתשלום
        double high = loan * (1 + rate);     // הגבול העליון לתשלום
        double payment = 0.0;

        while ((high - low) > epsilon) {
            payment = (low + high) / 2.0; // נקודת האמצע
            double balance = endBalance(loan, rate, n, payment);

            if (balance > 0) {
                low = payment; // התשלום נמוך מדי
            } else {
                high = payment; // התשלום גבוה מדי
            }
            iterationCounter++;
        }

        return payment;
    }
}
