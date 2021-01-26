package textProgram.interpreter;

import textProgram.exception.TaskException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ArithmeticInterpreter {
    private final static String NAME = "JavaScript";

    public static String interpretExpression(String text) throws TaskException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName(NAME);
        try {
            return engine.eval(text).toString();
        } catch (ScriptException e) {
            throw new TaskException(e);
        }
    }
}
