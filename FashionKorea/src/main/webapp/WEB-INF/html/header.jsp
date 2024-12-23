<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<meta charset="UTF-8" />
<title>패션 코리아</title>
</head>
<body>
	<!-- 헤더 -->
	<header>
		<nav>
			<a href="http://localhost/FashionKorea">
				<div class="logo">
					<img src="./images/logo/태극기.jpg" alt="패션 코리아">
				</div>
			</a>
			<div class="menuBar">

<<<<<<< HEAD
				<a href="">검색</a>
				<a href="productList.ko">상품 페이지</a>
=======
				<input type="text" id="searchbar">
				<a href="productList.ko" id="searchbutton">검색</a>
				<a href="">상품 페이지</a>
>>>>>>> branch 'main' of https://github.com/dbswl2650/Fashion.git
				<span>|</span>
				<a href="cartForm.ko">장바구니</a>
				<a href="signup.ko">회원가입</a>
				<a href="loginForm.ko">로그인</a>

			</div>
		</nav>
		<script>
			searchbar.value = <%=request.getParameter("search")%>;
			searchbar.oninput = function() {
				let search = searchbar.value;
				searchbutton.href = "productList.ko?search=" + search;
			}
		</script>
	</header>