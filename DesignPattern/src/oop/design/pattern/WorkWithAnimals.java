package oop.design.pattern;

/**
 * Created by Phil on 01/07/2014.
 */
public class WorkWithAnimals {

    public static void main(String[] args) {

        Dog fido = new Dog();

        fido.setName("Fido");
        System.out.println(fido.getName());

        fido.digHole();

        fido.setWeight(-1);

        int randNum = 10;
        fido.changeVar(randNum);
        System.out.println("randNum after method call: " + randNum);

        changeObjectName(fido);
        System.out.println("dog name after method call: " + fido.getName());

        // video 66 (polymorphism)
        Animal doggy = new Dog();
        Animal kitty = new Cat();
        System.out.println("Doggy says: " + doggy.getSound());
        System.out.println("Kitty says: " + kitty.getSound());

        Animal[] animals = new Animal[4];
        animals[0] = doggy;
        animals[1] = kitty;
        System.out.println("Doggy says: " + animals[0].getSound());
        System.out.println("Kitty says: " + animals[0].getSound());

        speakAnimal(doggy);

        ((Dog)doggy).digHole();

        Girafe girafe = new Girafe();
        girafe.setName("Frank");
        System.out.println(girafe.getName());

    }

    public static void changeObjectName(Dog fido) {
        fido.setName("Marcus");
    }

    public static void speakAnimal(Animal animal) {
        System.out.println("oop.design.pattern.Animal says: " + animal.getSound());
    }

}
