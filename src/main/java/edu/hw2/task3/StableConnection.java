package edu.hw2.task3;

public class StableConnection implements Connection {
    @Override
    public void execute(String command) {
        LOGGER.info("Successfully");
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Closed");
    }
}
