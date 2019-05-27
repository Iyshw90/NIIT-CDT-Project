<%@include file="WEB-INF/views/Header.jsp"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 70%;
}
.carousel-indicators li{
	color:black;
}
.carousel-control-prev-icon,.carousel-control-next-icon{
	color:black;
}
</style>
</head>


<body>


<div class="container-fluid mt-3">

<div id="myCarousel" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
     <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
  </ul>
  
  <!-- The slideshow -->
  <div class="carousel-inner">
  
    <div class="carousel-item active">
      <img src="<c:url value="/resources/images/static/Carousel-Fridges.jpg" />"   alt="Carousel-Fridges" width="1200" height="500" >
    </div>
    <div class="carousel-item">
      <img src="<c:url value="/resources/images/static/Carousel-Fridges1.jpg"/>" alt="Carousel-Fridges1" width="1200" height="500">
    </div>
    <div class="carousel-item">
   
      <img src="<c:url value="/resources/images/static/Carousel-Fridges2.jpg"/>"  alt="Carousel-Fridges2" width="1200" height="500">
    </div>
    <div class="carousel-item">
      <img src="<c:url value="/resources/images/static/Carousel-Fridges3.jpg"/>"  alt="Carousel-Fridges3" width="1200" height="500">
    </div>
    <div class="carousel-item">
      <img src="<c:url value="/resources/images/static/Carousel-Fridges4.jpg"/>"  alt="Carousel-Fridges6" width="1200" height="500">
    </div>
   
    
  </div>
  
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#myCarousel" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>

</div>



</body>
</html>
