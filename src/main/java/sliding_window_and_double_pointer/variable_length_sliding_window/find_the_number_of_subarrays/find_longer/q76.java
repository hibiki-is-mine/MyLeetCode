package sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.find_longer;

public class q76 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()){
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int left = 0;
        int right = 0;
        int resultLeftIndex = 0;
        int resultRightIndex = Integer.MAX_VALUE;

        int targetNum = 0;
        int currentNum = 0;
        int[] countS = new int['z' +1];
        int[] countT = new int['z' +1];

        for (char c : charArrayT){
            if (countT[c - 'A'] == 0){
                targetNum++;
            }
            countT[c - 'A']++;
        }

        while (right < charArrayS.length){
            countS[charArrayS[right] -'A']++;
            if (countT[charArrayS[right] -'A'] == countS[charArrayS[right] -'A'] ){
                currentNum++;
            }
            while (currentNum == targetNum){
                if (right - left < resultRightIndex - resultLeftIndex){
                    resultRightIndex = right;
                    resultLeftIndex = left;
                }
                countS[charArrayS[left] -'A']--;
                if (countS[charArrayS[left] -'A'] < countT[charArrayS[left] -'A']) {
                    currentNum--;
                }
                left++;
            }
            right++;
        }
        return resultRightIndex == Integer.MAX_VALUE ? "" : s.substring(resultLeftIndex, resultRightIndex + 1);
    }
}
