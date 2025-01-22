/* Q. 고양이를 출력한다. */


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/* desc. 자바에서는 몇몇 문자는 단독으로 써서 출력할 수 없다. (대표적으로 백슬래시와 큰 따옴표가 있다. */
/* desc. 그래서 문자를 출력하기 위해 조합을 만들어서 출력할 수 있도록 하는데 이를 Escape Sequance 라고 한다. */
/* desc. 이스케이프 시퀀스는 백슬래시(\) + 문자의 조합으로 쓰인다. */
public class p10171 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        bw.write("\\    /\\");
        bw.newLine();       /* desc. 줄 구분자 */

        bw.write(" )  ( ')");
        bw.newLine();

        bw.write("(  /  )");
        bw.newLine();

        bw.write(" \\(__)|");
        bw.newLine();

        bw.flush();
        bw.close();

    }
}