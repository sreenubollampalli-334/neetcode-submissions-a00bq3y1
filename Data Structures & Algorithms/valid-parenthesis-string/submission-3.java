class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                min++;
                max++;
            } 
            else if (ch == ')') {
                min--;
                max--;
            } 
            else { // '*'
                min--;   // treat as ')'
                max++;   // treat as '('
            }

            // fix min
            if (min < 0) min = 0;

            // if max becomes negative → invalid
            if (max < 0) return false;
        }

        return min == 0;
    }
}