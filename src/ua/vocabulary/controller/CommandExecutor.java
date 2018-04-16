package ua.vocabulary.controller;

import ua.vocabulary.model.ResourcesPaths;
import ua.vocabulary.model.Vocabulary;
import ua.vocabulary.model.VocabularyOnList;
import ua.vocabulary.model.Word;
import ua.vocabulary.view.Commands;
import ua.vocabulary.view.CommandsDescriptions;
import ua.vocabulary.view.View;

public class CommandExecutor {
    private static Vocabulary vocabulary = new VocabularyOnList();

    private CommandExecutor() {
    }

    /**
     * Forms simple help message.
     *
     * @return message that contains supportable commands and descriptions
     */
    public static String executeHelp() {
        StringBuilder help = new StringBuilder();
        help.append(CommandsDescriptions.HELP).append("\n");
        return String.valueOf(help);
    }

    public static String executeHelp(int commandCode) {
        StringBuilder help = new StringBuilder();
        switch (commandCode) {
        case -1:
            help.append(CommandsDescriptions.CLOSE);
            return String.valueOf(help);
        case 1:
            help.append(CommandsDescriptions.H_VCB);
            return String.valueOf(help);
        case 2:
            help.append(CommandsDescriptions.H_TEST);
            return String.valueOf(help);
        case 3:
            help.append(CommandsDescriptions.LAST);
            return String.valueOf(help);
        case 4:
            help.append(CommandsDescriptions.WORDS);
            return String.valueOf(help);
        default:
            return executeHelp();
        }
    }

    public static String executeVocabularyHelp() {
        StringBuilder vocabularyHelp = new StringBuilder();
        vocabularyHelp.append(CommandsDescriptions.VCB).append("\n")
                .append(CommandsDescriptions.VCB_KEYS);
        return String.valueOf(vocabularyHelp);
    }

    public static Vocabulary executeLastVocabulary() {
        /*TODO at the end of testing save/serialize current vocabulary
         * TODO deserialize it here.*/
        return new VocabularyOnList();
    }

    public static Vocabulary executeVocabulary(int key) {
        switch (key) {
        case 14:
           if (new Boolean(CommandLineHandler.cooperate(-1))) {
               vocabulary.getVocabulary().clear();
           } else {
               CommandLineHandler.cooperate(10 * key);
           }
            return vocabulary;
        case 15:
            vocabulary.save(ResourcesPaths.DEFAULT_PATH);
            return vocabulary;/*FIXME Saved vocabulary*/
        case 17:
            vocabulary.load(ResourcesPaths.DEFAULT_PATH);
            return vocabulary;
        default:
            return vocabulary;
        }
    }

    public static String executeVocabularyWords(Vocabulary vocabulary) {
        StringBuilder words = new StringBuilder();
        for (Word word : vocabulary.getVocabulary()) {
            words.append(word).append("\n");
        }
        return String.valueOf(words);
    }
}
