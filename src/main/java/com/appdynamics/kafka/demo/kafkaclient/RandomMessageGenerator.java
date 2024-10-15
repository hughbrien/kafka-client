package com.appdynamics.kafka.demo.kafkaclient;

import java.util.Random;

public class RandomMessageGenerator {

    private static final String[] WORDS = {
            "lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit",
            "sed", "do", "eiusmod", "tempor", "incididunt", "ut", "labore", "et", "dolore",
            "magna", "aliqua"
    };

    private static final Random RANDOM = new Random();

    public static String generateRandomMessage(int wordCount) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < wordCount; i++) {
            int wordIndex = RANDOM.nextInt(WORDS.length);
            message.append(WORDS[wordIndex]);
            if (i < wordCount - 1) {
                message.append(" ");
            }
        }
        return message.toString();
    }

}
