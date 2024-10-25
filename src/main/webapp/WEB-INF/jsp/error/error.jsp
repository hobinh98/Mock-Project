<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Error Page</title>
<!-- link online -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<style>
/* ẨN PHẦN TỬ audio NHƯ VẪN HOẠT ĐỘNG ĐƯỢC */
audio {
	display: none;
}

.exception {
	position: absolute;
	top: 0px;
}

.exception:hover {
	cursor: pointer;
}

body {
	position: relative;
	font-family: Arial, sans-serif;
	background-color: white;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 100vh;
	margin: 0;
}

.error-icons {
	display: flex;
	justify-content: center;
	margin-bottom: 20px;
}

.error-icons img {
	width: 100px;
	height: 100px;
	margin: 0 10px;
	animation: bounce 1s infinite;
}

@keyframes bounce {
	0% {
		transform: translateY(0);
	}

	50% {
		transform: translateY(-16px);
	}

	100% {
		transform: translateY(0);
	}
}

.error-container {
	background-image: url('<%=request.getContextPath()%>/styles/error/404 error.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
	width: 700px;
	height: 500px;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	text-align: center;
	animation: bounce 1s infinite;
}
</style>

</head>
<body>
	<b class="exception" onclick="searchOnGoogle('${exception }')">${exception }</b>
		
	<div class="error-icons">
		<img src="https://media.giphy.com/media/3oEjI6SIIHBdRxXI40/giphy.gif" alt="Error Icon 1">
	</div>
	<form action="" id="formAudio">
		<button id="play" type="button" class="error-container" style="background-color: transparent; border: none; padding: 0;">
				
		</button>
	</form>
	<audio id="myAudio" controls>
		<source src="<%=request.getContextPath()%>/styles/error/audioError.mp3" type="audio/mpeg">
	</audio>
	<input id="hidden" type="hidden" value="hidden">
	<!-- link online -->
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		function searchOnGoogle(keyword) {
			window.open("https://www.google.com/search?q=" + keyword, "_blank");
		}
		$("#play").click(function () {
			console.log("click")
			const audioElement = document.getElementById('myAudio');
			audioElement.play();

			let timeOut;
			timeOut = setTimeout(function () {
				// Sự kiện sẽ được kích hoạt sau 8 giây -- tìm hiểu "setTimeout" và "clearTimeout"
				const form = document.getElementById("formAudio");
				form.action = "/springmvc/home";
				form.submit();
			}, 8000);
		});
	</script>
</body>
</html>