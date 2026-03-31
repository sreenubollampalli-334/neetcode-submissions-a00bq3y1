class MinStack {

    int minvalue;
    Stack<Integer> st;

    public MinStack() {
        minvalue = Integer.MAX_VALUE;
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(val<=minvalue){
            st.push(minvalue);
            minvalue=val;
        }
        st.push(val);


        
    }
    
    public void pop() {
        
        if(st.pop()==minvalue) 
     minvalue=st.pop();
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return minvalue;
        
    }
}
