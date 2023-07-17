import java.util.*;
public class ZigZagConversion {
    public static String convertSingleRowToZigzagString(String str, int numRows) {
        if (str == null || str.isEmpty() || numRows <= 0) {
            return "";
        }
        if (numRows == 1) {
            return str;
        }
        StringBuilder result = new StringBuilder();
        // Step size
        int step = 2 * numRows - 2;
        
        // iterate row by row
        for (int row = 0; row < numRows; row++) {
            // iterate each character in the row
            for (int j = row; j < str.length(); j += step) {
                result.append(str.charAt(j));
                if (row != 0 && row != numRows -1) {
                    int intermediateIndex = (j + step - 2 * row);
                    if (intermediateIndex < str.length()) {
                        result.append(str.charAt(intermediateIndex));
                    }
                }
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args)
    {
        
        String inputArr[] = new String[]{ null, "", "abc","PAYPALISHIRING", "PAYPALISHIRING", };
        int numRowsArr[] = new int[]{0, 0, 0, 3, 4};
        for (int i = 0; i < inputArr.length; i++) {
            String input = inputArr[i];
            int numRows = numRowsArr[i];
            System.out.println("Zigzag:(" + input + "," + numRows + ")" + " =" + convertSingleRowToZigzagString(input, numRows));
        }
    }
}

/*
String with indices
[00]P                               [06]I                               [12]N
[01]A                   [05]L       [07]s                   [11]I       [13]G
[02]Y       [04]A                   [08]H       [10]R
[03]P                               [09]I
(difference between each character in the first and last row is 2 * numRows - 2 (step))
For first row (0=> 6 => 12)
For Last row  (3=> 9)

For middle rows, run another loop which starts from the current row and jumps step size after each iteration.
For row = 0 => j = 0, 6, 12
For row = 1 => j = 1, 7, 13
For row = 2 => j = 2, 8
For row = 3 => j = 3, 9
(j + step - 2 * row)

Time Complexity: O(N)
Space Complexity: O(1)
*/
