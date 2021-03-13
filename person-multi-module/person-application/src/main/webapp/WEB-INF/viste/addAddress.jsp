<%@ include file="header.jsp"%>

<form method="post" action="/gabriel/address/add/">
	<input type="text" name="City" placeholder="City" class="form-control"><br>
	<input type="text" name="Street" placeholder="Street"
		class="form-control"><br> <input type="text"
		name="House_Number" placeholder="House Number" class="form-control"><br>
	<input type="submit" value="add Address">

</form>

<%@ include file="footer.jsp"%>