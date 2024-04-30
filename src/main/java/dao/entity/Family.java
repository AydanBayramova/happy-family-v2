package dao.entity;


import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children=new ArrayList<>();
    private Set<Pet> pet=new HashSet<>();
    private static int countFamily;
    private static int nextId = 1;
    private int id;

    public Family(Human mother, Human father) {
        if (mother == null && father == null) {
            System.out.println("there is no mother and father");

        } else {
            this.id = nextId++;
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

    public int getId() {
        return id;
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
            System.out.println(("dao.entity.Family don't have any child yet"));
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
            System.out.println("dao.entity.Family has no children to delete.");
            return false;
        }

        return children.remove(child);
    }

    public boolean removePet(Pet removePet) {
        if (removePet==null){
            return false;
        }
        if (this.pet.size()==0){
            System.out.println("dao.entity.Family has no animals");
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
                ", children=" + children +
                ", pet=" + pet +
                ", id=" + id +
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

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder("family:\n");
        if (mother != null) {
            sb.append("  mother: ").append(mother).append("\n");
        }
        if (father != null) {
            sb.append("  father: ").append(father).append("\n");
        }
        if (!children.isEmpty()) {
            sb.append("  children:\n");
            for (Human child : children) {
                sb.append("    ").append(child).append("\n");
            }
        }
        if (!pet.isEmpty()) {
            sb.append("  pets:\n");
            for (Pet pet : pet) {
                sb.append("    ").append(pet).append("\n");
            }
        }
        return sb.toString();
    }
}
