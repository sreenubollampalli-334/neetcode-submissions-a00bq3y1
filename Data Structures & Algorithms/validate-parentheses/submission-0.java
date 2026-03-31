class Solution {
    public boolean isValid(String s) {
        char arr[]=s.toCharArray();
        Stack<Character> st=new Stack<>();
        for(char ch:arr){
            if(ch=='(') st.push(')');
            else if(ch=='{') st.push('}');
            else if(ch=='[') st.push(']');
                else{
                    if(st.isEmpty()||st.pop()!=ch) return false;
                    
                }
          

        }
         return st.isEmpty();
    }
}
