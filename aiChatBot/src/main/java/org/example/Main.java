package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        chatBotProcess chatBot = new chatBotProcess();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chat is Active");
        while(true){
            System.out.println("You: ");
            //give input
            String givenWord = scanner.nextLine();
            System.out.println("Hua Bot: "+chatBot.thinkAnswer(givenWord));
        }
    }
}