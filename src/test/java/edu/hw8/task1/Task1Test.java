package edu.hw8.task1;

import org.junit.jupiter.api.Test;
import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void test() throws InterruptedException {
        Server server = new Server();
        Client client = new Client();

        server.start();

        Thread serverThread = new Thread(() -> {
            assertAll(server::run);
        });

        serverThread.start();

        assertThat(client.run("личности")).isEqualTo("Не переходи на личности там, где их нет");
        assertThat(client.run("оскорбления")).isEqualTo(
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами");
        assertThat(client.run("глупый")).isEqualTo(
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.");
        assertThat(client.run("интеллект")).isEqualTo("Чем ниже интеллект, тем громче оскорбления");
    }
}
