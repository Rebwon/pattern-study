package com.rebwon.can_execute;

public final class User {

    record Company() {
    }

    // CanExecute
    public boolean canChangeEmail() {
        return false;
    }

    // Execute
    public void changeEmail(String newEmail, Company company) {
        if (canChangeEmail()) {
            throw new IllegalStateException("Cannot change email");
        }
    }
}
