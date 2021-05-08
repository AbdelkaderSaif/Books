package com.example.books;

public class BookCases {
    public String AuthorName,Img,Price,TitleBook;

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getTitleBook() {
        return TitleBook;
    }

    public void setTitleBook(String titleBook) {
        TitleBook = titleBook;
    }

    public BookCases(String authorName, String img, String price, String titleBook) {
        AuthorName = authorName;
        Img = img;
        Price = price;
        TitleBook = titleBook;
    }
}
