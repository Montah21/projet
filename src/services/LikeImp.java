/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.LikeService;
import models.Like;
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
public class LikeImp implements LikeService {
Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public void addLike(Like like) {
try {
            String req = "INSERT INTO `likes`(`IDPost`, `IdUser`, `IsLiked`) VALUES ("+like.getPost().getId()+","+like.getUser().getId()+", true)";
            System.out.println(req);
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Like Added  successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Like> getLikesByIdPost(int idPost) {
      List<Like> Likes = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM likes WHERE IDPost="+idPost;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Like l = new Like();
                Post post=new Post();
                post.setId(rs.getInt("IDPost"));
                l.setPost(post);
                l.setUser(new User(rs.getInt("IdUser")));
               l.setLiked(rs.getBoolean("IsLiked"));

              
               
                Likes.add(l);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
  
        
        return Likes;    }

    @Override
    public void dislike(Like like) {
try{
            String req = "UPDATE `likes` SET `IsLiked`=false WHERE IDPost ="+like.getPost().getId()+" and IdUser= "+like.getUser().getId();
            System.out.println(req);
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Post updated   successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
}

    @Override
    public void deleteLike(Like like) {
        try {
            String req = "DELETE FROM `likes` WHERE IDPost ="+like.getPost().getId()+" and IdUser= "+like.getUser().getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Like deleted successfully!");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean getLikeByIdUser(int idPost,int idUser) {
List<Like> Likes = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM likes WHERE IDPost="+idPost+" and IdUser= "+idUser;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Like l = new Like();
                Post post=new Post();
                post.setId(rs.getInt("IDPost"));
                l.setPost(post);
                l.setUser(new User(rs.getInt("IdUser")));
               l.setLiked(rs.getBoolean("IsLiked"));

              
               Likes.add(l);
               
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    return !Likes.isEmpty();
    }
    
}
