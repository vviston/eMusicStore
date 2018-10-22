<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product!</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="#" alt="image" style="width: 100%; height: 300px;" />
                </div>

                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p>${product.productManufacturer}</p>
                    <p>${product.productCategory}</p>
                    <p>${product.productCondition}</p>
                    <p>${product.productPrice}</p>
                </div>
            </div>

        </div>


<%@include file="/WEB-INF/views/template/footer.jsp" %>