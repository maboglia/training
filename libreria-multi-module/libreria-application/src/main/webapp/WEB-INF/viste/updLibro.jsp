<%@ include file="header.jsp" %>

<form method="post" action="/libri/modifica">
<input type="text" value="${libro.getId() }" name="id" disabled>
<input type="text" value="${libro.getTitolo() }" name="titolo" class="form-control"><br>
<input type="text" value="${libro.getPagine() }" name="pagine" class="form-control"><br>
<input type="text" value="${libro.getPrezzo() }" name="prezzo" class="form-control"><br>
<input type="text" value="${libro.getEditore_id() }" name="editore_id" class="form-control"><br>
<input type="text" value="${libro.getP_iva() }" name="p_iva" class="form-control"><br>

<input type="submit" value="aggiungi libro">

</form>

<%@ include file="footer.jsp" %>