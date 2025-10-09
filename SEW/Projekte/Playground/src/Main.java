public class Main {
    public static void main(String[] args) {
        // upSideDownPyramid(3);
        // upSidePyramid(4);
        // printPattern(5);

    }

    /*
     * * * * *
     * * *
     *
     */

    public static void upSideDownPyramid(int rows) {
        for (int row = 0; row < rows; row++) {
            for (int blank = 0; blank < row; blank++) {
                System.out.print("  ");
            }
            for (int col = rows - 1; col >= row; col--) {
                System.out.print("* ");
            }
            for (int col = rows - 2; col >= row; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void upSidePyramid(int rows) {
        for (int row = 0; row < rows; row++) {
            for (int blank = rows; blank > row; blank--) {
                System.out.print("  ");
            }
            for (int col = 0; col <= row; col++) {
                System.out.print("+ ");
            }
            for (int col = 0; col < row; col++) {
                System.out.print("+ ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printPattern(int rows) {
        for (int r = rows; r > 0; r--) {
            for (int c = r; c > 0; c--) {
                System.out.print("+");
            }
            for (int c = rows; c > 0; c--) {
                System.out.print("?");
            }
            System.out.println();
        }
    }
}