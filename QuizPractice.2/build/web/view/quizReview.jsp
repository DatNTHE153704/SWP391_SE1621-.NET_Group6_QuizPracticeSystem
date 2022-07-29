<%-- 
    Document   : quizReview
    Created on : Jun 24, 2022, 11:40:17 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link rel="stylesheet" href="css/quizReview.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <script src="https://kit.fontawesome.com/9650a62e47.js" crossorigin="anonymous"></script>

        <title>Quiz Review</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="infomation">
                <div class="info row">
                    <div class="col-1">
                        <a class="goBack" type="button" href="home">Back</a>
                    </div>
                    <div class="col-8" style="display:flex;">
                        <h6>Score: <fmt:formatNumber type = "number" 
                                          maxIntegerDigits = "2" value = "${score}" />/100</h6>
                        <h6>Completion Time: ${time}'</h6>
                        <h6>Submit: ${submitAt}</h6>
                    </div>
                    <div class="col-3">
                        <div class="detail">
                            <div class="detail1">
                                <img id="questionImage" src="img/question.png"> <label for="questionImage">
                                    <h3>${questionNumber}/${totalQuestion}</h3>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container-fluid">
                <div class="mainContent" style="display: flex;">
                    <div class="<c:choose>
                             <c:when test="${media != null}">
                                 col-6
                             </c:when>
                             <c:otherwise>
                                 col-12
                             </c:otherwise>
                         </c:choose>">
                        <div class="row question" style="display: flex;">
                            <div class="col-2">
                            </div>
                            <div class="col-10" style="float:right;">
                                <h4>${questionNumber}. ${content}</h4>
                            </div>
                        </div>
                        <div class="row answers" style="margin-top:10px;">
                            <div class="col-12">
                                <ul>
                                    <c:forEach items="${options}" var="o">
                                        <div class='row'>
                                            <c:if test="${o.optionId == studentWork.optionId}">
                                                <div class='col-2'>
                                                    <div style="float:right;">
                                                        <img src="img/youranswer.png" style='width:70px;height: auto;'>
                                                    </div>
                                                </div>
                                            </c:if>
                                            <div class="col-10" style="display: -webkit-inline-box;">

                                                <label class="labelA" for="" style="
                                                       <c:if test="${media != null}">
                                                           <c:choose>
                                                               <c:when test="${o.optionId != studentWork.optionId}">
                                                                   margin-left: 122px;
                                                               </c:when>
                                                               <c:otherwise>

                                                               </c:otherwise>
                                                           </c:choose>
                                                       </c:if>
                                                       <c:if test="${media == null}">
                                                           <c:choose>
                                                               <c:when test="${o.optionId != studentWork.optionId}">
                                                                   margin-left: 265px;
                                                               </c:when>
                                                               <c:otherwise>
                                                                   margin-left: 15px;
                                                               </c:otherwise>
                                                           </c:choose>
                                                       </c:if>
                                                       ">

                                                    <li style="margin: 0 30px;">
                                                        ${o.content}
                                                    </li>
                                                    <input type="radio" ${o.optionId == studentWork.optionId?"checked":""} class="radioAnswer">
                                                    <span class="checkmark"></span>

                                                </label>
                                                <c:if test="${o.isCorrect == true}">
                                                    <img src="img/right.png" style='width:25px;height: 25px;'>
                                                </c:if>
                                                <c:if test="${o.isCorrect == false}">
                                                    <img src="img/wrong.png" style='width:25px;height: 25px;'>
                                                </c:if>
                                            </div>
                                            <br>

                                        </div>
                                    </c:forEach>
                                </ul>
                                <c:if test="${studentWork.optionId == 0}">
                                    <div class="leave-blank">
                                        You did not answer this option !!!
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <c:if test="${media != null}">
                        <div class="right col-6">
                            <div>
                                <img src="${media}" style="width:100%; height:auto;">
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="modal fade eplain" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Explanation</h5>
                        </div>
                        <div class="modal-body">
                            Explanation: ${explanation}
                        </div>
                        <div class="modal-footer">
                            <a href="" class="" role="button">Exit</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="funtionBar fixed-bottom" style='height:70px; background-color: #007bff;'>
                <div style="margin-top:20px;margin-right: 20px;">
                    <div style="float:right;">
                        <button type="button" class="btn" data-toggle="modal" data-target=".eplain">Explanation</button>
                        <c:if test="${questionNumber>1}">
                            <a class="btn" href="quizReview?quizResultId=${quizResultId}&questionNumber=${questionNumber-1}">Previous</a>
                        </c:if>
                        <c:if test="${questionNumber!=totalQuestion}">
                            <a class="btn" href="quizReview?quizResultId=${quizResultId}&questionNumber=${questionNumber+1}">Next</a>
                        </c:if>
                        <c:if test="${questionNumber==totalQuestion}">
                            <button type="button" class="btn" data-toggle="modal" data-target=".submit">Finish Review</button>
                        </c:if>
                    </div>
                    <div>
                        <button type="button" class="btn" data-toggle="modal" data-target=".bd-example-modal-xl">Review
                            Results</button>
                    </div>
                </div>
            </div>
            <div class="modal fade bd-example-modal-xl" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <div>
                                <h5 class="modal-title" id="exampleModalLabel">Review Results</h5>
                                <br />
                                <h7>Review your quiz results</h7>
                            </div>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>

                        </div>
                        <div class="modal-body">
                            <div>
                                <input type="image" id="unanswered" src="img/unanswered.png" alt="SubmitForm" />
                                <input type="image" id="answered" src="img/answered.png" alt="SubmitForm" />
                                <input type="image" id="allquestions" src="img/allquestions.png" alt="Submit Form" />
                                <button type="button" class="btn scorereview" data-toggle="modal" data-target=".submit"
                                        style="float:right;background-color: #4472c4;border: 1px white solid; color:white;">Finish
                                    Review</button>
                            </div>
                            <br /><br />
                            <div class="holder" style='margin-left:20px'>
                                <c:forEach items="${questions}" var="q">
                                    <a href="quizReview?quizResultId=${quizResultId}&questionNumber=${questions.indexOf(q)+1}" 
                                       class="btn allquestions 
                                       <c:forEach items="${allStudentWork}" var="asw">
                                           <c:if test="${q.questionId == asw.questionId}">
                                               <c:choose>
                                                   <c:when test="${asw.optionId != 0}">
                                                       btn-secondary answered
                                                   </c:when>
                                                   <c:otherwise>
                                                       btn-light unanswered
                                                   </c:otherwise>    
                                               </c:choose>
                                           </c:if>
                                       </c:forEach>
                                       btn-lg active" 
                                       role="button">${questions.indexOf(q)+1}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade submit" id="submitModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Finish Review?</h5>
                        </div>
                        <div class="modal-body">
                            By clicking on the Finish Review button below, you will complete your current review.
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Back</button>
                            <a href="home" id="reviewSubmit" class="btn">Finish Review</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
        var unanswered = document.getElementById('unanswered');
        var answered = document.getElementById('answered');
        var allquestions = document.getElementById('allquestions');

        unanswered.addEventListener("click", viewUnanswered);
        function viewUnanswered() {
            var allquestions = document.getElementsByClassName("allquestions");
            var i;
            for (i = 0; i < allquestions.length; i++) {
                allquestions[i].style.display = 'inline-flex';
            }
            var answered = document.getElementsByClassName("answered");
            var j;
            for (j = 0; j < answered.length; j++) {
                answered[j].style.display = 'none';
            }
        }

        answered.addEventListener("click", viewAnswered);
        function viewAnswered() {
            var allquestions = document.getElementsByClassName("allquestions");
            var i;
            for (i = 0; i < allquestions.length; i++) {
                allquestions[i].style.display = 'inline-flex';
            }
            var unanswered = document.getElementsByClassName("unanswered");
            var j;
            for (j = 0; j < unanswered.length; j++) {
                unanswered[j].style.display = 'none';
            }
        }

        allquestions.addEventListener("click", viewAllQuestions);
        function viewAllQuestions() {
            var allquestions = document.getElementsByClassName("allquestions");
            var i;
            for (i = 0; i < allquestions.length; i++) {
                allquestions[i].style.display = 'inline-flex';
            }
        }

    </script>
</html>