package dao.entity;

import dao.entity.Family;
import dao.entity.Pet;
import model.enums.DaysOfWeek;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private long birthDateMillis; // Represents Unix Millis Timestamp
    private double iqLevel;

    private Map<DaysOfWeek, List<String>> schedule;
    private Family family;

    public Human(String name, String surname, long birthDateMillis, double iqLevel, Map<DaysOfWeek, List<String>> schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.birthDateMillis = birthDateMillis;
        this.iqLevel = iqLevel;
        this.schedule = schedule;
        this.family = family;
    }

    public Human(String name, String surname, long birthDateMillis, double iqLevel, Map<DaysOfWeek, List<String>> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDateMillis = birthDateMillis;
        this.iqLevel = iqLevel;
        this.schedule = schedule;
    }

    public Human(String name, String surname, long birthDateMillis) {
        this.name = name;
        this.surname = surname;
        this.birthDateMillis = birthDateMillis;
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

    public long getBirthDateMillis() {
        return birthDateMillis;
    }

    public void setBirthDateMillis(long birthDateMillis) {
        this.birthDateMillis = birthDateMillis;
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

    public void welcomeFavoritePet() {
        System.out.println("This animal is your favorite" + this.getFamily().getPet());
    }

    public void describeFavPet(Family family) {
        if (family.getPet() != null) {
            Pet pet = family.getPet().iterator().next();
            System.out.println("Family's favorite animal's habits are: " + pet.getHabits() + " and the family's animal's trickLevel is: " + pet.getTrickLevel());
        } else {
            System.out.println("The family has not any animal yet");
        }
    }

    public void feed() {
        System.out.println("You feed your animal" + this.getFamily().getPet());
    }

    public void greetPet() {
        System.out.println("Hello, my owner");
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.ofEpochDay(birthDateMillis / 86400000); // Convert milliseconds to days
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate.format(formatter) +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Your information is deleted by the garbage collector");
    }

    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.ofEpochDay(birthDateMillis / 86400000);
        return Period.between(birthDate, currentDate).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Double.compare(human.iqLevel, iqLevel) == 0 && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && birthDateMillis == human.birthDateMillis && Objects.equals(schedule, human.schedule) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDateMillis, iqLevel, schedule, family);
    }


    public String describeAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.ofEpochDay(birthDateMillis / 86400000);
        Period period = Period.between(birthDate, currentDate);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        return "Age: " + years + " years, " + months + " months, " + days + " days";
    }

    public Human(String name, String surname, String birthDateStr, double iqLevel) {
        this.name = name;
        this.surname = surname;
        this.iqLevel = iqLevel;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthDateStr, formatter);
        this.birthDateMillis = localDate.atStartOfDay(ZoneId.of("Asia/Baku")).toEpochSecond();

    }
}
