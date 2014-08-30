<%-- 
    Document   : loggedIn
    Created on : Jul 31, 2014, 9:19:53 PM
    Author     : dustineastes
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="customer" class="edu.acc.j2ee.capstone.model.Customer" scope="session"/>
<jsp:useBean id="frameOrders" class="java.util.List" scope="session"/> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="bootstrap.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.css">
        
        <title>Frame App Log In</title>
    </head>
   
    
    <body class="bg-info">
        
        <div class="container">
            <div class="col-md-10"></div>
             <div class="col-md-2">
                <h4><a href="LogoutServlet"> Log Out </a></h4>
            </div>
            
            <div class="col-md-4"></div>
            <div class="col-md-4">
                
                    <h1>Welcome ${customer.fname}</h1>
                    <h1>You have ${frameOrders.size()} Frame Orders </h1>
                    <h1><a href="FrameOrderServlet"> Create New Frame Order </a></h1>
                    <h1><a href="FrameOrderServlet"> Edit Old Frame Orders </a></h1>
                    
               
            </div>
                    <div class="col-md-4"></div>
                   
        </div>
    </body>
</html>
