<%-- 
    Document   : adminQuiz
    Created on : Jul 6, 2022, 8:16:24 PM
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
        <title>Admin Page</title>
        <link
            rel="stylesheet"
            href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css"
            />
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
            />
        <script src="https://kit.fontawesome.com/64bb7a6643.js" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminSubject.css" />
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
        <div class="sidebar" style="background:#007bff">
            <div class="form-input" style="float: left; margin: 20px 10px; width: 10%;">
                <a href="home"><span><i class="fa fa-arrow-circle-o-left" style="font-size: 25px; color: white;"></i></span><a
                        href=""></a>
            </div>
            <div class="sidebar-brand" style="float: right; margin: 0px; width: 80%; padding-left: 0;">
                <div class="user-wrapper">
                    <img src="../img/${sessionScope.user.avatar}"
                         width="40px" height="40px" alt="Error" />
                    <div>
                        <h4 style="font-size: 20px;">${sessionScope.user.userName}</h4>
                    </div>
                </div>
            </div>


            <div class="sidebar-menu" style="clear: both;">
                <ul>
                     <li>
                        <a href="managementUser" ><i class="fas fa-user-circle"></i><span>Manage User</span></a>
                    </li><br>
                    <li>
                        <a href="AdminQuizController"class="active"><i class="fas fa-book-open"></i><span>Manage Quiz</span></a>
                    </li><br>
                    <li>
                        <a href="ManagermentQuestion"><i class="fas fa-question"></i><span>Manage Question</span></a>
                    </li><br>
                    <li>
                        <a href=""><i class="fas fa-book-open"></i><span>Manage Subject</span></a>
                    </li><br>
                </ul>
            </div>
        </div>
        <div class="main-content">
            <header>
                <h2>
                    <label for="">
                        <span class="las la-bars"></span>
                    </label>
                    Dashboard
                </h2>
                <div class="search-wrapper">
                    <span class="class las la-search"></span>
                    <input type="search" placeholder="Search here" />
                </div>
               
            </header>

            <main>
                <div class="container">
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"> Subject</i> </div>
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
                            <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Owner</div>
                            <ul class="list-group category_block" id="onwer">
                                <c:forEach items="${listOwner}" var="lo">
                                    <li id="o${lo.userId}" class="list-group-item text-black"  value="${lo.userId}" onclick="quizOnwerClick(${lo.userId})">
                                        <a value="${lo.userId}">${lo.userName}</a>
                                    </li>
                                </c:forEach>

                            </ul>
                        </div>
                        <div class="col-sm-9">
                            <form action="AdminQuizController" method="post" class="mt-3">
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
                                <a style="margin-left: 65%;" href="AdminAddQuizController" type="button"
                                   class="btn btn-success btn-add">Add Quiz</a>
                                <input hidden="" type="submit" id="submitAuto">

                            </form>
                            <table class="table table-striped table-bordered mt-4">
                                <thead>
                                    <tr>
                                        <th>Quiz Name</th>
                                        <th>Owner</th>
                                        <th>Quiz Duration</th>
                                        <th>Number Question</th>
                                        <th>Subject</th>
                                        <th>Quiz Level</th>
                                        <th>Question</th>
                                        <th>Delete</th>
                                        <th>Update</th>  

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${typeSort == 1}">
                                        <c:forEach items="${listQuizSortName}" var="ql">
                                            <tr class ="quiz" id="${ql.quizId}q">
                                                <td>${ql.quizName}</td>
                                                <td>${ql.ownerName}</td>
                                                <td>${ql.quizDuration}</td>
                                                <td>${ql.numberQuestion}</td>
                                                <td>${ql.subjectName}</td>
                                                <td>${ql.quizLevelName}</td>
                                                <td><a href="ManagerQuestion?quizId=${ql.quizId}" class="btn btn-primary">Question</a></td>
                                                <td><a href="AdminDeleteQuizController?quizId=${ql.quizId}" class="btn btn-danger">Delete</a></td>
                                                <td><a href="AdminUpdateQuizController?quizId=${ql.quizId}" class="btn btn-warning">Update</a></td>                        
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${typeSort == 2}">
                                        <c:forEach items="${listQuizSortNumber}" var="ql">
                                            <tr class ="quiz" id="${ql.quizId}q">

                                                <td>${ql.quizName}</td>
                                                <td>${ql.ownerName}</td>
                                                <td>${ql.quizDuration}</td>
                                                <td>${ql.numberQuestion}</td>
                                                <td>${ql.subjectName}</td>
                                                <td>${ql.quizLevelName}</td>
                                                <td><a href="ManagerQuestion?quizId=${ql.quizId}" class="btn btn-primary">Question</a></td>
                                                <td><a href="AdminDeleteQuizController?quizId=${ql.quizId}" class="btn btn-danger">Delete</a></td>
                                                <td><a href="AdminUpdateQuizController?quizId=${ql.quizId}" class="btn btn-warning">Update</a></td>                        
                                            </tr>
                                        </c:forEach>
                                    </c:if>  
                                    <c:if test="${typeSort == 3}">
                                        <c:forEach items="${listQuizSortDuration}" var="ql">
                                            <tr class ="quiz" id="${ql.quizId}q">
                                                <td>${ql.quizName}</td>
                                                <td>${ql.ownerName}</td>
                                                <td>${ql.quizDuration}</td>
                                                <td>${ql.numberQuestion}</td>
                                                <td>${ql.subjectName}</td>
                                                <td>${ql.quizLevelName}</td>
                                                <td><a href="ManagerQuestion?quizId=${ql.quizId}" class="btn btn-primary">Question</a></td>
                                                <td><a href="AdminDeleteQuizController?quizId=${ql.quizId}" class="btn btn-danger">Delete</a></td>
                                                <td><a href="AdminUpdateQuizController?quizId=${ql.quizId}" class="btn btn-warning">Update</a></td>                        
                                            </tr>
                                        </c:forEach>
                                    </c:if>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </main>
        </div>
        <!--Script for modal active-->

    </body>
    <script>

        var listQuiz = document.getElementsByClassName("quiz");
        var listSubjectChoose = [];
        var listQuizLevelChoose = [];
        var listQuizOwnerChoose = [];
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
                filter(listSubjectChoose, listQuizLevelChoose, listQuizOwnerChoose);
            } else {
                $('#' + n).addClass('active');
                $('#' + n).addClass('.bg-info');
                listSubjectChoose.push(document.getElementById(n).value);
                filter(listSubjectChoose, listQuizLevelChoose, listQuizOwnerChoose);
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
                filter(listSubjectChoose, listQuizLevelChoose, listQuizOwnerChoose);

            } else {
                $('#' + n).addClass('active');
                $('#' + n).addClass('.bg-info');
                listQuizLevelChoose.push(document.getElementById(n).value);
                filter(listSubjectChoose, listQuizLevelChoose, listQuizOwnerChoose);
            }
        }
        function quizOnwerClick(n) {
            if ($('#o' + n).hasClass('active') == true)
            {
                $('#o' + n).removeClass('active');
                $('#o' + n).removeClass('.bg-info');
                if (listQuizOwnerChoose.length > 0)
                {
                    for (var i = 0, max = listQuizOwnerChoose.length; i < max; i++) {
                        if (listQuizOwnerChoose[i] == document.getElementById("o" + n).value)
                        {
                            listQuizOwnerChoose.splice(i, 1);
                        }
                    }
                }
                filter(listSubjectChoose, listQuizLevelChoose, listQuizOwnerChoose);

            } else {
                $('#o' + n).addClass('active');
                $('#o' + n).addClass('.bg-info');
                listQuizOwnerChoose.push(document.getElementById("o" + n).value);
                filter(listSubjectChoose, listQuizLevelChoose, listQuizOwnerChoose);
            }
        }

        function filter(listSubject, listLevel, listOwner)
        {
            typeSort = $("#select option:selected").val();
            if (listSubject.length > 0 || listLevel.length > 0 || listOwner > 0) {

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
                    for (var i = 0, max = listOwner.length; i < max; i++) {
                        if (${q.ownerId} == listOwner[i])
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
                    for (var i = 0, max = listOwner.length; i < max; i++) {
                        if (${q.ownerId} == listOwner[i])
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
                    for (var i = 0, max = listOwner.length; i < max; i++) {
                        if (${q.ownerId} == listOwner[i])
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
