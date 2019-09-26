<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>User Inventory Page</h1>

            <p class="lead">This is the user inventory page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>User Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th>Team</th>
            </tr>
            </thead>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><img src="<c:url value="/resources/images/${user.id}.png" />" alt="image" style="width: 100%"/></td>
                    <td>${user.fullName}</td>
                    <td>${user.comsi}</td>
                    <td>${user.startDate}</td>
                    <td>${user.room}</td>
                    <td>${user.cluster}</td>
                    <td>${user.chapter}</td>

                        <%--HTTP request is sent with specific userId to the controller--%>
                    <td><a href="<spring:url value="/userList/viewUser/${user.id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/userInventory/deleteUser/${user.id}"/>"><span class="glyphicon glyphicon-remove"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<c:url value="/admin/userInventory/addUser" />" class="btn btn-primary">Add User</a>

<%@include file="/WEB-INF/views/template/footer.jsp" %>