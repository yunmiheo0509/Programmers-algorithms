package Stack_Queue.프린터;

import java.util.*;

import static java.util.Arrays.sort;

//1:10
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Queue<HashMap> que2 = new LinkedList<>();
        //우선순위를 정리하는 배열 만들기
        Integer[] arr = new Integer[priorities.length];
        int f = 0;
        for (int pri : priorities) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            hash.put(f, pri);
            que2.offer(hash);
            arr[f] = pri;
            f++;

        }
        sort(arr, Collections.reverseOrder());

        System.out.println("arr: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int j = 0;
        System.out.println("que2: " + que2);
        int count = 0;
        while (que2.peek() != null) {
            System.out.println("que2:  " + que2.peek() + "arr[j]: " + arr[j]);
            for (Object s : que2.peek().keySet()) {
                if (que2.peek().get(s).equals(arr[j])) {
                    que2.poll();
                    j++;
                    System.out.println("s: "+s);
                    count++;
                    if (location==(Integer) s) {
                        return count;
                    }
                } else {
                    que2.offer(que2.poll());

                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
//        int[] priorities = {2, 1, 3, 2};
//        int location = 2;
        System.out.println(new Solution().solution(priorities, location));

    }
    /*
    좋은 풀이: 우선순위큐를 활용하여 하면 금방 할 수 있다.
    public int solution(int[] priorities, int location) {
        int answer = 1;

        PriorityQueue priority = new PriorityQueue<>(Collections.reverseOrder());//내림차순 큐

        for(int task : priorities){
            priority.add(task);
            System.out.println(priority);
        }
        //{2,5,4,1,3};

        System.out.println(priority);
        while(!priority.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)priority.peek()) {
                    if(i == location){
                        return answer;
                    }
                    priority.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
     */
}
