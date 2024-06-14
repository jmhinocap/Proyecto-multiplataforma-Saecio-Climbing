// Código para la API
const iniciarSesionUrl = "http://localhost:8086/api/auth/iniciar-sesion";
let usuarioUrlBase = "http://localhost:8086/api/usuario/leer-usuario-por-nombre-o-correo/";

async function iniciarSesionApi(nombreValor, contrasenaValor) {
    const inicioSesion = {
        usuarioOCorreo: nombreValor,
        contrasena: contrasenaValor
    };
    const respuesta = await fetch(iniciarSesionUrl, {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(inicioSesion)
    });

    return respuesta;
}

async function getUsuario(usuarioOCorreoValor) {
    const usuarioUrl = usuarioUrlBase + usuarioOCorreoValor;
    const respuesta = await fetch(usuarioUrl);
    const usuario = await respuesta.json();

    return usuario;
}

// Método init
$(document).ready(function () {
    iniciarSesion(1);
    resetearFormularios();
});

function resetearFormularios() {
    if (sessionStorage.getItem("usuario") === null) {
        document.getElementById('formularioLogIn').reset();
        document.getElementById('formularioSignUp').reset();
    } else if (document.getElementById('formularioRegistro') != null) {
        document.getElementById('formularioRegistro').reset();
    }
}

// Código para hacer aparecer y desaparecer el formulario de inicio de sesión
const container = document.getElementById("iniciarSesion");
var focus = 0;

$('#buttonIniciarSesion').click(function() {
    $("#iniciarSesion").toggleClass("mostrar-dropdown");
});

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
async function iniciarSesion(eleccion) {
    if (eleccion === 0) {
        let estado;
        const usuarioOCorreo = document.getElementById('inputUsuarioOCorreo');
        const contrasenaInicio = document.getElementById('inputContrasenaInicio');
        const respuesta = iniciarSesionApi(usuarioOCorreo.value, contrasenaInicio.value);
        
        (await respuesta).text().then(async function(text) {
            estado = text;
            if (estado === "logInSucc") {
                const usuario = await getUsuario(usuarioOCorreo.value);
                sessionStorage.setItem("usuario", JSON.stringify(usuario));
                location.reload();
            }
        });
    } else if (sessionStorage.getItem("usuario") != null) {
        const usuario = sessionStorage.getItem("usuario");
        ocultarElementos();
        mostrarElementos();
        rellenarElementos(JSON.parse(usuario));
    }
}

function ocultarElementos() {
    $("#botonesUsuarioContenedor").addClass("invisible");
}

function mostrarElementos() {
    $("#perfilContenedor").removeClass("invisible");
    $("#cerrarSesion").removeClass("invisible");
}

function rellenarElementos(usuario) {
    const nombreUsuario = $("#nombreUsuario");
    nombreUsuario[0].innerHTML = usuario.nombreUsuario;
}

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
// API
const authRegistrar = "http://localhost:8086/api/auth/registrar-usuario";
const registrarCuenta = "http://localhost:8086/api/registrar-usuario/registracion";

async function getConfirmacion(usuario) {
    const respuesta = await fetch(authRegistrar, {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
    });

    return respuesta;
}

async function postCuenta(usuario) {
    const respuesta = await fetch(registrarCuenta, {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
    });
}

// Inputs
const nombreField = document.getElementById("inputNombre");
const apellidosField = document.getElementById("inputApellidos");
const nombreUsuarioField = document.getElementById("inputNombreUsuario");
const correoField = document.getElementById("inputCorreo");
const contrasenaField = document.getElementById("inputContrasenaRegistro");

// Regex
const nombreApellidosPatron = /^[A-ZA-Ù]([a-zà-ù])+(\s{1,3}[A-ZA-Ù]([a-zà-ù])+)*$/;
const nombreUsuarioPatron = /^[^\s][A-Za-z\d_\-¡!¿?]{3,23}$/;
const correoPatron = /^[\w\-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
const contrasenaPatron = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$¡!%*¿?&])[A-Za-z\d@$¡!%*¿?&]{5,19}/;

// Lógica
function mostrarContrasena(contrasenaInput) {
    const contrasenaField = document.getElementById(contrasenaInput);
    if (contrasenaField.type === "password") {
        contrasenaField.type = "text";
    } else {
        contrasenaField.type = "password";
    }
}

async function verificarRegistro() {
    const nombreValor = nombreField.value;
    const apellidosValor = apellidosField.value;
    const nombreUsuarioValor = nombreUsuarioField.value;
    const correoValor = correoField.value;
    const contrasenaValor = contrasenaField.value;
    const terminos = $('#checkTerminos:checked').val();
    if (nombreApellidosPatron.test(nombreValor) && nombreApellidosPatron.test(apellidosValor) && nombreUsuarioPatron.test(nombreUsuarioValor) && correoPatron.test(correoValor) && contrasenaPatron.test(contrasenaValor) && terminos == "on") {
        let estado;

        const usuario = {
            nombre: nombreValor,
            apellidos: apellidosValor,
            usuario: nombreUsuarioValor,
            correoElectronico: correoValor,
            contrasena: contrasenaValor,
            foto: "foto-generica.jpg"
        };

        const respuesta = getConfirmacion(usuario);
        (await respuesta).text().then(function(text) {
            estado = text;
            registrarUsuario(usuario, estado);
        });
    }
}

async function registrarUsuario(usuario, estado) {
    if (estado === "registroCorrecto") {
        postCuenta(usuario);
        alert("Te hemos enviado un enlace de confirmación al correo. Activa la cuenta antes de poder usarla.");
        // al cerrar el alert, refrescar página y dejar sesión iniciada
    } else if (estado === "userEnUso") {
        // si el usuario hace algún cambio en el campo, esta clase se elimina. con un listener???
        $("#inputNombreUsuario").addClass("input-error");
        $("#userEnUso").show();
    } else if (estado === "emailEnUso") {
        // si el usuario hace algún cambio en el campo, esta clase se elimina
        $("#inputCorreo").addClass("input-error");
        $("#correoEnUso").show();
    }
}

// Cierre de sesión
function cerrarSesion() {
    sessionStorage.removeItem("usuario");
    location.reload();
}
