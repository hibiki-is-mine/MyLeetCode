package simple;

import java.util.Stack;

public class q20 {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray){
            if ( c =='('){
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '['){
                stack.push(']');
            } else if (!stack.empty()) {
                if (c != stack.pop()){
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}
