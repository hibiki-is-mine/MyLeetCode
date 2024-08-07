package simple;

import org.junit.Test;

public class q125 {
    @Test
    public void test(){
        String s ="a man,  plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }
    public boolean isPalindrome(String s){
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String s1 = new StringBuilder(s).reverse().toString();
        int leftIndex = 0;
        int rightIndex = s.length()-1;
        if (s.equals(s1)){
            return true;
        }else {
            return false;
        }
        /*while (leftIndex <= rightIndex){
            if (s.charAt(leftIndex) != s1.charAt(leftIndex) || s.charAt(rightIndex) !=s1.charAt(rightIndex) ){
                return false;
            }
            leftIndex++;
            rightIndex--;
        }*/
    }
}
