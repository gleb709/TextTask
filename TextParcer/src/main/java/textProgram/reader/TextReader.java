package textProgram.reader;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import textProgram.exception.TaskException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {
    private static final String FILE_PATH = "data/text.txt";
    private static final Logger logger = LogManager.getLogger();

    public String readText(String filePath) throws TaskException{
        if (filePath == null || !Files.exists(Paths.get(filePath))) {
            filePath = FILE_PATH;
        }
        String text = "";
        byte[] textByteFormat = new byte[0];
        try {
            textByteFormat = Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            logger.info("text reader fail" + e);
            throw new TaskException(e);
        }
        text = new String(textByteFormat);
        return text;
    }
}
