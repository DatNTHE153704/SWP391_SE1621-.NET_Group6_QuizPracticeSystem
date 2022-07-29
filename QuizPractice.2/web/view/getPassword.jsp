<%-- 
    Document   : newPassword
    Created on : Jun 2, 2022, 10:01:32 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Password</title>
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
                            New Password
                        </h4>
                        <form class="form-box px-3 pl-5" action="GetPassword" method="post">
                            <c:choose>
                                <c:when test="${alert eq 'case1'}">
                                    <div class="alert">
                                        <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
                                        <strong></strong> confirm password incorrect, please try again
                                    </div>
                                </c:when>
                                <c:otherwise>

                                </c:otherwise>
                            </c:choose>
                            <div class="form-input">
                                <span><i class="fa fa-key"></i></span>
                                <input type="password" name="newPassword" placeholder="New Password" tabindex="10" required>
                            </div>
                            <div class="form-input">
                                <span><i class="fa fa-unlock"></i></span>
                                <input type="password" name="confirmPasaword" placeholder="Confirm Password" tabindex="10" required>
                            </div>

                            <div class="mb-3">
                                <button type="submit" class="btn btn-block text-uppercase">
                                    Reset
                                </button>
                            </div>

                            <hr class="my-4">

                            <div class="text-center mb-2">
                                If you have an account?
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

