public class BugTester {
    public static void main(String[] args) {
        Bug uno = new Bug();

        for (int i = 0; i < 4; i++) {
            uno.breedBugs();
            uno.sprayBugs();
            System.out.println(uno.returnBugs());
        }
    }
}
