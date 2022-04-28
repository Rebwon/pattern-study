package com.rebwon.immutable;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

class AuditManagerTest {

    @Test
    void addRecord_adds_a_record_to_an_existing_file_if_not_overflowed() {
        var manager = new AuditManager(10);
        var file = new FileContent("Audit_1.txt", new String[]{
            "1;Peter Peterson;2016-04-06T16:30"
        });

        FileAction action = manager.addRecord(file, "Jane Doe",
            LocalDateTime.of(2016, 4, 6, 17, 0, 0));

        assertThat(action.type()).isEqualTo(ActionType.UPDATE);
        assertThat(action.fileName()).isEqualTo("Audit_1.txt");
        assertThat(action.content()).isEqualTo(new String[] {
            "1;Peter Peterson;2016-04-06T16:30",
            "2;Jane Doe;2016-04-06T17:00"});
    }

    @Test
    void addRecord_adds_a_record_to_a_new_file_if_overflowed() {
        var manager = new AuditManager(3);
        var file = new FileContent("Audit_1.txt", new String[]{
            "1;Peter Peterson;2016-04-06T16:30",
            "2;Jane Doe;2016-04-06T16:40",
            "3;Jack Rich;2016-04-06T17:00"
        });

        FileAction action = manager.addRecord(file, "Tom Tomson",
            LocalDateTime.of(2016, 4, 6, 17, 30, 0));

        assertThat(action.type()).isEqualTo(ActionType.CREATE);
        assertThat(action.fileName()).isEqualTo("Audit_2.txt");
        assertThat(action.content()).isEqualTo(new String[] {
                "1;Tom Tomson;2016-04-06T17:30"});
    }

    @Test
    void removeMentionsAbout_removes_mentions_from_files_in_the_directory() {
        var manager = new AuditManager(10);
        var file = new FileContent("Audit_1.txt", new String[]{
            "1;Peter Peterson;2016-04-06T16:30",
            "2;Jane Doe;2016-04-06T16:40",
            "3;Jack Rich;2016-04-06T17:00"
        });

        List<FileAction> actions = manager.removeMentionsAbout("Peter Peterson",
            new FileContent[]{file});

        assertThat(actions).hasSize(1);
        assertThat(actions.get(0).type()).isEqualTo(ActionType.UPDATE);
        assertThat(actions.get(0).fileName()).isEqualTo("Audit_1.txt");
        assertThat(actions.get(0).content()).isEqualTo(new String[] {
            "1;Jane Doe;2016-04-06T16:40",
            "2;Jack Rich;2016-04-06T17:00"});
    }

    @Test
    void removeMentionsAbout_removes_whole_file_if_it_doesnt_contain_anything_else() {
        var manager = new AuditManager(10);
        var file = new FileContent("Audit_1.txt", new String[]{
            "1;Peter Peterson;2016-04-06T16:30"
        });

        List<FileAction> actions = manager.removeMentionsAbout("Peter Peterson",
            new FileContent[]{file});

        assertThat(actions).hasSize(1);
        assertThat(actions.get(0).type()).isEqualTo(ActionType.DELETE);
        assertThat(actions.get(0).fileName()).isEqualTo("Audit_1.txt");
    }

    @Test
    void removeMentionsAbout_does_not_do_anything_in_case_no_mentions_found() {
        var manager = new AuditManager(10);
        var file = new FileContent("Audit_1.txt", new String[]{
            "1;Jane Smith;2016-04-06T16:30"});

        List<FileAction> actions = manager.removeMentionsAbout("Peter Peterson",
            new FileContent[]{file});

        assertThat(actions).hasSize(0);
    }
}