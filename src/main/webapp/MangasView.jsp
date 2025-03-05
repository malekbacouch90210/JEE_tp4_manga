<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Recherche des Mangas</title>
</head>
<body>
	<form action="controleur" method="post">
		<input type="text" name="motCle" value="${modele.motCle}"> 
		<input type="submit" value="OK">
	</form>
	<table border="1" width="80%">
		<tr>
			<th>ID</th>
			<th>Nom Manga</th>
			<th>Prix</th>
		</tr>
		<c:forEach items="${modele.mangas}" var="m">
			<tr>
				<td>${m.idManga}</td>
				<td>${m.nomManga}</td>
				<td>${m.prix}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
