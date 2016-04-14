/**
 * Created by Thorstein on 14.04.2016.
 */

import org.apache.commons.math3.primes.Primes;

public class NumberChecker {
    private int number = 0;

    public NumberChecker(String nr){
        if(nr.startsWith("-")){
            throw new ArithmeticException("Negative numbers can not be primes");
        }else{
            try{
                number = Integer.parseInt(nr);
            }catch (NumberFormatException e){
                throw new NumberFormatException("Couldn't parse string to integer");
            }
        }
    }

    public int getNumber(){
        return number;
    }

    public boolean isPrime(int number){
        return Primes.isPrime(number);
    }

    public String toString(int number){
        if((!isPrime(number))){
            return number + " er ikke et primtall";
        }else{
            return number + " er et primtall";
        }
    }

}
