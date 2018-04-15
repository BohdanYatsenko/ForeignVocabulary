package ua.vocabulary.model;

import java.util.List;

public interface Vocabulary {

    /**
     * Provides to add new word to vocabulary as pair learned:known.
     *
     * @param learn word in learned language
     * @param know translation to your native language
     * @return true if additions was successful, false elsewhere
     */
    boolean addWord(String learn, String know);

    /**
     * Add new word to vocabulary as two not null Strings.
     *
     * @param wordAndTranslation {@link Word} with that contains two not null String
     * @return true if addition was successful
     */
    boolean addWord(Word wordAndTranslation);

    /**
     * Provides to collect some word from vocabulary.
     *
     * @return random {@link Word}
     */
    Word getWord();

    /**
     * Prints all words from the current vocabulary.
     *
     * @return {@code List<Word>}
     */
    List<Word> getVocabulary();

    /**
     * Loads an exist vocabulary
     *
     * @param fileName file to load from
     * @return vocabulary with words and its translations
     */
    List<Word> load(String fileName);

    /**
     * Saves current vocabulary to specified file.
     *
     * @return true if file saved successful
     */
    boolean save(String fileName);

    /**
     * Saves current vocabulary to specified file with support append mode.
     *
     * @param fileName path to file or directory to save vocabulary
     * @param append true for append to the current file, false for rewrite.
     * @return true if file saved successful
     */
    boolean save(String fileName, boolean append);

}
