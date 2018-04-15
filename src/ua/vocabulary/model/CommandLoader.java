package ua.vocabulary.model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CommandLoader {
    private static String DEFAULT_PATH = "resources/cmds.vcmd";

    /**
     * Loads commands and its code representation by specified file path
     *
     * @param path file that describes UI commands
     * @return set of commands with its codes
     * @throws IOException if resources file is not exist
     */
    public static Map<String, Integer> loadCommands(String path)
            throws IOException {
        Map<String, Integer> commands = new HashMap<>();
        File file = new File(DEFAULT_PATH);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] strings = currentLine.split("=");
                commands.put(strings[0], Integer.parseInt(strings[1]));
            }
        }
        return commands;
    }

    /**
     * Loads existing commands and its codes from default resources file:
     * {@value DEFAULT_PATH}.
     *
     * @return set of commands as {@code Map<name, code>}
     * @throws IOException
     */
    public static Map<String, Integer> loadCommands() throws IOException {
        return loadCommands(DEFAULT_PATH);
    }
}
