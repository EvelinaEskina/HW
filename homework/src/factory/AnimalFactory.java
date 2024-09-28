package factory;

import animals.Animals;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalData;

public class AnimalFactory {
    private int age;
    private int weight;
    private String name;
    private String colour;

    public AnimalFactory(int age, int weight, String name, String colour) {
        this.age = age;
        this.weight = weight;
        this.name = name;
        this.colour = colour;
    }

    public static AnimalData valueOf(String animalType) {
        return null;
    }

    public Animals create(AnimalData animalData) {
        switch (animalData) {
            case CAT: {
                return new Cat(colour, weight, name, age);
            }
            case DOG: {
                return new Dog(colour, weight, name, age);
            }
            case DUCK: {
                return new Duck(colour, weight, name, age);
            }
        }
        return null;
    }
}
