package textProgram.entity.impl;

import textProgram.entity.Component;
import textProgram.entity.ComponentType;

public class Letter implements Component {
    private ComponentType componentType;
    private String letter;

    public Letter(String letter, ComponentType type){
        this.componentType = type;
        this.letter = letter;
    }

    public String getLetter(){
        return letter;
    }

    public ComponentType getComponentType(){
        return componentType;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public int getComponentsSize() {
        throw new UnsupportedOperationException("Method is not supported");

    }

    @Override
    public Component getComponent(int index) {
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public void setType(ComponentType type) {
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter1 = (Letter) o;

        return componentType == letter1.componentType && this.letter.equals(letter1.letter);

    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += 31 * hashCode + componentType.hashCode();
        hashCode += 31 * hashCode + letter.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return letter;
    }
}
