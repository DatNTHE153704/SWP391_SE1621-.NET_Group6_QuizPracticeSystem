<%-- 
    Document   : adminSubject
    Created on : Jul 6, 2022, 2:22:38 PM
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
    </head>
    <body>
        <div class="sidebar">
            <div class="sidebar-brand">
                <h2><span class="las la-accusoft"></span>Admin Page</h2>
            </div>

            <div class="sidebar-menu">
                <ul>
                    <li>
                        <a href="admin.html" 
                           ><i class="fas fa-user-circle"></i> <span>User</span></a
                        >
                    </li>
                    <li>
                        <a href="admin_course.html"
                           ><i class="fas fa-book-open"></i><span>Quiz</span></a
                        >
                    </li>
                    <li>
                        <a href="#"
                           ><i class="fas fa-graduation-cap"></i><span>Expert</span></a
                        >
                    </li>
                    <li>
                        <a href="AdminSubjectController" class="active"
                           ><i class="fas fa-laptop"></i>
                            <span>Subject</span></a
                        >
                    </li>
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
                    <img
                        src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEAoTadQ4n5Oe-rLqJz9j_UCkUhtcLoZlacA&usqp=CAU"
                        width="40px"
                        height="40px"
                        alt="Error"
                        />
                    <div>
                        <h4>Eminem</h4>
                        <small>Slim Shady</small>
                    </div>
                </div>
            </header>

            <main>
                <div class="container">
                    <div class="row justify-content-between subject-section">
                        <h2 class="mt-3">Subject Management</h2>
                        <a href="AdminAddSubjectController" style="height:30px !important;margin-right: 20px;margin-top: 10px " class="btn btn-primary btn-sm float-right">Add subject</a>
                    </div>

                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>     
                                <th>Thumbnail</th>     
                                <th>Description</th>    
                                <th>Delete</th>
                                <th>Update</th>    
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${adminSubject}" var="as">
                                <tr>               
                                    <td>${as.subjectName}</td>
                                    <!--<td><img src="${pageContext.request.contextPath}/view/img/${as.image}"></td>-->
                                    <td>${pageContext.request.contextPath}/view/img/${as.image}</td>
                                    <td>${as.description}</td>
                                    <td><button type="button" class="btn btn-primary">Delete</button></td>
                                    <td><a href="" class="btn btn-primary">Update</a></td>                                 
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </main>
        </div>
        <!--Script for modal active-->
        <script>
            $("#myModal").on("shown.bs.modal", function () {
                $("#myInput").trigger("focus");
            });
        </script>

        <script
            src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"
        ></script>
    </body>

</html>
