<!DOCTYPE html>

<head>
	<title>Exemplo Login</title>
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<!-- css -->
	<link rel="stylesheet" href="assets/css/login.css">
</head>

<body>
	
<div class="container-fluid" >
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4 p-5 bg-black">		
			<h1 class="login-box">Login no sistema</h1>
			<form action="?controller=user&action=validateLogin" method=POST name="formulario" id="formulario">
				<div class="form-group">
					<label >Login</label>
					<input type="text" class="form-control" name="userName" placeholder="Digite o usuário">				
				</div>
				<div class="form-group">
		 			<label >Senha</label>
					<input type="password" class="form-control" name="password" placeholder="Digite sua senha">
				</div>	
				<br>
				<input class="btn btn-primary" type="submit" name="Enviar" value="Fazer Login">
			</form>
		</div>	
		<div class="col-md-4"></div>
		<br>
		<br>	
		<a class="text-center" href="../index.php">Site Principal</a>
	</div> 
</div>
 
</body>

</html>