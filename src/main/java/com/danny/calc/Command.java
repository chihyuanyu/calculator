package com.danny.calc;

public interface Command {

    void execute();

    void backup();

    void undo();
}
