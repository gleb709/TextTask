package textProgram.parser.impl;

import textProgram.entity.Component;
import textProgram.entity.ComponentType;
import textProgram.entity.impl.Composite;
import textProgram.exception.TaskException;
import textProgram.parser.Parser;

public class TextParser extends Parser {
    private static TextParser INSTANCE = new TextParser();
    private String TABULATION = "\t";
    private String REGEX = "\\n\\s";


    private TextParser(){}

    public static TextParser getINSTANCE(){
        return INSTANCE;
    }

    @Override
    public Component parse(String text) throws TaskException {
        setNext(ParagraphParser.getINSTANCE());
        Component paragraphComposite;
        Component textComposite = new Composite();
        textComposite.setType(ComponentType.TEXT);

        String[] paragraphs = text.split(REGEX);

        for (String paragraph : paragraphs) {
            paragraph = paragraph.replace("    ", "");
            paragraph = paragraph.replace(TABULATION, "");
            paragraphComposite = parseNext(paragraph);
            textComposite.add(paragraphComposite);
        }
        return textComposite;
    }
}
