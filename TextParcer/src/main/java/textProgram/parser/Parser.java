package textProgram.parser;

import textProgram.entity.Component;
import textProgram.exception.TaskException;

public abstract class Parser {
    private Parser next;

    public abstract Component parse(String text) throws TaskException;

    protected Component parseNext(String text) throws TaskException {
        return next.parse(text);
    }

    public Parser setNext(Parser next) throws TaskException{
        this.next = next;
        return next;
    }
}
