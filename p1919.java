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
