/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicesETinter;
import Entity.materiel;
/**
 *
 * @author Emna
 */
public class serviceControlMAt {
      public static boolean Controlechar(String m) {
		String str = (m).toLowerCase();
                if (str.length() == 0)
                    return false;
		char[] charArray = str.toCharArray();
                
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (!((ch >= 'a' && ch <= 'z') || (String.valueOf(ch)).equals(" "))) {
				return false;
			}
		}
		return true;
	}

public boolean isNumeric(String text) {
             if (text == null || text.trim().equals("")) {
                 return false;
             }
             for (int iCount = 0; iCount < text.length()-3; iCount++) {
                 if (!Character.isDigit(text.charAt(iCount))) {
                    return false;
               }
           }
            return true;
        }
    
}
