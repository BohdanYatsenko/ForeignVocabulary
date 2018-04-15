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
     * Current answer from controller.
     */
    void showProcess(String... args);
    /**
     * Return user's score for the last test.
     */
    void showResults(String score);

    /**
     * Gets data from command line and should redirect it to controller layer.
     */
    String readCommandLine();

}
