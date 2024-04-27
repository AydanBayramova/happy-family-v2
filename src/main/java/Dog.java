import java.util.Set;

public class Dog extends Pet {


    public Dog(String species, String nickname, int age, int trickLevel, Set<String> habits) {
        super(species, nickname, age, trickLevel, habits);
    }

    public Dog(String nickname) {
        super(nickname);
    }

    @Override
    public void respond() {
        System.out.println("dog have sound:");
    }
}
