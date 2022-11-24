import java.util.ArrayList;

public class Human {
    private String name;   
    private Human father;
    private Human mother;
    private ArrayList<Human> children;
  
    public Human(String name, Human father, Human mother) {        
        this.name = name;        
        this.father = father;
        this.mother = mother;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }    
    public void setFather(Human father) {
        this.father = father;
    }
    public Human getFather() {
        return father;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getMother() {
        return mother;
    }
    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }
    public ArrayList<Human> getChildren() {
        return children;
    }
    
    public void addChildren(Human human) {        
        if(this.getChildren()==null) {
            this.setChildren(new ArrayList<Human>());
        }
        this.getChildren().add(human);
    }
    
    @Override
    public String toString() {
        return String.format("Human: [name: " + name + ", children: " + children + "]");
    }
}
