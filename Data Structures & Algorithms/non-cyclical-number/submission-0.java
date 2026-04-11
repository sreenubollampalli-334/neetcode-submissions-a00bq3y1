class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = number(slow);
            fast = number(number(fast));
        } while (slow != fast);

        return slow == 1;
    }

    static int number(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;   // square
            n = n / 10;
        }
        return sum;
    }
}