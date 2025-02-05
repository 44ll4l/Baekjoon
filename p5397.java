/* Q. 키로거
    창영이는 강산이의 비밀번호를 훔치기 위해서 강산이가 사용하는 컴퓨터에 키로거를 설치했다.
    며칠을 기다린 끝에 창영이는 강산이가 비밀번호 창에 입력하는 글자를 얻어냈다.
    키로거는 사용자가 키보드를 누른 명령을 모두 기록한다.
    따라서, 강산이가 비밀번호를 입력할 때, 화살표나 백스페이스를 입력해도 정확한 비밀번호를 알아낼 수 있다.
    강산이가 비밀번호 창에서 입력한 키가 주어졌을 때, 강산이의 비밀번호를 알아내는 프로그램을 작성하시오.
    강산이는 키보드로 입력한 키는 알파벳 대문자, 소문자, 숫자, 백스페이스, 화살표이다.*/

/* check. 문자열의 크기가 1,000,000 이므로 배열로 해결하기가 어렵다.
*         스택을 활용하여 선형시간 문제를 해결할 수 있는 알고리즘을 설계하자
*         스택 두 개를 만들고, 스택 두 개의 중간 지점을 커너로 간주한다.
*         문자 입력: 왼쪽 스택에 원소를 삽인한다.
*         백스페이스 입력: 왼쪽 스택에서 문자를 삭제한다.
*         <- 입력: 왼쪽 스택에서 오른쪽 스택으로 원고를 이동한다.
*         -> 입력: 오른쪽 스택에서 왼쪽 스택으로 원소를 이동한다.
*         stack 이나 연결리스트로 풀이가 가능하다.
          문자열을 입력받아서 '<' 가 들어오면 임시스택에 문자열을 넣어두고
          '>'가 들어오면 임시스택에 있는 문자열을 기본스택으로 가져온다.
          '<'가 들어가면 되돌아가야 하기 때문에 기존 스택에서 임시스택으로 문자열을 옮긴다.
          '-'가 들어오면 기존스택에서 pop으로 마지막 문자열을 뺀다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class p5397 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String[] input;
        // Test케이스의 갯수를 입력받는 코드
        // String 배열의 input 생성

        for (int i = 0; i < T; i++) {
            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();
            input = br.readLine().split("");

            for (String str : input) {
                switch (str) {
                    case "<":
                        if (!left.isEmpty()) {
                            right.push(left.pop());
                        }
                        break;


                    case ">":
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                        break;

                    case "-":
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;

                    default:
                        left.push(str);
                }
            }


            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}

/* desc. java Stack
          스택은 쌓다라는 의미로 선출후입(LIFO)의 특징을 가지고 있으며 프로그래밍 언어에서 메소드 콜을 할 때 사용한다.
          Stack<데이터타입> stack = new Stack<>(); 와 같은 형태로 생성한다.
          스택은 배열이나 열결리스트를 이용하여 구현될 수 있다.
          */
/* desc. java 스택 api를 사용하는 방법
*       push(), pop(), peek(), empty(), search() 기능을 지원한다.
*       stack.pop()으로 제일 최근에 들어간 값을 제거한다.
*       stack.peek()으로 가장 최근에 들어간 값을 출력한다.
*       stack.search(3)은 3의 인덱스를 출력해준다.
*       stack.empty()는 현재 스택이 비었으면 True, 값이 들어가 있으면 False를 출력해준다.
* */
/* desc. 배열 스택
         구현이 빠르고 데이터의 접근속도가 빨라 조회가 빠르다.
         but, 배열의 크기가 정해져있어야만 사용할 수 있다. */
/* desc. LinkedListStack
*        스택에 들어가는 데이터의 양이 한정되어있지 않고 삽입 삭제가 용이하다.
*        but, 구현이 어렵고 배열과 달리 조회가 힘들다.*/

/* desc. 결국 Stack 클래스는 LinkedList로 이루어 졌다는 것을 의미한다. */