import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import models.FoundWord;
import core.TextManager;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Http or local?");
        String type = scanner.nextLine().toLowerCase();

        System.out.println("Url");
        String url = scanner.nextLine();
        TextManager manager = new TextManager();

        manager.parseText(url, type);
        String[] words = {"lorem", "ipsum", "dolor"};
        ArrayList<ArrayList<FoundWord>> finds = manager.getWordsRepeat(words);
        System.out.println(finds);
    }
}
