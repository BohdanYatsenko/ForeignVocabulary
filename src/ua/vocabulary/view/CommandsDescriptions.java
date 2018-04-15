package ua.vocabulary.view;

public interface CommandsDescriptions {
    String HELP = String.format("%-6s - prints all commands, use additional key"
                    + " to call help for particular command", Commands.HELP);
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
    String LAST = String
            .format("%-6s - loads last vocabulary if exist", Commands.LAST);
    String WORDS = String
            .format("%-6s - show all words from the current vocabulary",
                    Commands.WORDS);

}
