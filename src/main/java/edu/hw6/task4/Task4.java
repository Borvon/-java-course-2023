package edu.hw6.task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class Task4 {

    private Task4() {

    }

    public static void task4(Path outputPath) throws IOException {

        try (OutputStream file = Files.newOutputStream(outputPath);
             CheckedOutputStream checkedOutputStream = new CheckedOutputStream(file, new Adler32());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             OutputStreamWriter outputStreamWriter =
                 new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
             PrintWriter writer = new PrintWriter(outputStreamWriter)) {

            writer.write("Programming is learned by writing programs. ― Brian Kernighan");
        }
    }

}
