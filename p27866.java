import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p27866 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] StrArray = br.readLine().split("");
        int i = Integer.parseInt(br.readLine());
        //int i는 int라서 string형인 br을 int로 형변환을 해주어야 한다.

        bw.write(StrArray[i-1]);

        bw.flush();
        bw.close();
    }
}
