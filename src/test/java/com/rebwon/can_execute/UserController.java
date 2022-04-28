package com.rebwon.can_execute;

import com.rebwon.can_execute.User.Company;

public record UserController(MessageBus messageBus) {

    interface MessageBus {

        void send();
    }

    static final class Database {

        static User getUser() {
            return null;
        }
    }

    public void changeEmail(String newEmail, Company company) {
        User user = Database.getUser();

        // canExecute
        user.canChangeEmail();

        // execute
        user.changeEmail(newEmail, company);

        messageBus.send();
    }
}
