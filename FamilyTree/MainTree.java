
public class MainTree {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        tree.createHuman("Elena");
        tree.createHuman("Dmitry");
        tree.child(tree.getPerson("Dmitry"), tree.getPerson("Elena"), "Olga");       
        tree.createHuman("Sergey");        
        tree.child(tree.getPerson("Sergey"), tree.getPerson("Olga"), "Oleg");
        
        for (int i = 0; i < FamilyTree.familyTree.size(); i++) {
            System.out.println(FamilyTree.familyTree.get(i));
        }        
    }
}
