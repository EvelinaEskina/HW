import animals.Animals;
import data.AnimalData;
import data.Menu;
import factory.AnimalFactory;
import utils.ValidateNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static ValidateNumber validateNumber;
    public static Menu menu;

    private static int enterNumberData(String errorMassage) {
        String dataStr = scanner.next();

        while (!validateNumber.isNumber(dataStr)) {
            System.out.println(errorMassage);
            dataStr = scanner.next();
        }
        int number = Integer.parseInt(dataStr);
        if (number > 0) {
            return number;
        }
        System.out.println(errorMassage);
        enterNumberData(errorMassage);

        return -1;
    }

    public static void main(String[] args) {

        validateNumber = new ValidateNumber();
        scanner = new Scanner(System.in);

        List<Animals> animals = new ArrayList<>();

        while (true) {
            String inputCommand = " ";
            System.out.println("Привет! Вводи команду ADD/LIST/EXIT");
            String input = scanner.next();
            while (inputCommand.length() == 0) {
                inputCommand = scanner.nextLine();
            }

            Menu menu = Menu.valueOf(inputCommand); {
                boolean isCommandValid = false;
                for (Menu command : Menu.values()) {
                    if (menu.name().equals(menu)) {
                        isCommandValid = true;
                        break;
                    }
                }
                if (!isCommandValid) {
                    System.out.println("Команда введена не верно.\\n Введи команду ADD/LIST/EXIT ");
                    continue;
                }
            }

            switch (menu) {
                case ADD: {
                    AnimalData[] animalDataArray = AnimalData.values();
                    String[] animalNames = new String[animalDataArray.length];

                    while (true) {
                        System.out.println(String.format("Введите тип животного: %s ", AnimalData.values()));
                        String animalType = scanner.nextLine().toUpperCase().trim();

                        boolean isAnimalValid = false;
                        for (AnimalData animalData : AnimalData.values()) {
                            if (animalData.name().equals(animalType)) {
                                isAnimalValid = true;
                                break;
                            }
                        }
                        if (!isAnimalValid) {
                            System.out.println("Тип введен не верно.\\n Введите тип cat/dog/duck ");
                            continue;
                        }

                        AnimalData animalData = AnimalData.valueOf(animalType);

                        System.out.println("Введите цвет животного");
                        String animalColour = scanner.nextLine();

                        System.out.println("Введите имя животного");
                        String animalName = scanner.nextLine();

                        System.out.println("Введите возраст животного");

                        int animalAge = enterNumberData("Не верно введен возраст.\nПовторите ввод");
                        if (animalAge == -1) {
                            System.out.println("Вы потратили все попытки ввода");
                            continue;
                        }

                        System.out.println("Введите вес животного");

                        int animalWeight = enterNumberData("Не верно введен вес животного.\nПовторите ввод");
                        if (animalWeight == -1) {
                            System.out.println("Вы потратили все попытки ввода");
                            continue;
                        }


                        AnimalFactory animalFactory = new AnimalFactory(animalAge, animalWeight, animalName, animalColour);

                        Animals animal = animalFactory.create(AnimalData.valueOf(animalType));
                        animals.add(animal);
                    }
                }

                case LIST: {
                    for (int i = 0; i < animals.size(); i++) {
                        System.out.println(animals.get(i));
                    }
                    break;
                }
                case EXIT: {
                    System.exit(0);
                }
            }


        }
    }
}




