import java.util.*;

public abstract class Pet {
    private String species;
    private Species speciesType;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Species getSpeciesType() {
        return speciesType;
    }

    public void setSpeciesType(Species speciesType) {
        this.speciesType = speciesType;
    }



    public Pet(String species, String nickname, int age, int trickLevel,Set<String> habits) {
        this.species=species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = new HashSet<>();
        try {
            speciesType = Species.valueOf(species.toUpperCase());
        } catch (IllegalArgumentException e) {
            speciesType = Species.UNKNOWN;
            System.out.println("Invalid animal kind. Setting type to UNKNOWN.");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Your information is deleted by garbage collector");
    }
    public abstract void respond();


    public Pet( String nickname) {
        this.nickname = nickname;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        if (trickLevel > 0 && trickLevel <= 100) {
            this.trickLevel = trickLevel;
        }
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = new HashSet<>();
    }

    public void eat() {
        System.out.println("I am eating");
    }


    @Override
    public String toString() {
        return "Pet{" +
                "species='" + species + '\'' +
                ", speciesType=" + speciesType +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + habits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species) && speciesType == pet.speciesType && Objects.equals(nickname, pet.nickname) && Objects.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, speciesType, nickname, age, trickLevel, habits);
    }
}
