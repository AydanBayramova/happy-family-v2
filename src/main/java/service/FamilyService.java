package service;

import controller.FamilyOverflowException;
import dao.entity.Family;
import dao.FamilyDao;
import dao.entity.Human;
import dao.entity.Pet;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
            return;
        }

        long count = families.stream()
                .filter(family -> family.countFamily() > minPerson)
                .count();

        if (count == 0) {
            System.out.println("There are no families with more than " + minPerson + " people.");
        } else {
            System.out.println("Families with more than " + minPerson + " people:");
            displayAllFamilies();
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
        String childGender;
        if (Math.random() < 0.5) {
            childName = masculineName;
            childGender = "Son";
        } else {
            childName = feminineName;
            childGender = "Daughter";
        }
        Human father = family.getFather();
        Human mother = family.getMother();

        String childSurname = (Math.random() < 0.5) ? father.getSurname() : mother.getSurname();
        long childBirthDateMillis = System.currentTimeMillis();
        Human child = new Human(childName + " (" + childGender + ")", childSurname, childBirthDateMillis);

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

    families.forEach(family -> family.getChildren().stream()
            .filter(child -> child.calculateAge() > age)
            .forEach(child -> family.deleteChild(child)));
}

    public int count() {
        return (int) familyDao.getAllFamilies().stream().count();
    }

    public List<Pet> getPet(int index) {
        return familyDao.getAllFamilies()
                .stream() // Create a Stream from the families list
                .filter(family -> index >= 0 && index < family.getPet().size()) // Filter for valid index
                .findFirst() // Get the first matching family (or empty if none)
                .map(family -> new ArrayList<>(family.getPet())) // Map to a new List of pets
                .orElse(null);
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
    public String getFormatFamilies(Family family) {
        if (family == null) {
            System.out.println("there is no ant family");
        }
        return family.prettyFormat();

    }
    public String getFormatFamilies(List<Family> families){
        if (families==null){
            System.out.println("there are not any family");
        }
        StringBuilder  stringBuilder=new StringBuilder();
        for (Family family:families) {
            stringBuilder.append(family.prettyFormat()).append("\n\n");
        }
        return families.toString().trim();
    }
    public void getFamiliesLessThan(int maxPerson) {
        List<Family> families = getAllFamilies();

        List<Family> newFamilies = families.stream()
                .filter(family -> family.countFamily() < maxPerson)
                .collect(Collectors.toList());

        if (newFamilies.isEmpty()) {
            System.out.println("There are no families with less than " + maxPerson + " people.");
        } else {
            System.out.println("Families with less than " + maxPerson + " people:");
            for (Family family : newFamilies) {
                System.out.println(family.prettyFormat());
            }
        }
    }

    public int countFamiliesWithMemberNumber(int targetMemberNumber) {
        try {
            return (int) familyDao.getAllFamilies()
                    .stream()
                    .filter(family -> family.countFamily() == targetMemberNumber)
                    .count();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return -1; // Return a negative value to indicate error
        }
    }

    public Optional<Family> createNewFamily(Human mother, Human father) {
        try {
            return Optional.ofNullable(Optional.of(new Family(mother, father))
                    .filter(family -> familyDao.saveFamily(family))
                    .orElse(null));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return Optional.empty();
        }
    }
}