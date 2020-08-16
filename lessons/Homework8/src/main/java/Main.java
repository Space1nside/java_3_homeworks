import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {5, 1, 5, 2, 2, 4, 1, 4, 5, 1, 5, 3, 2, 4, 4, 4, 5, 1, 3, 4, 2, 2, 1, 2, 4, 4, 4, 5, 4,
                3, 5, 4, 4, 5, 5, 1, 4, 1, 5, 3, 1, 4, 5, 3, 3, 4, 2, 2, 4, 4, 5, 5, 1, 1, 1, 4, 5, 5};

        int[] array2 = {4, 4, 2, 4, 3, 1, 3, 3, 1, 1, 3, 1, 3, 4, 4, 3, 2, 2, 1, 3, 4, 4, 2, 3, 4, 2, 4, 4, 1,
                4, 4, 4, 2, 1, 2, 4, 1, 5, 2, 2, 5, 4, 2, 2, 3, 1, 5, 5, 3, 5, 3, 1, 4, 5, 4, 2, 1, 3};

        int[] array3 = {1, 2, 1, 4, 1, 3, 4, 2, 2, 5, 2, 3, 1, 1, 2, 3, 3, 4, 4, 2, 4, 1, 2, 2, 2, 5, 1, 5, 1,
                2, 2, 1, 3, 3, 4, 3, 5, 3, 5, 1, 2, 1, 3, 3, 2, 4, 1, 4, 3, 5, 1, 2, 1, 2, 3, 2, 1, 3};

        int[] array4 = {2, 2, 4, 3, 2, 1, 5, 1, 4, 5, 4, 4, 5, 5, 4, 2, 3, 5, 1, 3, 4, 3, 2, 4, 5, 2, 5, 2, 4,
                1, 4, 5, 2, 3, 3, 4, 4, 3, 5, 2, 2, 3, 5, 1, 2, 4, 3, 4, 4, 3, 2, 2, 1, 4, 5, 5, 1, 5};

        int[] array5 = {2, 4, 5, 5, 4, 2, 2, 1, 5, 1, 3, 4, 2, 4, 2, 2, 4, 3, 5, 2, 2, 4, 4, 4, 5, 5, 2, 5, 5,
                2, 5, 1, 1, 5, 5, 4, 1, 2, 4, 1, 2, 2, 5, 4, 5, 1, 5, 4, 4, 5, 5, 5, 3, 3, 4, 3, 3, 5};

        int[] array6 = {3, 2, 2, 2, 2, 2, 1, 2, 5, 2, 3, 4, 3, 5, 5, 2, 4, 5, 3, 4, 3, 1, 3, 2, 1, 1, 5, 4, 4,
                2, 3, 1, 3, 4, 2, 4, 1, 3, 5, 1, 5, 3, 5, 2, 3, 4, 4, 1, 3, 1, 5, 5, 1, 2, 2, 1, 3, 1};

        int[] array7 = {5, 1, 2, 2, 1, 5, 1, 3, 3, 2, 1, 3, 2, 5, 1, 1, 2, 3, 5, 5, 4, 3, 1, 3, 3, 1, 5, 4, 2, 3, 4};

        findNumOfDifElements(array1);
        findNumOfDifElements(array2);
        findNumOfDifElements(array3);
        findNumOfDifElements(array4);
        findNumOfDifElements(array5);
        findNumOfDifElements(array6);
        findNumOfDifElements(array7);
    }

    public static void findNumOfDifElements(int[] array) {
        int[] amount = new int[5];
        for (int o : array) {
            if (o >= 1) {
                switch (o) {
                    case 1:
                        amount[0]++;
                        break;
                    case 2:
                        amount[1]++;
                        break;
                    case 3:
                        amount[2]++;
                        break;
                    case 4:
                        amount[3]++;
                        break;
                    case 5:
                        amount[4]++;
                        break;
                }
            }

        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(amount));
        System.out.println("Pines = " + amount[0] + ", Birches = " + amount[1] + ", Spruces = " + amount[2] + ", Oaks = " + amount[3] + ", Aspens = " + amount[4]);
        System.out.println();
    }
}
