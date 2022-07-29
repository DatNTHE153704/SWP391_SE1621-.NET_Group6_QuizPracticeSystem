<%-- 
    Document   : adminAddNewSubject
    Created on : Jul 6, 2022, 4:16:02 PM
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
        <link rel="stylesheet"
              href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
        <script src="https://kit.fontawesome.com/64bb7a6643.js" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminAddSubject.css" />
    </head>

    <body>
        <div class="sidebar">
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

            <div class="sidebar-menu">
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
                <div class="user-wrapper">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEAoTadQ4n5Oe-rLqJz9j_UCkUhtcLoZlacA&usqp=CAU"
                         width="40px" height="40px" alt="Error" />
                    <div>
                        <h4>Eminem</h4>
                        <small>Slim Shady</small>
                    </div>
                </div>
            </header>

            <main>
                <div class="container-fluid">
                    <div class="row justify-content-between subject-section">
                        <h2 class="mt-3">Add Quiz</h2>
                    </div>
                    <form action="AdminAddQuizController" method="post">
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
                            <button class="btn btn-secondary" type="button"><a class="listQuestion" style="color: white; " href="AdminQuizController">Cancel</a></button>
                        </div>
                    </form>

            </main>
        </div>

    </body>

</html>
