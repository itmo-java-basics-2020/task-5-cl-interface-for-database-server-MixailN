package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CreateTableCommand implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String[] options;

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
            if (base.isPresent()) {
                base.get().createTableIfNotExists(options[1]);
                return DatabaseCommandResult.success("Table was created");
            } else {
                return DatabaseCommandResult.error("Database doesn't exist!");
            }

        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
