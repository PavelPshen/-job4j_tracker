package ru.job4j.tracker.output;

import ru.job4j.tracker.input.Input;

public class MockOutput implements Input {
    private String[] answers;
    private int position = 0;

    public MockOutput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}