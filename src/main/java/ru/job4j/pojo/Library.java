package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookFirst = new Book("War And Piece", 100500);
        Book bookSecond = new Book("Idiot", 250);
        Book bookThird = new Book("The Three Musketeers", 420);
        Book bookFourth = new Book("Clean code", 464);
        Book[] books = new Book[4];
        books[0] = bookFirst;
        books[1] = bookSecond;
        books[2] = bookThird;
        books[3] = bookFourth;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " : " + book.getPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Replace 0 and 3");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " : " + book.getPages());
        }
        System.out.println("Clean code conclusion");
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " : " + book.getPages());
            }
        }
    }
}
