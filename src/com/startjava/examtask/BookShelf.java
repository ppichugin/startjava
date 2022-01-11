package com.startjava.examtask;

import java.util.Scanner;

public class BookShelf {
    private static int numOfBooks;
    private static Book[] books = new Book[10];

    static void start() {
        // для тестов
        books[0] = new Book("Bruce Eckel", "Thinking in Java", 2015);
        books[1] = new Book("Josh Long", "Cloud Native Java", 2019);
        books[3] = new Book("Lynn Beighley", "Head First SQL", 2012);
        numOfBooks = 3;
        // начало интерактива
        Scanner sc = new Scanner(System.in);
        int answerCode;
        do {
            showAllBooks();
            System.out.println("\nМЕНЮ: ");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Удалить книгу");
            System.out.println("3. Переместить книгу");
            System.out.println("4. Найти книгу по названию");
            System.out.println("5. Вывести число всех книг");
            System.out.println("6. Вывести количество свободного пространства");
            System.out.println("7. Выход");
            System.out.print("Введите номер: ");
            answerCode = sc.nextInt();
            switch (answerCode) {
                case 1 -> addBook();
                case 2 -> {
                    System.out.print("Укажите позицию где нужно удалить книгу: ");
                    int position = sc.nextInt();
                    deleteBook(position);
                }
                case 3 -> {
                    System.out.print("Укажите исходную позицию: ");
                    int srcPosition = sc.nextInt();
                    System.out.print("Укажите новую позицию: ");
                    int destination = sc.nextInt();
                    moveBook(srcPosition, destination);
                }
                case 4 -> {
                    System.out.print("Введите фрагмент названия книги для поиска: ");
                    sc.nextLine();
                    String bookToBeFound = sc.nextLine();
                    findBook(bookToBeFound);
                }
                case 5 -> System.out.println("\nВсего на полке книг: " + numOfBooks + " шт.");
                case 6 -> showFreeSpace();
                case 7 -> System.out.println("Спасибо, что воспользовались нашей программой.");
                default -> System.out.println("Введите корректный номер от 1 до 7.");
            }
        } while (answerCode != 7);
    }

    static void addBook() {
        if (numOfBooks == 10) {
            System.out.println("Невозможно добавить книгу. Нет свободного места.");
        } else {
            int indexFreeSpace = 0;
            for (int i = 0; i < books.length; i++) {
                if (books[i] == null) {
                    indexFreeSpace = i;
                    break;
                }
            }
            System.out.println("Добавляем книгу");
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите автора: ");
            String author = sc.nextLine();
            System.out.print("Введите название: ");
            String title = sc.nextLine();
            System.out.print("Введите год издания: ");
            int year = sc.nextInt();
            books[indexFreeSpace] = new Book(author, title, year);
            numOfBooks++;
            System.out.println("Книга добавлена");
        }
    }

    static void deleteBook(int position) {
        if (books[position - 1] == null) {
            System.out.println("Удаление невозможно. В этой позиции нет книги.");
            return;
        }
        books[position - 1] = null;
        System.out.println("Книга удалена");
    }

    static void findBook(String bookTitleToFind) {
        boolean isBookFound = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                continue;
            }
            if (books[i].getTitle().toLowerCase().contains(bookTitleToFind.toLowerCase())) {
                System.out.println("Книга, содержащая '" + bookTitleToFind + "' в названии находится в ячейке: " + (i + 1));
                System.out.println("Автор: " + books[i].getAuthor());
                System.out.println("Название: " + books[i].getTitle());
                System.out.println("Год издания: " + books[i].getPublishYear());
                isBookFound = true;
            }
        }
        if (!isBookFound) {
            System.out.println("Такая книга не найдена на полке.");
        }
    }

    static void showAllBooks() {
        System.out.print("\nСостояние книжной полки: ");
        System.out.print("|");
        for (Book bk : books) {
           if (bk != null) {
               System.out.print("\uD83D\uDD6E|");
           } else {
               System.out.print("_|");
           }
        }
        System.out.println("");
    }

    static void showFreeSpace() {
        System.out.print("\nНа полке имеется " + (10 - numOfBooks) + " свободных мест под номерами: ");
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println("");
    }

    static void moveBook(int source, int destination) {
        if (source == destination) {
            System.out.println("Исходная и новая позиции не могут бытть одинаковыми!");
            return;
        }
        if (source < 1 || source > 10) {
            System.out.println("Недопустимая исходная позиция. Проверьте и повторите ввод.");
            return;
        } else if (books[source - 1] == null) {
            System.out.println("Исходная позиция пустая. Нечего переместить с исходной позиции.");
            return;
        }
        if (destination < 1 || destination > 10) {
            System.out.println("Недопустимая новая позиция. Проверьте и повторите ввод.");
            return;
        } else if (books[destination - 1] != null) {
            System.out.println("Новая позиция занята. Перемещение не возможно.");
            return;
        }
        books[destination - 1] = books[source - 1];
        books[source - 1] = null;
        System.out.println("Книга перемещена");
    }
}
