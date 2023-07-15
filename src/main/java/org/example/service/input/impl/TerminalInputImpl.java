package org.example.service.input.impl;

import org.example.service.input.TerminalInput;

import java.util.Scanner;

public class TerminalInputImpl implements TerminalInput {

    private final Scanner scanner;

    public TerminalInputImpl(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public String readLine() {
        //valid
        return scanner.nextLine();
    }

    @Override
    public int readInt() {
        return Integer.parseInt(readLine());
    }
}
