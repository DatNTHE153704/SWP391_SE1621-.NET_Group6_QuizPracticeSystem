<%-- 
    Document   : footer
    Created on : May 30, 2022, 10:36:03 PM
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
    <footer style="background-color: #007bff; margin-top: 20px; color: white;">
        <div class="footer-wraper container mt-5">
            <div class="row">
                <div class="col-md-4 first-col" style="margin: 20px 0;">
                    <img src="${pageContext.request.contextPath}/img/q.svg" alt="logo" height="50px" width="50px" />
                    <!--<p id="logo-name">QPS</p>-->
                    <p id="footer-description">
                        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Hic quia
                        similique, voluptates ab quam iste quasi suscipit ea ut error,
                        maxime dignissimos delectus magnam porro dolor ullam nisi iusto
                        quos.
                    </p>
                </div>
                <div class="col-md-4 second-col" style="margin: 20px 0;">
                    <h5><i class="fas fa-map m-2"></i>Menu</h5>
                    <ul>
                        <li>
                            <i class="fas " style="color: whitesmoke;"></i><a href="home"  style="color: whitesmoke;">Home</a>
                        </li>
                        <li>
                            <i class="fas" style="color: whitesmoke;"></i><a href="QuizList" style="color: whitesmoke;">Quiz</a>
                        </li>
                        <c:if test="${sessionScope.user.roleId eq 2}">
                            <li>
                                <i class="fas " style="color: whitesmoke;"></i><a href="QuizListExpertController" style="color: whitesmoke;">My Quiz</a>
                            </li>

                        </c:if>
                        <c:if test="${sessionScope.user.roleId eq 1}">
                            <li>
                                <i class="fas " style="color: whitesmoke;"></i><a href="AdminQuizController" style="color: whitesmoke;">Admin</a>
                            </li>

                        </c:if>

                        <li>
                            <i class="fas " style="color: whitesmoke;"></i><a href=""  style="color: whitesmoke;">About</a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-4 third-col" style="margin: 20px 0;">
                    <h5><i class="fas fa-address-book m-2"></i>Contact info</h5>
                    <ul>
                        <li>
                            <div class="icon-location">
                                <i class="fas fa-home"></i>
                            </div>
                            <div class="location-footer">
                                <p>
                                    Đại Học FPT, Khu Công Nghệ Cao Hòa Lạc
                                </p>
                            </div>
                        </li>

                        <li>
                            <div class="icon-phone">
                                <i class="fas fa-phone"></i>
                            </div>
                            <div class="phone-footer">
                                <p>(+84)866131638</p>
                            </div>
                        </li>

                        <li>
                            <div class="icon-mail">
                                <i class="fas fa-envelope"></i>
                            </div>
                            <div class="mail-footer">
                                <p>quizpracticeg6@gmail.com</p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
</html>
