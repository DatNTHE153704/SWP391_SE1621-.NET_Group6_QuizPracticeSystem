<%-- 
    Document   : quizHandle2
    Created on : Jun 23, 2022, 11:52:44 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/quizHandle2.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


        <title>Quiz Review</title>
    </head>

    <body>
        <div class="container-fluid">
            <div class="infomation">
                <div class="info row">
                    <div col-1>
                        <a href="" class="goBack" type="button" class="btn" onclick="">Back</a>
                    </div>
                    <div class="col-6 clock" >
                        <div id="clockdiv" style="margin-top: 8px">
                            <div>
                                <span class="hour" id="h"></span>
                                <div class="smalltext"></div>
                            </div>
                            <div>
                                <span class="minutes" id="m"></span>
                                <div class="smalltext"></div>
                            </div>
                            <div>
                                <span class="seconds" id="s"></span>
                                <div class="smalltext"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-5">
                        <div class="detail">
                            <div class="detail1">
                                <img id="questionImage" src="${pageContext.request.contextPath}/img/question.png"> <label for="questionImage">
                                    <h3 id="numberQuestion"></h3>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--            <div class="row infomation1" style="background-color: #007bff;">
                            <div class="col-1">
                                <h6></h6>
                            </div>
                        </div>-->
            <form id="formQuiz" action="QuizHandle" method="post">
                <input hidden="" id="quizId" name="quizId" value="${quizId}">

                <input hidden="" id="hour" name="hour" value="">
                <input hidden="" id="minus" name="minus" value="">
                <input hidden="" id="second" name="second" value="">


                <c:forEach items="${requestScope.listQuestion}" var="lq">
                    <div class="mainContent questionQuiz" >

                        <div class="">
                            <div class="row question" style="display: flex;">
                                <div class="col-1">
                                </div>
                                <div class="col-11" style="float:right;">
                                    <h4>${lq.content}</h4>
                                </div>
                            </div>
                            <div class="row answers" style="margin-top:10px;">
                                <c:if test="${lq.media != null}">
                                    <div class="col-12">
                                        <ul>
                                            <div class='row'>
                                                <c:forEach items="${requestScope.listOption}" var="lo">
                                                    <c:if test="${lq.questionId == lo.questionId}">

                                                        <div class="col-11" style="display: -webkit-inline-box;">
                                                            <label class="labelA" for="">
                                                                <li style="margin-left: 30px;">
                                                                    ${lo.content}
                                                                </li>
                                                                <input type="radio" name="${lq.questionId}" value="${lo.optionId}" id="" class="radioAnswer">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                        </div>
                                                        <br />
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </ul>
                                    </div>
                                </c:if>
                                <c:if test="${lq.media == null}">
                                    <div class="col-1"></div>
                                    <div class="col-7">
                                        <ul>
                                            <div class='row'>
                                                <c:forEach items="${requestScope.listOption}" var="lo">
                                                    <c:if test="${lq.questionId == lo.questionId}">

                                                        <div class="col-11" style="display: -webkit-inline-box;">
                                                            <label class="labelA" for="">
                                                                <li style="margin-left: 30px;">
                                                                    ${lo.content}
                                                                </li>
                                                                <input type="radio" name="${lq.questionId}" value="${lo.optionId}" id="" class="radioAnswer">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                        </div>
                                                        <br />
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </ul>
                                    </div>
                                </c:if>
                                <div class="col-1">
                                </div>
                            </div>
                        </div>
                        <c:if test="${lq.media != null}">
                            <div class="right col-4">
                                <div>
                                    <iframe style="width:100%; height:450px;" src="">
                                    </iframe>
                                    <img src="" style="width:100%; height:auto;">
                                </div>
                            </div>
                        </c:if>

                    </div>
                </c:forEach>
                <input hidden="" type="submit" id="submitAuto">
                <div class="exitExam" id="exit">

                    <div class="exitExam-content">
                        <div style="font-weight: bold; margin-bottom: 30px">Exit Exam?</div>
                        <div id="messageNumber"></div>
                        <div id="message" style="margin-bottom: 30px"></div>

                        <input style="margin-button: 50px; background-color:white; border-color: greenyellow; color: greenyellow " id="submit"  class=" align-items-center float-right"
                               type="submit" value="Score exam">
                        <input style="margin-button: 50px; margin-right: 10px; font-weight: normal;" id="back" class=" close  align-items-center  float-right"
                               type="button" value="Back">
                    </div>
                </div>
            </form>

            <div class="funtionBar fixed-bottom" style='height:70px; background-color: #007bff; position: fixed; right: 0; bottom: 0; left: 0;'>
                <div style="margin-top:20px;margin-right: 20px;">
                    <div style="float:right;">
                        <button class="btn" onclick="plusSlides(-1)" type="button">Previous Question</button>
                        <button class="btn" onclick="plusSlides(1)" type="button">Next Question</button>
                        <button type="button" class="btn" id="submitPopup" >Submit Exam</button>
                    </div>
                    <div>
                        <button type="button" id="reviewPopup" class="btn" >Review Progress</button>
                    </div>
                </div>
            </div>



        </div>

        <!--Popup Review-->
        <div class="reviewExam" id="review">

            <div id="reviewPopup" class="reviewExam-content">
                <div class="questionButton">
                    <c:forEach items="${requestScope.listQuestion}" var="lq">
                        <button type="button" id="${lq.questionId}" style="background-color: white;" onclick="chooseQuestion(${lq.questionId})" ></button>
                    </c:forEach>
                </div>
                <input style="margin-button: 50px; background-color:white; border-color: greenyellow; color: greenyellow " id="submitReview"  class=" align-items-center float-right"
                       type="button" value="Score exam">
                <input style="margin-button: 50px; margin-right: 10px; font-weight: normal;" id="back" class=" close  align-items-center  float-right"
                       type="button" value="Back">
            </div>
        </div>
        <!--Popup Review-->


        <script>
            let slideIndex = 1;
            showSlides(slideIndex);
            function plusSlides(n) {
                showSlides(slideIndex += n);
            }

            function currentSlide(n) {
                showSlides(slideIndex = n);
            }
            function showSlides(n) {
                let i;
                let slides = document.getElementsByClassName("questionQuiz");
                if (n > slides.length) {
                    slideIndex = 1;
                }
                if (n < 1) {
                    slideIndex = slides.length;
                }
                for (i = 0; i < slides.length; i++) {
                    slides[i].style.display = "none";

                }
                document.getElementById("numberQuestion").innerHTML = slideIndex + " / " + i;

                slides[slideIndex - 1].style.display = "flex";
            }
            var reviewExam = document.getElementById("review");

            var exitExam = document.getElementById("exit");

            var btSubmit = document.getElementById("submitPopup");

            var btSubmitExam = document.getElementById("submit");
            var submitReview = document.getElementById("submitReview");

            var closeSubmit = document.getElementsByClassName("close")[0];
            var closeReview = document.getElementsByClassName("close")[1];
            var submitAuto = document.getElementById("submitAuto");


            var list;
            var number;
            btSubmit.onclick = function () {
                number = 0;
                list = [];
                exitExam.style.display = "block";
            <c:forEach items="${requestScope.listQuestion}" var="lq">

                value = document.getElementsByName(${lq.questionId});
                number = number + 1;
                for (var i = 0, length = value.length; i < length; i++) {
                    if (value[i].checked === true) {
                        list.push(value[i].value);
                        document.getElementById(${lq.questionId}).style.backgroundColor = "red";

                        break;
                    }
                }




            </c:forEach>
                if (number == list.length)
                {
                    document.getElementById("message").innerHTML = "By clicking on the [Score Exam] button below, you wil complete your current exam"
                            + " and receive your score. You will not be able to change any answers after this point";
                } else if (list.length == 0) {
                    document.getElementById("submit").value = "Exit Exam";
                    document.getElementById("message").innerHTML = "You have not answered any questions. By clicking on the [Exit Exam] button below"
                            + ", you will complete your current exam and be returned to the dashboard";

                } else {
                    document.getElementById("messageNumber").innerHTML = list.length + " of " + number;
                    document.getElementById("message").innerHTML = "By clicking on the [Score Exam] button below, you wil complete your current exam"
                            + " and receive your score. You will not be able to change any answers after this point";
                }

                // When the user clicks on <span> (x), close the modal

            };
            closeReview.onclick = function () {
                reviewExam.style.display = "none";

            };
            closeSubmit.onclick = function () {
                exitExam.style.display = "none";

            };


            var btReview = document.getElementById("reviewPopup");

            btReview.onclick = function () {
                number = 1;
                reviewExam.style.display = "block";
            <c:forEach items="${requestScope.listQuestion}" var="lq">
                list = [];
                document.getElementById(${lq.questionId}).innerHTML = number;
                document.getElementById(${lq.questionId}).value = number;
                number = number + 1;

                value = document.getElementsByName(${lq.questionId});

                for (var i = 0, length = value.length; i < length; i++) {
                    if (value[i].checked === true) {
                        document.getElementById(${lq.questionId}).style.backgroundColor = "blue";

                        break;
                    }
                }

            </c:forEach>
            };

            function chooseQuestion(n) {
                reviewExam.style.display = "none";
                currentSlide(document.getElementById(n).value);

            }
            var h = null;
            var m = null; // Phút
            var s = null; // Giây

            var timeout = null; // Timeout

            function start()
            {

                if (h === null) {
                    h = ${hour}
                    m = ${minus};
                    s = ${second};
                }

                if (s === -1) {
                    m -= 1;
                    s = 59;
                }
                if (m === -1) {
                    h -= 1;
                    m = 59;
                }

                if (h == -1) {

                    submitAuto.click();
                    return false;
                }

                document.getElementById('h').innerText = h.toString();
                document.getElementById('m').innerText = m.toString();
                document.getElementById('s').innerText = s.toString();

                document.getElementById('hour').value = h;
                document.getElementById('minus').value = m;
                document.getElementById('second').value = s;



                timeout = setTimeout(function () {
                    s--;
                    start();
                }, 1000);
            }
            window.onload = start();

            submitReview.onclick = function ()
            {
                submitAuto.click();


            };
        </script>
    </body>


</html>
