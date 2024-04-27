import java.time.LocalDate;
import java.util.*;

public class FamilyApp {
    public static void main(String[] args) {
        Human mother = new Human("Jane", "watson", LocalDate.of(1980, 9, 7));
        Human father = new Human("John", "Watson", LocalDate.of(1890, 9, 5));
        Family family = new Family(mother, father);
        Map<DaysOfWeek, List<String>> schedule = new HashMap<>();
        schedule.put(DaysOfWeek.MONDAY, Arrays.asList("Programming", "Gym"));
        schedule.put(DaysOfWeek.TUESDAY, Arrays.asList("Math", "English"));
        schedule.put(DaysOfWeek.WEDNESDAY, Arrays.asList("Art", "Music"));
        schedule.put(DaysOfWeek.THURSDAY, Arrays.asList("Science", "History"));
        schedule.put(DaysOfWeek.FRIDAY, Arrays.asList("Free time", "Friends"));
        schedule.put(DaysOfWeek.SATURDAY, Arrays.asList("Sports", "Movies"));
        schedule.put(DaysOfWeek.SUNDAY, Arrays.asList("Relax", "Family"));
        System.out.println("=========================");
        System.out.println(mother.toString());
        Human ch = new Human("Alex", "Bob", LocalDate.of(1999, 2, 3), 79, schedule, family);
        System.out.println(ch);
        ch.setSchedule(schedule);
        family.addChild(ch);
        System.out.println(family.countFamily());
        System.out.println("====");
        System.out.println(family.countFamily());
        Human ch1 = new Human("Alex", "Bob", LocalDate.of(1999, 2, 3), 79, schedule, family);
        System.out.println(ch1);
        family.addChild(ch1);
        System.out.println(family.countFamily());
        family.getPet();
        Pet cat = new DomesticCat("Cat", "lazyCat", 2, 66, new HashSet<>());
       Pet dog = new Dog("dog", "tom", 1, 77, new HashSet<>());
        cat.getHabits().add("sleeping");
       dog.getHabits().add("running");
        System.out.println(cat);
   //     System.out.println(dog);
        family.addPet(cat);
      family.addPet(dog);
     //   System.out.println(family.getPet());
        System.out.println(family.removePet(cat));
    //    System.out.println(family.getPet());
      //  System.out.println("0000");
     //   System.out.println(family.getPet());

    }
}