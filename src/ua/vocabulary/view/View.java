package ua.vocabulary.view;

public interface View {

    /**
     * Shows menu to screen
     */
    void showMenu();

    /**
     * Shows supported commands for use vocabulary
     */
    void showCommands();

    /**
     * Asks for translations of words from vocabulary
     */
    void startTesting();

    /**
     * Return user's score for the last test.
     */
    void showResults();

}
