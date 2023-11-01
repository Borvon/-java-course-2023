package edu.hw2.task3;

public class FaultyConnection implements Connection {
    private final int failRate = 3;
    private int numberOfExecutions = failRate;

    @Override
    public void execute(String command) {
        if (numberOfExecutions == failRate) {
            numberOfExecutions = 0;
            throw new ConnectionException("message", null);
        }

        numberOfExecutions++;
        LOGGER.info("Successfully");
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Closed");
    }
}
