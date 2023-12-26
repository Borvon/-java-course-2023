package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task2 {

    private Task2() {
    }

    @SuppressWarnings("MultipleStringLiterals")
    public static void cloneFile(Path path) throws IOException {

        String[] fileName = path.getFileName().toString().split("\\.");
        String copiedFileName = fileName[0] + " — копия." + fileName[1];

        if (Files.exists(Paths.get(path.getParent().toString(), copiedFileName))) {
            int copyNumber = 2;

            while (Files.exists(Paths.get(
                path.getParent().toString(),
                fileName[0] + " — копия (" + copyNumber + ")." + fileName[1]
            ))) {
                copyNumber++;
            }

            Files.copy(
                path,
                Paths.get(path.getParent().toString(), fileName[0] + " — копия (" + copyNumber + ")." + fileName[1])
            );

        } else {
            Files.copy(path, Paths.get(path.getParent().toString(), copiedFileName));
        }
    }

}
