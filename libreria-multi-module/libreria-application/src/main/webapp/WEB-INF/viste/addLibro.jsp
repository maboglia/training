<%@ include file="header.jsp" %>

<form method="post" action="/libri">
<!-- <input type="hidden" name="id" value=""> -->
<input type="text" name="titolo" placeholder="titolo" class="form-control"><br>
<input type="text" name="pagine" placeholder="pagine" class="form-control"><br>
<input type="text" name="prezzo" placeholder="prezzo" class="form-control"><br>
<input type="text" name="editore_id" placeholder="editore_id" class="form-control"><br>
<input type="text" name="p_iva" placeholder="p_iva" class="form-control"><br>

<input type="submit" value="aggiungi libro">

</form>

<%@ include file="footer.jsp" %>