import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TestPerformer {
    public static void main(String[] args) {
        Class firstTest = TestOne.class;
        TestOne testOne = new TestOne();
        try {
            start(firstTest, testOne);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static <T> void start(Class test, T testPlay) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = test.getDeclaredMethods();
        ArrayList<Method> priorities = new ArrayList<Method>();
        for (Method o : methods) {
            if (o.isAnnotationPresent(Test.class)) {
                priorities.add(o);
            }
        }
        priorities.sort(new Comparator<Method>() {
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });
        int beforeSuiteNum = 0;
        for (Method o: methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteNum++;
                if (beforeSuiteNum > 1) {
                    throw new RuntimeException("Used more BeforeSuite annotations than allowed");
                } else {
                    priorities.add(0, o);
                }
            }
        }

        int afterSuiteNum = 0;
        for (Method o: methods) {
            if (o.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteNum++;
                if (afterSuiteNum > 1) {
                    throw new RuntimeException("Used more AfterSuite annotations than allowed");
                } else {
                    priorities.add(o);
                }
            }
        }

        for (Method o: priorities) {
            o.invoke(testPlay);
        }
    }
}
