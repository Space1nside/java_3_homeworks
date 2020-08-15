public class TestOne {
    @BeforeSuite
    public void beforeTest() {
        System.out.println("BeforeSuite method from TestOne.class");
    }

    @Test(priority = 6)
    public void test1() {
        System.out.println("Test #1 with priority = 6 from TestOne.class");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test #2 with priority = 2 from TestOne.class");
    }

    @Test(priority = 10)
    public void test3() {
        System.out.println("Test #3 with priority = 10 from TestOne.class");
    }

    @AfterSuite
    public void afterTest() {
        System.out.println("AfterSuite method from TestOne.class");
    }
}
