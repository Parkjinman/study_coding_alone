package level2.me;

public class LargestSquare {
    static int solution(int[][] board) {
        int answer = 0;

        for(int i=1; i<board.length; i++) {
            for(int j=1; j<board[0].length; j++) {
                if(board[i][j] == 0) continue;
                if(Math.min(board[i][j-1], Math.min(board[i-1][j], board[i-1][j-1])) != 0)
                board[i][j] = Math.min(board[i][j-1], Math.min(board[i-1][j], board[i-1][j-1])) + 1;

                answer = Math.max(answer, board[i][j]);
            }
        }

        if(answer == 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1) return 1;
                }
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {
//        int[][] board = {{0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {0,0,1,0}};
//        int[][] board = {{0,0,1,1},{1,1,1,1}};
        int[][] board = {{1,0,0,0},{0,0,0,0}};

//        solution(board);
        System.out.println(solution(board));
    }
}
