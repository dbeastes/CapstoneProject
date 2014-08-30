/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.acc.j2ee.capstone.validators;

import edu.acc.j2ee.capstone.model.Customer;
import java.util.List;

/**
 *
 * @author dustineastes
 */
public class Finders {
    
    public static Customer findCustomer( List<Customer> customerList, String email){
    
        
        Customer foundCustomer = null;
     
        for (Customer customer : customerList){
            
           
            
            if (customer.getEmail().equals( email )){
                foundCustomer = customer;
               
            }
         
       }
       return foundCustomer;
    
    }
    
}
