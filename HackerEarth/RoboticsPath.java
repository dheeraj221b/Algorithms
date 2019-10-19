import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * RoboticsPath
 */
public class RoboticsPath {

    public static String minS = "Impossible";
    public static int minLen = Integer.MAX_VALUE;
    public static char maze[][];
    public static int row, col;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        row = s.nextInt();
        col = s.nextInt();

        maze = new char[row][col];

        for (int i = 0; i < row; i++) {
            maze[i] = s.next().toCharArray();
        }

        int q = s.nextInt();

        for (int i = 0; i < q; i++) {
            int sx = s.nextInt() - 1;
            int sy = s.nextInt() - 1;

            int fx = s.nextInt() - 1;
            int fy = s.nextInt() - 1;

            findShortestPath(sx, sy, fx, fy);
        }
    }

    public static void findShortestPath(int sx, int sy, int fx, int fy) {
        int visit[][] = new int[row][col];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy));
        visit[sx][sy] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            int i = node.i;
            int j = node.j;

            if (check(i + 1, j, visit)) {
                queue.add(new Node(i + 1, j));
                visit[i + 1][j] = 1 + visit[i][j];
            }

            if (check(i, j - 1, visit)) {
                queue.add(new Node(i, j - 1));
                visit[i][j - 1] = 1 + visit[i][j];
            }

            if (check(i, j + 1, visit)) {
                queue.add(new Node(i, j + 1));
                visit[i][j + 1] = 1 + visit[i][j];
            }

            if (check(i - 1, j, visit)) {
                queue.add(new Node(i - 1, j));
                visit[i - 1][j] = 1 + visit[i][j];
            }
        }
        for (int i = 0; i < visit.length; i++) {
            // System.out.println(Arrays.toString(visit[i]));
        }
        if (visit[fx][fy] == 0) {
            System.out.println("Impossible");
        } else {
            findLexicographicalyShortPath(visit, sx, sy, fx, fy);
        }
    }

    public static void findLexicographicalyShortPath(int visit[][], int sx, int sy, int fx, int fy) {
        String answer = "";

        while (sx != fx || sy != fy) {
            if ((fx + 1) < row && visit[fx + 1][fy] == (visit[fx][fy]) - 1) {
                answer = "U" + answer;
                fx = fx + 1;
            } else if ((fy + 1) < col && visit[fx][fy + 1] == (visit[fx][fy] - 1)) {
                answer = "L" + answer;
                fy = fy + 1;
            } else if ((fy - 1) >= 0 && visit[fx][fy - 1] == (visit[fx][fy] - 1)) {
                answer = "R" + answer;
                fy = fy - 1;
            } else if ((fx - 1) >= 0 && visit[fx - 1][fy] == (visit[fx][fy] - 1)) {
                answer = "D" + answer;
                fx = fx - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean check(int i, int j, int visit[][]) {
        if (i < row && j < col && i >= 0 && j >= 0 && visit[i][j] == 0 && maze[i][j] != '#') {
            return true;
        }
        return false;
    }

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }
}
