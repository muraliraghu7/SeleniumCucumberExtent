import org.apache.log4j.Logger;

public class Log {


    static final Logger logger = Logger.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName){
        Log.info("====================================="+sTestCaseName+" TEST START=========================================");
    }
    public static void endTestCase(){
        Log.info("===================================== TEST ENDS =========================================");
    }

    public static void info(String message) {
        logger.info(message);
    }
}


