package katas.exercises;

public class StringDigitSum {

    /**
     * Calculates the sum of all digits in the given string.
     *
     * @param input the string containing digits and other characters
     * @return the sum of all digits in the string
     */
    public static int sumOfDigits(String input) {

        if (input==null){
            throw new IllegalArgumentException("Input Can't be null!!");
        }

        input = input.replaceAll("[^0-9]", "");
        if (input.isEmpty()){
            return 0;
        }

        int i = Integer.parseInt(input);
        int sum = 0 ;
        while (i>0){
            int digit = i%10;
            sum = sum + digit;
            i = i/10;
        }

        return sum;

    }


    public static void main(String[] args) {
        String input1 = "abc123";
        String input2 = "5 cats and 2 dogs";
        String input3 = "No digits here!";

        System.out.println("Sum of digits in '" + input1 + "': " + sumOfDigits(input1));
        System.out.println("Sum of digits in '" + input2 + "': " + sumOfDigits(input2));
        System.out.println("Sum of digits in '" + input3 + "': " + sumOfDigits(input3));
    }
}
