
/**
 * main.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class hi
{
    public static void main(String s[]) {
        long startTime = System.currentTimeMillis();
        
         System.out.println(factorial(10000));
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
         System.out.println(totalTime);
        
        
        
    }
public static long factorial(int n) { 
    if (n == 1) return 1; 
    return n * factorial(n-1); 
} 
}
