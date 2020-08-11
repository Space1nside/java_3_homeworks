public class SpiralNumbers {
    private static int ROW = 5;
    private static int COLUMN = 7;
    public static void main(String[] args) {
        int[][] array = new int[ROW][COLUMN];
        makeItSpiralAndPrint(array, ROW, COLUMN);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 10) {
                    System.out.print(" " + array[i][j] + " ");
                } else {
                    System.out.print(array[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void makeItSpiralAndPrint(int[][] array, int endRow, int endColumn) {
        int startRow = 0;
        int startColumn = 0;
        int value = 0;

        while (startRow < endRow && startColumn < endColumn) {
            for (int i = startColumn; i < endColumn; i++) {
                array[startRow][i] = value++;
            }
            startRow++;

            for (int i = startRow; i < endRow; i++) {
                array[i][endColumn - 1] = value++;
            }
            endColumn--;

            if (startRow < endRow) {
                for (int i = endColumn - 1; i >= startColumn; i--) {
                    array[endRow - 1][i] = value++;
                }
                endRow--;
            }

            if (startColumn < endColumn) {
                for (int i = endRow - 1; i >= startRow; i--) {
                    array[i][startColumn] = value++;
                }
                startColumn++;
            }
        }
    }
}
