package level2.me;

public class EatTheGround {
    static int solution(int[][] land) {
        int answer = 0;

        for(int i=1; i<land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        for(int i=0; i<4; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}}; //result : 16
//        int[][] land = {{1,2,3,0},{5,6,7,8},{4,3,2,1}}; //result : 15
//        int[][] land  = {{4, 3, 2, 1},{2, 2, 2, 1},{6, 6, 6, 4},{8, 7, 6, 5}}; //result : 20
//        int[][] land  = {{1, 2, 3, 5},{5, 6, 8, 7},{4, 3, 2, 1}}; //17
//        int[][] land  = {{6, 5, 5, 5},{3, 4, 3, 3},{3, 2, 2, 2}}; //13
//        int[][] land  = {{1, 1, 1, 2},{1, 1, 1, 3},{1, 1, 1, 2}}; //5
//        int[][] land  = {{1, 1, 1, 1},{1, 1, 1, 1},{1, 1, 1, 1}}; //3
//        int[][] land  = {{1, 1, 1, 1},{1, 1, 1, 2},{1, 1, 1, 1}}; //4
//        int[][] land  = {{1, 1, 1, 2},{1, 1, 2, 1},{1, 2, 1, 1}}; //6
//        int[][] land  = {{5, 5, 5, 5}}; //5
//        int[][] land  = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}}; //38
//        solution(land);
        System.out.println(solution(land));
    }
}
