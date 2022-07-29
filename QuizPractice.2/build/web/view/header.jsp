<%-- 
    Document   : header
    Created on : May 30, 2022, 10:35:57 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Home Page</title>
        <!--=============================================================-->

        <!--==================Bootstrap css===========================-->
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
            />

        <!--=============================================================-->

        <!--==================Fontawesome===========================-->
        <script
            src="https://kit.fontawesome.com/64bb7a6643.js"
            crossorigin="anonymous"
        ></script>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <!--=============================================================-->

        <!--======================Jost-font==============================-->
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap"
            rel="stylesheet"
            />
        <!--=============================================================-->

        <!--==========================Roboto-font===============================-->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
            rel="stylesheet"
            />

        <!--=============================================================-->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Roboto+Mono&display=swap"
            rel="stylesheet"
            />
        <!---===================MyCss================================-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/hompage.css" />
        <!--=============================================================-->

        <!--===================Swiper=====================================-->
        <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css" />
        <link
            rel="stylesheet"
            href="https://unpkg.com/swiper/swiper-bundle.min.css"
            />
        <script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
        <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
        <!--=============================================================-->
        <script
            src="https://kit.fontawesome.com/64bb7a6643.js"
            crossorigin="anonymous"
        ></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/img/q.svg" alt="Q logo " width="40px;" height="50px;" /></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="QuizList">Quiz</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Subject</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                </ul>

                <!--Search box-->
                <form class="form-inline my-2 my-lg-0" action="SearchQuizController" method="post">
                    <input name="search" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" />
                    <button type="submit" class="btn btn-secondary mr-sm-5">Search</button>
                </form>

                <c:if test="${sessionScope.user == null}">
                    <a href="login" class="btn btn-secondary mx-3">Login</a>
                    <a href="register" class="btn btn-secondary mx-3">Register</a>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <ul class="navbar-nav mr-sm-2">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle mr-sm-4" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Hello, ${sessionScope.user.userName}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Profile</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Change Password</a>
                                <c:if test="${sessionScope.user.roleId == 3}">
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="practiceList">My Practice List</a>
                                </c:if>
                                <c:if test="${sessionScope.user.roleId == 1}">
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="managementUser">Manage</a>
                                </c:if>
                                    <c:if test="${sessionScope.user.roleId == 2}">
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="QuizListExpertController">Manage</a>
                                </c:if>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="logout">Logout</a>
                            </div>
                        </li>
                    </ul>
                </c:if>

            </div>
        </nav>
    </body>
</html>
