package ua.vocabulary.view;

import ua.vocabulary.controller.CommandLineHandler;

import java.util.Scanner;

public class CommandLineView implements View {
    @Override
    public void showMenu() {
        System.out.println("english learning through test");
        System.out.println("_____________________________");
    }

    @Override
    public void showCommands() {
        System.out.println(CommandsDescriptions.VCB);
        System.out.println(CommandsDescriptions.HELP);
    }

    @Override
    public void showProcess(String... args) {
        for (String state : args) {
            System.out.println(state);
        }
    }

    @Override
    public void showResults(String score) {

    }

    @Override
    public String readCommandLine() {
        Scanner commandLine = new Scanner(System.in);
        return commandLine.nextLine();
    }
}
