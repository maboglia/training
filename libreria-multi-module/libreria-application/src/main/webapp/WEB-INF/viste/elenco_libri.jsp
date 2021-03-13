<%@ include file="header.jsp" %>

	<h1>Elenco libri</h1>

	<ul>
		<c:forEach items="${libri}" var="libro">
			<li>
				<a href=/libri/${libro.getId()} }>${libro.getTitolo()}</a> - 
				<a href=/libri/update/${libro.getId()} >modifica</a> - 
				<a href=/libri/delete?id=${libro.getId()} >elimina</a>
<!-- 			<a href=# id="eliminaRest">eliminaRestAjax</a> -->
			
				
			</li>
		</c:forEach>
	</ul>

<%@ include file="footer.jsp" %>