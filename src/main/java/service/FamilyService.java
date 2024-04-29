package service;

import dao.entity.Family;
import dao.FamilyDao;
import dao.entity.Human;
import dao.entity.Pet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyService {

    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public Family getFamilyByIndex(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public boolean deleteFamily(int index) {
        return familyDao.deleteFamily(index);
    }

    public boolean deleteFamily(Family family) {
        return familyDao.deleteFamily(family);
    }

    public boolean saveFamily(Family family) {
        return familyDao.saveFamily(family);
    }

    public void displayAllFamilies() {
        getAllFamilies().forEach(family -> System.out.println(family.toString()));
    }

    public void getFamiliesBiggerThan(int minPerson) {
        List<Family> families = getAllFamilies();
        if (families.isEmpty()) {
            System.out.println("There are no families in the list.");
        }
        List<Family> newFamilies = new ArrayList<>();
        for (Family family : families) {
            if (newFamilies.size() > minPerson) {
                newFamilies.add(family);
            }
        }

        if (newFamilies.isEmpty()) {
            System.out.println("There are no families with more than " + minPerson + " people.");
        } else {
            System.out.println("Families with more than " + minPerson + " people:");
            displayAllFamilies();
        }
    }

    public void getFamiliesLessThan(int maxPerson) {
        List<Family> families = getAllFamilies();
        if (families.isEmpty()) {
            System.out.println("There are no families in the list.");
        }
        List<Family> newFamilies = new ArrayList<>();
        for (Family family : families) {
            if (newFamilies.size() < maxPerson) {
                newFamilies.add(family);
            }
        }

        if (newFamilies.isEmpty()) {
            System.out.println("There are no families with more than " + maxPerson + " people.");
        } else {
            System.out.println("Families with less than " + maxPerson + " people:");
            displayAllFamilies();
        }
    }

    public int countFamiliesWithMemberNumber(int targetMemberNumber) {
        int familyCount = 0;
        for (Family family : familyDao.getAllFamilies()) {
            if (family.countFamily() == targetMemberNumber) {
                familyCount++;
            }
        }
        return familyCount;
    }

    public Family createNewFamily(Human mother, Human father) {
        Family newFamily = new Family(mother, father);
        if (familyDao.saveFamily(newFamily)) {
            return newFamily;
        } else {
            System.out.println("Error creating new family.");
            return null;
        }
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String masculineName, String feminineName) {
        if (family == null) {
            System.out.println("dao.entity.Family not found.");
            return null;
        }

        String childName;
        if (Math.random() < 0.5) {
            childName = masculineName + " (Son)";
        } else {
            childName = feminineName + " (Daughter)";
        }

        Human child = new Human(childName,family.getFather().getSurname(),family.getFather().getBirthDateMillis());

        family.addChild(child);

        if (familyDao.saveFamily(family)) {
            return family;
        } else {
            System.out.println("Error updating family information.");
            return null;
        }
    }
public Family adoptChild(Family family, Human child) {
  if (family==null){
      System.out.println("dao.entity.Family is null");
  }
  family.addChild(child);
    if (familyDao.saveFamily(family)) {
        return family;
    } else {
        System.out.println("Error updating family information.");
        return null;
    }

}


    public void deleteAllChildrenOlderThan(int age) {
        List<Family> families = familyDao.getAllFamilies();
        for (Family family : families) {
            List<Human> children = family.getChildren();
            List<Human> childrenToRemove = new ArrayList<>();
            for (Human child : children) {

                int childAge = child.calculateAge();
                if (childAge > age) {
                    childrenToRemove.add(child);
                }
            }
            children.removeAll(childrenToRemove);
        }
    }
    public int count() {
        List<Family> families = familyDao.getAllFamilies();
        return families.size();
    }

    public List<Pet> getPet(int index) {
        List<Family> families = familyDao.getAllFamilies();
        if (index>=0 && index<families.size()){
            return new ArrayList<>(families.get(index).getPet());
        }
        else {
            return null;
        }
    }


    public boolean addPet(int index, Pet pet) {
        List<Family> families = familyDao.getAllFamilies();
        if (index >= 0 && index < families.size()) { // Geçerli bir index mi kontrol et
            Family targetFamily = families.get(index);
            if (targetFamily != null) { // Hedef aile var mı kontrol et
                targetFamily.addPet(pet);
                return true;
            } else {
                System.out.println("Error: Family not found at index " + index);
            }
        } else {
            System.out.println("Error: Invalid index " + index);
        }
        return false;
    }



    public Family getFamilyById(int id) {
        List<Family> families = familyDao.getAllFamilies();
        for (Family family : families) {
            if (family.getId() == id) {
                return family;
            }
        }
        return null;
    }
}