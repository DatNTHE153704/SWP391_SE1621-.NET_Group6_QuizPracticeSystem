<%-- 
    Document   : abc
    Created on : Jul 21, 2022, 4:59:06 PM
    Author     : nguye
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Manage Question</title>
        <link rel="stylesheet"
              href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
        <script src="https://kit.fontawesome.com/64bb7a6643.js" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="css/managementUser.css" />
    </head>
    <body>
        <div class="sidebar">
            <div class="form-input" style="float: left; margin: 20px 10px; width: 10%;">
                <a href="home"><span><i class="fa fa-arrow-circle-o-left" style="font-size: 25px; color: white;"></i></span><a
                        href=""></a>
            </div>
            <div class="sidebar-brand" style="float: right; margin: 0px; width: 80%; padding-left: 0;">
                <div class="user-wrapper">
                    <img src="../img/${avatar}"
                         width="40px" height="40px" alt="Error" />
                    <div>
                        <h4 style="font-size: 20px;">${userName}</h4>
                    </div>
                </div>
            </div>

            <div class="sidebar-menu" style="clear: both;">
                <ul>
                    <li>
                        <a href="managementUser" ><i class="fas fa-user-circle"></i><span>Manage User</span></a>
                    </li><br>
                    <li>
                        <a href=""><i class="fas fa-book-open"></i><span>Manage Quiz</span></a>
                    </li><br>
                    <li>
                        <a href="" class="active"><i class="fas fa-question"></i><span>Manage Question</span></a>
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
                <form action="managementUser" method="get">
                    <div class="search-wrapper">
                        <span class="class las la-search"></span>
                        <input name="value" type="text" placeholder="Search here" />
                        <input type="submit" value="Search" />
                    </div>
                </form>
            </header>
            <main>
                <div style="font-size: 30px">
                    Information Question
                </div>
                <form action="UpdateQuestionAdmin" method="post">
                    <div class="modal-body">

                        <h1 style="color: red;font-weight:600">Subject: ${infor.subjectName}</h1>
                        <h2 style="color: #a1a1a1">Quiz: ${infor.quizName}</h2>
                        <h3 style="margin-bottom: 20px;color: blue;font-weight:600">Expert: ${infor.ownerName}</h3>

                        <div class="form-group">
                            <label>Question Name</label>
                            <input value="${Question}" name="nameQuestion" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Explanation</label>
                            <input value="${explanation}" name="exp" type="text" class="form-control" required>
                        </div>
                        <c:if test="${img != null}">
                            <img style="height: 150px;width: 260px;margin-bottom: 10px" src="img/${img}" alt="" />
                        </c:if>
                        <div hidden class="form-group">
                            <label>Old image</label>
                            <input value="${img}"name="mediaa" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>New Image</label>
                            <input name="media" type="file" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>Option 1</label>
                            <input value="${op1}"name="option1" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Option 2</label>
                            <input value="${op2}"name="option2" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Option 3</label>
                            <input value="${op3}"name="option3" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Option 4</label>
                            <input value="${op4}"name="option4" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Correct Answer:</label>
                            <input value="${answerCorrect}" type="number" min="1" max="4" name="correctA" class="form-control"
                                   placeholder="Correct Answer" required />
                        </div>
                        <div class="modal-footer">
                            <c:if test="${status == 1}">
                                <a href="ManagermentQuestion?index=${index}"><button type="button" class="btn btn-primary">Back</button></a>
                            </c:if>
                            <c:if test="${status == 2}">
                                <a href="searchQuestion?index=${index}"><button type="button" class="btn btn-primary">Back</button></a>
                            </c:if>
                            <c:if test="${status == 3}">
                                <a href="FilterQuestion"><button type="button" class="btn btn-primary">Back</button></a>
                            </c:if>

                            <input type="submit" class="btn btn-success" value="Edit">
                        </div>
                    </div>
                </form>
            </main>
        </div>
    </body>
</html>
