package textProgram.parser.impl;

import textProgram.entity.Component;
import textProgram.entity.ComponentType;
import textProgram.entity.impl.Composite;
import textProgram.entity.impl.Letter;
import textProgram.parser.Parser;

public class LexemeParser extends Parser {
    private static LexemeParser INSTANCE = new LexemeParser();
    private static final String REGEX = "";
    private static final String PUNCTUATION = "[.]{3}|[.!,?]";

    private LexemeParser(){}

    public static LexemeParser getINSTANCE(){
        return INSTANCE;
    }

    @Override
    public Component parse(String text) {
        Component lexemeComposite = new Composite();
        lexemeComposite.setType(ComponentType.LEXEME);
        Letter symbol;

        String[] symbols = text.split(REGEX);
        for (String element : symbols) {
            if (element.matches(PUNCTUATION)) {
                symbol = new Letter(element, ComponentType.PUNCTUATION);
            } else {
                symbol = new Letter(element, ComponentType.LETTER);
            }
            lexemeComposite.add(symbol);
        }

        return lexemeComposite;
    }
}
