package algorithm;

public class TestDemo {
    public static void main(String[] args) {
        boolean[][] isRead = new boolean[10][10];
        for (int i = 0; i < isRead.length; i++) {
            for (int j = 0; j < isRead[0].length; j++) {
                System.out.print(isRead[i][j]);
            }
            System.out.println();
        }
    }
}
