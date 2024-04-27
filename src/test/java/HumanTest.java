import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {
    @Test
    @DisplayName("Test toString")
    void toStringTest() {
        Human mother = new Human("Jane", "watson", LocalDate.of(1980, 9, 7));
        String test = "Human{name='Jane', surname='watson', birthDate=1980-09-07, iqLevel=0.0, schedule=null, family=null}";
        assertEquals(test, mother.toString());
    }

    @Test
    @DisplayName("Test Delete Child")
    void deleteChild() {
        Human mother = new Human("Jane", "watson", LocalDate.of(1980, 9, 7));
        Human father = new Human("John", "Watson", LocalDate.of(1890, 9, 5));
        Family family = new Family(mother, father);
        Human human = new Human("J", "W", LocalDate.of(1990, 8, 3));
        family.addChild(human);
        family.deleteChild(human);
        assertEquals(0, family.getChildren().size());

    }

    @Test
    @DisplayName("Test Delete Child")
    void noDeleteChild() {
        Human mother = new Human("Jane", "Watson", LocalDate.of(1980, 9, 7));
        Human father = new Human("John", "Watson", LocalDate.of(1890, 9, 5));
        Family family = new Family(mother, father);
        Human human = new Human("J", "W", LocalDate.of(1990, 8, 3));
        Human human2 = new Human("Joe", "W", LocalDate.of(1990, 8, 3));
        family.addChild(human);
        family.deleteChild(human2);
        assertEquals(1, family.getChildren().size());

    }

    @Test
    @DisplayName("Add child")
    void addChild() {
        Map<DaysOfWeek, List<String>> schedule = new HashMap<>();
        schedule.put(DaysOfWeek.MONDAY, Arrays.asList("Programming", "Gym"));
        schedule.put(DaysOfWeek.TUESDAY, Arrays.asList("Math", "English"));
        schedule.put(DaysOfWeek.WEDNESDAY, Arrays.asList("Art", "Music"));
        schedule.put(DaysOfWeek.THURSDAY, Arrays.asList("Science", "History"));
        schedule.put(DaysOfWeek.FRIDAY, Arrays.asList("Free time", "Friends"));
        schedule.put(DaysOfWeek.SATURDAY, Arrays.asList("Sports", "Movies"));
        schedule.put(DaysOfWeek.SUNDAY, Arrays.asList("Relax", "Family"));
        Human mother = new Human("Jane", "Watson", LocalDate.of(1980, 9, 7));
        Human father = new Human("John", "Watson", LocalDate.of(1890, 9, 5));
        Family family = new Family(mother, father);
        Human child = new Human("Alex", "Bob", LocalDate.of(1999, 2, 3), 79, schedule, family);
        family.addChild(child);
        assertEquals(3, family.countFamily());
    }


}
