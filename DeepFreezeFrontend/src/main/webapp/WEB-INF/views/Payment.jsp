<%@ include file="Header.jsp"%>
<html>
<head>

<title>Payment</title>
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>



<style type="text/css">


.panel-title {display: inline;font-weight: bold;}

.panel-heading{

}
.checkbox.pull-right { margin: -6; }

.navbar{
padding: .01rem 1rem;
}
.navbar-dark .navbar-nav .active>.nav-link{
	font-size: 16px;
	font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
    line-height: 1.5;
}

.pl-ziro { padding-left: 0px; }

</style>
</head>
<body>

<div class="container">
    <div class="row">
    <form action="<c:url value="/pay"/>" method="POST">
        <div class="col-xs-12 col-md-4 ">
            <div class="panel panel-default">
            
                <div class="panel-heading">
                
                    <h5 class="panel-title">Payment Details</h5>
                   
                    
                    <div class="checkbox pull-right">
                        <label>
                        	<input onclick="document.getElementById('cardNumber').disabled = false;document.getElementById('cardHolderName').disabled = false;document.getElementById('mm').disabled = false;document.getElementById('yy').disabled = false;document.getElementById('cv').disabled = false;" 
                        	type="radio" name="pmode" required value="CC"/>CC
                         	<input onclick="document.getElementById('cardNumber').disabled = true;document.getElementById('cardHolderName').disabled = true; document.getElementById('mm').disabled = true;document.getElementById('yy').disabled = true;document.getElementById('cv').disabled = true; " 
                         	type="radio" name="pmode" required value="COD"/>COD
                         
                        </label>
                    </div>
                </div>
                
                <div class="panel-body">
                   
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input id="cardNumber" type="text" class="form-control" placeholder="Valid Card Number" pattern="[0-9]{16}" title="Enter valid 16-digit Card number"
                                required autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="cardHolderName">
                            CARD HOLDER NAME</label>
                        <div class="input-group">
                            <input id="cardHolderName" pattern="[A-Za-z]{2,20}" type="text" class="form-control" id="cardHolderName" placeholder="Card Holder Name" title="Only Alphabets are allowed"
                                required autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    
                    
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expityMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input id="mm" pattern="^(0[1-9]|1[012])$" title="Enter valid month in two digits" type="text" class="form-control" id="expityMonth" placeholder="MM" required />
                                </div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input id="yy" pattern="^(1[9]|[2-4][0-9])$" title="Enter valid last two digits of the year" type="text" class="form-control" id="expityYear" placeholder="YY" required /></div>
                            </div>
                        </div>
                        
                        
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CV CODE</label>
                                <input id="cv" pattern="[0-9]{3}" title="Enter valid 3-digit CV number" type="password" class="form-control" id="cvCode" placeholder="CV" required />
                            </div>
                        </div>
                    </div>
                    
                    
                   
                </div>
            </div>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#"><span class="badge pull-right"><span class="glyphicon glyphicon-usd"></span>${grandTotal}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;Final Payment &nbsp;&nbsp; &nbsp; &nbsp;</a>
                </li>
            </ul>
            <br/>
            <input type="submit" class="btn btn-success btn-lg btn-block" value="Pay"/>
        </div>
        </form>
        
    </div>
</div>


</body>
</html>