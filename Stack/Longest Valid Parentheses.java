// ()(()()()

class Solution{
    static int maxLength(String s){
        // code here
        Stack<Integer> stack  = new Stack<>();
        stack.push(-1);
        int match = 0;
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
               stack.pop();
               if(stack.size() == 0) {
                   stack.push(i);
               }
               else {
                   match = Math.max(match,i - stack.peek());
               }
            }
        }
        return match;
    }
}
