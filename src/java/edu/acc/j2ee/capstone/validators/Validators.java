/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.acc.j2ee.capstone.validators;

import edu.acc.j2ee.capstone.model.FailBean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dustineastes
 */
public class Validators {
    
    
    
    private static final String emailPattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
    
    public static Pattern pattern = Pattern.compile(emailPattern);  
    public static Matcher matcher;
    public static FailBean fail = new FailBean();

   
   
        
public static FailBean validateInputs(HttpServletRequest request) {
    String fname = (String) request.getParameter("firstName");
    String lname = (String) request.getParameter("lastName");
    String password = (String) request.getParameter("password");
    String email = (String) request.getParameter("email");
    
    matcher = pattern.matcher(email);
    if(matcher.find()){
        fail.setEmailFail("");
        if(fname.length() > 0 ){
            fail.setfNameFail("");
            if(lname.length() > 0){
                fail.setlNameFail("");
                if(password.length() > 0 ){
                    fail.setPassFail("");
                    fail.setNoErrors(true);
                } else fail.setPassFail("Not a valid Passord");
            }else fail.setlNameFail("Not a Valid Last Name");
        }else fail.setfNameFail("Not a Valid First Name");   
    } else fail.setEmailFail("Not a Valid E-mail");
  return fail;  
} 
    
    
}
