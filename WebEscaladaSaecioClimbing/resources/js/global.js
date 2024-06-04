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

// Código para iniciar sesión


// Código para hacer aparecer y desaparecer el formulario de registro
const registro = document.getElementById('contenedorPaginaRegistro');

function mostrarRegistro() {
    registro.style.display = "block";
}

function ocultarRegistro() {
    registro.style.display = "none";
}

// Código para registrarse
/*
 * --- Regex ---
 * Nombre/apellidos:
 * /^[A-ZA-Ù]([a-zà-ù])+(\s{1,3}[A-ZA-Ù]([a-zà-ù])+)*$
 * 
 * Nombre de usuario:
 * /^[^\s][A-Za-z\d_\-¡!¿?]{3,23}$
 * 
 * Corre electrónico:
 * /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$
 * 
 * Contraseña:
 * /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$¡!%*¿?&])[A-Za-z\d@$¡!%*¿?&]{5,19}
*/
// Inputs
const nombreField = document.getElementById("inputNombre");
const apellidosField = document.getElementById("inputApellidos");
const nombreUsuarioField = document.getElementById("inputNombreUsuario");
const correoField = document.getElementById("inputCorreo");
const contrasenaField = document.getElementById("inputContrasena");

// Regex
const nombreApellidosPatron = /^[A-ZA-Ù]([a-zà-ù])+(\s{1,3}[A-ZA-Ù]([a-zà-ù])+)*$/;
const nombreUsuarioPatron = /^[^\s][A-Za-z\d_\-¡!¿?]{3,23}$/;
const correoPatron = /^[\w\-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
const contrasenaPatron = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$¡!%*¿?&])[A-Za-z\d@$¡!%*¿?&]{5,19}/;

function registrarUsuario() {
    // Valores
    const nombreValor = nombreField.value;
    const apellidosValor = apellidosField.value;
    const nombreUsuarioValor = nombreUsuarioField.value;
    const correoValor = correoField.value;
    const contrasenaValor = contrasenaField.value;
    const terminos = $('#checkTerminos:checked').val();
    // 1. Validar datos: nombre, apellidos (si hubiera), nombre de usuario, correo, contraseña y términos y condiciones
    if (nombreApellidosPatron.test(nombreValor) && nombreApellidosPatron.test(apellidosValor) && nombreUsuarioPatron.test(nombreUsuarioValor) && correoPatron.test(correoValor) && contrasenaPatron.test(contrasenaValor) && terminos == "on") {
        console.log("Funciona");
    }
    /*
     * 2. Crear JSON:
     * {
     *  "nombre": nombre,
     *  "apellidos": apellidos,
     *  "usuario": nombreUsuario,
     *  "correoElectronico": correo,
     *  "contrasena": contrasena,
     *  "foto": "foto_genereica"
     * }
    */

    const usuario = {
        nombre: nombreValor,
        apellidos: apellidosValor,
        usuario: nombreUsuarioValor,
        correoElectronico: correoValor,
        contrasena: contrasenaValor,
        foto: "foto-generica.jpg"
    }

    // Si se envía el JSON de arriba a /auth/registrar-usuario, se devuelve un mensaje dependiendo de si ya existe una cuenta con el nombre o el correo, o por el contrario ha sido posible crear la cuenta
    // Cuando se pueda crear la cuenta, se llamará a RegistrarUsuarioController y se enviará el mismo DTO
    
}
