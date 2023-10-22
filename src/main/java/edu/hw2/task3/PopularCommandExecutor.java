package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        Connection connection = manager.getConnection();

        for (int i = 0; i < maxAttempts; i++) {
            try {
                connection.execute(command);
                break;
            } catch (ConnectionException exception) {
                if (i + 1 == maxAttempts) {
                    throw new ConnectionException(exception.getMessage(), exception);
                }
            }

        }
    }
}
