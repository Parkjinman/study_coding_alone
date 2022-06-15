package programers.level1.me;

import java.util.*;

public class GetReportResults {
    static String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    static String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    static int k = 2;
//    static String[] id_list = {"con", "ryan"};
//    static String[] report = {"ryan con3", "ryan con2", "ryan con3", "ryan con2"};
//    static int k = 3;

    // 신고 결과 받기
    public static int[] solution(String[] id_list, String[] report, int k) {
        int idListLen = id_list.length;
        int[] answer = new int[idListLen];
        int[] reportCntArr = new int[idListLen];
        HashMap<String, ArrayList<String>> reportChk = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();

        /** index 설정 */
        for(int i=0; i<idListLen; i++) {
            indexMap.put(id_list[i], i);
        }

        /** 각 계정별 신고한 회원 수 */
        for(String str : report) {
            ArrayList<String> list = new ArrayList<>();
            String[] strArr = str.split(" ");

            if(reportChk.get(strArr[0]) != null) {
                for (int i = 0; i < reportChk.get(strArr[0]).size(); i++) {
                    // 한 유저가 똑같은 유저를 신고한 경우
                    if(!reportChk.get(strArr[0]).get(i).equals(strArr[1])) {
                        list.add(reportChk.get(strArr[0]).get(i));
                    }
                }
                list.add(strArr[1]);
            } else {
                list.add(strArr[1]);
            }

            reportChk.put(strArr[0], list);
        }

        /** 각 계정당 신고당한 횟수 */
        for(int i=0; i<idListLen; i++) {
            if(reportChk.get(id_list[i]) != null) {
                for (int j = 0; j < reportChk.get(id_list[i]).size(); j++) {
                    reportCntArr[indexMap.get(reportChk.get(id_list[i]).get(j))]++;
                }
            }
        }

        Queue<String> queue = new LinkedList<>();

        for(int i=0; i<reportCntArr.length; i++) {
            /** k번 신고를 당하면 정지 */
            if(reportCntArr[i] >= k) queue.add(id_list[i]);
        }

        while(!queue.isEmpty()) {
            String str = queue.poll();
            for(int i=0; i<idListLen; i++) {
                if(reportChk.get(id_list[i]) != null) {
                    /** 처리결과 메일을 받은 횟수 저장 */
                    if (reportChk.get(id_list[i]).contains(str)) answer[indexMap.get(id_list[i])]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(id_list, report, k);
    }
}
