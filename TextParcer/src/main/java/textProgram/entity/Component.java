package textProgram.entity;

import java.util.List;

public interface Component {
    void add(Component component);
    void remove(Component component);
    int getComponentsSize();
    Component getComponent(int index);
    ComponentType getType();
    void setType(ComponentType type);
}
