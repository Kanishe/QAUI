import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
    private static final Logger logger = LogManager.getLogger(Test.class);
    public static void main(String[] args) {
        System.out.println("d");
        logger.info("i");
        logger.error("e");
        logger.warn("w");
        logger.debug("d");
    }
}
