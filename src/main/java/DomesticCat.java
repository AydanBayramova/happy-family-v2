import java.util.Set;

public class DomesticCat extends Pet {

    public DomesticCat(String species, String nickname, int age, int trickLevel, Set<String> habits) {
        super(species, nickname, age, trickLevel, habits);
    }

    public DomesticCat(String nickname) {
        super(nickname);
    }

    @Override
    public void respond() {
        System.out.println("domestic cat is very sweet" + super.getNickname());
    }
}
