<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container bootstrap snippet">
            <div class="row">
                <div class="col-sm-10"><h1>User Profile</h1></div>
                <div class="col-sm-2"><a href="/users" class="pull-right"><img title="profile image" class="img-circle img-responsive" src="${user.avatar}"></a></div>
            </div>
            <div class="row">
                <div class="col-sm-3"><!--left col-->

                    <div class="text-center">
                        <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
                        <!--<img src="${avatar}" class="avatar img-circle img-thumbnail" alt="avatar">-->
                        <h6>Upload a different photo...</h6>
                        <h6>${user.email}</h6>
                        <input type="file" class="text-center center-block file-upload">
                    </div></hr><br>

                </div><!--/col-3-->
                <div class="col-sm-9">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                    </ul>


                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>
                            <form class="form" action="##" method="post" id="registrationForm">
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="first_name"><h4>Username</h4></label>
                                        <input type="text" class="form-control" value="${user.userName}" name="first_name" id="first_name" placeholder="first name" title="enter your first name if any.">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="Gender"><h4>Gender</h4></label>
                                        <c:choose>
                                            <c:when test="${user.gender == true}">
                                                <input type="text" class="form-control" value="FeMale" name="gender" id="gender" placeholder="enter gender" title="enter your gender">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control" value="Male" name="gender" id="gender" placeholder="enter gender" title="enter your gender">
                                            </c:otherwise>
                                        </c:choose>

                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="date"><h4>Date of birth</h4></label>
                                        <input type="text" class="form-control" value="${user.dob}" name="date" id="date" placeholder="enter mobile number" title="enter your date of birth number if any.">
                                    </div>
                                </div>
<!--                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="address"><h4>Address</h4></label>
                                        <input type="address" class="form-control" value="${dob.address}" name="address" id="address"  placeholder="enter address"  title="enter your address.">
                                    </div>
                                </div>-->
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <br>
                                        <button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>
                                        <button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>
                                    </div>
                                </div>
                            </form>

                            <hr>

                        </div><!--/tab-pane-->
                    </div><!--/tab-pane-->
                </div><!--/tab-content-->

            </div><!--/col-9-->
        </div><!--/row-->
    </body>
</html>

