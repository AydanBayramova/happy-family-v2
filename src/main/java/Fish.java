import java.util.Set;

public class Fish extends Pet implements CanFoul {


    public Fish(String species, String nickname, int age, int trickLevel, Set<String> habits) {
        super(species, nickname, age, trickLevel, habits);
    }

    public Fish(String nickname) {
        super(nickname);
    }

    @Override
    public void respond() {
        System.out.println("i am your fish ,owner" + super.getNickname());
    }

    @Override
    public void foul() {
        System.out.println("fish  has ful method");
    }
}
