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

    static double epsilon = 0.001; // Approximation accuracy
    static int iterationCounter;  // Number of iterations 

    public static void main(String[] args) {
        // Input: loan amount, annual interest rate (percentage), number of payments
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]) / 100; // Convert to decimal
        int n = Integer.parseInt(args[2]);

        System.out.println("Loan = " + loan + ", interest rate = " + (rate * 100) + "%, periods = " + n);

        // Brute Force Solver
        iterationCounter = 0; // Reset counter
        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);

        // Bisection Solver
        iterationCounter = 0; // Reset counter
        System.out.print("\nPeriodical payment, using bi-section search: ");
        System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
    }

    /**
     * Computes the ending balance of a loan.
     *
     * @param loan    The loan amount.
     * @param rate    The annual interest rate as a decimal.
     * @param n       The number of payments.
     * @param payment The fixed annual payment.
     * @return The remaining balance after n payments.
     */
    private static double endBalance(double loan, double rate, int n, double payment) {
        double balance = loan;
        for (int i = 0; i < n; i++) {
            balance = (balance - payment) * (1 + rate);
        }
        return balance;
    }

    /**
     * Brute-force search for the periodical payment.
     *
     * @param loan    The loan amount.
     * @param rate    The annual interest rate as a decimal.
     * @param n       The number of payments.
     * @param epsilon The approximation accuracy.
     * @return The periodical payment that reduces the balance to nearly zero.
     */
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        double payment = 0; // Start at zero payment
        iterationCounter = 0;

        while (true) {
            double balance = endBalance(loan, rate, n, payment);
            if (Math.abs(balance) < epsilon) {
                return payment;
            }
            payment += epsilon; // Increment payment by epsilon
            iterationCounter++;
        }
    }

    /**
     * Bisection search for the periodical payment.
     *
     * @param loan    The loan amount.
     * @param rate    The annual interest rate as a decimal.
     * @param n       The number of payments.
     * @param epsilon The approximation accuracy.
     * @return The periodical payment that reduces the balance to nearly zero.
     */
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        double low = 0;               // Lower bound of payment
        double high = loan * (1 + rate); // Upper bound of payment
        double payment = 0;

        while ((high - low) > epsilon) {
            payment = (low + high) / 2; // Midpoint
            double balance = endBalance(loan, rate, n, payment);

            if (balance > 0) {
                low = payment; // Payment is too low
            } else {
                high = payment; // Payment is too high
            }
            iterationCounter++;
        }

        return payment;
    }
}
