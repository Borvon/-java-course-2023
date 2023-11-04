package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class SessionTest {
    @Test
    @DisplayName("Session test")
    void chooseWordTest() {
        Session session = new Session();

        session.chooseWord("Deadline");
        assertThat(session.getGuessingString()).isEqualTo("********");

        session.chooseWord("Word");
        assertThat(session.getGuessingString()).isEqualTo("****");
    }

    @Test
    @DisplayName("Session test")
    void tryCorrectLetterTest() {
        Session session = new Session();
        session.chooseWord("Please");

        assertThat(session.tryLetter("e")).isEqualTo(Session.TryLetterResponse.CORRECT);
        assertThat(session.getGuessingString()).isEqualTo("**e**e");
    }

    @Test
    @DisplayName("Session test")
    void tryWrongLetterTest() {
        Session session = new Session();
        session.chooseWord("Please");

        assertThat(session.tryLetter("z")).isEqualTo(Session.TryLetterResponse.WRONG);
        assertThat(session.getGuessingString()).isEqualTo("******");
    }

    @Test
    @DisplayName("Session test")
    void tryCapitalLetterTest() {
        Session session = new Session();
        session.chooseWord("Please");

        assertThat(session.tryLetter("P")).isEqualTo(Session.TryLetterResponse.CORRECT);
        assertThat(session.getGuessingString()).isEqualTo("p*****");
    }

    @Test
    @DisplayName("Session test")
    void noAttemptsTest() {
        Session session = new Session();
        session.chooseWord("Please");

        for (int i = 0; i < 4; i++) {
            session.tryLetter("z");
        }

        assertThat(session.tryLetter("z")).isEqualTo(Session.TryLetterResponse.LOOSE);
        assertThat(session.tryLetter("z")).isEqualTo(Session.TryLetterResponse.TOO_MANY_ATTEMPTS);
    }

    @Test
    @DisplayName("Session test")
    void invalidInputTest() {
        Session session = new Session();
        session.chooseWord("Please");

        assertThat(session.tryLetter("input")).isEqualTo(Session.TryLetterResponse.INVALID_INPUT);

    }

    @Test
    @DisplayName("Session test")
    void goodTryTest() {
        Session session = new Session();
        session.chooseWord("Please");

        assertThat(session.tryLetter("p")).isEqualTo(Session.TryLetterResponse.CORRECT);
        assertThat(session.getGuessingString()).isEqualTo("p*****");

        assertThat(session.tryLetter("l")).isEqualTo(Session.TryLetterResponse.CORRECT);
        assertThat(session.getGuessingString()).isEqualTo("pl****");

        assertThat(session.tryLetter("e")).isEqualTo(Session.TryLetterResponse.CORRECT);
        assertThat(session.getGuessingString()).isEqualTo("ple**e");

        assertThat(session.tryLetter("a")).isEqualTo(Session.TryLetterResponse.CORRECT);
        assertThat(session.getGuessingString()).isEqualTo("plea*e");

        assertThat(session.tryLetter("s")).isEqualTo(Session.TryLetterResponse.WIN);
        assertThat(session.getGuessingString()).isEqualTo("please");
    }

    @Test
    @DisplayName("Session test")
    void attemptsCounterTest() {
        Session session = new Session();
        session.chooseWord("Please");

        session.tryLetter("r");
        assertThat(session.getCurrentAttempts()).isEqualTo(1);
        session.tryLetter("rrr");
        assertThat(session.getCurrentAttempts()).isEqualTo(1);
        session.tryLetter("r");
        assertThat(session.getCurrentAttempts()).isEqualTo(2);
    }
}
