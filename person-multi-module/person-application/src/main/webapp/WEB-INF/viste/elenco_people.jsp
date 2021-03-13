<%@ include file="header.jsp"%>
<%@page import="com.project.user.customer.model.models.Person"%>
<h1>Elenco people</h1>

<ul>
	<c:forEach items="${people}" var="person">
		<li><a href=/gabriel/people/${person.getId()}>${person.getFName()}</a>
			- <a href=/gabriel/people/update/${person.getId()}>change</a> - <a
			href=/gabriel/people/delete?id=${person.getId()}>delete</a></li>
	</c:forEach>
</ul>
<button onclick="myFunction()">Add Person</button>

<script>
function myFunction() {
  location.replace("/gabriel/people/add")
}
</script>

<%@ include file="footer.jsp"%>