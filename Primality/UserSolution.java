package Primality;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Primality */
public class UserSolution {
        
    public static boolean isPrime(int n){
    		if(n==1 || n==2)
    			return true;
            if(n%2 ==0){
                    return false;
            }
                else{
                        int root_n = (int)Math.sqrt(n);
//                        System.out.println("root="+ root_n);
                        for(int i=3; i<=root_n;i++){
                                if(n%i==0){
                                        return false;
                                }
                        }
                }
            return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            
            boolean flag = isPrime(n);
            
            if(flag)
                    System.out.println("Prime");
            else
                    System.out.println("Not prime");
        }
    }
}
