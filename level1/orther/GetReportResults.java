package level1.orther;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class GetReportResults {
    static String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    static String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    static int k = 2;
//    static String[] id_list = {"con", "ryan"};
//    static String[] report = {"ryan con3", "ryan con2", "ryan con3", "ryan con2"};
//    static int k = 3;

    // 신고 결과 받기
    public static int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }

    public static void main(String[] args) {
//        solution(id_list, report, k);

        new Thread(() -> {
            System.out.println("Welcome Heejin blog");
        }).start();

        IntFunction intSum = (x) -> x+1;
        System.out.println(intSum.apply(1));
    }
}
