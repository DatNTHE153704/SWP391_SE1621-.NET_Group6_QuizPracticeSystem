<%-- 
    Document   : quizDetail
    Created on : Jun 27, 2022, 1:39:19 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quiz Detail</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/quizDetail.css">
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
        <jsp:include page="header.jsp"></jsp:include>
            <section class="jumbotron text-center">
                <div class="container">
                    <h1 class="jumbotron-heading">list of Quiz on the website</h1>
                    <p class="lead text-muted mb-0">List of quizzes for students to practice, review to increase knowledge</p>
                </div>
            </section>
            <div id="quizDetail">
                <div class="quizSub">
                    <h3>Quiz Detail</h3>
                </div>
                <div class="content">
                    <div class="img-content">
                        <img class="img" src="https://aztest.vn/uploads/news/2020/easy-quiz-questions-1282929.jpg" alt="" />
                    </div>
                    <div class="quiz-content">
                        <h4>Subject: ${quizDetail.subjectName}</h4>
                    <h5 class="quizName">Quiz Name: ${quizDetail.quizName}</h5>
                    <h5 class="Expert">Expert: ${quizDetail.ownerName}</h5>
                    <h5 class="number">Number Question: ${quizDetail.dateCreated}</h5>
                    <h5 class="level">Level : ${quizDetail.quizLevelName}</h5>
                    <h5 class="time">Quiz time: ${quizDetail.quizDuration} minute</h5>
                    <h5 class="date">date create: ${quizDetail.dateCreated}</h5>
                    <div class="detail-content">
                        <h6>Quiz detail:</h6>
                        <p class="description">${quizDetail.description}</p>
                    </div>
                    <a class="back" href="">Back</a>
                    <a class="practice" href="QuizHandle?quizId=${quizDetail.quizId}">Practice</a>
                </div>
            </div>
        </div>


    </body>
    <jsp:include page="footer.jsp"></jsp:include>
</html>
