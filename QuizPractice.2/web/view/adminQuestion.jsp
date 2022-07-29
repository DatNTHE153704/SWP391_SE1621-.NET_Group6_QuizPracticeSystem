<%-- 
    Document   : managementUser
    Created on : Jul 11, 2022, 12:14:53 AM
    Author     : ASUS
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
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
    <style>
        .modal-body .alert {
            padding: 10px;
            background-color: #f44336;
            color: white;
            width: 100%;
            margin: 10px auto;
        }

        .modal-body .closebtn {
            margin-left: 15px;
            color: white;
            font-weight: bold;
            float: right;
            font-size: 22px;
            line-height: 20px;
            cursor: pointer;
            transition: 0.3s;
        }

        .modal-body .closebtn:hover {
            color: black;
        }
        .Question-Content{
            width: 80%;
            font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
            font-size: 25px;
            color: #566787;
            line-height: 1.42857143;
            margin: 5px 0px 5px 24px;
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
        .acive-index{
            background-color: #007bff;
            color: white;
        }
        .text-white{
            color: white!important;
        }
    </style>
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

            <div class="sidebar-menu" style="clear: both;">
                <ul>
                    <li>
                        <a href="managementUser" ><i class="fas fa-user-circle"></i><span>Manage User</span></a>
                    </li><br>
                    <li>
                        <a href="AdminQuizController"><i class="fas fa-book-open"></i><span>Manage Quiz</span></a>
                    </li><br>
                    <li>
                        <a href="ManagermentQuestion" class="active"><i class="fas fa-question"></i><span>Manage Question</span></a>
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
                <form action="searchQuestion" method="get">
                    <div class="search-wrapper">
                        <span class="class las la-search"></span>
                        <input name="value" type="text" placeholder="Search here" />
                        <input type="submit" value="Search" />
                    </div>
                </form>
            </header>

            <main>
                <div style="font-size: 30px;float: left;margin: 10px 0">
                    Question Management
                </div>
                <button style="float: right; margin: 10px 0;" type="button" class="btn btn-success btn-add" data-toggle="modal"
                        data-target="#addEmployeeModal">
                    Add New Question
                </button>
                <div style="clear: both;height: 40px;">
                    <form action="FilterQuestion" method="post">
                        <label style="font-size: 24px ;margin-top:18px">Quiz: </label>
                        <select name="quiz" onchange="this.form.submit();" style="font-size: 17px;padding: 4px">
                            <option value="0" >All</option>
                            <c:forEach items="${lisQuiz}" var="ll">
                                <option name="quizId" value="${ll.quizId}" ${quizz == ll.quizId ? "selected":""} >${ll.quizName} (in ${ll.subjectName} Subject)</option>
                            </c:forEach>
                        </select>
                    </form>
                </div>

                <%
                    String index = (String) request.getAttribute("alert");
                    int i = Integer.parseInt(index);
                    int indexQ = (i - 1) * 10 + 1;
                %>  
                <!--Question content-->
                <div class="containner-option" style="margin-top: 50px">
                    <c:forEach items="${AllQuestion}" var="lq">
                        <div class="Quiz-name" style="display: flex">
                            <span class="Question-Content" style="border-bottom: 1px solid #ccc;"><%=indexQ++%>.${lq.content}<p style="font-size: 18px;color: black;margin-top: 8px"></p></span>
                            <div class="Icon" style="width: 20%;text-align: right">
                                <a href="inforQuestionOfExpert?quizID=${lq.quizId}&inforQ=${lq.questionId}"><i class="fa fa-pencil-square-o"></i><span></span></a>
                                <a href="deleteQuestionAdmin?deleteId=${lq.questionId}&quizID=${lq.quizId}&indexP=<%=index%>"><i class="fa fa-trash-o"></i><span></span></a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <c:if test="${totalQuestion == 0}">
                    <h6 style="font-size: 40px; color: red; text-align: center; margin: 40px 0;">${msg}</h6>
                </c:if>

                <!--Paging Question-->
                <c:if test="${check == null}">
                    <div class="pagging">
                        <c:forEach begin="1" end ="${numberP}" var="i">
                            <span class="sub-pagging ${tagP == i?"acive-index":""} ">
                                <a  href="ManagermentQuestion?index=${i}" class="${tagP == i?"text-white":"text-black"}" >${i}</a>
                            </span>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${check != null}">
                    <div class="pagging">
                        <c:forEach begin="1" end ="${numberP}" var="i">
                            <span class="sub-pagging ${tagP == i?"acive-index":""} ">
                                <a  href="searchQuestion?index=${i}" class="${tagP == i?"text-white":"text-black"}" >${i}</a>
                            </span>
                        </c:forEach>
                    </div>
                </c:if>


            </main>
        </div>

        <div class="modal fade" id="alertDanger" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                    </div>
                </div>
            </div>
        </div>
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content" style="width: 600px">
                    <form action="AdminAddQuestion" method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Add Question</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div style="height: 40px;margin-bottom: 10px">
                                <label style="font-size: 24px">Quiz: </label>
                                <select name="quizID" style="font-size: 17px;padding: 4px">
                                    <c:forEach items="${lisQuiz}" var="ll">
                                        <option name="quizId" value="${ll.quizId}">${ll.quizName} in ${ll.subjectName} Subject</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Question Name</label>
                                <input name="nameQ" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Explanation</label>
                                <input name="exp" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input name="img" type="file" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Option 1</label>
                                <input name="op1" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Option 2</label>
                                <input name="op2" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Option 3</label>
                                <input name="op3" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Option 4</label>
                                <input name="op4" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Correct Answer:</label>
                                <input type="number" min="1" max="4" name="ca" class="form-control"
                                       placeholder="Correct Answer" required />
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!--Script for modal active-->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    </body>
</html>
