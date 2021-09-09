package Hash.베스트앨범;

import java.security.spec.ECField;
import java.sql.Array;
import java.util.*;

//4:25~5:25
public class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> large = new HashMap<>();
        HashMap<String, Integer> sum = new HashMap<>();
        HashMap<Integer, Integer> num1 = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            num1.put(i, plays[i]);
        }
        List<Map.Entry<Integer, Integer>> list_entries = new ArrayList<Map.Entry<Integer, Integer>>(num1.entrySet());
        // compare로 값을 비교
        Collections.sort(list_entries, (obj2, obj1) -> {
            // 오름 차순 정렬
            return obj1.getValue().compareTo(obj2.getValue());
        });
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list_entries) {
            int aa = entry.getKey();
            if (large.containsKey(genres[aa])) {
                ArrayList<Integer> arr = large.get(genres[aa]);
                arr.add(aa);
                large.put(genres[aa], arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(aa);
                large.put(genres[aa], arr);
            }
            if (sum.get(genres[i]) != null) {
                int sum2 = sum.get(genres[i]);
                sum.put(genres[i], sum2 + plays[i]);
            } else sum.put(genres[i], plays[i]);
            i++;
        }
        List<Map.Entry<String, Integer>> list_entries2 = new ArrayList<Map.Entry<String, Integer>>(sum.entrySet());
        // compare로 값을 비교
        Collections.sort(list_entries2, (obj2, obj1) -> {
            // 오름 차순 정렬
            return obj1.getValue().compareTo(obj2.getValue());
        });
        for (Map.Entry<String, Integer> entry : list_entries2) {
            answer.add(large.get(entry.getKey()).get(0));
            try {
                answer.add(large.get(entry.getKey()).get(1));
            }catch(Exception e){
                continue;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        String[] genres = {"A", "A","B","A","B","B"};
        String[] genres = {"A", "A","B"};
//        int[] plays = {500, 600, 150, 800, 2500};
//        int[] plays = {5, 5, 6, 5, 7, 7};
        int[] plays = {600, 500, 300};

        Solution sol = new Solution();
        System.out.println(sol.solution(genres, plays));
        //[4, 5, 0, 1])

    }
}
