<%-- 
    Document   : quizList
    Created on : Jun 29, 2022, 9:53:47 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" type="text/css" href="css/quizList.css">
        <title>Quiz List</title>

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
    </style>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <section class="jumbotron text-center">
                <div class="container">
                    <h1 class="jumbotron-heading">list of Quiz on the website</h1>
                    <p class="lead text-muted mb-0">List of quizzes for students to practice, review to increase knowledge</p>
                </div>
            </section>

            <!--Course List-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="card bg-light mb-3">
                            <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Subject</div>
                            <ul class="list-group category_block">
                            <c:forEach items="${listSubject}" var="s">
                                <li class="list-group-item text-white ${tag == s.subjectId?"active":""}">
                                    <a class="${tag == s.subjectId?"text-white":"text-black"}" href="QuizCategory?subjectID=${s.subjectId}">${s.subjectName}</a>
                                </li>
                            </c:forEach>
                        </ul>
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Lever</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${quizLevel}" var="o">
                                <li class="list-group-item text-white ${tag1 == o.quizLevelId?"active":""} ">
                                    <a class="${tag1 == o.quizLevelId?"text-white":"text-black" }" href="QuizLevel?quizLevelId=${o.quizLevelId}">${o.quizLevelName}</a>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                </div>
                <div class="col-sm-9">
                    <div class="row">
                        <c:forEach items="${lisQuiz}" var="ql">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <div class="quiz-subject">
                                        <p style="height: 44px">
                                            ${ql.quizName}
                                        </p>
                                    </div>
                                    <img src="https://aztest.vn/uploads/news/2020/easy-quiz-questions-1282929.jpg" alt="" />
                                    <div class="card-body">
                                        <div class="quiz-col1">
                                            <p><a href="" class="quiz-name">${ql.ownerName}</a></p>
                                        </div>
                                         <div class="quiz-col1">
                                            <p class="quiz-nameSub" style="width: 100%;text-align: left;font-size: 15px">Subject: ${ql.subjectName}</p>
                                        </div>
                                        <div class="quiz-col1">
                                            <p class="quiz-date" style="padding-right: 40px;">${ql.dateCreated}</p>
                                            <p class="quiz-number">Question: ${ql.numberQuestion}</p>
                                        </div>
                                        <div class="hearder_conter">
                                            <div class="row">
                                                <div class="col">
                                                    <a href="QuizDetail?quizId=${ql.quizId}"class="btn btn-primary">View</a>
                                                </div>
                                                <div class="col">
                                                    <a href="QuizHandle?quizId=${ql.quizId}" class="btn btn-success btn-block">Practice</a>
                                                </div>
                                            </div>
                                        </div> 

                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
        <div class="pagging">
            <c:forEach begin="1" end ="${numberP}" var="i">
                <span class="sub-pagging ${tagP == i?"active":""}">
                    <a href="QuizList?index=${i}">${i}</a>
                </span>
            </c:forEach>
        </div>

    </body>
    <jsp:include page="footer.jsp"></jsp:include>

</html>

