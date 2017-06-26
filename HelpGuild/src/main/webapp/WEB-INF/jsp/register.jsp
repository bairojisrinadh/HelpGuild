<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>
<!DOCTYPE html>
<link rel="icon" href="../../favicon.ico">
<title>Login</title>
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
<link href="signin.css" rel="stylesheet">
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<body>
	<div class="container">
		<form:form cssClass="form-horizontal" commandName="registernow">
			<h2 class="form-signin-heading">Please Register</h2>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Email: </label>
				<div class="col-sm-10">
					<form:input path="email" id="email" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Name: </label>
				<div class="col-sm-10">
					<form:input path="name" id="name" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Password:
				</label>
				<div class="col-sm-10">
					<form:password path="password" id="password"
						cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Confirm
					Password: </label>
				<div class="col-sm-10">
					<form:input path="confirmPassword" id="rePassword"
						cssClass="form-control" />
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-default btn-primary" id="submit"
						type="submit" name="submit" value="Submit" />
				</div>
			</div>
		</form:form>
	</div>
</body>

