import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FamilyTest {


    @Test
    @DisplayName("Test toString")
    void toStringTest() {
        Human mother = new Human("Jane", "watson", LocalDate.of(1980, 9, 7));
        String test="Human{name='Jane', surname='watson', birthDate=1980-09-07, iqLevel=0.0, schedule=null, family=null}";
        assertEquals(test,mother.toString());
    }

    @Test
    @DisplayName("Test familyAnimal")
    void  addAnimal(){
        Human mother = new Human("Jane", "Watson", LocalDate.of(1980, 9, 7));
        Human father = new Human("John", "Watson", LocalDate.of(1890, 9, 5));
        Family family = new Family(mother, father);
        Pet cat = new DomesticCat("Cat", "lazyCat", 2, 66, new HashSet<>());
        cat.getHabits().add("sleeping");
        family.addPet(cat);
        family.getPet();
        Object test="[Pet{species='Cat', speciesType=CAT, nickname='lazyCat', age=2, trickLevel=66, habits=[sleeping]}]";
         assertEquals(test,family.getPet());
    }

}