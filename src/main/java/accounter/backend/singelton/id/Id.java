package accounter.backend.singelton.id;

public class Id {

    private static long counter;
    private static boolean permit;

    private Id() {
    }

    public static void init(long counter) {
        Id.counter = counter;
        permit = true;
    }

    public static void setPermit(boolean p) {
        permit = p;
    }

    public static long getNewId() {
        if (permit) {
            permit = false;
            return ++counter;
        }
        return counter;
    }
}
