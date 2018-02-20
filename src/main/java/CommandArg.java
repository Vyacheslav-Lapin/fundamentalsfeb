import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandArg {
    private static final Logger log = LogManager.getLogger(CommandArg.class);

    public static void main(String... args) {
        for (int i = 0; i < args.length; i++) {
            log.info("Аргумент №{} = {}", i, args[i]);
        }
    }
}
