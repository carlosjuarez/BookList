package com.juvcarl.batch.mcs.booklist.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("author")
    @Expose
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Item withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Item withImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Item withAuthor(String author) {
        this.author = author;
        return this;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}