package ua.vocabulary.view;

public interface CommandsDescriptions {
    String HELP = String.format("%-6s - prints all commands, use additional key"
                    + " to call help for particular command.\n"
                    + "Command list\n[%s;\n%s;\n%s;\n%s;]\n",
                    Commands.HELP, Commands.OPERATE_V, Commands.TEST,
                    Commands.WORDS, Commands.CLOSE);
    String VCB = String.format("%-6s - to operations with vocabulary;",
            Commands.OPERATE_V);

    String VCB_KEYS = String
            .format("use keys:\n%-6s - to add new word to vocabulary;\n"
                            + "%-6s - to clear the current vocabulary;\n"
                            + "%-6s - to create new vocabulary;\n"
                            + "%-6s - to open an existing vocabulary;\n"
                            + "%-6s - to remove word from the current vocabulary;\n",
                    Commands.V_ADD, Commands.V_CLEAR, Commands.V_CREATE,
                    Commands.V_OPEN, Commands.V_REMOVE_WORD);
    String TEST = String
            .format("%-6s - operations with test flow", Commands.TEST);
    String TEST_KEYS = String
            .format("%-6s - start test with vocabulary natural order;\n"
                    + "%-6s - testing repeatedly until [-end];\n"
                    + "%-6s - testing without soring;\n"
                    + "%-6s - testing with vocabulary in specified file;\n"
                    + "%-6s - close current test;\n",
                    Commands.T_SHUFFLED, Commands.T_NATURAL, Commands.T_REPEATEDLY,
                    Commands.T_NON_SCORE, Commands.T_FILE, Commands.T_STOP);
    String LAST = String
            .format("%-6s - loads last vocabulary if exist", Commands.LAST);
    String WORDS = String
            .format("%-6s - show all words from the current vocabulary",
                    Commands.WORDS);
    String H_VCB = String.format("help [-vcb]:\n%s", VCB_KEYS);
    String H_TEST = String.format("help [-test]:\n%s", TEST_KEYS);
    String CLOSE = String.format("%-6s - end current test;", Commands.CLOSE);

}
