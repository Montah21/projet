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
public class Like {
    private Post post;
    private User user;
    private boolean isLiked;

    public Like() {
    }

    public Like(Post post, User user, boolean isLiked) {
        this.post = post;
        this.user = user;
        this.isLiked = isLiked;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    @Override
    public String toString() {
        return "Like{" +
                "post=" + post +
                ", user=" + user +
                ", isLiked=" + isLiked +
                '}';
    }
}
