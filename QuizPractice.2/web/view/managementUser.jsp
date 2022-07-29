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
        <title>Manage User</title>
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
                        <a href="managementUser" class="active"><i class="fas fa-user-circle"></i><span>Manage User</span></a>
                    </li><br>
                    <li>
                        <a href="AdminQuizController"><i class="fas fa-book-open"></i><span>Manage Quiz</span></a>
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
                <form action="managementUser" method="get">
                    <div class="search-wrapper">
                        <span class="class las la-search"></span>
                        <input name="value" type="text" placeholder="Search here" />
                        <input type="submit" value="Search" />
                    </div>
                </form>

            </header>

            <main>

                <div class="container-fluid">
                    <h2 style="float: left; margin: 50px 0;" style="margin-top: 80px;">User Management</h2>
                    <button style="float: right; margin: 60px 0;" type="button" class="btn btn-success btn-add" data-toggle="modal"
                            data-target="#exampleModal">
                        Add New User
                    </button>
                    <table style="clear: both; " class="table table-striped table-bordered">
                        <thead style="text-align: center;">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">UserName</th>
                                <th scope="col">Email</th>
                                <th scope="col">Avatar</th>
                                <th scope="col">Gender</th>
                                <th scope="col">Dob</th>
                                <th scope="col">Role</th>
                                <th scope="col">Status</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>

                        <tbody style="text-align: center;">

                            <c:if test="${totalUsers != 0}">
                                <c:forEach items="${users}" var="u">
                                    <tr>
                                        <td>${u.userId}</td>
                                        <td>${u.userName}</td>
                                        <td>${u.email}</td>
                                        <td><img src="../img/${u.avatar}" alt="" width="100px" height="100px"></td>
                                        <td>
                                            <c:if test="${u.gender == true}">
                                                Male
                                            </c:if>
                                            <c:if test="${u.gender == false}">
                                                Female
                                            </c:if>
                                        </td>
                                        <td><fmt:formatDate value="${u.dob}" pattern="dd/MM/yyyy" /></td>
                                        <td>   
                                            <c:forEach items="${roles}" var="r"> 
                                                <c:if test="${r.roleId == u.roleId}">
                                                    ${r.roleName}
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <c:if test="${u.status == 1}">
                                                Active
                                            </c:if>
                                            <c:if test="${u.status == 2}">
                                                Not Active
                                            </c:if>
                                            <c:if test="${u.status == 3}">
                                                Blocked
                                            </c:if>
                                        </td>
                                        <td>
                                            <input id="text-value" type="hidden" value="${value}" />
                                            <c:if test="${u.status == 3 || u.status == 2}">
                                                <a href="#" onclick="messageActive(${u.userId}, ${u.roleId})" class="btn btn-success">Active</a>
                                            </c:if>
                                            <c:if test="${u.status == 1}">
                                                <a href="#" onclick="messageBlock(${u.userId}, ${u.roleId})" class="btn btn-danger">Block</a>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                    </table>
                    <c:if test="${totalUsers == 0}">
                        <h6 style="font-size: 40px; color: red; text-align: center; margin: 40px 0;">${alert}</h6>
                    </c:if>
                </div>
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

        <!-- Modal Add -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add New User</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="addUser" method="post">
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
                            </style>

                            <c:if test="${msg1 eq 'case1'}">
                                <div class="alert">
                                    <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
                                    This username is already in use !!!
                                </div>
                                <input type="hidden" id="msg-1" value="${msg1}" />
                            </c:if>

                            <div class="form-group">
                                <label for="exampleInputName1">User Name</label>
                                <input type="text" name="userName" class="form-control" id="exampleInputName1"
                                       placeholder="Enter User Name" required />
                            </div>

                            <c:if test="${msg2 eq 'case2'}">
                                <div class="alert">
                                    <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span>
                                    This email is already in use !!!
                                </div>
                                <input type="hidden" id="msg-2" value="${msg2}" />
                            </c:if>

                            <div class="form-group">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                                       placeholder="Enter Email" required />
                            </div>

                            <c:if test="${msg3 eq 'case3'}">
                                <div class="alert">
                                    <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span>
                                    Password and Confirm Password must be match !
                                </div>
                                <input type="hidden" id="msg-3" value="${msg3}" />
                            </c:if>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                                       placeholder="Enter Password" required />
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Confirm Password</label>
                                <input type="password" name="re-password" class="form-control" id="exampleInputPassword1"
                                       placeholder="Confirm Password" required />
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Gender</label>
                                <label for="" style="margin-left: 20px;"></label>
                                <input type="radio" name="gender" value="Male" checked /> Male
                                <label for="" style="margin-left: 20px;"></label>
                                <input type="radio" name="gender" value="Female" /> Female
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Dob</label>
                                <input type="date" name="dob" class="form-control" id="exampleInputDob1"
                                       placeholder=" Enter Dob" required />
                            </div>

                            <div class="form-group">
                                <label for="exampleInputRole1">Role</label><br>
                                <select name="role" id="exampleInputRole1">
                                    <c:forEach items="${roles}" var="r"> 
                                        <c:if test="${r.roleId != 1}">
                                            <option value="${r.roleId}">${r.roleName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                    Close
                                </button>
                                <button type="submit" class="btn btn-primary">Add</button>
                            </div>
                        </form>
                    </div>

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

        <script>

                                        function messageActive(userId, roleId) {
                                            var check;
                                            var value = document.getElementById('text-value').value;
                                            if (roleId == 1) {
                                                check = alert('Error');
                                            } else {
                                                window.location.href = 'activeUser?userId=' + userId + '&value=' + value;
                                            }
                                        }

                                        function messageBlock(userId, roleId) {
                                            var check;
                                            var value = document.getElementById('text-value').value;
                                            if (roleId == 1) {
                                                check = alert('Admin can not block Admin.');
                                            } else {
                                                check = confirm('Are you sure to block this user.');
                                                if (check == true) {
                                                    window.location.href = 'blockUser?userId=' + userId + '&value=' + value;
                                                }
                                            }
                                        }
                                        $(document).ready(function () {
                                            var msg1 = $("#msg-1").val();
                                            var msg2 = $("#msg-2").val();
                                            var msg3 = $("#msg-3").val();
                                            if (msg1 == "case1" || msg2 == "case2" || msg3 == 'case3') {
                                                $("#exampleModal").modal('show');
                                            }
                                        });

                                        $(".btn-add").click(function () {
                                            $("#exampleModal").modal('show');
                                        });
        </script>

    </body>

</html>
