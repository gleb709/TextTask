package textProgram.comparator;

import textProgram.entity.Component;
import textProgram.exception.TaskException;
import textProgram.parser.Parser;
import textProgram.parser.impl.ParagraphParser;

import java.util.Comparator;

public class SortParagraphsByWords implements Comparator<Component> {
    @Override
    public int compare(Component first, Component second) {
        Parser parser = ParagraphParser.getINSTANCE();
        int firstCount = 0;
        int secondCount = 0;
        try {
        for(int i = 0; i < first.getComponentsSize(); i++){
                firstCount += parser.parse(first.getComponent(i).toString()).getComponentsSize();
        }
        for(int i = 0; i < second.getComponentsSize(); i++){
            secondCount += parser.parse(second.getComponent(i).toString()).getComponentsSize();
        }
        } catch (TaskException e) {
            e.printStackTrace();
        }
        return secondCount-firstCount;
    }
}
