<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Students</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active"><a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
            </a></li>
            <li class="nav-item"><a class="nav-link" href="#">Link</a></li>
            <li class="nav-item dropdown"><a
                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                    role="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false"> Dropdown </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a> <a
                        class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item"><a class="nav-link"
                                    href="<%=request.getContextPath() + "/CreateStudent"%>">Add
                Student</a></li>
        </ul>
        <form class="form-inline my-2 my-lg-0" method="get" action="SearchStudent">
            <input class="form-control mr-sm-2" type="search" name="q"
                   placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container mt-5">
    <form method="post" action="UpdateStudent">
        <div class="form-group">
            <input type="hidden" name="studentID" value="${student.ID}">
        </div>
        <div class="form-group">
            <input type="hidden"
                   name="fullName" class="form-control" id="fullname" value="${student.fullName}">
        </div>
        <div class="form-group">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">Gender</label>
                </div>
                <select class="custom-select" id="inputGroupSelect01" name="gender">

                    <option value="1" <c:if test="${student.gender == 'Male'}">selected</c:if>>
                        Male
                    </option>
                    <option value="2" <c:if test="${student.gender == 'Female'}">selected</c:if>>
                        Female
                    </option>
                    <option value="0" <c:if test="${student.gender == 'Other'}">selected</c:if>>
                        Other
                    </option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" required
                   name="address" class="form-control" id="address"
                   placeholder="Enter address" value="${student.address}">
        </div>
        <div class="form-group">
            <label for="phoneNumber">Phone Number</label>
            <input type="text" required
                   name="phoneNumber" class="form-control" id="phoneNumber" value="${student.phoneNumber}"
                   placeholder="Enter phone number">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" name="email" class="form-control" required
                   id="exampleInputEmail1" aria-describedby="emailHelp" value="${student.email}"
                   placeholder="Enter email">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
