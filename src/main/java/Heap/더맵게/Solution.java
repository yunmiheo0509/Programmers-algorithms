package Heap.더맵게;

import java.util.PriorityQueue;
//4:36~45 우선순위 큐 사용하면 쉽게 품. 자바에서는 힙이 우선순위큐임.
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i:scoville){
            minHeap.add(i);
        }
        while (minHeap.peek()<K) {
            if (minHeap.size()<2){
                return -1;
            }
            answer++;
            minHeap.add(minHeap.poll()+minHeap.poll()*2);
        }

        return answer;
    }
}