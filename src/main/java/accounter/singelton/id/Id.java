package accounter.singelton.id;

public class Id {

    private static long counter;

    private Id() {
    }

    public static void setCounter(long counter) {
        Id.counter = counter;
    }

    public static long getNewId() {
        return ++counter;
    }
}
