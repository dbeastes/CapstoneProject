<%-- 
    Document   : SignUpPage
    Created on : Aug 3, 2014, 3:06:55 PM
    Author     : dustineastes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="failBean" class="edu.acc.j2ee.capstone.model.FailBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.css">
        <title>Sign Up</title>
    </head>
    <body class="bg-info">
        <div class="container">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <h1>Register as a new User</h1>
                <form role="form" type='GET' action='SignUpServlet'>
                    <div class="form-group">
                        <label for="firstName">First Name<span style="color: red">${failBean.fNameFail}</span></label>
                        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="Enter First Name">
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name<span style="color: red">${failBean.lNameFail}</span></label>
                        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Enter Last Name">
                    </div>
                    <div class="form-group">
                        <label for="email">E-mail <span style="color: red">${failBean.emailFail}</span></label>
                        <input type="email" class="form-control" name="email" id="exampleInputPassword1" placeholder="Enter E-mail">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password<span style="color: red">${failBean.passFail}</span></label>
                        <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Enter Password">
                    </div>


                    <div class="col-md-6">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                    <div class="col-md-6">
                        <a href="index.jsp"> I Already Have an Account </a>
                    </div>
                </form>
            </div>
            <div class="col-md-4"></div>
        </div>

    </body>
</html>
