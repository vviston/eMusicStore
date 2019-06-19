<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Users</h1>

            <p class="lead">Checkout all the awesome users available now!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><img src="<c:url value="/resources/images/${user.id}.png" />" alt="image" style="width: 100%"/></td>
                    <td>${user.fullName}</td>
                    <td>${user.comsi}</td>
                    <td>${user.team}</td>
                    <td>${user.room}</td>

                    <%--HTTP request is sent with specific userId to the controller--%>
                    <td><a href="<spring:url value="/userList/viewUser/${user.id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a></td>
                </tr>
            </c:forEach>
        </table>

<%@include file="/WEB-INF/views/template/footer.jsp" %>