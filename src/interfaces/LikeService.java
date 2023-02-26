/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Like;

import java.util.List;

/**
 *
 * @author Manel
 */
public interface LikeService {
  public void addLike(Like like);
  public List<Like> getLikesByIdPost(int idPost); 
  public void dislike(Like like);
  public void deleteLike(Like like);

     public boolean getLikeByIdUser(int idPost,int idUser);
}
