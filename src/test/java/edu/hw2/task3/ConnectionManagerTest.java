package edu.hw2.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ConnectionManagerTest {

    @Test
    @DisplayName("DefaultManager test")
    void DefaultManagerTest() {
        var manager = new DefaultConnectionManager();

        for (int i = 0; i < 10; i++) {
            if(i%2==0)
            assertThat(manager.getConnection().getClass().toString()).isEqualTo("class edu.hw2.task3.FaultyConnection");
            else assertThat(manager.getConnection().getClass().toString()).isEqualTo("class edu.hw2.task3.StableConnection");
        }
    }

    @Test
    @DisplayName("DefaultManager test")
    void FaultyManagerTest() {
        var manager = new FaultyConnectionManager();

        for (int i = 0; i < 10; i++) {
            assertThat(manager.getConnection().getClass().toString()).isEqualTo("class edu.hw2.task3.FaultyConnection");
        }
    }

}
