package com.danny.calc;

/**
 * 命令介面
 */
public interface Command {

    void execute();

    void backup();

    void undo();
}
