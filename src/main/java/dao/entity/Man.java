package dao.entity;

import dao.entity.Family;
import dao.entity.Human;
import model.enums.DaysOfWeek;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname, LocalDate birthDate, double iqLevel, Map<DaysOfWeek, List<String>> schedule, Family family) {
        super(name, surname, birthDate, iqLevel, schedule, family);
    }

    public Man(String name, String surname, LocalDate birthDate, double iqLevel, Map<DaysOfWeek, List<String>> schedule) {
        super(name, surname, birthDate, iqLevel, schedule);
    }

    public Man(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
    }

    @Override
    public void greetPet() {
        super.greetPet();
        System.out.println("man like eat his pet");
    }

    public void repairCar() {
        System.out.println("dao.entity.Man like car collection");
    }
}
