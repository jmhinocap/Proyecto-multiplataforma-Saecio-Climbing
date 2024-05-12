// Código para hacer aparecer y desaparecer el formulario de registro
const body = document.body;
const registro = document.getElementById('contenedorPaginaRegistro');

function mostrarRegistro() {
    registro.style.display = "block";
}

function ocultarRegistro() {
    // activarElementos(body.getElementsByTagName('*'));
    registro.style.display = "none";
}
