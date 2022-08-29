package studyExem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<String> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] arr = str.split("");
        for(int i=0; i<arr.length; i++) {
            list.add(arr[i]);
        }

        int N = Integer.parseInt(br.readLine());
        String temp1, temp2 = null;
        while(N-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            temp1 = st.nextToken();
            if(temp1.equals("P")) temp2 = st.nextToken();
            else temp2 = "";

            System.out.println(temp1);
            System.out.println(temp2);

            switch(temp1) {
                case "P" :
                    list.add(temp2);
                    break;
                case "L" : //

                    break;
                case "D" :

                    break;
                default :
                    break;
            }
        }
    }
}