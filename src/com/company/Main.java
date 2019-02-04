/*
This is Assignment 1 for COIS 2240 by Devon Ladd
 */
package com.company;
import java.sql.Time;
import java.util.Scanner;

public class Main {
    /*
    main asks users for input, sends it to callLoops and finds the average of 10 samples
    Times total is what callLoops returns
    long iteTotal is the total time for all the
    int n is the user's requested number of fibonacci numbers

     */
    public static void main(String[] args) {
        while (true)
        {

            Times total;

            long iteTotal = 0;
            long recTotal = 0;

            // scanner allows input to be taken
            Scanner reader = new Scanner(System.in);

            // request and take input
            System.out.println("Enter a number");
            int n = reader.nextInt();

            for (int j=0;j<10;j++)
            {
                total = callLoops(n);
                iteTotal += total.getIteTime();
                recTotal += total.getRecTime();
            }
            long iteAve = iteTotal/10;
            long recAve = recTotal/10;
            System.out.println("Iterative average: " + iteAve + "\nRecursive average: " + recAve);
        }
    }
    /*
    fiboSeriesIte prints out the fibonacci sequence for the given x
    int x counts the number of loops
    long prev1 is the previous sum
    long prev2 is the current sum
    long prev3 is an intermediate variable
     */
    public static void fiboSeriesIte(int x){
        long prev1 = 0;
        long prev2 = 1;
        long prev3 = 1;
        for (int i = 0; i < x; i++)
        {
            System.out.println(prev1);
            prev3 += prev1;
            prev1 = prev2;
            prev2 = prev3;
        }
    }
    /*
    fiboSeriesRec prints out the fibonacci series for the given x
    int x keeps track of the number of loops, counts down
    long y is the current sum
    long z is the next sum
     */
    public static void fiboSeriesRec(int x, long y, long z){
        // only is true when the series is complete
        if (x <= 0)
        {
            return;
        }
        System.out.println(y);
        // decrements x, y=z, z=z+y
        fiboSeriesRec(x-1, z, z+y);
    }
    /*
    callLoops takes an integer n and uses it to find iteTime and recTime
    returns type Times which contains both times
    iteStart/iteEnd are the start and end times for fiboSeriesIte
    recStart/recEnd are the start and end times for fiboSeriesRec
    iteTime is the difference between iteEnd and iteStart
    recTime is the difference between recEnd and recStart
     */
    public static Times callLoops(int n)
    {

        // gets current time, runs method, gets current time
        long iteStart = System.nanoTime();
        fiboSeriesIte(n);
        long iteEnd = System.nanoTime();

        // gets current time, runs method, gets current time
        long recStart = System.nanoTime();
        fiboSeriesRec(n, 0, 1);
        long recEnd = System.nanoTime();

        // find the difference between the start and end times, the time the method took
        long iteTime = iteEnd-iteStart;
        long recTime = recEnd-recStart;

        // print out results
        System.out.println("Iteration:" + iteTime + "\nRecursive:" + recTime);
        Times time = new Times(iteTime, recTime);
        return time;
    }
}
