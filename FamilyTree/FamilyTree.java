import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    static List<Human> familyTree = new ArrayList<Human>();
    
    public void createHuman(String name) {
        Human p = new Human(name, null, null);        
        familyTree.add(p);        
    }
    
    public void child(Human father, Human mother, String name) {
        Human p = new Human(name, father, mother);        
        father.addChildren(p);
        mother.addChildren(p);
        familyTree.add(p);       
    }

    public Human getPerson(String name) {
        ArrayList<Human> findList = new ArrayList<>();
        for (int i = 0; i < familyTree.size(); i++) {
            if (name == familyTree.get(i).getName()) {
                return familyTree.get(i);
            }
        }
        return findList.get(0); 
            
    }
}


