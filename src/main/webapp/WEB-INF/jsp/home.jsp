<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<title>Insert title here</title>

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
	  <div class="   ontainer-fluid">
	    <div class="navbar-header">
	      <a class="navbar-br   nd" href="#">MVC Penjualan</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="#">Home</a></li>
	      <li><a href="#">Barang</a></li>
	      <li><a href="#">Customer</a></li>
	      <li><a href="#">Karyawan</a></li>
	      <li><a href="#">Kota</a></li>
	      <li><a href="#">Provinsi</a></li>
	      <li><a href="#">Supplier</a></li>
	      <li><a href="#">Transaksi Penjualan</a></li>
	    </ul>
	  </div>
	</nav>
	<!-- tutup tag navbar -->
	
	<div class="container">
		<div class="row">
			<div class="col-md-4 text-left"><h2>List Barang</h2></div>
			<div class="col-md-8 text-right" style="padding-top: 20px"> <a class="btn btn-success btn-lg" href="#">Tambah Barang</a></div> 
		</div>
		<div class="row">
			<div class="table-responsive">        
			  <table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Firstname</th>
			        <th>Lastname</th>
			        <th>Email</th>
			        <th>Action</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>John</td>
			        <td>Doe</td>
			        <td>july@example.com</td>
			        <td><a href="#" class="btn btn-warning"> <span class="glyphicon glyphicon-pencil"></span> Edit</a>
			        	<a href="#" class="btn btn-danger"> <span class="glyphicon glyphicon-remove"></span> Delete</a>
			        </td>
			      </tr>
			      <tr>
			        <td>Mary</td>
			        <td>Moe</td>
			        <td>july@example.com</td>
			        <td><a href="#" class="btn btn-warning"> <span class="glyphicon glyphicon-pencil"></span> Edit</a>
			        	<a href="#" class="btn btn-danger"> <span class="glyphicon glyphicon-remove"></span> Delete</a>
			        </td>
			      </tr>
			      <tr>
			        <td>July</td>
			        <td>Dooley</td>
			        <td>july@example.com</td>
			        <td><a href="#" class="btn btn-warning"> <span class="glyphicon glyphicon-pencil"></span> Edit</a>
			        	<a href="#" class="btn btn-danger"> <span class="glyphicon glyphicon-remove"></span> Delete</a>
			        </td>
			      </tr>
			      <tr>
			        <td>Scott</td>
			        <td>Dooley</td>
			        <td>july@example.com</td>
			        <td><a href="#" class="btn btn-warning"> <span class="glyphicon glyphicon-pencil"></span> Edit</a>
			       		<a href="#" class="btn btn-danger"> <span class="glyphicon glyphicon-remove"></span> Delete</a>
			        </td>
			      </tr>
			    </tbody>
			  </table>
			</div>
			<!-- pagination -->
			 <ul class="pagination">
			  <li><a href="#">1</a></li>
			  <li><a href="#">2</a></li>
			  <li><a href="#">3</a></li>
			  <li><a href="#">4</a></li>
			  <li><a href="#">5</a></li>
			</ul> 
			<!-- tutup tag pagination -->
		</div>
		
		<!-- mulai form  -->
		<div class="row"> 
			<h2 class="text-center">Tambah Barang</h2> 
		</div>
		<div class="row">
			 <form class="form-horizontal" action="/action_page.php">
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="email">Email:</label>
			    <div class="col-sm-10">
			      <input type="email" class="form-control" id="email" placeholder="Enter email">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="pwd">Password:</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="gender">Jenis Kelamin:</label>
			    <div class="col-sm-10">
			      	<div class="radio">
					  <label><input type="radio" name="jenisKelamin" value="L">Laki-laki</label>
					</div>
					<div class="radio">
					  <label><input type="radio" name="jenisKelamin" value="P">Perempuan</label>
					</div>
			    </div>
			  </div>
			  
			   <div class="form-group">
				  <label for="sel1" class="control-label col-sm-2">Nama Karyawan:</label>
				  <div class="col-sm-10">
				  <select class="form-control" id="sel1">
				    <option>Aceng Conello</option>
				    <option>Ujang Mamat</option>
				    <option>3</option>
				    <option>4</option>
				  </select>
				  </div>
				</div> 
				
			<div class="form-group">
				<label for="sel1" class="control-label col-sm-2">Tanggal Transaksi:</label>
                <input type="text" value="2012-05-15 21:05" id="datetimepicker">
                   
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
               
            </div>
	
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-primary">Simpan</button>
			    </div>
			  </div>
			</form> 
		</div>
		<!-- tutup form -->
	</div>

 <script type="text/javascript">
	 $('#datetimepicker').datetimepicker({
	     format: 'yyyy-mm-dd hh:ii'
	 });
</script>
</body>
</html>