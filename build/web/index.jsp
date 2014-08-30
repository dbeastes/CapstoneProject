<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="failBean" class="edu.acc.j2ee.capstone.model.FailBean" scope="session"/>
<jsp:useBean id="customer" class="edu.acc.j2ee.capstone.model.Customer" scope="session"/>
<c:if test="${customer.id > 0}"><c:redirect url="loggedIn.jsp"/></c:if>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="bootstrap.css">
        <title>Frame App Sign In</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="bg-info">
       
        
           
            <div class='text-center'>
               
                <div class="col-md-12">
                    <h1>Welcome to the Frame App</h1>
            
          </div>
               
             </div>
              
        <div class='container'>
            </br>
            <div class='col-md-4'></div>
            <div class="col-md-4">
        <form role="form" type='POST' action='SignInServlet'>
            <div class="form-group"><span style="color:red">${failBean.emailFail}</span> 
                <label >Email address:</label>
                <input type="email" class="form-control" name="email" placeholder="Enter email">
            </div>
            <div class="form-group">
                <label >Password:    </label>
                <input type="password" class="form-control"name="password" placeholder="Password">
            </div>

            <div class='col-md-6'>
            <button type="submit" class="btn btn-default">Submit</button>
            </div>
            <div class='col-md-6'>
            <a href='SignUpPage.jsp'>Register as new User</a>
            </div>
            
        </form>
        </div> 
     
        </div> 
      
    </body>
</html>
