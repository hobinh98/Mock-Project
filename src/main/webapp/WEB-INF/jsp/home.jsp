<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome home</title>
<!-- link online -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/bootstrap-4.6.2-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/fontawesome-free-5.15.4-web/css/all.min.css">

<style type="text/css">
#buttonWelcome {
	background-color: transparent;
	border: none;
	padding: 0;
	width: 100%;
	height: 100%;
}

body {
	margin: 0;
	padding: 0;
	height: 100vh;
	width: 100vw;
	overflow: hidden;
}

.welcome {
	background-image:
		url('<%=request.getContextPath()%>/styles/error/welcome.gif');
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
	width: 100%;
	height: 100%;
	position: relative;
}

.welcome form {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}
</style>

</head>
<body>
	<div class="welcome">
		<form action="" id="formWelcome">
			<button id="buttonWelcome" type="button" style=""></button>
		</form>
	</div>

	<!-- link online -->
	<script	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		$("#buttonWelcome").click(function() {
			const form = document.getElementById("formWelcome");
			form.action = "/springmvc/home/manage";
			form.submit();
		});
	</script>
</body>
</html>