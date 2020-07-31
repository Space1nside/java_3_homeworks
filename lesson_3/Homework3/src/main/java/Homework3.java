import java.io.*;
import java.util.*;

public class Homework3 {
    public static void main(String[] args) {
        File file = new File("C:\\Java\\Java_3\\lessons\\lesson_3\\java_3_homeworks\\lesson_3\\Homework3\\src\\Just_File");
        try {
            //task one
            FileInputStream fis = new FileInputStream(file);
            byte[] arrForFile = new byte[(int) file.length()];
            int x;
            while ((x = fis.read(arrForFile)) != -1) {
                System.out.println(Arrays.toString(arrForFile));
            }
            fis.close();
            System.out.println();

            //task two
            ArrayList<InputStream> fileArray = new ArrayList<>();
            fileArray.add(new FileInputStream("C:\\Java\\Java_3\\lessons\\lesson_3\\java_3_homeworks\\lesson_3\\Homework3\\src\\firstFile"));
            fileArray.add(new FileInputStream("C:\\Java\\Java_3\\lessons\\lesson_3\\java_3_homeworks\\lesson_3\\Homework3\\src\\secondFile"));
            fileArray.add(new FileInputStream("C:\\Java\\Java_3\\lessons\\lesson_3\\java_3_homeworks\\lesson_3\\Homework3\\src\\thirdFile"));
            fileArray.add(new FileInputStream("C:\\Java\\Java_3\\lessons\\lesson_3\\java_3_homeworks\\lesson_3\\Homework3\\src\\fouthFile"));
            fileArray.add(new FileInputStream("C:\\Java\\Java_3\\lessons\\lesson_3\\java_3_homeworks\\lesson_3\\Homework3\\src\\fifthFile"));

            SequenceInputStream connectedFiles = new SequenceInputStream(Collections.enumeration(fileArray));
            FileOutputStream outFilesIntoOne = new FileOutputStream("C:\\Java\\Java_3\\lessons\\lesson_3\\java_3_homeworks\\lesson_3\\Homework3\\src\\FiveInOneFile");
            x = 0;
            while ((x = connectedFiles.read()) != -1) {
                outFilesIntoOne.write(x);
                System.out.print((char) x);
            }
            connectedFiles.close();
            outFilesIntoOne.close();
            System.out.println("\n");

            //task three
            Scanner sc = new Scanner(System.in);
            RandomAccessFile book = new RandomAccessFile("C:\\Java\\Java_3\\lessons\\lesson_3\\java_3_homeworks\\lesson_3\\Homework3\\src\\taskThreeFile", "r");
            System.out.println("Enter the page: ");
            int p = sc.nextInt() - 1;
            byte[] arrOfChars = new byte[1800];
            book.seek(p * 1800);
            book.read(arrOfChars);
            System.out.println(new String(arrOfChars));
            book.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
