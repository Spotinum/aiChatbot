package org.example;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class chatBotProcess {

    public String thinkAnswer(String givenWord) {
        try {
            //Read the JSON file
            String jsonContent = new String(Files.readAllBytes(Paths.get("intents.json")));

            //Parse the JSON content
            JSONObject jsonObject = new JSONObject(jsonContent);

            //Get the intents array
            JSONArray intentsArray = jsonObject.getJSONArray("intents");
            String[] givenWords = givenWord.split("[\\s,.!?]+");
            Integer mostCommonCount = 0;
            Integer intentIndex = 0;


            //Iterate through the intents array
            for (int i = 0; i < intentsArray.length(); i++) {
                //Get the patterns array
                JSONObject intentObj = intentsArray.getJSONObject(i);
                JSONArray patternsArray = intentObj.getJSONArray("patterns");

                //Iterate through the patterns array
                for (int j = 0; j < patternsArray.length(); j++) {
                    String pattern = patternsArray.getString(j);
                    //Split the pattern into individual words
                    String[] words = pattern.split("[\\s,.!?]+");
                    Integer count = 0;
                    for (String word : words) {
                        for(String given : givenWords){
                            //Check if the given word is present in the pattern
                            if(word.toLowerCase().equals(given.toLowerCase())){
                                count++;
                            }
                        }
                    }
                    //if the word appeared in this intents Pattern then it should be correct
                    if(count > mostCommonCount){
                        mostCommonCount = count;
                        intentIndex = i;
                    }
                }

            }
            //Get the responses array
            JSONArray responsesArray = intentsArray.getJSONObject(intentIndex).getJSONArray("responses");
            //Get a random response
            int randomIndex = (int) (Math.random() * responsesArray.length());
            String response = responsesArray.getString(randomIndex);
            return response;

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return "Sorry, I didn't get that. Can you please repeat?";
    }
}
