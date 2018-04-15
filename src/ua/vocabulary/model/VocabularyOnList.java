package ua.vocabulary.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class VocabularyOnList implements Vocabulary {
    private List<Word> vocabulary;

    /*FIXME*/
    public static void main(String[] args) {
        Vocabulary a = new VocabularyOnList();
        System.out.println(a.getVocabulary());
        a.addWord("add", "додати");
        a.addWord("add", "додати");
        a.addWord("add", "додати");
        a.save("vcb");
        System.out.println(a.load("vcb"));
        System.out.println(a.getVocabulary());
    }

    public VocabularyOnList() {
        vocabulary = new ArrayList<>();
    }

    public VocabularyOnList(List<Word> vocabulary) {
        this.vocabulary = vocabulary;
    }

    @Override
    public boolean addWord(Word wordAndTranslation) {
        if (!isWordEmpty(wordAndTranslation)) {
            return vocabulary.add(wordAndTranslation);
        } else {
            return false;
        }
    }

    @Override
    public List<Word> getVocabulary() {
        return vocabulary;
    }

    @Override
    public boolean save(String fileName) {
        return save(fileName, false);
    }

    @Override
    public boolean save(String fileName, boolean append) {
        File file = new File(fileName + ".txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            for (Word word: vocabulary) {
                String learn = word.getLearn();
                String know = word.getKnow();
                fileWriter.write(learn + "/" + know + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            return false;
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Word> load(String fileName) {
        File vocabularyFile = new File(fileName + ".txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(vocabularyFile);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                Word word = new Word();
                String[] wordsFromVocabulary = scanner.nextLine().split("/");
                word.setLearn(wordsFromVocabulary[0]);
                word.setKnow(wordsFromVocabulary[1]);
                vocabulary.add(word);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (fileReader != null) {
                fileReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vocabulary;
    }

    public boolean addWord(String learn, String known) {
        Word currentWord = new Word(learn, known);
        return vocabulary.add(currentWord);
    }

    @Override
    public Word getWord() {
        Random random = new Random();
        return vocabulary.get(random.nextInt(vocabulary.size()));
    }

    /**
     * Checks is the specified word has not any of its parts.
     *
     * @param word a pair word and its translation
     * @return true if word has not word or translation or both
     */
    private boolean isWordEmpty(Word word) {
        if (word != null) {
            if ((word.getLearn() != null) && (word.getKnow() != null)) {
                if (!word.getLearn().equals("") || !word.getKnow().equals("")) {
                    return true;
                }
            }
        }
        return false;
    }
}
