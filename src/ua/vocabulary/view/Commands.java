package ua.vocabulary.view;

public interface Commands {
    String HELP = "-help";

    /**
     * Basic statement for command line to start operations with current
     * vocabulary
     */
    String OPERATE_V = "-vcb";

    /**
     * Additional keys for operations with vocabulary.
     * Variable names stats with 'V_'.
     *
     * -n   - creates the new file file that contains all words from the
     *      current vocabulary;
     * -a   - add the word to the current vocabulary;
     * -rm  - removes specified word from the current vocabulary;
     * -clr - removes all words from the current vocabulary;
     * -s   - saves the current vocabulary to last file;
     * -f   - save key that provides to add path to the new file;
     * -o   - open vocabulary from specified file;
     */
    String V_CREATE = "-n";
    String V_ADD = "-a";
    String V_REMOVE_WORD = "-rm";
    String V_CLEAR = "-clr";
    String V_SAVE = "-s";
    String S_FILE = "-f";
    String V_OPEN = "-o";

    /**
     * Key for test start.
     * Additional keys starts with 'T_'.
     * -test    - starts test with the current vocabulary;
     * -sfl     - randomly asks words from the current vocabulary; FIXME always shuffled.
     * -n       - asks words from current vocabulary with ascending order;
     * -f       - asks words from specified file instead of current vocabulary;
     * -non     - asks words without calculating results;
     * -loop    - asks words while -test -end will be called;
     * -end     - stop the current test.
     */
    String TEST = "-test";
    String T_SHUFFLED = "-sfl";
    String T_NATURAL = "-n";
    String T_REPATEDLY = "-loop";
    String T_NON_SCORE = "-non";
    String T_FILE = "-f";
    String T_STOP = "-end";

    /**
     * Loads the last vocabulary if exist.
     */
    String LAST = "-last";

    /**
     * Prints the current vocabulary.
     */
    String WORDS = "-words";
    String CLOSE = "-exit";
}
