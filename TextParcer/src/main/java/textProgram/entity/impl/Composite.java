package textProgram.entity.impl;

import textProgram.entity.Component;
import textProgram.entity.ComponentType;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private ComponentType componentType;
    private List<Component> components = new ArrayList<>();
    private final String TABULATION = "\t";
    private final String SPACE = " ";
    private final String NEW_LINE = "\n";

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public int getComponentsSize() {
        return components.size();
    }

    @Override
    public Component getComponent(int index) {
        return components.get(index);
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public void setType(ComponentType type) {
        componentType = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        if(!this.getType().equals(composite.getType())){
            return false;
        }
        return composite.getComponentsSize() != 0? this.components.equals(composite.components) : false;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += 31 * hashCode + (componentType == null ? 0 : componentType.hashCode());
        hashCode += 31 * hashCode + components.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Component component: components) {
            if(component.getType().equals(ComponentType.TEXT)){
                builder.append(TABULATION);
            }else if(componentType.equals(ComponentType.PARAGRAPH)){
                builder.append(NEW_LINE);
                builder.append(TABULATION);
            }else if (ComponentType.SENTENCE.equals(component.getType())) {
                builder.append(SPACE);
            } else if (ComponentType.LEXEME.equals(component.getType())) {
                builder.append(SPACE);
            }
            builder.append(component.toString());
        }
        return builder.toString();
    }
}
