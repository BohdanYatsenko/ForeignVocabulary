package ua.vocabulary.controller;

import sun.security.krb5.internal.PAData;
import ua.vocabulary.model.CommandLoader;
import ua.vocabulary.model.Vocabulary;
import ua.vocabulary.view.CommandLineView;
import ua.vocabulary.view.CommandPatterns;
import ua.vocabulary.view.CommandsDescriptions;
import ua.vocabulary.view.View;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineHandler {
    /**
     * Current controller, view;
     */
    private static CommandLineHandler process;
    private View view;
    private Vocabulary vocabulary;
    private static Map<String, Integer> commands;

    private static final String ERROR_MESSAGE =
            "No such command try: " + CommandsDescriptions.HELP;

    public static void main(String[] args) {
        process = new CommandLineHandler();
        process.process();
    }

    public CommandLineHandler() {
        view = new CommandLineView();
    }

    private void process() {
        int executedCommandCode = 0;
        try {
            commands = CommandLoader.loadCommands();
        } catch (IOException e) {
            view.showProcess("cmd commands are unknown\n"
                    + "check your resources directory");
        }
        do {
            view.showMenu();
            String request = view.readCommandLine();
            executedCommandCode = requestParser(request);
        } while (!(executedCommandCode == -1));
    }

    private int requestParser(String request) {
        request = request.trim();
        int executedCommandCode = 0;
        Pattern command = Pattern.compile(CommandPatterns.COMMAND);
        Matcher matcher = command.matcher(request);
        if (matcher.find()) {
            executedCommandCode = commandParser(request);
        }
        return executedCommandCode; /*FIXME*/
    }

    /**
     * Checks what kind of command is requested by user.
     *
     * @param request command string
     * @return
     */
    private int commandParser(String request) {
        Pattern command = Pattern.compile(CommandPatterns.SIMPLE_COMMAND);
        Matcher matcher = command.matcher(request);
        if (matcher.find()) {
            int commandCode = commands.get(matcher.group(1));
            switch (commandCode) {
            case -1:
                view.showProcess("bye bye");
                return commandCode;
            case 0:
                view.showProcess(CommandExecutor.executeHelp(), "\n");
                return commandCode;
            case 1:
                view.showProcess(CommandExecutor.executeVocabularyHelp());
                return commandCode;
            case 3:
                /*TODO commandExecutor load vocabulary from file (last in memory)*/
                vocabulary = CommandExecutor.executeLastVocabulary();
                if (vocabulary != null) {
                    view.showProcess("<|success|>");
                }
                return commandCode;
            case 4:
                /*TODO what program should to do when it reads simple command
                 * TODO if it -vcb - show help message
                 * TODO if it -help - show help
                 * TODO if it -vcb -o path - must return Vocabulary object from path*/
                if (vocabulary != null) {
                    view.showProcess("Current vocabulary: [",
                            CommandExecutor.executeVocabularyWords(vocabulary),
                            "]");
                } else {
                    view.showProcess("Vocabulary is empty.",
                            "Load add new words or load from existing vocabulary");
                }
                return commandCode;
            }
        } else {
            command = Pattern.compile(CommandPatterns.COMMAND_KEY);
            matcher = command.matcher(request);
            if (matcher.find()) {
                int commandCode = commands.get(matcher.group(1));
                int keyCode = commands.get(matcher.group(2));
                switch (commandCode) {
                case 0:
                    view.showProcess(CommandExecutor.executeHelp(keyCode));
                    return (1 + commandCode + keyCode);
                case 1: /*each method returns updated Vocabulary*/
//                    vocabulary = CommandExecutor./*FIXME*/
                    vocabulary = CommandExecutor.executeVocabulary(keyCode);
                    break;
                default:
                    view.showProcess(ERROR_MESSAGE);
                    return 0;
                }
            } else {
                command = Pattern.compile(CommandPatterns.COMMAND_KEY_PARAMETER);
                matcher = command.matcher(request);
                if (matcher.find()) {
                    System.out.println("com + param" + request);
                }
            }
        } return 0; /*FIXME*/
    }

    public static String cooperate(int askCode) {
        return process.userCooperate(askCode);
    }

    /*FIXME external*/
    private String userCooperate(int askCode) {
        String request = "";
        switch (askCode) {
        case -1:
            view.showProcess("Are you want to remove specified word?");
            request = view.readCommandLine();
            break;
        case -11:
            view.showProcess("Canceled.");
        case -2:
            view.showProcess("Are you sure want to clear vocabulary?");
            request = view.readCommandLine();
            break;
        case 3:
            view.showProcess("Enter path to save.");
            request = view.readCommandLine();
        }
        if (askCode < 0) {
            Pattern userAnswer = Pattern.compile(CommandPatterns.CONFIRM);
            Matcher matcher = userAnswer.matcher(request);
            if (matcher.find()) {
                return "true";
            } else {
            userAnswer = Pattern.compile(CommandPatterns.ABORT);
            matcher = userAnswer.matcher(request);
            if (matcher.find()) {
                return "false";
            }
            }
        }
        return null;
    }
}
