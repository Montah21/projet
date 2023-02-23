/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Manel
 */
public class Comment {
    private int id;
    private Post post;
    private String content;
    private String imageUrl;
    private User user;

    public Comment() {
    }

    public Comment(Post post, String content, String imageUrl, User user) {
        this.post = post;
        this.content = content;
        this.imageUrl = imageUrl;
        this.user = user;
    }

    public Comment(int id, Post post, String content, String imageUrl, User user) {
        this.id = id;
        this.post = post;
        this.content = content;
        this.imageUrl = imageUrl;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", post=" + post +
                ", content='" + content + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", user=" + user +
                '}';
    }
}
