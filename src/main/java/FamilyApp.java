import controller.FamilyController;
import dao.CollectionFamilyDao;
import model.enums.DaysOfWeek;
import service.FamilyService;
import dao.entity.*;
import dao.FamilyDao;

import java.time.LocalDate;
import java.util.*;

public class FamilyApp {
    public static void main(String[] args) {
//        Human mother = new Human("Jane", "watson", LocalDate.of(1980, 9, 7));
//        Human father = new Human("John", "Watson", LocalDate.of(1890, 9, 5));
//        Family family = new Family(mother, father);
//        Map<DaysOfWeek, List<String>> schedule = new HashMap<>();
//        schedule.put(DaysOfWeek.MONDAY, Arrays.asList("Programming", "Gym"));
//        schedule.put(DaysOfWeek.TUESDAY, Arrays.asList("Math", "English"));
//        schedule.put(DaysOfWeek.WEDNESDAY, Arrays.asList("Art", "Music"));
//        schedule.put(DaysOfWeek.THURSDAY, Arrays.asList("Science", "History"));
//        schedule.put(DaysOfWeek.FRIDAY, Arrays.asList("Free time", "Friends"));
//        schedule.put(DaysOfWeek.SATURDAY, Arrays.asList("Sports", "Movies"));
//        schedule.put(DaysOfWeek.SUNDAY, Arrays.asList("Relax", "dao.entity.Family"));
//        System.out.println("=========================");
//        System.out.println(mother.toString());
//        Human ch = new Human("Alex", "Bob", LocalDate.of(1999, 2, 3), 79, schedule, family);
//        System.out.println(ch);
//        ch.setSchedule(schedule);
//        family.addChild(ch);
//        System.out.println(family.countFamily());
//        System.out.println("====");
//        System.out.println(family.countFamily());
//        Human ch1 = new Human("Alex", "Bob", LocalDate.of(1999, 2, 3), 79, schedule, family);
//        System.out.println(ch1);
//        family.addChild(ch1);
//        System.out.println(family.countFamily());
//        family.getPet();
//        Pet cat = new DomesticCat("Cat", "lazyCat", 2, 66, new HashSet<>());
//       Pet dog = new Dog("dog", "tom", 1, 77, new HashSet<>());
//        cat.getHabits().add("sleeping");
//       dog.getHabits().add("running");
//        System.out.println(cat);
//   //     System.out.println(dog);
//        family.addPet(cat);
//      family.addPet(dog);
//     //   System.out.println(family.getPet());
//        System.out.println(family.removePet(cat));
//    //    System.out.println(family.getPet());
//      //  System.out.println("0000");
//     //   System.out.println(family.getPet());
//        ArrayList<Family> families = new ArrayList<>();
//        families.add(family);
//        System.out.println(families.size());
//        families.add(family);
//
//        System.out.println("---------------");
//        System.out.println(families.remove(1));
//        System.out.println("------------------------");
//        System.out.println(families.size());
//        FamilyDao familyDao = new CollectionFamilyDao(families);
//        FamilyService familyService = new FamilyService(familyDao);
//        FamilyController familyController = new FamilyController(familyService);
//        familyService.displayAllFamilies();
//        familyController.displayAllFamilies();
//        System.out.println("=======================================================================================");
//        Human father1 = new Human("John", "Doe", LocalDate.of(1980, 5, 15));
//        Human mother1 = new Human("Jane", "Doe", LocalDate.of(1985, 8, 20));
//        familyController.createNewFamily(father1, mother1);
//
//        // Yeni aileyi göster
//        System.out.println("\nYeni aile oluşturuldu:");
//        familyController.displayAllFamilies();
//
//        int maxAge = 10;
//        familyController.deleteAllChildrenOlderThan(maxAge);
//        System.out.println("\n" + maxAge + " yaşından büyük tüm çocukları silinmiş aileler:");
//        familyController.displayAllFamilies();
//        int familyIndex = 0; // Evcil hayvan eklemek istediğiniz ailenin indeksi
//        Pet pet = new Dog("Cat","Cat",3,55,new HashSet<>());
//        pet.getHabits().add("sleeping");
//        System.out.println(familyController.addPet(familyIndex, pet));
//
//        familyController.displayAllFamilies();
//        System.out.println(familyController.getPet(0));
//        System.out.println(familyController.deleteFamily(0));
//        System.out.println(familyController.count());
//
//        //
        ArrayList<Family> families = new ArrayList<>();
        FamilyDao familyDao = new CollectionFamilyDao(families);
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);
        Human father1 = new Human("John", "Doe", LocalDate.of(1980, 5, 15).toEpochDay());
        Human mother1 = new Human("Jane", "Doe", LocalDate.of(1985, 8, 20).toEpochDay());
        familyController.createNewFamily(father1, mother1);
        //    System.out.println(familyController.getAllFamilies());
        Human father2 = new Human("John55", "Doe", LocalDate.of(1980, 5, 15).toEpochDay());
        Human mother2 = new Human("Jane", "Doe", LocalDate.of(1985, 8, 20).toEpochDay());

        familyController.createNewFamily(father2, mother2);
        System.out.println(familyController.count());
        familyController.displayAllFamilies();
    }
}