package textProgram.parser.impl;

import textProgram.entity.Component;
import textProgram.entity.ComponentType;
import textProgram.entity.impl.Composite;
import textProgram.exception.TaskException;
import textProgram.parser.Parser;

public class ParagraphParser extends Parser {
    private static ParagraphParser INSTANCE = new ParagraphParser();
    private final String REGEX = "[.]{3}|[.!?]";

    private ParagraphParser(){}

    public static ParagraphParser getINSTANCE(){
        return INSTANCE;
    }

    @Override
    public Component parse(String text) throws TaskException {
        setNext(SentenceParser.getINSTANCE());

        Component paragraphComposite = new Composite();
        paragraphComposite.setType(ComponentType.PARAGRAPH);
        Component sentenceComposite;

        String[] sentences = text.split(REGEX);
        for (String sentence : sentences) {
            sentenceComposite = parseNext(sentence);
            paragraphComposite.add(sentenceComposite);
        }
        return paragraphComposite;

    }
}
