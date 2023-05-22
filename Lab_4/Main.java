import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "text.txt";
        String wordList = "word1,word2,word3"; // Список слов через запятую

        // Чтение текста из файла
        String textContent = readTextFromFile(filePath);

        // Создание объекта Text и разбиение текста на предложения
        Text text = parseText(textContent);

        // Создание списка слов из заданного списка
        List<Word> words = createWordList(wordList);

        // Подсчет количества вхождений слов в каждом предложении
        countOccurrences(text, words);

        // Сортировка слов по убыванию общего количества вхождений
        Collections.sort(words, (w1, w2) -> Integer.compare(w2.getCount(), w1.getCount()));

        // Вывод результатов
        for (Word word : words) {
            System.out.println("Word: " + word.getWord() + ", Total Count: " + word.getCount());
        }
    }

    private static String readTextFromFile(String filePath) {
        StringBuilder textContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textContent.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return textContent.toString().trim();
    }

    private static Text parseText(String textContent) {
        Text text = new Text();

        String[] sentences = textContent.split("[.!?]");

        for (String sentence : sentences) {
            Sentence sentenceObj = new Sentence();

            String[] words = sentence.split("\\s+");

            for (String word : words) {
                sentenceObj.addWord(new Word(word));
            }

            text.addSentence(sentenceObj);
        }

        return text;
    }

    private static List<Word> createWordList(String wordList) {
        List<Word> words = new ArrayList<>();

        String[] wordArray = wordList.split(",");

        for (String word : wordArray) {
            words.add(new Word(word));
        }

        return words;
    }

    private static void countOccurrences(Text text, List<Word> words) {
        for (Sentence sentence : text.getSentences()) {
            for (Word word : sentence.getWords()) {
                for (Word targetWord : words) {
                    if (word.getWord().equalsIgnoreCase(targetWord.getWord())) {
                        targetWord.incrementCount();
                    }
                }
            }
        }
    }
}