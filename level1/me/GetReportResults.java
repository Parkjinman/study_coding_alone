package level1.me;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetReportResults {
    static String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    static String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    static int k = 2;
//    static String[] id_list = {"con", "ryan"};
//    static String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//    static int k = 3;

    // 신고 결과 받기
    public static int[] solution(String[] id_list, String[] report, int k) {
        int idListLen = id_list.length;
        int[] answer = new int[idListLen];
        HashMap<String, ArrayList<String>> reportChk = new HashMap<>();

        for(String str : report) {
            ArrayList<String> list = new ArrayList<>();
            String[] strArr = str.split(" ");

            if(reportChk.get(strArr[0]) != null) {
                for(int i=0; i<list.size(); i++) {
                    list.add(reportChk.get(strArr[0]).get(i));
                }
                list.add(strArr[1]);
            } else {
                list.add(strArr[1]);
            }

            reportChk.put(strArr[0], list);
        }

        System.out.println(reportChk);

        // 신고당하면 카운트 +1
        // 같은 사람한테 신고를 당한 기록이 있으면 카운트 -1

        // k번 신고를 당하면 정지

        // 처리결과 메일을 받은 횟수 저장

        return answer;
    }

    public static void main(String[] args) {
        solution(id_list, report, k);
//        ArrayList<String> list = new ArrayList<>();
//        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
//
//        list.add("frodo");
//        list.add("neo");
//
//        hashMap.put("muzi",list);
//
//        System.out.println(list);
//        System.out.println(hashMap.get("muzi").get(0));
    }
}
