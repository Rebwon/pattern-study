package com.rebwon.immutable;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public final class ApplicationService {

    private final String directoryName;
    private final AuditManager auditManager;
    private final Persister persister;

    public ApplicationService(String directoryName) {
        this.directoryName = directoryName;
        this.auditManager = new AuditManager(10);
        this.persister = new Persister();
    }

    public void removeMentionsAbout(String visitorName) {
        FileContent[] files = persister.readDirectory(directoryName);
        List<FileAction> actions = auditManager.removeMentionsAbout(visitorName, files);
        persister.applyChanges(actions);
    }

    public void addRecord(String visitorName, LocalDateTime timeOfVisit) {
        File file = Stream.of(new File(directoryName).listFiles())
            .min((f1, f2) -> f1.lastModified() > f2.lastModified() ? -1 : 1)
            .orElseGet(null);

        FileContent fileContent = persister.readFile(file.getName());
        FileAction action = auditManager.addRecord(fileContent, visitorName, timeOfVisit);
        persister.applyChange(action);
    }
}
