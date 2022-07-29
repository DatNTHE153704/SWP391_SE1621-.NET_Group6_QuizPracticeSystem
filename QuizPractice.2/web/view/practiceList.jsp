<%-- 
    Document   : practiceList
    Created on : Jul 6, 2022, 12:38:46 AM
    Author     : ASUS
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practice List</title>

        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>


        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            #customers {
                font-family: Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;

            }

            #customers td, #customers th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #customers tr:nth-child(even){background-color: #f2f2f2;}

            #customers tr:hover {background-color: #ddd;}

            #customers th {
                padding-top: 12px;
                padding-bottom: 12px;
                background-color: #007bff;
                color: white;
            }

            .table-practice-list {
                text-align: center;
                /*                background-color: #ddd;*/
            }

            .table-practice-list h1{
                margin: 40px 0;
            }

            .practice-list{
                margin: 80px 0;
            }

            .filter{
                margin: 40px 0;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="practice-list">
                <div class="container">
                    <div class="table-practice-list">
                        <h1 style="font-family: inherit; font-size: 40px;">Practice List</h1>
                        <div class="filter">
                            <div class="row">
                                <div class="col-md-3">
                                    <form class="filter-subject" action="practiceList" method="get" >
                                        <select class="form-control" name="subjectId" style="width: 100%; margin: 20px 0;" onchange="this.form.submit()">
                                            <option value="0" selected>All Subjects</option>
                                        <c:forEach items="${listSubject}" var="s">
                                            <option value="${s.subjectId}" ${s.subjectId == subjectId?"selected":""}>${s.subjectName}</option>
                                        </c:forEach>
                                    </select>
                                </form>
                            </div>
                            <div class="col-md-9">
                            </div>
                        </div>
                    </div>
                    <table id="customers">
                        <tr>
                            <th></th>
                            <th>Quiz Name</th>
                            <th>Subject</th>
                            <th>Answered</th>
                            <th>NumberCorrectAnswers</th>
                            <th>Score</th>
                            <th>Complete Time</th>
                            <th>Submit At</th>
                            <th>Details</th>
                        </tr>
                        <c:if test="${totalResult != 0}">
                            <c:forEach items="${listResult}" var="r">
                                <tr>
                                    <td>${listResult.indexOf(r)+1}</td>
                                    <td>${r.quizName}</td>
                                    <td>${r.subjectName}</td>
                                    <td>${r.numberQuestionsAnswered} / ${r.numberQuestion}</td>
                                    <td>${r.numberCorrectAnswer} / ${r.numberQuestion}</td>
                                    <td>${r.score}</td>
                                    <td>${r.time}</td>
                                    <td><fmt:formatDate value="${r.submitAt}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
                                    <td><a href="quizReview?quizResultId=${r.quizResultId}">Details</a></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </table>
                    <c:if test="${totalResult == 0}">
                        <h1 style="margin-top: 80px; color: red;">${message}</h1>
                    </c:if>
                </div>
            </div>
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
        <jsp:include page="footer.jsp"></jsp:include>

    </body>

</html>


