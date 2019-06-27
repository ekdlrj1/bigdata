<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script>
$(document).ready(function() {
		$("#nvbtn").click(function() {
			var paramData = $("#search").serialize();   
			var html = "";
			$.post("nvapi.gg", paramData, function(data) {
				$.each(data.items, function(key, val) {
// 					alert("Data: " + key + "\nStatus: " + val.title);
					html += "<a href='" + val.link + "'>" + val.title + "</a><br>";
					$("#test2").html(html);
				});
			});
		});
});
</script>
</head>
<body>
	<br>

	<div class="container">
		<h2>내 사이트</h2>
		<br>
		<!-- Nav pills -->
		<ul class="nav nav-pills" role="tablist">
			<li class="nav-item"><a class="nav-link active"
				data-toggle="pill" href="#home">Home</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="pill"
				href="#menu1">오늘 머 먹지?</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="pill"
				href="#menu2">네이버뉴스</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div id="home" class="container tab-pane active">
				<br>
				<h3>HOME</h3>
				<p>메인 화면</p>
			</div>
			<div id="menu1" class="container tab-pane fade">
				<br>
				<h3>오늘 머 먹지?</h3>
				<p>머먹지 페이지 띄우기</p>
			</div>
			<div id="menu2" class="container tab-pane fade">
				<br>
				<h3>네이버 뉴스</h3>
				<input type="text" name="search" id="search">
				<button type="button" id="nvbtn" class="btn btn-success">검색ㄱㄱ</button>
				<p id="test2">네이버 뉴스보기 페이지</p>
				
<!-- 					<button id="btn2">Set HTML</button> -->
<!-- 				<a href="nvapi.gg">네이버 뉴스 보기</a> -->

			</div>
		</div>
	</div>

</body>
</html>
