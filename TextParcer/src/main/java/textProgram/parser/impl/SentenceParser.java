package textProgram.parser.impl;

import textProgram.entity.Component;
import textProgram.entity.ComponentType;
import textProgram.entity.impl.Composite;
import textProgram.exception.TaskException;
import textProgram.interpreter.ArithmeticInterpreter;
import textProgram.parser.Parser;

import java.util.regex.Pattern;

public class SentenceParser extends Parser {
    private static SentenceParser INSTANCE = new SentenceParser();
    private static final String REGEX = " ";
    private final String REGEX_EXPRESSION = "\\p{N}+";

    private SentenceParser(){}

    public static SentenceParser getINSTANCE(){
        return INSTANCE;
    }

    @Override
    public Component parse(String text) throws TaskException {
        setNext(LexemeParser.getINSTANCE());

        Component sentenceComposite = new Composite();
        sentenceComposite.setType(ComponentType.SENTENCE);
        Component lexemeComposite;
        String[] lexemes = text.split(REGEX);
        Pattern pattern = Pattern.compile(REGEX_EXPRESSION);
        for (String lexeme : lexemes) {
            if (pattern.matcher(lexeme).find()) {
                lexeme = ArithmeticInterpreter.interpretExpression(lexeme);
            }
            lexemeComposite = parseNext(lexeme);
            sentenceComposite.add(lexemeComposite);
        }
        return sentenceComposite;
    }
}
