package com.frankmoley.lil.designpatternsapp.command;

public interface Command {
    Stock getStock();
    void execute();
}
