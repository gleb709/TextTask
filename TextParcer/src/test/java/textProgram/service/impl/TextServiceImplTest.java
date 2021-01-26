package textProgram.service.impl;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import textProgram.entity.Component;
import textProgram.exception.TaskException;
import textProgram.parser.Parser;
import textProgram.parser.impl.TextParser;
import textProgram.reader.TextReader;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class TextServiceImplTest {
    private String textToParse;
    private Parser parser;
    private TextReader fileReader;
    private Component textComposite;
    private TextServiceImpl service;

    @BeforeMethod
    public void setTestInfo() throws TaskException, IOException {
        service = new TextServiceImpl();
        fileReader = new TextReader();
        textToParse = fileReader.readText("data/text.txt");
        parser = TextParser.getINSTANCE();
        textComposite = parser.parse(textToParse);
    }

    @Test
    public void testSortParagraphByWords() {
        String actualLargestParagraph = "";
        String expectedLargestParagraph = " It has survived - not only (five) centuries, but also the" +
                " leap into 16 electronic typesetting, remaining 8 essentially -3 unchanged  It was popularised " +
                "in the 125 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop" +
                " publishing software like Aldus PageMaker including versions of Lorem Ipsum \n";
        textComposite = service.sortParagraphByWords(textComposite);
        actualLargestParagraph = textComposite.getComponent(1).toString();
        assertEquals(actualLargestParagraph, expectedLargestParagraph);
    }

    @Test
    public void testFindSentenceWithLargestWord() {
        String expectedSentence = " It has survived - not only (five) centuries, but also the leap into 16 electronic typesetting," +
                " remaining 8 essentially -3 unchanged";
        String actualSentence = "";
        actualSentence = service.findSentenceWithLargestWord(textComposite);
        assertEquals(actualSentence, expectedSentence);
    }

    @Test
    public void testDeleteSentences() throws TaskException {
        int actualParagraphCount = 0;
        int expectedParagraphCount = 3;  // т.к. последний абзац состоит из одного предложения
                                        // то вместе с предложением удалится и сам абзац
        service.deleteSentences(textComposite, 5);
        actualParagraphCount = textComposite.getComponentsSize();
        assertEquals(actualParagraphCount, expectedParagraphCount);
    }

    @Test
    public void testFindRepeatWord() {
        int expectedCount = 6;
        int actualCount = service.findRepeatWord(textComposite).get("it");
        assertEquals(actualCount, expectedCount);
    }

    @Test
    public void testConsonantsCount() {
        int actualCount = service.consonantsCount(textComposite);
        int expectedCount = 235;
        assertEquals(actualCount, expectedCount);
    }

    @Test
    public void testVowelsCount() {
        int actualCount = service.vowelsCount(textComposite);
        int expectedCount = 343;
        assertEquals(actualCount, expectedCount);
    }

    @AfterMethod
    public void deleteInfo(){
        service = null;
        fileReader = null;
        textToParse = null;
        parser = null;
        textComposite = null;
    }
}