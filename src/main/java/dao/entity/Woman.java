package dao.entity;

import dao.entity.Family;
import dao.entity.Human;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public final class Woman extends Human {
//    public Woman(String name, String surname, LocalDate birthDate, double iqLevel, Map<DaysOfWeek, List<String>> schedule, Family family) {
//        super(name, surname, birthDate, iqLevel, schedule, family);
//    }

//    public Woman(String name, String surname, LocalDate birthDate, double iqLevel, Map<DaysOfWeek, List<String>> schedule) {
//        super(name, surname, birthDate, iqLevel, schedule);
//    }

    public Woman(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public void makeup() {
        System.out.println("woman likes makeup");
    }

    @Override
    public void greetPet() {
        super.greetPet();
        System.out.println("woman feed her pet 3 times during the day");
    }
}
