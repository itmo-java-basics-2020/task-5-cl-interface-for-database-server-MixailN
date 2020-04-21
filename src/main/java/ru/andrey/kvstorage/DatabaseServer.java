package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.DatabaseCommands;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {

    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        if (commandText == null) {
            return DatabaseCommandResult.error("Can't receive command");
        }
        try {
            String[] fullCommand = commandText.split(" ");
            String[] options = commandText.substring(commandText.indexOf(" ") + 1).split(" ");
            return DatabaseCommands.valueOf(fullCommand[0]).getCommand(env, options).execute();
        } catch (Exception e) {
            return DatabaseCommandResult.error("<ERROR> Something wrong with this command, more details: " + e.getMessage());
        }
    }
}
