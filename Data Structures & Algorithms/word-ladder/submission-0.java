class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair>queue=new LinkedList<>();
        queue.add(new pair(beginWord,1));
        HashSet<String>st=new HashSet<>();
      //  st.remove(beginWord);
        int len=wordList.size();
        for(int i=0;i<len;i++){
            st.add(wordList.get(i));
        }
        while(!queue.isEmpty()){
            String word=queue.peek().first;
            int steps=queue.peek().second;
            queue.poll();
            if(word.equals(endWord)) return steps;
            for(int i=0;i<word.length();i++){
              //  char replacedArray[]=word.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    char replacedcharArray[]=word.toCharArray();
                 replacedcharArray[i]=ch;
                 String replacedword=new String(replacedcharArray);
                 if(st.contains(replacedword)){
                    st.remove(replacedword);
                    queue.add(new pair(replacedword,steps+1));
                 }

                }
            }
        }
       return 0; 
    }
}
class pair{
String first;
    int second;
    pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}