<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Penjualan- Header</title>
      <spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="mainCss" />
      <spring:url value="/resources/datetimepicker/css/bootstrap-datetimepicker.csss" var="datetimepickerCss" />
      <spring:url value="/resources/bootstrap/js/bootstrap.min.js" var="bootstrapJs" />
      <spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />
      <spring:url value="/resources/datetimepicker/js/bootstrap-datetimepicker.js" var="datetimepickerJs" />
      <link href="${mainCss}" rel="stylesheet" />
      <link href="${datetimepickerCss}" rel="stylesheet" />
      <script src="${bootstrapJs}"></script>
      <script src="${jqueryJs}"></script>
      <script src="${datetimepickerJs}"></script>
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
		<div class="row">
			<div class="text-center"><h2>Data Penjualan</h2></div>
		</div>
		<div class="row">
			<form class="form-inline"
                  action="${pageContext.request.contextPath}/header-penjualan/all">
                  <div class="form-group">
				    <label for="email">Search :</label>
				    <input type="text" class="form-control" name="cari" value="${param.cari}"/>
				  </div>
				  <button type="submit" class="btn btn-default">Submit</button>
             </form>
		</div>
		<div class="row">
			<div class="text-center" style="padding-top: 20px"> <a class="btn btn-info btn-block" href="${pageContext.request.contextPath}/header-penjualan/add">Tambah Barang</a></div> 
		</div>
		<div class="row">
			<div class="table-responsive">        
			  <table class="table table-striped">
			    <thead>
			      <tr>
			        <th>No.Nota</th>
			        <th>Nama Customer</th>
			        <th>Nama Karyawan</th>
			        <th>Tanggal Transaksi</th>
			        <th>Harga Total</th>
			        <th>Action</th>
			      </tr>
			    </thead>
			    <tbody>
				    <c:forEach items="${list}" var="data">
				    <tr>
				    	<td><c:out value="${data.noNota}" /></td>
				    	
				    	<td><c:out value="${data.namaCustomer}" /></td>
				    	<td><c:out value="${data.namaKaryawan}" /></td>
				    	<td><c:out value="${data.tanggalTransaksi}" /></td>
				    	<td><c:out value="${data.hargaTotal}" /></td>
				    	<td><a href="${pageContext.request.contextPath}/header-penjualan/edit/${data.noNota}" class="btn btn-warning"> <span class="glyphicon glyphicon-pencil"></span> Edit</a>
				        	<a href="${pageContext.request.contextPath}/header-penjualan/delete/${data.noNota}" class="btn btn-danger"> <span class="glyphicon glyphicon-remove"></span> Delete</a>
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
	</div>
	<!-- close container tag  -->

</body>
</html>