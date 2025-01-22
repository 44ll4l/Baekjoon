/* Q. p2563 색종이 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2563_solved {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] base = new int[101][101];
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                base[i][j] = 0;
            }
        }

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            int xpos = Integer.parseInt(input[0]);
            int ypos = Integer.parseInt(input[1]);

            for(int x = xpos; x < xpos+10; x++){
                for(int y = ypos; y < ypos+10; y++){
                    base[x][y] = 1;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                result += base[i][j];
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}