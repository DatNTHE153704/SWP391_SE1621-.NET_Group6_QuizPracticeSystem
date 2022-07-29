<%-- 
    Document   : register
    Created on : May 30, 2022, 10:36:13 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/register.css">
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
                    <div class="form-input">
                        <a href="home"><span><i class="fa fa-arrow-circle-o-left" style="font-size: 25px;"></i></span><a href=""></a>
                    </div>
                    <div class="card-body ml-2">
                        <h4 class="title text-center mt-4">
                            Register
                        </h4>
                        <form class="form-box px-3 pl-5" action="register" method="post">
                            <c:if test="${msg1 eq 'case1'}">
                                <div class="alert">
                                    <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
                                    This username is already being used !
                                </div>
                            </c:if>

                            <div class="form-input">
                                <span><i class="fa fa-user"></i></span>
                                <input type="text" name="username" placeholder="User Name" tabindex="10" required>
                            </div>

                            <c:if  test="${msg2 eq 'case2'}">
                                <div class="alert">
                                    <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
                                    This email address is already being used !
                                </div>
                            </c:if>

                            <div class="form-input">
                                <span><i class="fa fa-envelope-o"></i></span>
                                <input type="email" name="email" placeholder="Email Address" tabindex="10" required>
                            </div>

                            <c:if  test="${msg3 eq 'case3'}">
                                <div class="alert">
                                    <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
                                    Password and Confirm Password must be match !
                                </div>
                            </c:if>
                            <div class="form-input">
                                <span><i class="fa fa-key"></i></span>
                                <input type="password" name="password" placeholder="Password" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-key"></i></span>
                                <input type="password" name="repassword" placeholder="Confirm Password" required>
                            </div>

                            <div class="form-radio">
                                <span><i class="fa fa-transgender"></i></span>
                                <input type="radio" name="gender" placeholder="Gender" value="Male" tabindex="10" required> Male
                                <input type="radio" name="gender" placeholder="Gender" value="Female" tabindex="10" required> Female
                            </div>

                            <div class="form-input">
                                <span><i class="fa fa-calendar"></i></span>
                                <input type="date" name="dob" placeholder="Date of Birth" tabindex="10" required>
                            </div>

                            <div class="mb-3">
                                <button type="submit" class="btn btn-block text-uppercase">
                                    Register
                                </button>
                            </div>

                            <hr class="my-4">

                            <div class="text-center mb-2">
                                If you have account?
                                <a href="login" class="register-link">
                                    Login here
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
