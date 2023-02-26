/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.CommentService;
import interfaces.LikeService;
import interfaces.PostService;
import models.Post;
import models.User;
import util.MyConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manel
 */
public class PostImp implements PostService {
Connection cnx = MyConnection.getInstance().getCnx();
CommentService CommentService=new CommentImp();
LikeService likeImp=new LikeImp();
    @Override
    public void addPost(Post post) {
        try {
            String req = "INSERT INTO posts( content, IdUser, imageUrl) VALUES ( '"+post.getContent()+"',"+post.getUser().getId()+", '"+post.getImageUrl()+"' );";
            System.out.println(req);
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Post Added  successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return;
    }

    @Override
    public List<Post> getPostByIdUser(int idUser) {
        List<Post> posts = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM posts WHERE IdUser="+idUser;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Post p = new Post();
                p.setId(rs.getInt("ID"));
                p.setUser(new User(rs.getInt("IdUser")));
                p.setImageUrl(rs.getString(4));
                p.setContent(rs.getString(2));
                p.setComments(CommentService.getCommentByIdPost(rs.getInt("ID")));
                p.setLikes(likeImp.getLikesByIdPost(rs.getInt("ID")));
                posts.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return posts;    }

    @Override
    public void updatePost(Post post) {
        try {
            String req = "UPDATE `posts` SET `Content`='"+post.getContent()+"',`IdUser`="+post.getUser().getId()+",`ImageUrl`='"+post.getImageUrl()+"' WHERE ID="+post.getId();
            System.out.println(req);
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Post updated   successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return;

    }

    @Override
    public void deletePost(int id) {
  try {
            String req = "DELETE FROM `posts` WHERE ID="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Post deleted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Post getPostById(int id) {
       Post p = new Post();
        try {

            String req = "SELECT * FROM posts WHERE ID="+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                p.setId(rs.getInt("ID"));
                p.setUser(new User(rs.getInt("IdUser")));
                p.setImageUrl(rs.getString(4));
                p.setContent(rs.getString(2));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return p;
    }
 
}
