package samples;

interface PrivateInterface {

    private static String staticPrivate() {
        return "static private";
    }

    private String instancePrivate() {
        return "instance private";
    }

    default void check() {
        String result = staticPrivate();
        if (!result.equals("static private"))
            throw new AssertionError("Incorrect result for static private interface method");
        PrivateInterface pvt = new PrivateInterface() {
        };
        result = pvt.instancePrivate();
        if (!result.equals("instance private"))
            throw new AssertionError("Incorrect result for instance private interface method");
    }
}

public class InterfaceEnhacements {

    public static void main(String[] args) {
        PrivateInterface piClass = new PrivateInterface() {
        };
        piClass.check();
    }

}