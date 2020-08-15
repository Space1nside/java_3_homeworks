import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Iterator;

public class HomeworkChecker {
    public static void main(String[] args) {
        File homeworkFile = new File("C:/Java");
        HomeworkChecker teacher = new HomeworkChecker();
        try {
            teacher.checkHomework(homeworkFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkHomework(File homeworkFile) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String[] listOfFiles = homeworkFile.list();
        ArrayList<String> nameOfFiles = new ArrayList<>();

        for (String o : listOfFiles) {
            String[] classFile = o.split("\\.");
            if (classFile[1].equalsIgnoreCase("class")) {
                nameOfFiles.add(classFile[0]);
                break;
            }
        }

        Iterator<String> classHomework = nameOfFiles.iterator();
        while (classHomework.hasNext()) {
            String fileName = String.valueOf(classHomework.next());
            Class loadHomework = URLClassLoader.newInstance(new URL[]{new File("C:/Java").toURL()}).loadClass(fileName);
            Constructor constructor = loadHomework.getConstructor();
            Object newMethod = constructor.newInstance();

            Method firstMethod = loadHomework.getDeclaredMethod("valueOfNum", int.class,int.class,int.class,int.class);
            int result1 = (Integer) firstMethod.invoke(newMethod, 2, 2, 2, 2);
            System.out.println(result1);

            Method secondMethod = loadHomework.getDeclaredMethod("rangeSum", int.class,int.class);
            int result2 = (Integer) secondMethod.invoke(newMethod, 6, 2);
            System.out.println(result2);

            Method thirdMethod = loadHomework.getDeclaredMethod("positiveNegative", int.class);
            int result3 = (Integer) thirdMethod.invoke(newMethod, -6);
            System.out.println(result3);

            Method fourthMethod = loadHomework.getDeclaredMethod("negativeNum", int.class);
            int result4 = (Integer) fourthMethod.invoke(newMethod, 3);
            System.out.println(result4);

            Method fifthMethod = loadHomework.getDeclaredMethod("greeting", String.class);
            int result5 = (Integer) fifthMethod.invoke(newMethod, "Jason");
            System.out.println(result5);

            Method sixthMethod = loadHomework.getDeclaredMethod("leapYear", int.class);
            int result6 = (Integer) sixthMethod.invoke(newMethod, 1987);
            System.out.println(result6);
        }
    }
}
