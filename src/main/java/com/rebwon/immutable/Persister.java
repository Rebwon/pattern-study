package com.rebwon.immutable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public final class Persister {

    public FileContent readFile(String fileName) {
        try {
            String[] content = Files.readAllLines(Paths.get(fileName))
                .toArray(String[]::new);
            return new FileContent(fileName, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FileContent[] readDirectory(String directoryName) {
        return Stream.of(new File(directoryName).listFiles())
            .filter(file -> !file.isDirectory())
            .map(file -> readFile(file.getAbsolutePath()))
            .toArray(FileContent[]::new);
    }

    public void applyChange(FileAction action) {
        applyChanges(List.of(action));
    }

    public void applyChanges(List<FileAction> actions) {
        for (FileAction action : actions) {
            switch (action.type()) {
                case CREATE, UPDATE -> {
                    try {
                        Files.write(Paths.get(action.fileName()), List.of(action.content()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case DELETE -> {
                    try {
                        Files.delete(Paths.get(action.fileName()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> throw new UnsupportedOperationException();
            }
        }
    }
}
