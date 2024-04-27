import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children=new ArrayList<>();
    private Set<Pet> pet=new HashSet<>();
    private static int countFamily;


    public Family(Human mother, Human father) {
        if (mother == null && father == null) {
            System.out.println("there is no mother and father");

        } else {
            this.mother = mother;
            this.father = father;
            this.children =new ArrayList<>();
        }

    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public  Set<Pet> getPet() {
        if (pet != null) {
            return pet;
        } else {
            System.out.println("The family currently has no pet.");
            return null;
        }
    }

    public void setPet( Set<Pet> pet) {
        this.pet = pet;
    }
    public void addPet(Pet newPet) {
        pet.add(newPet);
    }



    public void addChild(Human child) {
        if (child == null) {
            System.out.println(("Family don't have any child yet"));
        } else {
            this.children.add(child);
            child.setFamily(this);

        }

    }

    public boolean deleteChild(int index) {
        if (index < 0 || children.size() <= index) {
            System.out.println("Invalid index");
            return false;
        }

        Human removedChild = this.children.remove(index);
        removedChild.setFamily(null);
        return true;
    }

    public boolean deleteChild(Human child) {
        if (child == null) {
            return false;
        }

        if (this.children.size() == 0) {
            System.out.println("Family has no children to delete.");
            return false;
        }

        return children.remove(child);
    }

    public boolean removePet(Pet removePet) {
        if (removePet==null){
            return false;
        }
        if (this.pet.size()==0){
            System.out.println("Family has no animals");
            return false;
        }
       return pet.remove(removePet);
    }
    public int countFamily() {
        int count = 2;
        return 2 + children.size();
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", childrenCount=" + children.size() +
                ", pet=" + pet +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pet);
    }
}
