
package intToHexPackage;

/**
 * Methods to convert an integer to hexadecimal
 *
 * @Author: Timothy Bomers
 * @Date: 2/20/2019
 * @Version: 0.1.0
 */
public class IntToHexClass {
    public static void main(String[] args) {
        System.out.println("hello world");
    }

    /*******************************************************************************
     * A method that converts an integer to its hexadecimal equivalent, so that
     * it only takes up a specified size of memory.
     * @param d A string representing the integer to be converted to hexadecimal.
     * @param bitLength An Integer representing the desired bitLength of the output.
     *                  Expects a value from 0 to 32.
     * @return A string representing the hexadecimal equivalent of the input integer,
     *         that takes up the given number of bits
     * @throws IllegalArgumentException
     ******************************************************************************/
    public String intToHex(String d, int bitLength) throws IllegalArgumentException{
        int theInt;

        //checks that the inputs are valid
        try {
            theInt = Integer.valueOf(d);
        } catch(Exception e) {
            throw new IllegalArgumentException("String Input Invalid");
        } finally {
            if (bitLength > 32 || bitLength < 0) {
                throw new IllegalArgumentException("BitLength Input Invalid");
            }
        }

        //Checks to make sure the given number can be represented
        //in the given number of bits
        if (theInt > 0) {
            if(Math.pow(2, (bitLength - 1)) - 1 < theInt) {
                throw new IllegalArgumentException("BitLength not long enough");
            }
        } else {
            if (Math.pow(2, bitLength - 1) < Math.abs(theInt)) {
                throw new IllegalArgumentException("BitLength not long enough");
            }
        }

        //returns the hexadecimal equivalent of the integer
        //If the integer is positive, it is converted using Integer.toHexString
        //If the integer is negative, its two's complement is calculated as a positive number,
        //then it is converted using Integer.toHexString
        if (theInt >= 0) {
            return Integer.toHexString(theInt);
        } else {
            return ("-" + Integer.toHexString((int)((Math.pow(2, (bitLength)) - Math.abs(theInt)))));
        }
    }


     /*******************************************************************************
     * A version of the above function without any form of error checking
     * @param d A string representing the integer to be converted to hexadecimal.
     * @param bitLength An Integer representing the desired bitLength of the output.
     *                  Expects a value from 0 to 32.
     * @return A string representing the hexadecimal equivalent of the input integer,
     *         that takes up the given number of bits
     ****** ************************************************************************/
     public String intToHexSimple(String d, int bitLength) {
         //Convert the String representing an integer to an int
         int theInt = Integer.valueOf(d);
         // returns the hexadecimal equivalent of the integer
         // If the integer is positive, it is converted using Integer.toHexString
         // If the integer is negative, its two's complement is calculated as a positive number,
         // then it is converted using Integer.toHexString
         if (theInt >= 0) {
             return Integer.toHexString(theInt);
         } else {
             return ("-" + Integer.toHexString((int)((Math.pow(2, (bitLength)) - Math.abs(theInt)))));
         }
     }
}
