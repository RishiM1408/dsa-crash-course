package com.dsa.systemdesign;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 1472: Design Browser History
 *
 * Pattern: Dynamic Array + Pointer
 * Visit: clear forward history, add new, move pointer.
 * Back/Forward: move pointer bounded.
 */
public class DesignBrowserHistory {

    private List<String> history;
    private int curr;

    public DesignBrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
    }

    public void visit(String url) {
        // Clear forward history
        while (history.size() > curr + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        curr++;
    }

    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }

    public String forward(int steps) {
        curr = Math.min(history.size() - 1, curr + steps);
        return history.get(curr);
    }

    public static void main(String[] args) {
        DesignBrowserHistory browser = new DesignBrowserHistory("leetcode.com");
        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");

        System.out.println("Back 1: " + (browser.back(1).equals("facebook.com") ? "PASS" : "FAIL"));
        System.out.println("Back 1: " + (browser.back(1).equals("google.com") ? "PASS" : "FAIL"));
        System.out.println("Forward 1: " + (browser.forward(1).equals("facebook.com") ? "PASS" : "FAIL"));

        browser.visit("linkedin.com"); // History: leet, google, facebook, linkedin
        System.out.println("Forward 2: " + (browser.forward(2).equals("linkedin.com") ? "PASS" : "FAIL"));
        System.out.println("Back 2: " + (browser.back(2).equals("google.com") ? "PASS" : "FAIL"));
    }
}
