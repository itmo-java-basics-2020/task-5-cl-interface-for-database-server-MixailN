package ru.andrey.kvstorage.console;

public enum DatabaseCommands {
    CREATE_DATABASE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] options) {
            return new CreateDatabaseCommand(env, options);
        }
    },
    CREATE_TABLE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] options) {
            return new CreateTableCommand(env, options);
        }
    },
    UPDATE_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] options) {
            return new UpdateKeyCommand(env, options);
        }
    },
    READ_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] options) {
            return new ReadKeyCommand(env, options);
        }
    };

    public abstract DatabaseCommand getCommand(ExecutionEnvironment env, String[] options);
}