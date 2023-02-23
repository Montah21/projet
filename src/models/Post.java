/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manel
 */
public class Post {
    private int id;
    private String content;
    private String imageUrl;
    private User user;
    List<Comment> comments=new ArrayList<>();
    List<Like> likes=new ArrayList<>();

    public Post() {

    }

    public Post(int id, String content, String imageUrl, User user) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
        this.user = user;
    }

    public Post(String content, String imageUrl, User user) {
        this.content = content;
        this.imageUrl = imageUrl;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public User getUser() {
        return user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", user=" + user +
                ", comments=" + comments +
                ", likes=" + likes +
                '}';
    }
}
