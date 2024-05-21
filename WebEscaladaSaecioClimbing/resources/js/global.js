// Código para hacer aparecer y desaparecer el formulario de inicio de sesión
const container = document.getElementById("iniciarSesion");
var focus = 0;

function abrirIniciarSesion(event) {
    var boton = event.target.matches("#buttonIniciarSesion");

    if (boton && focus === 0) {
        document.getElementById("iniciarSesion").classList.toggle("mostrar-dropdown");
        focus++;
        console.log(focus);
    } else if (boton && focus === 1) {
        cerrarIniciarSesion();
        document.getElementById("buttonIniciarSesion").blur();
    }
}

function cerrarIniciarSesion() {
    document.getElementById("iniciarSesion").classList.remove("mostrar-dropdown");
    
    if (focus === 1) {
        focus--;
    }
}

container.addEventListener('focusout', (e) => {
    if (container.classList.contains("mostrar-dropdown") && !container.contains(e.relatedTarget)) {
        cerrarIniciarSesion();
    }

    if (focus === 1) {
        focus--;
    }
})

// Código para hacer aparecer y desaparecer el formulario de registro
const registro = document.getElementById('contenedorPaginaRegistro');

function mostrarRegistro() {
    registro.style.display = "block";
}

function ocultarRegistro() {
    registro.style.display = "none";
}
