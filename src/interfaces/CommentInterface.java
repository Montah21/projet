/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Comment;

import java.util.List;

/**
 *
 * @author Manel
 */
public interface CommentInterface {
  public void addComment(Comment comment);
  public List<Comment> getCommentByIdPost(int idPost); 
  public void updateComment(Comment comment);
  public void deleteComment(int idComment);
  
}
