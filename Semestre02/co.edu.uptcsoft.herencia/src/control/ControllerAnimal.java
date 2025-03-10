package control;
import logic.Dog;
import logic.Cat;
public class ControllerAnimal {
    public String interfazDog(String nom, String com, String eda, String raz) {
        byte edad = Byte.parseByte(eda);
        Dog dog = new Dog(nom, com, edad, raz);
        return String.valueOf(dog);
    }
    public String interfazCat(String nom, String com, String eda, String ped){
        byte edad = Byte.parseByte(eda);
        Cat cat = new Cat(nom, com, edad,ped);
        return String.valueOf(cat);
    }

}
