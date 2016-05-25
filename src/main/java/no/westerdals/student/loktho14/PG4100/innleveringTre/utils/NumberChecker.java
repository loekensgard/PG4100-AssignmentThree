package no.westerdals.student.loktho14.PG4100.innleveringTre.utils;

import org.apache.commons.math3.primes.Primes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

/**
 * @author Thorstein
 *
 * NumberChecker is a class checking if a given number is positiv
 * and if its a number at all.
 */

public class NumberChecker {
    private int number = 0;
    private static final Logger logger = LogManager.getLogger("Errors");


    /**
     * Method for checking if the given input is positive.
     * @param nr
     */
    public NumberChecker(String nr){
        if(nr.startsWith("-")){
            logger.error("Error : User tried to send in negative number");
            throw new ArithmeticException("Negative numbers can not be primes");
        }else{
            isNumber(nr);
        }
    }

    /**
     * Method for checking if the given input is a number
     * @param nr
     */
    private void isNumber(String nr) {
        try{
            number = Integer.parseInt(nr);
        }catch (NumberFormatException e){
            logger.error("Error : Couldn't parse string to integer" + Arrays.toString(e.getStackTrace()));
            throw new NumberFormatException("Couldn't parse string to integer");
        }
    }

    /**
     * @return a number
     */
    public int getNumber(){
        return number;
    }

    /**
     *
     * @param number
     * @return a boolean telling if the given number is a prime or not
     *
     * Method from apache-commons-math3-primes for checking if our number is a prime or not
     */
    public boolean isPrime(int number){
        return Primes.isPrime(number);
    }

    /**
     *
     * @param number
     * @return a string telling te user if his number is a prime or not
     */
    public String toString(int number){
        if((!isPrime(number))){
            return number + " er ikke et primtall";
        }else{
            return number + " er et primtall";
        }
    }

}
