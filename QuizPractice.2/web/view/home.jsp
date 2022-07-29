<%-- 
    Document   : home
    Created on : Jun 13, 2022, 8:39:11 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Home Page</title>
        <!--=============================================================-->

        <!--==================Bootstrap css===========================-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />

        <!--=============================================================-->

        <!--==================Fontawesome===========================-->
        <script src="https://kit.fontawesome.com/64bb7a6643.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <!--=============================================================-->

        <!--======================Jost-font==============================-->
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet" />
        <!--=============================================================-->

        <!--==========================Roboto-font===============================-->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet" />

        <!--=============================================================-->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Mono&display=swap" rel="stylesheet" />
        <!---===================MyCss================================-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/hompage.css" />
        <!--=============================================================-->

        <!--===================Swiper=====================================-->
        <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css" />
        <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
        <script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
        <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
        <!--=============================================================-->
        <script src="https://kit.fontawesome.com/64bb7a6643.js" crossorigin="anonymous"></script>
    </head>
    <style>
        .quiz-subject p {
            height: 30px;
            font-size: 20px;
            text-transform: uppercase;
            font-weight: bold;
            margin-left: 20px;
        }
        .card-body .quiz-nameSub{
            text-transform: uppercase;
            font-weight: bold;
        }
        .pagging{
            text-align: center;
            margin-top: 20px;
        }
        .sub-pagging{
            border: 1px solid #bebebe;
            padding: 5px 10px;
            margin-left: 2px;
            color: red;

        }
        .sub-pagging a {
            color:black;
        }
        .sub-pagging:hover{
            background-color: #007bff;
        }
        .sub-pagging:hover a {
            color: #ffffff;
        }
        a .active{
            color: white;
        }
        .category_block li:hover {
            background-color: #007bff;
        }
        .category_block li:hover a {
            color: #ffffff;
        }
        .category_block li a {
            color: #343a40;
        }

        p .quiz-name {
            font-weight: 700;
            font-family: inherit;
            color: blue;
            text-decoration: none;
            width: 50%;
            text-align: center;
            padding-right: 55px;
            padding-left: 5px;
        }
        .quiz-number{
            width: 50%;
            text-align: center
        }
        .card-body .quiz-nameSub {
            width: 50%;
            text-align: center;
            color: red;
            font-family: inherit;
        }
        .quiz-col1{
            display: flex !important;
        }
    </style>
    <body>
        <!--Navbar-->

        <!--end nav bar-->
        <jsp:include page="header.jsp"></jsp:include>

            <!--Slide show-->
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>

                <div class="container-fluid slide-show">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="${pageContext.request.contextPath}/img/e-learning.svg" alt="First slide" height="400px" />
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="${pageContext.request.contextPath}/img/E BOOKS.svg" alt="Second slide" height="400px" />
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="${pageContext.request.contextPath}/img/educational resources.svg" alt="Third slide" height="400px" />
                    </div>
                </div>
            </div>



            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <!--Course List-->
        <div class="container course-list" style="margin-top: 10px;">
            <div class="row">
                <c:forEach items="${listLastQuiz}" var="ql">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="card">
                            <div class="quiz-subject">
                                <p>
                                    ${ql.quizName}
                                </p>
                            </div>
                            <img src="https://aztest.vn/uploads/news/2020/easy-quiz-questions-1282929.jpg" alt="" />
                            <div class="card-body">
                                <div class="quiz-col1" >
                                    <p><a href="" class="quiz-name">${ql.ownerName}</a></p>
                                    <p class="quiz-nameSub">${ql.subjectName}</p>
                                </div>
                                <div class="quiz-col1" >
                                    <p class="quiz-date" style="padding-right: 40px;">${ql.dateCreated}</p>
                                    <p class="quiz-number">Question: ${ql.numberQuestion}</p>
                                </div>
                                <div class="hearder_conter">
                                    <div class="row">
                                        <div class="col">
                                            <a href="QuizDetail?quizId=${ql.quizId}"class="btn btn-primary">View</a>
                                        </div>
                                        <c:if test="${sessionScope.user.roleId eq 3 || sessionScope.user == null}">
                                            <div class="col">
                                                <a href="QuizHandle?quizId=${ql.quizId}" class="btn btn-success btn-block">Practice</a>
                                            </div>
                                        </c:if>
                                    </div>
                                </div> 

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!--            <div class="view-more" style="margin: 5% 45%;">
                            <a href="#" class="btn btn-primary">View More</a>
                        </div>-->
        </div>

        <script>
            const swiper = new Swiper(".swiper-container", {
                // Optional parameters
                slidesPerView: 3,
                centeredSlides: true,
                spaceBetween: 30,

                // If we need pagination
                pagination: {
                    el: ".swiper-pagination",
                    // type: 'fraction',
                },

                // Navigation arrows
                navigation: {
                    nextEl: ".swiper-button-next",
                    prevEl: ".swiper-button-prev",
                },

                // And if we need scrollbar
                scrollbar: {
                    el: ".swiper-scrollbar",
                },
            });
        </script>
        <script>
            $(function () {
                $('[data-toggle="popover"]').popover();
            });
        </script>
        <!---============================jquery=====================================-->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <!---============================popper=====================================-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <!---============================min.js=====================================-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    </body>

    <jsp:include page="footer.jsp"></jsp:include>


</html>

