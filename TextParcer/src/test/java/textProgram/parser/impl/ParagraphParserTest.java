package textProgram.parser.impl;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import textProgram.exception.TaskException;
import textProgram.parser.Parser;
import textProgram.reader.TextReader;

import static org.testng.Assert.assertEquals;

public class ParagraphParserTest {
    private final static String FILEPATH = "data/text.txt";
    private String textToParse;
    private Parser parser;
    private TextReader fileReader;

    @BeforeMethod
    public void setInfo() throws TaskException {
        fileReader = new TextReader();
        textToParse = fileReader.readText(FILEPATH);
        parser = TextParser.getINSTANCE();
        textToParse = parser.parse(textToParse).getComponent(3).toString();
        parser = ParagraphParser.getINSTANCE();
    }

    @Test
    public void testParse() {
        int expectedSentences = 1;
        int actualSentences = 0;
        try {
            actualSentences = parser.parse(textToParse).getComponentsSize();
        } catch (TaskException e) {
            e.printStackTrace();
        }
        assertEquals(actualSentences, expectedSentences);
    }

    @AfterMethod
    public void removeInfo(){
        fileReader = null;
        textToParse = null;
        parser = null;
    }
}