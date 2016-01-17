package com.company;

/**
 * Created by Marti on 14/01/16.
 */

public class Question2 {
    public  static void main(String[] args) {
        new Question2().showFile();
    }

    private String getFileName() {
        Input in = new Input();
        while (true) {
            System.out.print("Please enter a file name:");
            if (in.hasNext()) {
                return in.next();
            }
            System.out.print("You didn't type anything, try again.");
        }
    }

    private void printFileContent(String fileName) {
        FileInput file = new FileInput(fileName);
        while (file.hasNextLine()) {
            System.out.println(file.nextLine());
        }
        file.close();
    }

    public  void showFile() {
        printFileContent(getFileName());
    }
}
