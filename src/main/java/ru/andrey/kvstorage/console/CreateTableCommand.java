package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CreateTableCommand implements DatabaseCommand {
    ExecutionEnvironment env;
    String[] options;

    public CreateTableCommand(ExecutionEnvironment newEnv, String[] newOptions) {
        env = newEnv;
        options = newOptions;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (options.length != 2) {
            return DatabaseCommandResult.error("This command required 2 options");
        }
        try {
            Optional<Database> base = env.getDatabase(options[0]);
            base.get().createTableIfNotExists(options[1]);
            return DatabaseCommandResult.success("Table was created");
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
