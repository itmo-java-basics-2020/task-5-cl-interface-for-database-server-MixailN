package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class ReadKeyCommand implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String[] options;

    public ReadKeyCommand(ExecutionEnvironment newEnv, String[] newOptions) {
        env = newEnv;
        options = newOptions;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (options.length != 3) {
            return DatabaseCommandResult.error("This command required 3 options");
        }
        try {
            Optional<Database> base = env.getDatabase(options[0]);
            if (base.isPresent()) {
                String result = base.get().read(options[1], options[2]);
                return DatabaseCommandResult.success(result);
            } else {
                return DatabaseCommandResult.error("Database doesn't exist!");
            }

        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
