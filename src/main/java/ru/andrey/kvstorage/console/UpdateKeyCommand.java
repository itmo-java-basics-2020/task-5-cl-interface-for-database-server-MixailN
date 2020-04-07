package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class UpdateKeyCommand implements DatabaseCommand {
    ExecutionEnvironment env;
    String[] options;

    public UpdateKeyCommand(ExecutionEnvironment newEnv, String[] newOptions) {
        env = newEnv;
        options = newOptions;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (options.length != 4) {
            return DatabaseCommandResult.error("This command required 4 options");
        }
        try {
            Optional<Database> base = env.getDatabase(options[0]);
            base.get().write(options[1], options[2], options[3]);
            return DatabaseCommandResult.success("Value was written");
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}