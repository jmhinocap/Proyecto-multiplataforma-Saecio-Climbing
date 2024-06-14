// Método init
$(document).ready(function() {
    document.getElementById('formularioRegistro').reset();

    if (sessionStorage.getItem("usuario") != null) {
        $("#sesionNoIniciada").remove();
        mostrarAscensiones();
    } else {
        $("#ascensionesContenedor").remove();
        $("#buttonRegistrarAscension").remove();
        $("#ascensionesVacias").remove();
    }
});

// Código para la API
const nuevaAscensionUrl = "http://localhost:8086/api/ascension/nueva-ascension";
const zonasUrl = "http://localhost:8086/api/zona/leer-zonas";
let sectoresUrlBase = "http://localhost:8086/api/sector/leer-sectores-por-id-zona/";
let viasUrlBase = "http://localhost:8086/api/via/leer-vias-por-id-sector/";
let viaUrlBase = "http://localhost:8086/api/via/leer-via/";
let ascensionesUrlBase = "http://localhost:8086/api/ascension/leer-ascensiones-por-id-usuario/";

async function nuevaAscension(ascension) {
    const respuesta = await fetch(nuevaAscensionUrl, {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(ascension)
    });
}

async function getZonas() {
    const respuesta = await fetch(zonasUrl);
    const zonas = await respuesta.json();

    return zonas;
}

async function getSectores(idZona) {
    const sectoresUrl = sectoresUrlBase + idZona;
    const respuesta = await fetch(sectoresUrl);
    const sectores = await respuesta.json();

    return sectores;
}

async function getVias(idSector) {
    const viasUrl = viasUrlBase + idSector;
    const respuesta = await fetch(viasUrl);
    const vias = await respuesta.json();

    return vias;
}

async function getVia(idVia) {
    const viaUrl = viaUrlBase + idVia;
    const respuesta = await fetch(viaUrl);
    const via = await respuesta.json();

    return via;
}

async function getAscensiones(idUsuario) {
    const ascensionesUrl = ascensionesUrlBase + idUsuario;
    const respuesta = await fetch(ascensionesUrl);
    const ascensiones = await respuesta.json();

    return ascensiones;
}

// Código para el registro de ascensiones
const registroAscension = document.getElementById('contenedorRegistroAscension');
const selectZona = document.getElementById('selectZona');
const selectSector = document.getElementById('selectSector');
const selectVia = document.getElementById('selectVia');
const selectTipoAscension = document.getElementById('selectTipoAscension');
const fechaAscensionInput = document.getElementById('fechaAscension');

// ¿Añadir sierra?
async function mostrarRegistrarAscension() {
    const zonas = await getZonas();
    const sectores = await getSectores(zonas[0].idZona);
    const vias = await getVias(sectores[0].idSector);

    // Refactor todo esto para que se haga con menos líneas de código en un mismo método
    for (let i = 0; i < zonas.length; i++) {
        selectZona.innerHTML +=
        "<option value='" + zonas[i].idZona + "'>" + zonas[i].nombre + "</option>";
    }

    for (let i = 0; i < sectores.length; i++) {
        selectSector.innerHTML +=
        "<option value='" + sectores[i].idSector + "'>" + sectores[i].nombre + "</option>";
    }

    for (let i = 0; i < vias.length; i++) {
        selectVia.innerHTML +=
        "<option value='" + vias[i].idVia +"'>" + vias[i].nombre + "</option>";
    }

    contenedorRegistroAscension.style.display = "block";
}

async function cambiarSectores(event) {
    selectSector.innerHTML = "";
    const sectores = await getSectores(event.target.value);

    for (let i = 0; i < sectores.length; i++) {
        selectSector.innerHTML +=
        "<option value='" + sectores[i].idSector + "'>" + sectores[i].nombre + "</option>";
    }
}

async function cambiarVias(event) {
    selectVia.innerHTML = "";
    const vias = await getVias(event.target.value);

    for (let i = 0; i < vias.length; i++) {
        selectVia.innerHTML +=
        "<option value='" + vias[i].idVia + "'>" + vias[i].nombre + "</option>"
    }
}

async function registrarAscension() {
    const viaValor = await getVia(selectVia.value);
    const fechaValor = fechaAscensionInput.value;
    const tipoAscensionValor = selectTipoAscension.value;

    if (tipoAscensionValor === null) {
        // Error
    } else {
        const ascension = {
            usuario: JSON.parse(sessionStorage.getItem("usuario")),
            via: viaValor,
            fechaAscension: fechaValor,
            tipoDeAscension: tipoAscensionValor
        }
        nuevaAscension(ascension);
        alert("Vía registrada con éxito");
        ocultarRegistroAscension();
    }
}

function ocultarRegistroAscension() {
    contenedorRegistroAscension.style.display = "none";
}

// Código para mostrar las ascensiones
async function mostrarAscensiones() {
    const usuario = JSON.parse(sessionStorage.getItem("usuario"));
    const ascensiones = await getAscensiones(usuario.idUsuario);
    const ascensionesTabla = document.getElementById('ascensiones');
    
    if (ascensiones.length != 0) {
        $("#ascensionesVacias").remove();
        for (let i = 0; i < ascensiones.length; i++) {
            const idSector = ascensiones[i].via.idSector;
            ascensionesTabla.innerHTML +=
            "<tr class='ascension'>"
                + "<td><a href='sector.html?idSector=" + idSector + "'>" + ascensiones[i].via.nombre + "</a></td>"
                + "<td><a href='sector.html?idSector=" + idSector + "'>" + ascensiones[i].fechaAscension + "</a></td>"
                + "<td><a href='sector.html?idSector=" + idSector + "'>" + ascensiones[i].tipoDeAscension + "</a></td>"
            + "</tr>";
        }
    }
}

// Autoformateo de fechaAscension
var fecha = document.getElementById('fechaAscension');

function checkValue(str, max) {
  if (str.charAt(0) !== '0' || str == '00') {
    var num = parseInt(str);
    if (isNaN(num) || num <= 0 || num > max) num = 1;
    str = num > parseInt(max.toString().charAt(0)) && num.toString().length == 1 ? '0' + num : num.toString();
  };
  return str;
};

fecha.addEventListener('input', function(e) {
  this.type = 'text';
  var input = this.value;
  if (/\D\/$/.test(input)) input = input.substr(0, input.length - 3);
  var values = input.split('/').map(function(v) {
    return v.replace(/\D/g, '')
  });
  if (values[0]) values[0] = checkValue(values[0], 31);
  if (values[1]) values[1] = checkValue(values[1], 12);
  var output = values.map(function(v, i) {
    return v.length == 2 && i < 2 ? v + ' / ' : v;
  });
  this.value = output.join('').substr(0, 14);
});

fecha.addEventListener('blur', function(e) {
  this.type = 'text';
  var input = this.value;
  var values = input.split('/').map(function(v, i) {
    return v.replace(/\D/g, '')
  });
  var output = '';
  
  if (values.length == 3) {
    var year = values[2].length !== 4 ? parseInt(values[2]) + 2000 : parseInt(values[2]);
    var month = parseInt(values[0]) - 1;
    var day = parseInt(values[1]);
    var d = new Date(year, month, day);
    if (!isNaN(d)) {
      document.getElementById('result').innerText = d.toString();
      var fechas = [d.getMonth() + 1, d.getDate(), d.getFullYear()];
      output = fechas.map(function(v) {
        v = v.toString();
        return v.length == 1 ? '0' + v : v;
      }).join(' / ');
    };
  };
  this.value = output;
});
