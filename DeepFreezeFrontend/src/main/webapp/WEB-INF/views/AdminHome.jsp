<%@ include file="Header.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>Admin</title>
<style type="text/css">
section {
    padding-top: 4rem;
    padding-bottom: 5rem;
    background-color: white;
}
.bgColor{
	background-color:#deeaee;
}
.wrap {
    display: flex;
    background: white;
    padding: 1rem 1rem 1rem 1rem;
    border-radius: 0.5rem;
    box-shadow: 17px 14px 30px -5px rgba(0,0,0,0.1);
    margin-bottom: 2rem;
}

.wrap:hover {
    background: linear-gradient(135deg,#66ccff 0%,#cceeff 100%);
    color: white;
}



.ico-wrap {
    margin: auto;
}

.mbr-iconfont {
    font-size: 4.5rem !important;
    color: #313131;
    margin: 1rem;
    padding-right: 1rem;
}
.vcenter {
    margin: auto;
}

.mbr-section-title3 {
    text-align: left;
}
h2 {
    margin-top: 0.5rem;
    margin-bottom: 0.5rem;
}
.display-5 {
    font-family: 'Source Sans Pro',sans-serif;
    font-size: 1.4rem;
}
.mbr-bold {
    font-weight: 700;
}

 p {
    padding-top: 0.5rem;
    padding-bottom: 0.5rem;
    line-height: 25px;
}
.display-6 {
    font-family: 'Source Sans Pro',sans-serif;
    font-size: 1re}
</style>
</head>
<body>
<section>
<div class="container">

	
		<div class="row mbr-justify-content-center">

            
             <div class="col-lg-6 mbr-col-md-10">
                <div class="wrap">
                    <div class="ico-wrap">
                        <span class="mbr-iconfont fa-calendar fa"></span>
                    </div>
                    <div class="text-wrap vcenter">
                        <h2 class="mbr-fonts-style mbr-bold mbr-section-title3 display-5">Cool
                            <span>Categories</span>
                        </h2>
                        <a class="mbr-fonts-style text1 mbr-text display-6 nav-link" href="<c:url value="/category"/>">  Category Management</a>
                        <p class="mbr-fonts-style text1 mbr-text display-6">Wide varieties of refrigerator types available which can be customized as per consumer preference !</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 mbr-col-md-10">
                <div class="wrap">
                    <div class="ico-wrap">
                        <span class="mbr-iconfont fa-calendar fa"></span>
                    </div>
                    <div class="text-wrap vcenter">
                        <h2 class="mbr-fonts-style mbr-bold mbr-section-title3 display-5">A Unique Set of
                            <span>Products</span>
                        </h2>
                        <a class="nav-link" href="<c:url value="/product"/>"> Product Management</a>
                        <p class="mbr-fonts-style text1 mbr-text display-6">Products with unique features and functionalities which gives an impression of realtime cooling!</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 mbr-col-md-10">
                <div class="wrap">
                    <div class="ico-wrap">
                        <span class="mbr-iconfont fa-globe fa"></span>
                    </div>
                    <div class="text-wrap vcenter">
                        <h2 class="mbr-fonts-style mbr-bold mbr-section-title3 display-5">Creative 
                            <span>Supplier's</span>
                        </h2>
                        <a class="nav-link" href="<c:url value="/supplier"/>"> Supplier Management</a>
                        <p class="mbr-fonts-style text1 mbr-text display-6">People efficient in providing the best quality products to the consumers.  </p>
                    </div>
                </div>
            </div>
           

            

            
        </div>
        </div>

</section>
        
        <!-- Footer section starts -->
		
		<br>
<article class="bgColor mb-2">  
<div class="card-body text-center">
    <h3 class="text-black mt-3">DEEP FREEZE</h3> 
<p class="h5 text-b;ack"> <h5>World of Refrigerator's </h5> <h6>choose your unique style of cooling and keep it cool </h6> </p>   <br>
<p><a class="btn btn-info" target="_blank" href="<c:url value="/aboutUs"/>"> © 2007-2019 Deepfreeze.com  
 <i class="fa fa-window-restore "></i></a></p>
</div>
<br><br>
</article>


</body>
</html>