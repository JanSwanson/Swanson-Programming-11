import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            lines.add(line);
        }
        br.close();
        //Set the word to be found here - - - - - - o
        //                                          |
        //                                          V
        System.out.println(wordFinder(lines, ""));
    }

    public static ArrayList wordFinder (ArrayList<String> lines, String word){
        ArrayList indexOfWord = new ArrayList();
        if(word.length()>0) {
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                int tempIndex = line.indexOf(word);
                if (tempIndex < 0) {
                } else {
                    if ((tempIndex == 0 && isNotLetter(line.substring(tempIndex + word.length(), tempIndex + word.length() + 1))) || (isNotLetter(line.substring(tempIndex - 1, tempIndex)) && isNotLetter(line.substring(tempIndex + word.length(), tempIndex + word.length() + 1))) || (isNotLetter(line.substring(tempIndex - 1, tempIndex)) && tempIndex + word.length() - 1 == line.length()) || (tempIndex == 0 && word.length() - 1 == line.length())) {
                        indexOfWord.add(i);
                    }
                }
            }
        }
        return indexOfWord;
    }

    public static boolean isNotLetter (String letter){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        CharSequence letterChar = letter;
        if(alphabet.contains(letterChar)){
            return false;
        }
        else{
            return true;
        }
    }
}
