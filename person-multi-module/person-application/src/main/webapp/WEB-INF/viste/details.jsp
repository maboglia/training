<%@ include file="header.jsp"%>


<h1>${person.getFName()}</h1>
<h1>${person.getLName()}</h1>
<h2>Email: ${person.getEmail()}</h2>
<h2>Phone: ${person.getPhone()}</h2>
<h2>Password: ${person.getPassword()}</h2>
<h2>Address:</h2>
<ul>
	<c:forEach items="${person.getAds()}" var="address">
		<li>
			<h3>City: ${address.getCity()}</h3>
			<h3>Street: ${address.getStreet()}</h3>
			<h3>House Number: ${address.getHNumber()}</h3> <a
			href=/gabriel/address/add/${address.getId()}>add</a> <a
			href=/gabriel/address/update/${person.getId()}>change</a> <a
			href=/gabriel/delete?id=${person.getId()}>delete</a>
		</li>
	</c:forEach>
</ul>


<%@ include file="footer.jsp"%>