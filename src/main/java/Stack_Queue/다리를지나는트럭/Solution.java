package Stack_Queue.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int full = 0;int j=0;
        Queue<Integer> que = new LinkedList<>();
        System.out.println(j+"      que: "+que);
        for (int i : truck_weights) {
            while (true) {
                if (que.isEmpty()) {
                    answer++;
                    que.add(i);
                    full += i;
                    System.out.println("1: "+i+"j: "+j+"que: "+que);
                    break;
                } else if (que.size() < bridge_length) {
                    if (full + i <= weight) {
                        answer++;
                        que.add(i);
                        full += i;
                        System.out.println("2: "+i+"j: "+j+"que: "+que);
                        break;
                    } else {
                        answer++;
                        que.add(0);//이걸추가하지 않으면 트럭은 전진을 안함...이걸 빼먹어서 틀림
                        System.out.println("3: "+i+"j: "+j+"que: "+que);
                    }
                } else if (que.size() == bridge_length) {
                    full -=que.poll();
//                    System.out.println("4: "+i+"j: "+j+"que: "+que);
                } else {
                    answer++;
                    System.out.println("5: "+i+"j: "+j+"que: "+que);
                    break;
                }
            }
        }System.out.println("5: "+"j: "+j+"que: "+que);
        return answer + bridge_length;
    }

    public static void main(String[] args) {
//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10};
//
//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_weights = {7, 4, 5, 6};

//        int bridge_length =  100;
//        int weight = 100;
//        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};


        int bridge_length = 5;
        int weight = 5;
        int[] truck_weights = {2,2,2,2,1,1,1,1,1}; //19
        Solution sol = new Solution();
        System.out.println(sol.solution(bridge_length, weight, truck_weights));

    }
}