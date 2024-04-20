import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        String quack = "quack";

        ArrayList<Character> list = new ArrayList<>();

        loop1:
        for (int i = 0; i < input.length; i++) {
            int index = quack.indexOf(input[i]);

            index = index == 0 ? 5 : index;
            
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == quack.charAt(index-1)) {
                    index = index == 5 ? 0 : index;

                    list.set(j, quack.charAt(index));

                    continue loop1;
                } 
            }

            if (input[i] == 'q') {
                list.add(input[i]);
            } else {
                System.out.println(-1);
                return;
            }
        }
        
        int answer = list.size();
        
        for (char ch : list) {
            if (ch != 'k') {
                answer = -1;
                break;
            }
        }
        
        System.out.println(answer);
    }   
}