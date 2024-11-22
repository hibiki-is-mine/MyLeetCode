package middle;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class q3175 {

    @Test
    public void test(){
        int[] skills = {16,4,7,17};
        int k = 562084119;
        System.out.println(findWinningPlayer(skills, k));
    }

    @Test
    public void test2(){
        int amount = 6000;
        double finalFee = amount*0.8*0.775 + amount*0.2 + 730;
        System.out.println(finalFee);
    }

    public int findWinningPlayer(int[] skills, int k) {


        if (k< skills.length){
            int firstPlayer = 0;
            int secondPlayer = 1;
            int maxWins = 0;
            while(maxWins < k){
                if (skills[firstPlayer] > skills[secondPlayer]){
                    secondPlayer = secondPlayer + 1;

                    maxWins++;
                } else {
                    firstPlayer = secondPlayer;
                    secondPlayer = secondPlayer + 1;
                    maxWins = 1;
                }
            }
            return firstPlayer ;
        } else {//如果玩家数量小于等于k，那么直接返回最大的技能值对应的玩家
            int maxSkillIndex = 0;
            for (int i = 1; i < skills.length; i++){
                if (skills[maxSkillIndex] < skills[i]){
                    maxSkillIndex = i;
                }
            }
            return maxSkillIndex;
        }
    }

}
