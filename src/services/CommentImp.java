/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.CommentService;
import interfaces.PostService;
import models.Comment;
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
public class CommentImp implements CommentService {
Connection cnx = MyConnection.getInstance().getCnx();
//    private PostService postService= new PostImp();
    @Override
    public void addComment(Comment comment) {


 try {
            String req = "INSERT INTO `comments`(`IdPost`, `Content`, `IdUser`, `ImageUrl`)"
                    + " VALUES ("+comment.getPost().getId()+",'"+comment.getContent()+"',"+comment.getUser().getId()+",'"+comment.getImageUrl()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Comment Added  successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    @Override
    public List<Comment> getCommentByIdPost(int idPost) {
       List<Comment> Comments = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM comments WHERE IdPost="+idPost;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Comment c = new Comment();
                c.setId(rs.getInt("ID"));
                User user=new User(rs.getInt("IdUser"));
              //  c.setPost(postService.getPostById(idPost));
                c.setUser(user);
                c.setImageUrl(rs.getString(5));
                c.setContent(rs.getString(3));
              
               
                Comments.add(c);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Comments;    }

    @Override
    public void updateComment(Comment comment) {
        try {
            String req = "UPDATE `comments` SET `IdPost`="+comment.getPost().getId()+",`Content`='"+comment.getContent()+"',`IdUser`="+comment.getUser().getId()+",`ImageUrl`='"+comment.getImageUrl()+"'  WHERE ID="+comment.getId();
            System.out.println(req);
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Comment updated   successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }




    @Override
    public void deleteComment(int idComment) {
        try {
            String req = "DELETE FROM `comments` WHERE ID="+idComment;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Comment deleted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
