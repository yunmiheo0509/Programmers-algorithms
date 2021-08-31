package Heap.이중우선순위큐;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

//5:55~ 24
class Solution {
    public int[] solution(String[] operations) {

        String s;
        int intStr;
        PriorityQueue<Integer> prq = new PriorityQueue<>();//최소
        PriorityQueue<Integer> prq2 = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            s = operations[i];
//            intStr = Integer.parseInt(s.replaceAll("[^0-9,^-]", ""));
            intStr = Integer.parseInt(s.substring(2));
            if (s.contains("I")) {//삽입
                prq.add(intStr);
                prq2.add(intStr);
            } else if (s.contains("-")) {//최솟값 삭제
                prq2.remove(prq.poll());
            } else {//최댓값 삭제
                prq.remove(prq2.poll());
            }
        }

        int[] answer = {0,0};
        if(!prq.isEmpty()){
            answer[0]=prq2.peek();
            answer[1]=prq.peek();
        }
        return answer;

    }
}