package no.westerdals.student.loktho14.PG4100.innleveringTre.utils;

import org.apache.commons.math3.primes.Primes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class NumberChecker {
    private int number = 0;
    private static final Logger logger = LogManager.getLogger("Errors");

    public NumberChecker(String nr){
        if(nr.startsWith("-")){
            logger.error("Error : User tried to send in negative number");
            throw new ArithmeticException("Negative numbers can not be primes");
        }else{
            isNumber(nr);
        }
    }

    private void isNumber(String nr) {
        try{
            number = Integer.parseInt(nr);
        }catch (NumberFormatException e){
            logger.error("Error : Couldn't parse string to integer" + Arrays.toString(e.getStackTrace()));
            throw new NumberFormatException("Couldn't parse string to integer");
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
