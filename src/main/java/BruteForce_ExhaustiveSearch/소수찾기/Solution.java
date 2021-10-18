package BruteForce_ExhaustiveSearch.소수찾기;

import java.util.ArrayList;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        int[] arr = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(numbers.toCharArray()[i]));
        }

        for(int r=1;r<=numbers.length();r++) {
            System.out.println("r이 변할때 "+ r);
            Permutation perm = new Permutation(arr.length, r);
            perm.permutation(arr, 0);
            ArrayList<ArrayList<Integer>> result = perm.getResult();
            ArrayList<Integer> yesterX = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {

                int x = 0;
                double y = Math.pow(10, result.get(i).size() - 1);

                if (result.get(i).get(0) != 0) {
                    for (int j = 0; j < result.get(i).size(); j++) {
                        System.out.print(result.get(i).get(j) + " ");
                        x += result.get(i).get(j) * y;
                        y /= 10;
                    }
                    System.out.println();
                    System.out.println("x다: "+x);
                    int chk=0;
                    if (isPrime(x)) {
                        for (int s : yesterX) {
                            if (x == s) {
                                chk=1;
                                break;
                            }
                        }
                        if(chk!=1) answer++;
                    }
                    yesterX.add(x);
                } else continue;
            }
        }
        System.out.println("answer: "+answer);
        return answer;
    }

    public boolean isPrime(int n) {
        if(n==1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("011");
    }
}

class Permutation {
    private int n;
    private int r;
    private int[] now; // 현재 순열
    private ArrayList<ArrayList<Integer>> result; // 모든 순열

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Integer>>();
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permutation(int[] arr, int depth) { // 현재 순열의 길이가 r일 때 결과 저장
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(now[i]);
            }
            result.add(temp);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            now[depth] = arr[depth];
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }
    }


}
