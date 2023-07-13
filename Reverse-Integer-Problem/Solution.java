class Solution {
    public int reverse(int x) {
         // Convert the number to a string
        String str = String.valueOf(x);

        // Check if the number is negative
        boolean isNegative = false;
        if (str.charAt(0) == '-') {
            isNegative = true;
            str = str.substring(1); // Remove the negative sign from the string
        }

        // Reverse the string
        StringBuilder reversedStr = new StringBuilder(str).reverse();

        // Convert the reversed string back to an integer
        int result;
        try {
            result = Integer.parseInt(reversedStr.toString());
        } catch (NumberFormatException e) {
            // In case of overflow, return 0
            return 0;
        }

        // Apply the sign to the result if the original number was negative
        if (isNegative) {
            result *= -1;
        }

        return result;
        
    }
}