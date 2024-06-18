<h1>Cadastro de cliente</h1>
<form action="?controller=client&action=registerView" method="post">

<div class="form-group">
    <label class="form-label">Nome</label>
    <input class="form-control" type="text" name="name">
</div>

<div class="form-group">
    <label class="form-label">Email</label>
    <input class="form-control" type="text" name="email">
</div>

<div class="form-group">
    <label class="form-label">Telefone</label>
    <input class="form-control" type="text" name="phone">
</div>

<div class="form-group">
    <div class="radio">
        <label><input type="radio" name="gender" value="female" checked> Feminino </label>
    </div>
    <div class="radio">
        <label><input type="radio" name="gender" value="male"> Masculino </label>
    </div>
    <div class="radio">
        <label><input type="radio" name="gender" value="other"> Outro </label>
    </div>
</div>

<div class="checkbox">
    <label>
        <input type="checkbox" name="accept"> Desejo receber os comunicados do site.
    </label>
    </div>

<button class="btn btn-primary" type="submit">Enviar</button>


</form>








