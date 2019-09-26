<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add User!</h1>

            <p class="lead">Fill the below information to add a user!</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/userInventory/addUser" method="post" commandName="user" enctype="multipart/form-data">
        <div class="form-group">
            <label for="fullName">Name</label>
            <form:input path="fullName" id="fullName" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="comsi">Comsi</label>
            <form:input path="comsi" id="comsi" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="startDate">Start Date</label>
            <form:input type="date" path="startDate"  id="startDate" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="room">Room</label>
            <form:input path="room" id="room" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="cluster">Cluster</label>
            <form:input path="cluster" id="cluster" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="chapter">Chapter</label>
            <form:input path="chapter" id="chapter" class="form-Control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input id="productImage" path="userPhoto" type="file" class="form:input-large" />
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/userInventory"/>" class="btn btn-default">Cancel</a>

        </form:form>


<%@include file="/WEB-INF/views/template/footer.jsp" %>