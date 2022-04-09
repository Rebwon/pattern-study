package com.rebwon.java17.file_11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.junit.jupiter.api.Test;

public final class FileExample {

    @Test
    void files_writeString1() throws IOException {
        Path path = Files.writeString(Path.of("a.txt"), "Hello World", StandardOpenOption.CREATE);
    }
}
