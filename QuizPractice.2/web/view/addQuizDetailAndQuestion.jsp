<%-- 
    Document   : quizDetailAndQuestion
    Created on : Jul 4, 2022, 10:14:49 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/quizDetailAndQuestion.css">

        <title>Document</title>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <h2>Quiz Details</h2>
                <div class="tab">
                    <button class="tablinks" onclick="openCity(event, 'Overview')" id="openDefault">Overview</button>
                </div>

                <!-- Tab content -->
                <div id="Overview" class="tabcontent">
                    <form action="AddQuizExpertController" method="post">
                        <div class="mainSection">
                            <div class="firstSection">
                                <div class="subjectNameContet">
                                    <!--Subject name section-->
                                    <label for="subjectName">Quiz Name</label>
                                    <input type="text" name="quizName" id="quizName" placeholder="Please input your quiz name here.">
                                    <c:if test="${check eq false}">
                                        <label style="color: red;" for="subjectName">${mess}</label>

                                    </c:if>
                                </div>
                                <!--end of subject section-->
                                <!--Category section-->
                                <div class="subjectContent">
                                    <label for="Subject">Subject</label>
                                    <select name="subject" id="subject">
                                    <c:forEach items="${listSubject}" var="ls">
                                        <option name ="subjectChoose" value="${ls.subjectId}" >${ls.subjectName}</option>
                                    </c:forEach>

                                </select>
                            </div>
                            <div class="levelContent">
                                <label for="level">Level</label>
                                <select name="level" id="level">
                                    <c:forEach items="${listQuizLevel}" var="ll">
                                        <option name="quizLevelChoose" value="${ll.quizLevelId}" >${ll.quizLevelName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="quizDurationContent">
                                <label for="quizDuration">Quiz Duration</label>
                                <input name="hour" type="number" class="hour"> :
                                <input name="minus" type="number" class="minus"> :
                                <input name="second" type="number" class="second">
                            </div>
                            <div class="numberQuestionContent">
                                <label for="numberQuestion">Number Question: ${numberQuestion}</label>

                            </div>

                        </div>
                        <div class="secondSection">
                            <div class="imageSection">
                                <img src="img/asp-mvc.jpg" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="description">
                        <label for="descriptionSection">Description:</label><br>

                        <textarea id="descriptionSection" name="description" rows="6" cols="133">

                        </textarea>
                    </div>

                    <div class="buttonSection">
                        <button class="btn btn-primary" type="submit">Submit</button>
                        <button class="btn btn-secondary" type="button"><a class="listQuestion" style="color: white; " href="QuizListExpertController">Cancel</a></button>
                    </div>
                </form>
            </div>

          
            <script>
                function openCity(evt, tabname) {
                    var i, tabcontent, tablinks;
                    tabcontent = document.getElementsByClassName("tabcontent");
                    for (i = 0; i < tabcontent.length; i++) {
                        tabcontent[i].style.display = "none";
                    }
                    tablinks = document.getElementsByClassName("tablinks");
                    for (i = 0; i < tablinks.length; i++) {
                        tablinks[i].className = tablinks[i].className.replace(" active", "");
                    }
                    document.getElementById(tabname).style.display = "block";
                    evt.currentTarget.className += " active";
                }
                document.getElementById("openDefault").click();
            </script>
                <jsp:include page="footer.jsp"></jsp:include>

    </body>

</html>


