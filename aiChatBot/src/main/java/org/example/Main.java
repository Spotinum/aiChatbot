package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        trainingRun trainingRun = new trainingRun();
        botResponse botResponse = new botResponse();
        trainingRun.train();

        //run a loop until user presses ctrl + c
        while (true) {
            try {
                // Create a BufferedReader instance to read user input
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("You: ");
                String userInput = reader.readLine();
                System.out.println("Bot: " + botResponse.getResponse(userInput));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}