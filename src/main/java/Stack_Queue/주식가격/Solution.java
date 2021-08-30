package Stack_Queue.주식가격;


//4:00~4:21
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
//처음에 일단 +1은 기본적으로 해야한다. 가격이 낮아지면 더이상 검사할 필요가 없어서 break로 탈출 아니면 효율성 통과못함.
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }
}