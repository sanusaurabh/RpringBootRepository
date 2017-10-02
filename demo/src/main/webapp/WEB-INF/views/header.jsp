<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 
<div>
 <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>  
        <h3>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h3>
    </c:if>
</div>

<div class="container">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SEO HELPER</a>
    </div>
    <ul class="nav navbar-nav">
      <li id="home"><a href="welcome">Home</a></li>
      <li id ="uploadCsvfileforfilterdata"><a href="uploadCsvfileforfilterdata">Filter_Csv </a></li>
      <li><a href="multipleUpload">Send_Email</a></li>
      <li><a href="#">Email_Extractor</a></li>
    </ul>
  </div>
</nav>
</div>
<%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script> --%>