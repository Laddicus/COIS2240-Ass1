package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = reader.nextInt();
        final long iteStart = System.nanoTime();
        fiboSeriesIte(n);
        final long iteEnd = System.nanoTime();

        final long recStart = System.nanoTime();
        fiboSeriesRec(n, 0, 1);
        final long recEnd = System.nanoTime();

        final long iteTime = iteEnd-iteStart;
        final long recTime = recEnd-recStart;
        System.out.println("Iteration:" + iteTime + "\nRecursive:" + recTime);
        reader.close();
    }
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
    public static void fiboSeriesRec(long x, long y, long z){
        if (x <= 0)
        {
            return;
        }
        System.out.println(y);
        fiboSeriesRec(x-1, z, z+y);
    }
}
