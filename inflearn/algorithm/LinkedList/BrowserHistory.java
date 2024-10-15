package inflearn.algorithm.LinkedList;

import java.util.LinkedList;

public class BrowserHistory {
    private LinkedList<String> history = new LinkedList<>();
    private int currentStep = 0;

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        System.out.println("null");
        System.out.println("null");
        System.out.println("null");
        System.out.println("null");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        System.out.println("null");
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }

    public BrowserHistory(String homepage) {
        this.history.add(homepage);
    }

    public void visit(String url) {
        if (this.currentStep < this.history.size() - 1) {
            this.history = new LinkedList<>(this.history.subList(0, this.currentStep + 1));
        }

        this.history.add(url);
        this.currentStep++;
    }

    public String back(int steps) {
        if (this.currentStep - steps <= 0) {
            this.currentStep = 0;
            return this.history.get(currentStep);
        }

        this.currentStep -= steps;
        return this.history.get(currentStep);
    }

    public String forward(int steps) {
        if (this.currentStep + steps >= this.history.size() - 1) {
            this.currentStep = this.history.size() - 1;
            return this.history.get(currentStep);
        }

        this.currentStep += steps;
        return this.history.get(currentStep);
    }
}
