<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detail Penjualan - Add</title>
<spring:url value="/resources/css/bootstrap.min.css" var="mainCss" />
      <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
      <spring:url value="/resources/css/index.css" var="indexCss" />
      <spring:url value="/resources/css/font-awesome.min.css" var="faCss" />
      <spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />
      <link href="${mainCss}" rel="stylesheet" />
      <link href="${faCss}" rel="stylesheet">
      <link href="${indexCss}" rel="stylesheet" />
      <script type="text/javascript" src="${jqueryJs}"></script>
      <script type="text/javascript" src="${bootstrapJs}"></script>
</head>
<body>

	<!-- navbar -->
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">MVC Penjualan</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="#">Home</a></li>
	      <li><a href="#">Barang</a></li>
	      <li><a href="#">Customer</a></li>
	      <li><a href="#">Karyawan</a></li>
	      <li><a href="#">Kota</a></li>
	      <li><a href="#">Provinsi</a></li>
	      <li><a href="#">Supplier</a></li>
	      <li class="active"><a href="${pageContext.request.contextPath}/header-penjualan/all">Transaksi Penjualan</a></li>
	    </ul>
	  </div>
	</nav>
	<!-- tutup tag navbar -->
<div class="container">
		<!-- mulai form  -->
		<div class="row"> 
			<h2 class="text-center">Form Detail Data</h2> 
		</div>
		<div class="row">
			 <form:form class="form-horizontal" action="${pageContext.request.contextPath}/header-penjualan/edit-header/save-detail" 
			 method="POST" modelAttribute="detailPenjualan">
				 <div class="form-group">
					<label class="control-label col-sm-2" for="noNota">Kode Detail :</label>
					<div class="col-sm-10">
					  <form:input path="kodeDetail" type="text" class="form-control" id="kodeDetail" placeholder="Enter Kode Detail"/>
					</div>
				 </div>
				  
				<div class="form-group">
					<label for="sel1" class="control-label col-sm-2">Barang :</label>
					<div class="col-sm-10">
						<form:select path="kodeBarang" class="form-control" id="namaBarang" >
							<form:option value = "-" label = "Silahkan Pilih Barang"/>
                     		<form:options items = "${products}" />
						</form:select>
					</div>
				</div> 
				<div class="form-group">
					<label class="control-label col-sm-2" for="qty">Qty:</label>
					<div class="col-sm-10">
					  <form:input path="qty" onchange="calculateSubtotal()" type="number" class="form-control" id="qty" placeholder="Enter Qty"/>
					</div>
				 </div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="globalDiskon">Harga Satuan Global :</label>
					<div class="col-sm-10">
					  <form:input path="hargaSatuan" onchange="calculateSubtotal()"
					  type="text" class="form-control" id="hargaSatuan" placeholder="Enter Harga Satuan"/>
					</div>
				</div> 
			  
				<div class="form-group">
					<label class="control-label col-sm-2" for="hargaTotal">Diskon :</label>
					<div class="col-sm-10">
					  <form:input path="diskon" onchange="calculateSubtotal()" type="number" class="form-control" id="diskon" placeholder="Enter Discount"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="hargaTotal">Sub Total :</label>
					<div class="col-sm-10">
					  <form:input path="subtotal" readonly="true" type="number" class="form-control" id="subtotal" placeholder="Enter Sub Total"/>
					</div>
				</div>
				<div class="form-group">
				  <div class="col-sm-offset-2 col-sm-10">
				    <button type="submit" class="btn btn-info">Simpan</button>
				  </div>
				</div>
			</form:form> 
		</div>
	</div>

<script>
function calculateSubtotal() {
  var hargaSatuan = document.getElementById("hargaSatuan").value;
  var qty = document.getElementById("qty").value;
  var diskon = document.getElementById("diskon").value;
  var total = hargaSatuan * qty;
  var totalDiskon = (diskon/100) * total;
  document.getElementById("subtotal").value = total - totalDiskon;
}
</script>
</body>
</html>