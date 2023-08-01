public class PowXToN {
  public double myPow(double x, int n) {
    double tmp = 0.0;
    if (n == 0) {
      return 1.0;
    }
    tmp = myPow(x, n / 2);
    if (n % 2 == 0) {
      return tmp * tmp;
    } else {
      if (n > 0) {
        return x * tmp * tmp;
      }
      return (tmp * tmp) / x;
    }
  }
}
/**
Input: 2.00000, 10 Output: 1024.00000
Input: 2.10000, 3  Output: 9.26100
Input: 2.00000, -2 Output: 0.25000
Time Complexity: O(log |n|)
Space Complexity: O(log |n|), for recursive call stack
*/
