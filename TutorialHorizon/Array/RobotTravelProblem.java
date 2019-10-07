/**
 * RobotTravelProblem
 */
public class RobotTravelProblem {
    public static void main(String[] args) {
        int arr[][] = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, -1, 1, 1 }, { 1, -1, 1, 1 } };

        findNoOfPaths(arr);
    }

    public static void findNoOfPaths(int arr[][]) {
        int row = arr.length;
        int col = arr[0].length;

        int pathMatrix[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] != -1) {
                    pathMatrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (arr[i][j] != -1) {
                        pathMatrix[i][j] = pathMatrix[i - 1][j] + pathMatrix[i][j - 1];
                    }
                }
            }
        }
        System.out.println(pathMatrix[row - 1][col - 1]);
    }
}