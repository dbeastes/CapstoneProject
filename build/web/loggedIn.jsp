<%-- 
    Document   : loggedIn
    Created on : Jul 31, 2014, 9:19:53 PM
    Author     : dustineastes
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Collection, java.util.ArrayList"%> 
<jsp:useBean id="customer" class="edu.acc.j2ee.capstone.model.Customer" scope="session"/>
<jsp:useBean id="frameOrders" class="java.util.ArrayList" scope="session"/>
<jsp:useBean id="customerFrameOrders" class="java.util.ArrayList" scope="session"/> 
<jsp:useBean id="fail" class="edu.acc.j2ee.capstone.model.FailBean" scope="request" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery-2.1.1.min.js"></script>
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
                <h4> <span style="color: red"> ${fail.newOrderFail} </span> </h4>
                    <h1>Welcome ${customer.fname}</h1>
                    <h1>You have ${customerFrameOrders.size()} Frame Orders </h1>
                    
                    <c:forEach var="frameOrder" items="${customerFrameOrders}">
                        <a class="orders" value="${frameOrder.ordername}">
                            <p class="frameOrder" >${frameOrder.ordername}</p>
                        </a>
                    </c:forEach> 
                        
                    <h1><a href="FrameOrderServlet"> Create New Frame Order </a></h1>
                    <h1><a href="FrameOrderServlet"> Edit Old Frame Orders </a></h1>
                    
               
            </div>
                    <div class="col-md-4"></div>
                   
        </div>
    
                    <form role="form" type='POST' id="editOrder" action='FrameOrderServlet'>
                        <input type="hidden" class="form-control" id="orderName" name="orderName"  value="images/Frame3.png">
                    </form>
        
                    <script>  
             $(document).ready(function() {
                    
                    
                   // $("#frameOrderForm").hide();
                    $(".orders").click(function() {
                   ;   
                    $("#orderName").attr('value', $(this).attr('value'));
                    $("#editOrder").submit();
                    });
                    });
                    </script>
    </body>
</html>
