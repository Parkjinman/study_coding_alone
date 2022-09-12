package studyExem;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Pattern;

public class Main {
    static Stack<String> stack = new Stack<>();
    static Queue<String> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String[] arr = str.split("");


        boolean execSe = false;
        // A+B*C-D/E
        for(int i=0; i<arr.length; i++) {
            if(Pattern.matches("^[a-zA-Z]*$", arr[i])) {
                queue.offer(arr[i]);
                if(execSe) {
                    while (!queue.isEmpty()) {
                        bw.write(queue.poll());
                    }
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    execSe = false;
                }
            } else {
                if(!arr[i].equals("(") && !arr[i].equals(")")) stack.push(arr[i]);
                if(stack.size() > 1) execSe = true;
            }
        }

        while (!queue.isEmpty()) {
            bw.write(queue.poll());
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }


        bw.flush();
        bw.close();
    }
}