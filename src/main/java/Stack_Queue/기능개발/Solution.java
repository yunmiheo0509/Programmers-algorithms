package Stack_Queue.기능개발;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int count=0;
        int sum=0;
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int b;

        for (int i = 0; i < speeds.length; i++) {
            if((100 - progresses[i])%(double)speeds[i]>0){
                b =((100 - progresses[i])/ speeds[i])+1;
            }else b = (100 - progresses[i])/ speeds[i];
            arr.add(b);
        }

        sum = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if(sum>=arr.get(i)){
                count+=1;
            }else {
                sum = arr.get(i);
                arr2.add(count);
                count=1;
            }if (i+1==arr.size()){
                arr2.add(count);
            }
        }
        answer = new int[arr2.size()];
        for (int i = 0; i < arr2.size(); i++) {
            answer[i] = arr2.get(i);
        };
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
       sol.solution(progresses,speeds);

    }
}