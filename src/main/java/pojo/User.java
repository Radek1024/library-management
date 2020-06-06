package pojo;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private String name;
    private String lastName;
    private String address;
    private int booksRented;
    private String book;
    private LocalDate beginning;
    private LocalDate end;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBooksRented() {
        return booksRented;
    }

    public void setBooksRented(int booksRented) {
        this.booksRented = booksRented;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public LocalDate getBeginning() {
        return beginning;
    }

    public void setBeginning(LocalDate beginning) {
        this.beginning = beginning;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", booksRented=" + booksRented +
                ", book=" + book +
                ", beginning=" + beginning +
                ", end=" + end +
                '}';
    }
}
