package Hash.위장;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//3:35~
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int answer = 1;

        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])){
                int count = map.get(clothes[i][1]);
                map.put(clothes[i][1],count+1);
            }else{
                map.put(clothes[i][1],1);
            }
        }
        System.out.println(map);
        for(int n:map.values()){
            System.out.println(n);
            answer *= n+1;
        }
       return answer-1;
    }
}