package com.learning.collections.list;

/* Save history of last user activity */

import java.util.Deque;
import java.util.LinkedList;

public class HistoryManager {
    public final Deque<String> history = new LinkedList<String>();
    public final int MAX_SIZE = 5;

    public void printHistory() {
        int i = 1;
        for (String el : history) {
            System.out.println(i++ + ". " + el);
        }
        System.out.println();
    }

    public void addStep(String step) {
        if (history.size() == MAX_SIZE) {
            history.removeLast();
        }
        history.addFirst(step);
    }

    public static void main(String[] args) {
        HistoryManager manager = new HistoryManager();

        manager.addStep("Add some text");
        manager.addStep("Create new file");
        manager.printHistory();

        manager.addStep("Refactor code");
        manager.addStep("Create new file");
        manager.addStep("Rename file");
        manager.printHistory();

        manager.addStep("Add new param to function");
        manager.printHistory();
    }
}
