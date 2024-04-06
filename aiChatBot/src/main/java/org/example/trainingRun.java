package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class trainingRun {
    public void train(){
        try {
            // Command to run the Python script using a specific Python interpreter
            String pythonInterpreter = "/home/spotinum/Documents/personalProjects/aiChatbot/.venv/aiChatbot/bin/python";
            String scriptPath = "/home/spotinum/Documents/personalProjects/aiChatbot/training.py";

            // Create ProcessBuilder instance with the command and script path
            ProcessBuilder pb = new ProcessBuilder(pythonInterpreter, scriptPath);

            // Start the process
            Process process = pb.start();

            // Get the output stream of the process
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Read the output of the process
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Python script executed with exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
