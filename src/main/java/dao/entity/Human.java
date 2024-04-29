package dao.entity;

import model.enums.DaysOfWeek;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private double iqLevel;

    private Map<DaysOfWeek, List<String>> schedule;
    private Family family;


    public Human(String name, String surname, LocalDate birthDate, double iqLevel, Map<DaysOfWeek, List<String>> schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iqLevel = iqLevel;
        this.schedule = schedule;
        this.family = family;
    }
    public Human(String name, String surname, LocalDate birthDate, double iqLevel, Map<DaysOfWeek, List<String>> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iqLevel = iqLevel;
        this.schedule = schedule;

    }
    public Human(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;

    }
    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getIqLevel() {
        return iqLevel;
    }

    public void setIqLevel(double iqLevel) {
        if (iqLevel > 0 && iqLevel < 100) {
            this.iqLevel = iqLevel;
        }
    }

    public Map<DaysOfWeek, List<String>> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DaysOfWeek, List<String>> schedule) {
        this.schedule = schedule;
    }
public void welcomeFavoritePet(){
    System.out.println("This animal is your favorite"+this.getFamily().getPet());
}
public  void describefavPet(Family family){
        if (family.getPet()!=null){
            Pet pet=family.getPet().iterator().next();
            System.out.println("dao.entity.Family's favorite animals habits is: "+pet.getHabits()+"and family's animals trickLevel is: "+pet.getTrickLevel());
        }else {
            System.out.println("The family has not any animal yet");
        }
    }
public  void feed(){
    System.out.println("your feed your animal"+this.getFamily().getPet());
}
public  void greetPet(){
    System.out.println("Hello,my owner");
}

    @Override
    public String toString() {
        return "dao.entity.Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Your information is deleted by garbage collector");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Double.compare(human.iqLevel, iqLevel) == 0 && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(birthDate, human.birthDate) && Objects.equals(schedule, human.schedule) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iqLevel, schedule, family);
    }
    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}