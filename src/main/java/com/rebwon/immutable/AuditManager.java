package com.rebwon.immutable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public record AuditManager(int maxEntriesPerFile) {

    public List<FileAction> removeMentionsAbout(String visitorName, FileContent[] directoryFiles) {
        return Arrays.stream(directoryFiles)
            .map(file -> removeMentionsIn(file, visitorName))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .toList();
    }

    private Optional<FileAction> removeMentionsIn(FileContent file, String visitorName) {
        List<AuditEntry> entries = parse(file.content());

        List<AuditEntry> newContent = IntStream.range(0, entries.size())
            .filter(i -> !entries.get(i).visitor().equals(visitorName))
            .mapToObj(i -> new AuditEntry(i, entries.get(i).visitor(), entries.get(i).timeOfVisit()))
            .toList();

        if (newContent.size() == entries.size()) return Optional.empty();

        if (newContent.size() == 0) return Optional.of(new FileAction(file.fileName(), new String[0], ActionType.DELETE));

        return Optional.of(new FileAction(file.fileName(), serialize(newContent), ActionType.UPDATE));
    }

    public FileAction addRecord(FileContent currentFile, String visitorName,
        LocalDateTime timeOfVisit) {
        List<AuditEntry> entries = parse(currentFile.content());

        if (entries.size() < maxEntriesPerFile) {
            entries.add(new AuditEntry(entries.size() + 1, visitorName, timeOfVisit));
            String[] newContent = serialize(entries);

            return new FileAction(currentFile.fileName(), newContent, ActionType.UPDATE);
        } else {
            var entry = new AuditEntry(1, visitorName, timeOfVisit);
            String[] newContent = serialize(List.of(entry));
            String newFileName = getNewFileName(currentFile.fileName());

            return new FileAction(newFileName, newContent, ActionType.CREATE);
        }
    }

    private String getNewFileName(String existingFileName) {
        String fileName = PathUtils.getFileNameWithoutExtension(existingFileName);
        int index = Integer.parseInt(fileName.split("_")[1]);
        return "Audit_" + (index + 1) + ".txt";
    }

    private String[] serialize(List<AuditEntry> entries) {
        return entries
            .stream()
            .map(entry -> entry.number() + ";" + entry.visitor() + ";" + entry.timeOfVisit().toString())
            .toArray(String[]::new);
    }

    private List<AuditEntry> parse(String[] content) {
        var result = new ArrayList<AuditEntry>();
        for (String line : content) {
            String[] data = line.split(";");
            result.add(new AuditEntry(Integer.parseInt(data[0]), data[1], LocalDateTime.parse(data[2])));
        }
        return result;
    }

    static final class PathUtils {
        static String getFileNameWithoutExtension(String fileName) {
            return fileName.substring(0, fileName.lastIndexOf('.'));
        }
    }
}

record AuditEntry(int number, String visitor, LocalDateTime timeOfVisit) {

}

record FileAction(String fileName, String[] content, ActionType type) {

}

enum ActionType {
    CREATE, UPDATE, DELETE
}

record FileContent(String fileName, String[] content) {

}
