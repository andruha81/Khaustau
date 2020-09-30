package battle.utils;

import battle.entities.Animal;

import java.util.Map;
import java.util.Scanner;

public class Names {

    private static final Scanner scanner = new Scanner(System.in);

    private Names() {
        new Scanner(System.in);
    }

    public static String createName() {

        System.out.println("Enter name of the fighter");
        return scanner.next();

    }

    public static boolean checkNameRepeat(Map<String, Animal> fighters, String name) {

        boolean resultCheckName = fighters.containsKey(name);

        if (resultCheckName) {
            System.out.println("Fighter with name " + name + " exists. Enter another name");
        }

        return resultCheckName;
    }
}
