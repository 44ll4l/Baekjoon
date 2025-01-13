import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p1919 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.next();
        String word2 = scanner.next();

        //word(string) -> list로 받고
        char[] word1List = word1.toCharArray();
        char[] word2List = word2.toCharArray();

        //두 배열의 중복값 체크
        Set<String> sameList = new HashSet<>();
        for (char w1 : word1List) {
            for (char w2 : word2List) {
                if (w1 == w2) {
                    sameList.add(String.valueOf(w1));
                }
            }
        }

        //빼고 더하면 result
        int counter1 = 0, counter2 = 0;
        for(char w1: word1List){
            for(String s1: sameList){
                if(String.valueOf(w1).equals(s1)){
                    counter1 += 1;
                }
            }
        }

        for(char w2: word2List){
            for(String s1: sameList){
                if(String.valueOf(w2).equals(s1)){
                    counter2 += 1;
                }
            }
        }

        int result = 0, min;
        if(counter1 > counter2) min = counter2;
        else min = counter1;

        result += word1List.length - min;
        result += word2List.length - min;

        System.out.print(result);
    }
}
// toCharArray() String 클래스의 메소드로서 문자를 한 개씩 뽑아서 문자형 배열로 저장해준다.


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p31419 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        int cnt =0;
        int[] countstr1 = new int[26];
        int[] countstr2 = new int[26];

        for(int i=0; i <str1.length(); i++) {
            countstr2[str2.charAt(i)-'a']++;
        }

        for(int i=0; i<26; i++) {
            int compare = countstr1[i] - countstr2[i];
            if (compare != 0) cnt += Math.abs(compare);
        }

        System.out.println(cnt);
    }
}
// 입력받은 str1, str2의 각 구성 문자는 'a'~'z'이내임
// str1, str2의 각 a~z의 갯수를 담는 int형 배열 countstr1, countstr2 선언
// 삭제해야 할 문자의 갯수를 담는 int형 cnt 선언
// str1, str2의 길이만큼 for문을 각각 돌며 a~z의 갯수를 countstr1, countstr2에 대응되는 인덱스에 담기

// ex. countstr1[0], countstr[0]에는 각 문자열 중에서 a의 갯수를 담음
// -> countstr[str1.charAt(i)-'a']

//countstr의 길이만큼(26만큼) for문을 돌며 countstr1[i]-countstr2[i]를 비교,
//-> countstr1[i]-countstr2[i]==0 이라면 str1,str2 내에 해당 문자의 값은 상쇄되므로 skip
//-> countstr1[i]-countstr2[i]!=0이라면 countstr1[i]-countstr2[i]의 절댓값 만큼 상쇄되지 않아 삭제해야 하므로
//Math.abs()의 값을 cnt에 더한다.
//for문을 다 돈 후, cnt 반환
