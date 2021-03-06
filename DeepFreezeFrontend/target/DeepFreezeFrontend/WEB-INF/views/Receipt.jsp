<%@ include file="Header.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Receipt</title>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
.invoice-title h2, .invoice-title h3 {
	display: inline-block;
}

.navbar-nav {
	float: left ! important;
	margin-right: 662px;
}

.navbar-right {
	float: right ! important;
}

.navbar {
	padding: .01rem 1rem;
}

.navbar-dark .navbar-nav .active>.nav-link {
	font-size: 16px;
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	line-height: 1.5;
}

.table>tbody>tr>.no-line {
	border-top: none;
}

.table>thead>tr>.no-line {
	border-bottom: none;
}

.table>tbody>tr>.thick-line {
	border-top: 2px solid;
}
</style>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="invoice-title">
					<h2>Invoice</h2>
					<h3 class="pull-right">Order # ORD ${orderInfo.orderId}</h3>
				</div>
				<hr>
				<div class="row">
					<div class="col-xs-6">
						<address>
							<strong>Billed To:</strong><br> ${orderInfo.userName}
						</address>
					</div>
					<div class="col-xs-6 text-right">
						<address>
							<strong>Shipped To:</strong><br> ${address}
						</address>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-6">
						<address>
							<strong>Payment Method:</strong><br> ${orderInfo.pmode}
						</address>
					</div>
					<div class="col-xs-6 text-right">
						<address>
							<strong>Order Date:</strong><br> ${orderInfo.orderDate}
						</address>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h5 class="panel-title">
							<strong>Order summary</strong>
						</h5>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-condensed">
								<thead>
									<tr>
										<td><strong>Item</strong></td>
										<td class="text-center"><strong>Price</strong></td>
										<td class="text-center"><strong>Quantity</strong></td>
										<td class="text-right"><strong>Totals</strong></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cartItems}" var="cartItem">
										<tr>
											<td>${cartItem.productName}</td>
											<td class="text-center">${cartItem.price}</td>
											<td class="text-center">${cartItem.quantity}</td>
											<td class="text-right">${cartItem.price * cartItem.quantity}</td>
										</tr>
									</c:forEach>
									<tr>
										<td class="thick-line"></td>
										<td class="thick-line"></td>
										<td class="thick-line text-center"><strong>Subtotal</strong></td>
										<td class="thick-line text-right">INR ${grandTotal} /-</td>
									</tr>
									<tr>
										<td class="no-line"></td>
										<td class="no-line"></td>
										<td class="no-line text-center"><strong>Shipping</strong></td>
										<td class="no-line text-right">INR. $150</td>
									</tr>
									<tr>
										<td class="no-line"></td>
										<td class="no-line"></td>
										<td class="no-line text-center"><strong>Total</strong></td>
										<td class="no-line text-right">INR ${grandTotal+150} /-</td>
									</tr>
									<hr>
									<tr>
									<td></td>
									<td></td>
									<td></td>
										<td>
											<center>
												<a href="index.jsp" class="btn btn-block btn-info" > Ok </a>
											</center>
										</td>
									
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>