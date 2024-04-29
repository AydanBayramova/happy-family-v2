import controller.FamilyController;
import dao.CollectionFamilyDao;
import dao.FamilyDao;
import dao.entity.Family;
import dao.entity.Human;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.FamilyService;

import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class DaoTest {
    @Test
    @DisplayName("Display method")
    void displayMethod(){
        ArrayList<Family> families = new ArrayList<>();
        FamilyDao familyDao = new CollectionFamilyDao(families);
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);
        Human father1 = new Human("John", "Doe", LocalDate.of(1980, 5, 15).toEpochDay());
        Human mother1 = new Human("Jane", "Doe", LocalDate.of(1985, 8, 20).toEpochDay());
        familyController.createNewFamily(father1, mother1);
        String test="[dao.entity.Family{mother=dao.entity.Human{name='John', surname='Doe'}, father=dao.entity.Human{name='Jane', surname='Doe'}}]";
        assertEquals(familyController.getAllFamilies().toString(),test);
    }
    @Test
    @DisplayName("Count")
    void count(){
        ArrayList<Family> families = new ArrayList<>();
        FamilyDao familyDao = new CollectionFamilyDao(families);
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);
        Human father1 = new Human("John", "Doe", LocalDate.of(1980, 5, 15).toEpochDay());
        Human mother1 = new Human("Jane", "Doe", LocalDate.of(1985, 8, 20).toEpochDay());
        familyController.createNewFamily(father1, mother1);
        Human father2= new Human("Tom", "Doe", LocalDate.of(1980, 5, 15).toEpochDay());
        Human mother2 = new Human("Lima", "Doe", LocalDate.of(1985, 8, 20).toEpochDay());
        familyController.createNewFamily(father2,mother2);
        assertEquals(2,familyController.count());

    }
}
