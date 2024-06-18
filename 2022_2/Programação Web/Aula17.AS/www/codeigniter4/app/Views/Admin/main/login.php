<!DOCTYPE html>
<html>
<head>
	<title>Exemplo Login</title>
	 <!-- Bootstrap CSS -->
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="<?=base_url('assets/css/login.css')?>">
</head>
<body>
<div class="container-fluid" >
<!-- style="vertical-aling:center" -->
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4 p-5">
			<h1 class="text-center" >Login ADM</h1>
			<form action="<?=base_url('admin/validateLogin')?>" method=POST name="formulario" id="formulario">
				<div class="form-group">
					<label >Login</label>
					<input type="text" class="form-control" name="login" placeholder="Digite o usuário">				
				</div>
				<div class="form-group">
		 			<label >Senha</label>
					<input type="password" class="form-control" name="password" placeholder="Digite sua senha">
				</div>	
				<input class="btn" type="submit" name="Enviar" value="Fazer Login">
			</form>

			<a class="hSite" href="../index.php">Site</a>
		</div>	
		<div class="col-md-4"></div>	
	</div> 
</div>
</body>
</html>