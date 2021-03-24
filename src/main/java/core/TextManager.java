package core;

import models.FoundWord;
import models.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextManager {
    private final ExternalResources resources = new ExternalResources();
    public ArrayList<ArrayList<Word>> parsedText;

    public void parseText(String path, String resourceType) throws IOException {
        BufferedReader response;
        if (resourceType.equals("http")){
            response = this.resources.getText(path);
        } else if (resourceType.equals("local")) {
            response = this.resources.getFile(path);
        } else {
            return;
        }
        this.parsedText = this.getParsedText(response);
    }

    public ArrayList<ArrayList<Word>> getParsedText(BufferedReader response) throws IOException {
        StringBuilder text = new StringBuilder();

        String line;
        while ((line = response.readLine()) != null) {
            text.append(line);
            text.append("\n");
        }
        response.close();
        return this.getTextRows(text.toString());
    }

    public ArrayList<ArrayList<Word>> getTextRows(String text){
        ArrayList<ArrayList<Word>> rows = new ArrayList<>();

        for (String row: text.split("\n")) {
            ArrayList<Word> words = new ArrayList<>();
            for (String word : row.split(" ")) {
                words.add(new Word(word));
            }
            rows.add(words);
        }
        return rows;
    }


    public ArrayList<FoundWord> getWordRepeat(String shouldFind, ArrayList<ArrayList<Word>> rows){
        ArrayList<FoundWord> foundItems = new ArrayList<>();
        for(ArrayList<Word> row: rows){
            for(Word word: row) {
                if (word.getValue().replaceAll(" ", "").toLowerCase().equals(shouldFind.toLowerCase())) {
                    if (!word.isRead()) {
                        foundItems.add(new FoundWord(shouldFind, row.indexOf(word), rows.indexOf(row)));
                        word.markAsRead();
                    }
                }
            }
        }
        return foundItems;
    }

    public ArrayList<ArrayList<FoundWord>> getWordsRepeat(String[] words){
        ArrayList<ArrayList<FoundWord>> foundItems = new ArrayList<>();
        for(String word: words){
            foundItems.add(this.getWordRepeat(word, this.parsedText));
        }
        return foundItems;
    }
}
