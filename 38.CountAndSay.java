public class CountAndSay {
  public String countAndSay(int n) {
    List < String > dp = new ArrayList < >(n);
    dp.add("1");
    for (int i = 1; i < n; i++) {
      String prev = dp.get(i - 1);
      StringBuilder curr = new StringBuilder("");
      for (int j = 0; j < prev.length(); j++) {
        int count = 1;
        while (j + 1 < prev.length() && prev.charAt(j) == prev.charAt(j + 1)) {
          count++;
          j++;
        }
        curr.append(count).append(prev.charAt(j));
      }
      dp.add(curr.toString());
    }
    return dp.get(n - 1);
  }
}
/*
n=1     1
n=2     11
n=3     21
n=4     1211
n=5     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211

Solution: generate each row of the count-and-say pattern based on the previous row, and store all the intermediate results in a list of strings
Time Complexity :O(n*m) where n is the number of rows to generate, and m is the maximum length of a row in the pattern. 
Space complexity : O(n * m), where n is the number of rows to generate and m is the maximum length of a row in the pattern. 
*/
