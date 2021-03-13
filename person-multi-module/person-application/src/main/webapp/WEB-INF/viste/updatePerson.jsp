<%@ include file="header.jsp"%>

<form method="post" action="/gabriel/people/update">
	<input type="text" value="${person.getId() }" name="id" disabled>
	<input type="text" value="${person.getfName() }" name="fName"
		class="form-control"><br> <input type="text"
		value="${person.getlName() }" name="lName" class="form-control"><br>
	<input type="text" value="${person.getEmail() }" name="Email"
		class="form-control"><br> <input type="text"
		value="${person.getPhone() }" name="Phone" class="form-control"><br>
	<input type="text" value="${person.getPassword() }" name="Password"
		class="form-control"><br> <input type="submit"
		value="update Person">

</form>

<%@ include file="footer.jsp"%>