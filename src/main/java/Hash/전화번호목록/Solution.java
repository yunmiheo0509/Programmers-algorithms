package Hash.전화번호목록;

import java.util.*;

//내 풀이는 시간초과나서 오류남 해시맵을 써야 시간초과가 안남 훨씬 빠름
class Solution {//이것도 정해
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);// 이거하면 앞에 숫자가 분명 같은 애들끼리 붙어있게된다. 그래서 가능
        for (int i = 0; i < phoneBook.length - 1; i++){
            if (phoneBook[i + 1].startsWith(phoneBook[i])){
                return false;
            }
        }
        return true;
    }
}
/*정해
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        int length = phone_book.length;

        Map<String, String> map = new HashMap<String, String>();

        for(String temp : phone_book){
            map.put(temp, temp);
        }

        for(String str : phone_book){
            for(int index = 0; index < str.length(); index++){
                String temp = str.substring(0, index);
                if( map.containsKey( temp ) ){
                    return false;
                }
            }
        }
        return true;
    }
}
 */



