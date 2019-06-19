<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>User Detail</h1>

            <p class="lead">Here is the detail information of the user!</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${user.id}.png" /> " alt="image" style="width: 100%"/>
                </div>

                <div class="col-md-5">
                    <h3>${user.fullName}</h3>
                    <p>${user.comsi}</p>
                    <p><strong>Start date</strong> : ${user.startDate}</p>
                    <p><strong>Room</strong> : ${user.room}</p>
                    <p><strong>Team</strong> : ${user.team}</p>
                </div>
            </div>

        </div>


<%@include file="/WEB-INF/views/template/footer.jsp" %>