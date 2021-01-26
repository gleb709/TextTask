package textProgram.parser.impl;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import textProgram.exception.TaskException;
import textProgram.parser.Parser;
import textProgram.reader.TextReader;

import static org.testng.Assert.assertEquals;

public class LexemeParserTest {
    private final static String FILEPATH = "data/test/text.txt";
    private String textToParse;
    private Parser parser;
    private TextReader fileReader;

    @BeforeMethod
    public void setInfo() throws TaskException {
        fileReader = new TextReader();
        textToParse = fileReader.readText(FILEPATH);
        parser = SentenceParser.getINSTANCE();
        textToParse = parser.parse(textToParse).getComponent(0).toString();
        parser = LexemeParser.getINSTANCE();
    }

    @Test
    public void testParse() {
        int expectedLetters = 4;
        int actualLetters = 0;
        try {
            actualLetters = parser.parse(textToParse).getComponentsSize();
        } catch (TaskException e) {
            e.printStackTrace();
        }
        assertEquals(actualLetters, expectedLetters);
    }

    @AfterMethod
    public void deleteInfo(){
        fileReader = null;
        textToParse = null;
        parser = null;
    }
}