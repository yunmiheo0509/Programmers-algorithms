package Sorting.가장큰수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//4:40  comparator를 새롭게 정의 해야하는 것은 알았는데 문자열을 더해서 비교하면 쉽다는걸 몰랐다
/*풀이
1. 숫자 → 문자열

String.valueOf(숫자) 를 사용하여 String 타입으로 변환할 수 있다.



2. 내림차순 정렬

람다식, compareTo 사용

Collections.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));



A.compareTo(B)

A와 B가 같으면 0 리턴

A가 B보다 크면 양수 리턴

A가 B보다 작으면 음수 리턴

맨 첫자리부터 차례대로 비교



3. numbers가 0으로만 주어지는 경우 예외 처리

4. 정렬된 문자열을 answer에 담아 리턴

 */
class Solution {
    public String solution(int[] numbers) {
        String answer ="" ;
        String[] num = new String[numbers.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(num, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        if(num[0].equals("0")){
            answer +="0";
        }else{
            for (int i = 0; i < num.length; i++) {
                answer +=num[i];
            }
        }
        return answer;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num ={3, 30, 34, 5, 9};
        System.out.println("정답: "+solution.solution(num));
        ;
    }
}