package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    static DatabaseCommandResult success(String result) {
        return new SomeResult(true, result);
    }

    static DatabaseCommandResult error(String errorMessage) {
        return new SomeResult(false, errorMessage);
    }

    class SomeResult implements DatabaseCommandResult {
        String result;
        String errorMessage;
        boolean isSucceeded;

        private SomeResult(boolean isSucceeded, String newInfo) {
            this.isSucceeded = isSucceeded;
            if (isSucceeded) {
                result = newInfo;
            } else {
                errorMessage = newInfo;
            }
        }

        @Override
        public Optional<String> getResult() {
            return Optional.of(result);
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return isSucceeded ? DatabaseCommandStatus.SUCCESS : DatabaseCommandStatus.FAILED;
        }

        @Override
        public boolean isSuccess() {
            return isSucceeded;
        }

        @Override
        public String getErrorMessage() {
            return errorMessage;
        }
    }
}