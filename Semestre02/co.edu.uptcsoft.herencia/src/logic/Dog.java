package logic;

public class Dog extends Mammal {
    private String race;

    public Dog(String name, String food, byte age, String race) {
        super(name, food, age);
        this.race = race;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "dog{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", race = '" + race + '\'' +
                ", food = '" + food + '\'' +
                ", gestation = " + gestation +
                '}';
    }
}
