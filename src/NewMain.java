
import interfaces.PostService;
import services.PostImp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   PostService pi=new PostImp() ;
  // postService pi1=new PostService (.);
      pi.deletePost(1);
        System.out.println(pi.getPostByIdUser(1) );
      
        
    }
    
    
}
