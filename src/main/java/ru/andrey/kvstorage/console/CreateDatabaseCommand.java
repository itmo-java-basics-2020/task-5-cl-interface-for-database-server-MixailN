package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;

public class CreateDatabaseCommand implements DatabaseCommand {
    ExecutionEnvironment env;
    String[] options;

    public CreateDatabaseCommand(ExecutionEnvironment newEnv, String[] newOptions) {
        env = newEnv;
        options = newOptions;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (options.length != 1) {
            return DatabaseCommandResult.error("This command required 1 option");
        }
        //some actions
        return DatabaseCommandResult.success("Database was created");
    }
}
