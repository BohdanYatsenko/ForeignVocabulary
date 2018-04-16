package ua.vocabulary.view;

public interface CommandPatterns {
    String COMMAND = "^(-[\\w]+).*";
    String SIMPLE_COMMAND = "^(-[\\w]+)$";
    String COMMAND_KEY = "^(-[\\w]+) (?:(-[\\w]+))$";
    String COMMAND_KEY_PARAMETER = "^(-[\\w]+) (?:(-[\\w]+) ([a-z:\\/\\.]+))$";
    String CONFIRM = "^[yY+]$";
    String ABORT = "^[nN-]$";
}
