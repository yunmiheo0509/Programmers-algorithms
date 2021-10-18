package Sorting.H_Index;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public int solution(int[] citation) {
        int answer = 0;
        int chk;
        Integer[] citations = new Integer[citation.length];
        for (int i = 0; i < citation.length; i++) {
            citations[i] = citation[i];
        }
        Arrays.sort(citations, Collections.reverseOrder());
        int num = citations.length;

        for (int i = 0; i < citations.length; i++) {
            System.out.print(citations[i]);
        }
//        System.out.println(num);
        if (num > citations[0]) {
            chk = citations[0];
        } else chk = num;

        for (int i = chk; i > 0; i--) {
            System.out.println();
            System.out.println("i: "+i);
            int count = 0;
            if (citations[i - 1] >= i) {
                if(i-1==num-1) return i;
                for (int k = i; k < num; k++) {
                    System.out.println("k: "+k);
                    if (i >= citations[k]) {
                        count++;
                        System.out.print("count: "+count);
                    } else {
                        count = 0;
                        System.out.print("else k: "+k+" "+citations[k]+" "+i);
                        break;
                    }
                }
                if (count == 0) continue;
                else {
                    answer = i;
                    return answer;
                }
            }

        }
            return answer;
        }
        public static void main (String[]args){
            Solution solution = new Solution();
            int[] citiation = {1, 3, 5, 7, 9, 11};
//[1, 3, 5, 7, 9, 11] = 4
            System.out.println("정답: "+solution.solution(citiation));
        }
    }
