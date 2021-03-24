<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Full page scroll</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index/pageScroll/full-page-scroll.css?<%=(int)(Math.random()*10)%>" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index/main.css?<%=(int)(Math.random()*10)%>" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index/section1.css?<%=(int)(Math.random()*10)%>" />
</head>
<body>
	<div id="main" class="scroll-container">
		<section class="section1">
			<header>
				<div id="menu_top_space"></div>
				<div class="menu">
					<div class="menu_top">
						로고
					</div>
					<div class="menu_bottom">
						<div class="left">
						왼쪽
						</div>
						<div class="center">
						중앙
						</div>
						<div class="right">
						오른쪽
						</div>
					</div>
				</div>
			</header>			
		</section>
		<section class="section2">
			<div>
				<span>Page #2</span>				
			</div>
		</section>
		<section class="section3">
			<div>
				<span>Page #3</span>				
			</div>
		</section>
		<section class="section4">
			<div>
				<span>Page #4</span>				
			</div>
		</section>
		<section class="section5">
			<div>
				<span>Page #5</span>				
			</div>
		</section>
	</div>
	<script src="${pageContext.request.contextPath}/resources/css/index/pageScroll/full-page-scroll.js?<%=(int)(Math.random()*10)%>"></script>
	<script type="text/javascript">
		new fullScroll({
			displayDots: true,
			dotsPosition: 'left',
			animateTime: 0.7,
			animateFunction: 'ease'
		});
	</script>
</body>
</html>