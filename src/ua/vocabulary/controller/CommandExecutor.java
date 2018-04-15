package ua.vocabulary.controller;

import ua.vocabulary.model.CommandLoader;
import ua.vocabulary.model.Vocabulary;
import ua.vocabulary.model.VocabularyOnList;
import ua.vocabulary.model.Word;
import ua.vocabulary.view.CommandsDescriptions;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class CommandExecutor {

    private CommandExecutor() {}

    public static String executeHelp() {
        StringBuilder help = new StringBuilder();
        help.append(CommandsDescriptions.HELP).append("\n")
                .append(CommandsDescriptions.VCB).append("\n")
                .append(CommandsDescriptions.LAST);
        return String.valueOf(help);
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

    public static String executeVocabularyWords(Vocabulary vocabulary) {
        StringBuilder words = new StringBuilder();
        for (Word word : vocabulary.getVocabulary()) {
            words.append(word).append("\n");
        }
        return String.valueOf(words);
    }
}
