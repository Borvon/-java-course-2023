package edu.hw2.task3;

public class DefaultConnectionManager implements ConnectionManager {
    int numberOfConnections = 1;

    @Override
    public Connection getConnection() {
        Connection connection;
        if (numberOfConnections == 1) {
            numberOfConnections = 0;
            connection = new FaultyConnection();
        } else {
            numberOfConnections++;
            connection = new StableConnection();
        }
        return connection;
    }
}
