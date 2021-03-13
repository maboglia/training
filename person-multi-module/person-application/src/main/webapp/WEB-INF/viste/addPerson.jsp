<%@ include file="header.jsp"%>

<form method="post" action="/gabriel/people/add/">

	<input type="text" name="fName" placeholder="fName"
		class="form-control"><br> <input type="text" name="lName"
		placeholder="lName" class="form-control"><br> <input
		type="text" name="email" placeholder="email" class="form-control"><br>
	<input type="text" name="phone" placeholder="phone"
		class="form-control"><br> <input type="text"
		name="password" placeholder="password" class="form-control"><br>

	<input type="submit" value="add Person">

</form>

<%@ include file="footer.jsp"%>