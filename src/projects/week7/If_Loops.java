package projects.week7;

import java.util.Random;

public class If_Loops {
    public static void main(String[] args)
    {
        // O(n) notation
        Random rand = new Random(0l);
        int size = 10000;
        int[][] sample2D = new int[size][size];
        for(int i=0; i<sample2D.length; i++) {
            int[] sample = rand.ints(sample2D[i].length, 0, 10).toArray();
            sample2D[i] = sample;
        }
        int sum;
        long startTime = System.currentTimeMillis();
        sum = findSum(sample2D);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("That took %d milliseconds to calculate the sum of %,d random integers\nThe sum is %,d",(endTime - startTime),size*size,sum));

        // Factorials
        System.out.println(fact(4));

        // Fibonacci Sequence
        System.out.println(fibonacci(2));

    }
    public static int fibonacci(int n)
    {
        int total = 0;

        if(n >=1){
            total += fibonacci(n-1) + fibonacci(n-2);
        }else { // If n = 0
            total += 1;
        }
        return total;
    }
    /*
        Fibonacci Sequence
        1, 1, 2, 3, 5, 8, 13, 21, F(n-1) + F(n-2)
        F(0) = 1
        F(1) = 1
        F(n) = F(n-1) + F(n-2)
     */

    /*
        Factorial:
        fact(n)

        n! = n * (n - 1) * (n - 2) * .... * 3 * 2 * 1
        let 0! = 1

        find 2!
        2! = 2 * 1!
        1! = 1 * 0!
        0! = 1 // The factorial of 0 is always 1.
        Answer: 2

        n! = { n * (n-1)!, n >= 1: 0, n =0 }
     */
    // Recursive method aka the method calls itself.
    public static int fact(int n)
    {
        int total = 0;

        if(n >=1){
            total += n * fact(n-1);
        }else { // If n = 0
            total += 1;
        }
        return total;
    }
    /*
    Calculating fact(4):
    fact(4) --> 4 * fact(3) --> 4 * ( 3 * ( 2 * ( 1 * 1 ))) --> 24
    fact(3) --> 3 * fact(2) --> 3 * ( 2 * ( 1 * 1 ))        --> 6
    fact(2) --> 2 * fact(1) --> 2 * ( 1 * 1 )               --> 2
    fact(1) --> 1 * fact(0) --> 1 * 1                       --> 1
    fact(0) --> 1                                           --> 1
     */

    /*
    Big O notation:
    A measure of time complexity.
    Types:
    1. Constant - O ( 1 )
    2. Linear - O ( n )
    3. Quadratic - O ( n^2 )
    4. Polynomial - O ( n^c )
    5. Factorial - O ( n! )
    For full list: https://en.wikipedia.org/wiki/Big_O_notation#Orders_of_common_functions

    When determining big O, you take the largest growing term and isolate that term.
    Then you drop the constant and are left with the notation.
    T = a*n + b = a * n = n = O ( n )
    T = c * n^2 + d * n + e = c * n ^ 2 = O ( n^2 )
     */
    public static int findSum(int[][] array) // O(n^2)
    {
        int total = 0; // O ( 1 )
        for(int i=0; i<array.length; i++)
            // int i=0 -> O ( 1 )
            // i<array.length -> O ( n )
            // i++ -> O ( n )
            for(int j=0; j<array[i].length; j++)
                // int j=0 -> O ( 1 )
                // j<array[i].length -> O ( n )
                // ^ Technically O(n) + O(1)
                //  because it grabs the array at index i which is O(1) as well.
                //  But it can be shortened to O(n) because that is the largest growing term.
                // j++ -> O ( n )
                total += array[i][j]; // O ( 1 )
        return total; // O ( 1 )
        // Big O Notation Calculations.
        //  total   +  ( i=0  i<len    i++ ) * ( j=0    j<len  j++  ) * total+=elem
        // ( O(1) ) + ( O(1) + O(n) + O(n) ) * ( O(1) + O(n) + O(n) ) * O(1)
        // Simplify
        // ( O(1) ) + ( O(1) + 2O(n) ) * ( O(1) + 2O(n) ) * O(1)
        // Remove Constants
        // ( O(1) ) + ( O(1) + O(n) ) * ( O(1) + O(n) ) * O(1)
        // Simplify
        // ( O(1) ) + ( O(n^2) + 2O(n) + O(1) )
        // Remove Constants
        // ( O(1) ) + ( O(n^2) + O(n) + O(1) )
        // Simplify
        // O(n^2) + O(n) + 2O(1)
        // Remove Constants
        // O(n^2) + O(n) + O(1)
        // Isolate largest growing term
        // O(n^2)
        // Answer = O(n^2)
    }
}
