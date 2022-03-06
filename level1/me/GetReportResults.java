package level1.me;

import java.util.HashMap;

public class GetReportResults {
    static String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    static String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    static int k = 2;
//    String[] id_list = {"con", "ryan"};
//    String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//    int k = 3;

    // 신고 결과 받기
    public static int[] solution(String[] id_list, String[] report, int k) {
        int idListLen = id_list.length;
        int[] answer = new int[idListLen];
        HashMap<String, String> reportChkCnt = new HashMap();
        HashMap<String, HashMap<String, String>> hashMap = new HashMap<>();

        for(String str : report) {
            String[] strArr = str.split(" ");

            // 신고당하면 카운트 +1
            reportChkCnt.put(strArr[0], strArr[1]);

            // 같은 사람한테 신고를 당한 기록이 있으면 카운트 -1
        }


        // k번 신고를 당하면 정지

        // 처리결과 메일을 받은 횟수 저장

        return answer;
    }

    public static void main(String[] args) {
        solution(id_list, report, k);
    }
}
