
<b:base title="Formulario">
	<div class="container">
		<h2 class="form-signin-heading">formulario</h2>	
		<form:form method="post" modelAttribute="loginForm" action = "http://localhost:8080/utm/api/v1/user">
			<form:label path="username">Username</form:label>
			<form:input path="username" cssClass="form-control" placeholder="Username"/>
			<form:label path="password">Password</form:label>
			<form:password path="password" cssClass="form-control" placeholder="****"/>
			<br/>
			<button class="btn btn-lg btn-primary btn-block" type="submit">enviar</button>
		</form:form>
		
	</div>
</b:base>