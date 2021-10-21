package graph_search.dfs;

public class IslandCountryIreland_1 {

    public static void dfs(int x, int y, int[][] matrix){
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        matrix[x][y] = 0;
        for(int k = 0; k<8; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx >= 0 && nx <matrix.length && ny >= 0 && ny < matrix.length && matrix[nx][ny] == 1){
                dfs(nx, ny, matrix);
            }
        }


    }

    public static int solution(int sizeOfMatrix, int[][] matrix){
        int answer = 0;
        int n = sizeOfMatrix;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1){
                    answer ++;
                    dfs(i, j, matrix);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int[][] arr = {{1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}};

        System.out.println(solution(arr.length, arr));
    }
}
