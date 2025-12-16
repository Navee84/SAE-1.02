public class execTime {
    private static long startTime;
    public static long lastExecTime = -1;

    public static void startProfiling() {
        startTime = System.nanoTime();
    }
    public static long stopProfiling() {
        lastExecTime = System.nanoTime() - startTime;
        return lastExecTime;
    }
}
