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
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/quizList.css">
        <title>Quiz List</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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

    </style>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <section class="jumbotron text-center">
                <div class="container">
                    <h1 class="jumbotron-heading">list of Quiz on the website</h1>
                    <p class="lead text-muted mb-0">List of quizzes for students to practice, review to increase knowledge</p>
                </div>
            </section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list">Subject</i> </div>
                        <ul class="list-group category_block" id="subject">
                        <c:forEach items="${listSubject}" var="s">
                            <li id="${s.subjectId}" class="subject list-group-item text-black" value="${s.subjectId}" onclick="subjectClick(${s.subjectId})" >
                                <a value="${s.subjectId}">${s.subjectName}</a>
                            </li>
                        </c:forEach>
                    </ul>

                    <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Lever</div>
                    <ul class="list-group category_block" id="quizLevel">
                        <c:forEach items="${quizLevel}" var="o">
                            <li id="${o.quizLevelId * (-1)}" class="quizLevel list-group-item text-black ${o.quizLevelId * (-1)}"  value="${o.quizLevelId}" onclick="quizLevelClick(${o.quizLevelId * (-1)})">
                                <a value="${o.quizLevelId}">${o.quizLevelName}</a>
                            </li>
                        </c:forEach>

                    </ul>
                </div>
                <div class="col-sm-9">
                    <form action="QuizListExpertController" method="post" class="mt-3">
                        <select id="select" name="Sort" style="height: 30px;font-size: 15px " onchange="submit()">
                            <c:if test="${typeSort == 1}">
                                <option value="name" selected>Name</option>
                                <option value="number" >Number Of Question</option>
                                <option value="duration">Quiz Duration</option>
                            </c:if>
                            <c:if test="${typeSort == 2}">
                                <option value="name">Name</option>
                                <option value="number" selected>Number Of Question</option>
                                <option value="duration">Quiz Duration</option>
                            </c:if>
                            <c:if test="${typeSort == 3}">
                                <option value="name">Name</option>
                                <option value="number" >Number Of Question</option>
                                <option value="duration" selected>Quiz Duration</option>
                            </c:if>

                        </select>
                        <a style="margin-left: 65%;" href="AddQuizExpertController" type="button"
                           class="btn btn-success btn-add">Add Quiz</a>
                        <input hidden="" type="submit" id="submitAuto">

                    </form>
                    <table class="table table-striped table-bordered mt-4">
                        <thead>
                            <tr>
                                <!--<th scope="col">#</th>-->
                                <!--<th scope="col">id</th>-->
                                <th scope="col">Quiz Name</th>
                                <!--<th scope="col"></th>-->
                                <th scope="col">Quiz Duration</th>
                                <th scope="col">Number Question</th>
                                <th scope="col">Subject</th>
                                <th scope="col">Quiz Level</th>
                                <th scope="col">Question</th>
                                <th scope="col">Delete</th>
                                <th scope="col">Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${typeSort == 1}">
                                <c:forEach items="${listQuizSortName}" var="q">
                                    <tr class ="quiz" id="${q.quizId}q">
                                        <!--<td>1</td>-->
                                        <!--<td>U001</td>-->
                                        <td>${q.quizName}</td>
                                        <td>${q.quizDuration}</td>
                                        <td>${q.numberQuestion}</td>
                                        <td>${q.subjectName}</td>
                                        <td>${q.quizLevelName}</td>
                                        <td><a href="ManagerQuestion?quizId=${q.quizId}" class="btn btn-primary">Question</a></td>
                                        <td>
                                            <a href="DeleteQuizController?quizId=${q.quizId}" class="btn btn-danger">Delete</a>
                                        </td>
                                        <td>
                                            <a href="UpdateQuizExpertController?quizId=${q.quizId}"
                                               class="btn btn-warning">Update</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${typeSort == 2}">
                                <c:forEach items="${listQuizSortNumber}" var="q">
                                    <tr class ="quiz" id="${q.quizId}q">
                                        <!--<td>1</td>-->
                                        <!--<td>U001</td>-->
                                        <td>${q.quizName}</td>
                                        <td>${q.quizDuration}</td>
                                        <td>${q.numberQuestion}</td>
                                        <td>${q.subjectName}</td>
                                        <td>${q.quizLevelName}</td>
                                        <!--<td>Active</td>-->
                                        <td><a href="ManagerQuestion?quizId=${q.quizId}" class="btn btn-primary">Question</a></td>
                                        <td>
                                            <a href="DeleteQuizController?quizId=${q.quizId}" class="btn btn-danger">Delete</a>
                                        </td>
                                        <td>
                                            <a href="UpdateQuizExpertController?quizId=${q.quizId}"
                                               class="btn btn-warning">Update</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>  
                            <c:if test="${typeSort == 3}">
                                <c:forEach items="${listQuizSortDuration}" var="q">
                                    <tr class ="quiz" id="${q.quizId}q">
                                        <!--<td>1</td>-->
                                        <!--<td>U001</td>-->
                                        <td>${q.quizName}</td>
                                        <td>${q.quizDuration}</td>
                                        <td>${q.numberQuestion}</td>
                                        <td>${q.subjectName}</td>
                                        <td>${q.quizLevelName}</td>
                                        <!--<td>Active</td>-->
                                        <td><a href="ManagerQuestion?quizId=${q.quizId}" class="btn btn-primary">Question</a></td>
                                        <td>
                                            <a href="DeleteQuizController?quizId=${q.quizId}" class="btn btn-danger">Delete</a>
                                        </td>
                                        <td>
                                            <a href="UpdateQuizExpertController?quizId=${q.quizId}"
                                               class="btn btn-warning">Update</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp"></jsp:include>

        <script>

            var listQuiz = document.getElementsByClassName("quiz");
            var listSubjectChoose = [];
            var listQuizLevelChoose = [];
            var submitAuto = document.getElementById("submitAuto");
            var typeSort;
            function submit()
            {
                submitAuto.click();

            }

            function subjectClick(n) {
                if ($('#' + n).hasClass('active') == true)
                {
                    $('#' + n).removeClass('active');
                    $('#' + n).removeClass('.bg-info');
                    if (listSubjectChoose.length > 0)
                    {
                        for (var i = 0, max = listSubjectChoose.length; i < max; i++) {
                            if (listSubjectChoose[i] == document.getElementById(n).value)
                            {
                                listSubjectChoose.splice(i, 1);
                            }
                        }
                    }
                    filter(listSubjectChoose, listQuizLevelChoose);
                } else {
                    $('#' + n).addClass('active');
                    $('#' + n).addClass('.bg-info');
                    listSubjectChoose.push(document.getElementById(n).value);
                    filter(listSubjectChoose, listQuizLevelChoose);
                }


            }
            function quizLevelClick(n) {
                if ($('#' + n).hasClass('active') == true)
                {
                    $('#' + n).removeClass('active');
                    $('#' + n).removeClass('.bg-info');
                    if (listQuizLevelChoose.length > 0)
                    {
                        for (var i = 0, max = listQuizLevelChoose.length; i < max; i++) {
                            if (listQuizLevelChoose[i] == document.getElementById(n).value)
                            {
                                listQuizLevelChoose.splice(i, 1);
                            }
                        }
                    }
                    filter(listSubjectChoose, listQuizLevelChoose);

                } else {
                    $('#' + n).addClass('active');
                    $('#' + n).addClass('.bg-info');
                    listQuizLevelChoose.push(document.getElementById(n).value);
                    filter(listSubjectChoose, listQuizLevelChoose);
                }
            }

            function filter(listSubject, listLevel)
            {
                typeSort = $("#select option:selected").val();
                if (listSubject.length > 0 || listLevel.length > 0) {

                    for (var a = 0, max = listQuiz.length; a < max; a++) {
                        listQuiz[a].style.display = "none";
                    }
                    if (typeSort == "name")
                    {
        <c:forEach items="${listQuizSortName}" var="q">
                        for (var i = 0, max = listSubject.length; i < max; i++) {
                            if (${q.subjectId} == listSubject[i])
                            {
                                document.getElementById(${q.quizId} + "q").style.display = "";
                            }
                        }
                        for (var i = 0, max = listLevel.length; i < max; i++) {
                            if (${q.quizLevelId} == listLevel[i])
                            {
                                document.getElementById(${q.quizId} + "q").style.display = "";
                            }
                        }
        </c:forEach>
                    }
                    if (typeSort == "number")
                    {
        <c:forEach items="${listQuizSortNumber}" var="q">
                        for (var i = 0, max = listSubject.length; i < max; i++) {
                            if (${q.subjectId} == listSubject[i])
                            {
                                document.getElementById(${q.quizId} + "q").style.display = "";
                            }
                        }
                        for (var i = 0, max = listLevel.length; i < max; i++) {
                            if (${q.quizLevelId} == listLevel[i])
                            {
                                document.getElementById(${q.quizId} + "q").style.display = "";
                            }
                        }
        </c:forEach>
                    }
                    if (typeSort == "duration")
                    {
        <c:forEach items="${listQuizSortDuration}" var="q">
                        for (var i = 0, max = listSubject.length; i < max; i++) {
                            if (${q.subjectId} == listSubject[i])
                            {
                                document.getElementById(${q.quizId} + "q").style.display = "";
                            }
                        }
                        for (var i = 0, max = listLevel.length; i < max; i++) {
                            if (${q.quizLevelId} == listLevel[i])
                            {
                                document.getElementById(${q.quizId} + "q").style.display = "";
                            }
                        }
        </c:forEach>
                    }
                } else {
                    for (var a = 0, max = listQuiz.length; a < max; a++) {
                        listQuiz[a].style.display = "";
                    }

                }
            }

    </script>

</html>

