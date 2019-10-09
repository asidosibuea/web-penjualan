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
<title>Penjualan - ADD</title>
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
			<h2 class="text-center">Form Header Data</h2> 
		</div>
		<div class="row">
			 <form:form id="formHeader" class="form-horizontal"
			  method="post" action="${pageContext.request.contextPath}/header-penjualan/edit-header/final-post" modelAttribute="headerPenjualan">
				 <div class="form-group">
					<label class="control-label col-sm-2" for="noNota">No.Nota :</label>
					<div class="col-sm-10">
					  <form:input path="noNota" type="text" class="form-control" id="noNota" placeholder="Enter No. Nota"/>
					</div>
				 </div>
				  
				<div class="form-group">
					<label for="sel1" class="control-label col-sm-2">Nama Customer :</label>
					<div class="col-sm-10">
						<form:select path="kodeCustomer" class="form-control" id="namaCustomer" >
							<form:option value = "-" label = "Silahkan Pilih Customer"/>
                     		<form:options items = "${customers}" />
						</form:select>
					</div>
				</div> 
				
				<div class="form-group">
					<label for="sel1" class="control-label col-sm-2">Nama Karyawan :</label>
					<div class="col-sm-10">
						<form:select path="kodeKaryawan" class="form-control" id="namaKaryawan" >
							<form:option value = "-" label = "Silahkan Pilih Karyawan"/>
                     		<form:options items = "${employees}" />
						</form:select>
					</div>
				</div> 
				<div class="form-group">
					<label class="control-label col-sm-2" for="tanggalTransaksi">Tanggal Transaksi :</label>
					<div class="col-sm-10">
					  <form:input path="tanggalTransaksi" type="text" class="form-control" id="tanggalTransaksi" placeholder="Enter Tanggal Transaksi"/>
					</div>
				 </div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="globalDiskon">Diskon Global :</label>
					<div class="col-sm-10">
					  <form:input path="globalDiskon" onchange="calculateTotal()" type="text" class="form-control" id="globalDiskon" placeholder="Enter Global Diskon"/>
					</div>
				</div>
			  
				<div class="form-group">
					<label class="control-label col-sm-2" for="hargaTotal">Total :</label>
					<div class="col-sm-10">
					  <form:input readonly="true"  path="hargaTotal" type="text" class="form-control" id="hargaTotal" placeholder="Enter Total Harga"/>
					  <input type="hidden" id="hiddenData" value="${totalTanpaDiskon}">
					</div>
				</div>
				
				
				<div class="form-group">
				  <div class="col-sm-offset-2 col-sm-10">
				    <button type="submit" class="btn btn-info">Simpan</button>
				  </div>
				</div>
				
				<!-- table detail penjualan  -->
				<div class="row">
					<div class="text-center"><h2>Detail Data</h2></div>
				</div>
				<div class="row">
					<div class="text-center" style="padding-top: 20px"> <input type="button" value="Tambah Barang" class="btn btn-info btn-block btnAdDetail" 
					 onclick ="submitForm()"></div>
				</div>
				<div class="row">
					<div class="table-responsive">        
					  <table class="table table-striped">
					    <thead>
					      <tr>
					        <th>Kode Detail</th>
					       	<th>Nama Barang</th>
					        <th>Qty</th>
					        <th>Diskon</th>
					        <th>Subtotal</th>
					        <th>Action</th>
					      </tr>
					    </thead>
					    <tbody>
						    <c:forEach items="${listDetilDto}" var="data">
						    <tr>
						    	<td><c:out value="${data.kodeDetail}" /></td>
						    	
						    	<td><c:out value="${data.namaBarang}" /></td> 
						    	<td><c:out value="${data.qty}" /></td>
						    	<td><c:out value="${data.diskon}" /></td>
						    	<td><c:out value="${data.subtotal}" /></td>
						    	<td>
						        	<a href="${pageContext.request.contextPath}/header-penjualan/edit-header/delete-detail/${data.noNota}/${data.kodeDetail}" class="btn btn-danger"> <span class="glyphicon glyphicon-remove"></span> Delete</a>
						        </td>
						    </tr>
						    </c:forEach>
					    </tbody>
					  </table>
					</div>
					<!-- pagination -->
					 <ul class="pagination">
						 <c:forEach var="i" begin="1" end="${jumlahHalaman}">
						 	<li><a href="${pageContext.request.contextPath}/header-penjualan/all?page=${i}&cari=${param.cari}">${i}</a></li>
						 </c:forEach>
					</ul> 
					<!-- tutup tag pagination -->
				</div>
				<!-- detail penjualan end tag -->
				
			</form:form> 
		</div>
		<!-- tutup form -->
		
		
		
	</div>
	<!-- tutup tag container -->
<script>

function calculateTotal() {
	var total = document.getElementById("hiddenData").value;
	var diskon = document.getElementById("globalDiskon").value;
	
	var totalDiskon = total - ((diskon/100) * total);
	document.getElementById("hargaTotal").value = totalDiskon;
}

function submitForm() {
	document.getElementById("formHeader").action = "/mvcpenjualan/header-penjualan/edit-header/save-session";
	document.getElementById("formHeader").submit();
}

</script>
</body>
</html>