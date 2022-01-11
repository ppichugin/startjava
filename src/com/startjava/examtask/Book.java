package com.startjava.examtask;

public class Book {
    private String author;
    private String title;
    private int publishYear;

    public Book(String author, String title, int publishYear) {
        this.author = author;
        this.title = title;
        this.publishYear = publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishYear() {
        return publishYear;
    }

}
