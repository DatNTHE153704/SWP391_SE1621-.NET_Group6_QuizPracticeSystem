<%-- 
    Document   : forgot
    Created on : May 30, 2022, 10:36:20 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Forgot Password</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/verify.css">
        <!-----------------------------------Roboto Font--------------------------------->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap" rel="stylesheet">
        <!-------------------------------------------------------------------------------->
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Open+Sans" />

        <!-------------------------------------------------------------------------------->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row px-3 ">
                <div class="col-lg-10 col-xl-9 card flex-row mx-auto px-0">
                    <div class="card-body ml-2">
                        <h4 class="title text-center mt-4">
                            Forgot Your Password
                        </h4>
                        <form class="form-box px-3 pl-5" action="forgot" method="post">
                            <%
                                String a = (String) request.getAttribute("alert");
                                if (a != null) {%>
                            <div class="alert">
                                <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
                                <%=a%>
                            </div>
                            <%}%>

                            <div class="form-input">
                                <span><i class="fa fa-envelope-o"></i></span>
                                <input type="email" name="email" placeholder="Email Address" tabindex="10" required>
                            </div>
                            <div class="mb-3">
                                <button type="submit" class="btn btn-block text-uppercase">
                                    Send Email
                                </button>
                            </div>
                            <div class="text-right">
                                <a href="login" class="forget-link">
                                    Back to Login
                                </a>
                            </div>

                            <hr class="my-4">

                            <div class="text-center mb-2">
                                Don't have an account?
                                <a href="register" class="register-link">
                                    Register here
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

