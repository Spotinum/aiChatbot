package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class botResponse {

    public String getResponse(String userInput) {
        try {
            // Command to run the Python script using a specific Python interpreter
            String pythonInterpreter = "/home/spotinum/Documents/personalProjects/aiChatbot/.venv/aiChatbot/bin/python";
            String scriptPath = "/home/spotinum/Documents/personalProjects/aiChatbot/chatbot.py";

            // Create ProcessBuilder instance with the command, script path, and argument
            ProcessBuilder pb = new ProcessBuilder(pythonInterpreter, scriptPath, userInput);

            // Start the process
            Process process = pb.start();

            // Get the output stream of the process
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Read the output of the process
            String line;
            String response = "";
            while ((line = reader.readLine()) != null) {
                response = line;
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            return response;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "Error";

    }
}
