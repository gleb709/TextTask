package textProgram.reader;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import textProgram.exception.TaskException;
import textProgram.reader.TextReader;

import static org.testng.Assert.assertEquals;

public class TextReaderTest {
    private String expectedText = "";
    private final static String FILE_PATH = "data/test/text.txt";

    @BeforeClass
    public void setTestInfo(){
        expectedText = "Text reader\ncheck";
    }
    @Test
    public void testReadText() throws TaskException{
        String actualText = "";
        TextReader textReader = new TextReader();
        try {
            actualText = textReader.readText(FILE_PATH);
        } catch (TaskException e) {
            e.printStackTrace();
        }
        assertEquals(actualText, expectedText);
    }

    @AfterClass
    public void removeInfo(){
        expectedText = null;
    }
}