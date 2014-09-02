<%-- 
    Document   : FrameOrderPage
    Created on : Aug 13, 2014, 11:48:30 PM
    Author     : dustineastes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="customer" class="edu.acc.j2ee.capstone.model.Customer" scope="session"/>
<jsp:useBean id="moulding" class="java.util.List" scope="session" />
<jsp:useBean id="frameOrder" class="edu.acc.j2ee.capstone.model.Frameorders" scope="session"/>

<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery-2.1.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/spacers.css"
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="bg-info">
        <div class="container">
             
            <div class="col-sm-12">
            <div class="pull-right">
                <h4><a href="LogoutServlet"> Log Out </a></h4>
            </div> 
            
            </div>

            <div class="colsm-12"></div>
                <h1><div class="text-center"> ${customer.lname} </div>  </h1>
                <h2><div class="text-center">Choose Moulding Style</div></h2>
            </div>
           
                  
    <div class="col-sm-12">   
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                
                    <div class="col-sm-3"> 
                        <div class="moulding" value=${moulding[0].id}> <img width="100px" src=${moulding[0].imagelink} /> </div>
                    </div>
                    <div class="col-sm-3"> 
                        <div class="moulding" value=${moulding[1].id}> <img width="100px" src=${moulding[1].imagelink} /> </div>
                    </div>
                    <div class="col-sm-3"> 
                        <div class="moulding" value=${moulding[2].id}> <img width="100px" src=${moulding[2].imagelink} /> </div>
                    </div>
                    <div class="col-sm-3"> 
                        <div class="moulding" value=${moulding[3].id}> <img width="100px" src=${moulding[3].imagelink} /> </div> 
                    </div>
            </div>
            <div class="col-sm-3"></div>
    </div>
            
            <div class="col-sm-12">
                <h2><div class="text-center">Choose a Mat Color</div></h2>
            </div>
            
            
            <div class="col-sm-12">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                <div>
                    <div class="col-sm-3">
                        <img width="100px" class="mat" src="images/mat1.png" /> 
                    </div>
                    <div class="col-sm-3">
                        <img width="100px" class="mat" src="images/mat2.png" /> 
                    </div>
                    <div class="col-sm-3">
                        <img width="100px" class="mat" src="images/mat3.png" /> 
                    </div>
                    <div class="col-sm-3">
                        <img class="mat" width="100px" src="images/mat4.png" /> 
                    </div>
                </div>
                </div>
                <div class="col-sm-3"></div>
           </div>
            
            
            <div class="col-sm-12">
            <div class="spacer100"></div>
            </div>
  
          
            

                    <div class="span12">  
                        <div class="col-sm-3"></div>
                        <div class="col-sm-6">
                           
                                <div class="center-block" style="width:600px; height:600px">
                                    
                                    <div class="imageOverlay" style="left:70px; top:70px;" >
                                        <img width="400px" src="images/picture.png" />
                                    </div>
                                    <div id="chosenMat" class="imageOverlay" style="left:20px; top:-380px;">
                                        <img width="200px" src="images/mat4.png" />
                                    </div>
                                    <div id="chosenMoulding" class="imageOverlay" style="left:0px; top:-600px;">
                                        <img width="240px" src='images/Frame3.png' />
                                    </div>
                                
                            </div>
                        </div>
                        <div class="col-sm-3"></div>
                    </div> 


            
            <div class="col-sm-12"></div>
            
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
 
                 <form role="form" type='POST' action='NewFrameOrderServlet'>
                     <input type="text" class="form-control" id="frameType" name="frameType"  value="images/Frame3.png">
                     <input type="text" class="form-control" id="matType" name="matType"  value="images/mat4.png">
              
                <div class="center-block">
                     <button type="submit" class="btn btn-default">Save New Frame Order</button>
                </div>
                 </form>    
            </div>
            
            <div class="col-sm-4"></div>
            
            <div class="col-sm-12">
                <div class="spacer40"></div>
            </div>
          
                    
              
                 
            <script >  
                var num = 4;
                var imagelink = "${moulding[4].imagelink}";
                $(document).ready(function() {
                    if (${frameOrder.frameid} > 0 ){
                       
                        $("#chosenMat").children().attr('src', '${frameOrder.mat}');
                        $("#chosenMoulding").children().attr('src', '${frameOrder.frametype}');
                        $("#frameType").attr('value' , '${frameOrder.frametype}');
                        $("#matType").attr('value' , '${frameOrder.mat}');
                    }
                    
                   // $("#frameOrderForm").hide();
                    $(".moulding").click(function() {
                        
                        $("#frameType").attr('value', $(this).children().attr('src'));
                        $("#chosenMoulding").children().attr('src', $(this).children().attr('src'));
                    });
                    $(".mat").click(function() {
                       $("#matType").attr("value", $(this).attr("src")); 
                       $("#chosenMat").children().attr('src', $(this).attr('src'));
                    });
                    });
                
            </script>
    </body>
</html>
