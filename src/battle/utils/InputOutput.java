package battle.utils;

import battle.api.dao.IFightersDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputOutput {

    private InputOutput() {
    }

    public static String enterPath() {

        String path;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Enter path to the txt file with fighters");

            path = reader.readLine();

            while (!path.matches(".+\\.txt$")) {

                System.out.println("Invalid path to the txt file. The extension of the file should be txt. Enter again");

                path = reader.readLine();

            }

        } catch (IOException e) {
            path = "C:\\defaultFighters.txt";
        }

        return path;

    }

    public static void readFile(String path, IFightersDao fightersDao) {

        try {

            Files.lines(Path.of(path))
                    .map(CreateFighter::createAnimal)
                    .forEach(x -> fightersDao.addFighter(x));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
