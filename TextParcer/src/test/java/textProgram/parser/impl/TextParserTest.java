package textProgram.parser.impl;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import textProgram.exception.TaskException;
import textProgram.parser.Parser;
import textProgram.reader.TextReader;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class TextParserTest {
    private final static String FILEPATH = "data/text.txt";
    private String textToParse;
    private Parser parser;
    private TextReader fileReader;

    @BeforeMethod
    public void setTestInfo() throws TaskException, IOException {
        fileReader = new TextReader();
        textToParse = fileReader.readText("data/text.txt");
        parser = TextParser.getINSTANCE();
    }

    @Test
    public void testParse() {
        int expectedParagraphs = 4;
        int actualParagraphs = 0;
        try {
            actualParagraphs = parser.parse(textToParse).getComponentsSize();

        } catch (TaskException e) {
            e.printStackTrace();
        }
        assertEquals(actualParagraphs, expectedParagraphs);
    }

    @AfterMethod
    public void removeInfo(){
        fileReader = null;
        textToParse = null;
        parser = null;
    }
}