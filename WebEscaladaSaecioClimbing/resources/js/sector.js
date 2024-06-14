// Código para la API
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const idSector = urlParams.get('idSector');
const viasContainer = document.getElementById('sectorTabla');
const navRegiones = document.getElementById('contenedorNavRegiones');
const nuevaAscensionUrl = "http://localhost:8086/api/ascension/nueva-ascension";
const sectorUrl = "http://localhost:8086/api/sector/leer-sector/" + idSector;
const viasUrl = "http://localhost:8086/api/via/leer-vias-por-id-sector/" + idSector;
let zonaUrl = "http://localhost:8086/api/zona/leer-zona/";
let nombreSierraUrl = "http://localhost:8086/api/sierra/leer-nombre-sierra/";
let nombreZonaUrl = "http://localhost:8086/api/zona/leer-nombre-zona/";
let sectoresUrl = "http://localhost:8086/api/sector/leer-sectores-por-id-zona/";

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

async function getSector() {
  const respuesta = await fetch(sectorUrl);
  const sector = await respuesta.json();

  return sector;
}

async function getVias() {
  const respuesta = await fetch(viasUrl);
  const viasArray = await respuesta.json();

  return viasArray;
}

async function getZona(idZona) {
  zonaUrl += idZona;
  const respuesta = await fetch(zonaUrl);
  const zona = await respuesta.json();

  return zona;
}

async function getNombreSierra(idSierra) {
  nombreSierraUrl += idSierra;
  const respuesta = await fetch(nombreSierraUrl);
  const nombreSierra = respuesta.text();

  return nombreSierra;
}

async function getNombreZona(idZona) {
  nombreZonaUrl += idZona;
  const respuesta = await fetch(nombreZonaUrl);
  const nombreZona = respuesta.text();

  return nombreZona;
}

async function getSectores(idZona) {
  sectoresUrl += idZona;
  const respuesta = await fetch(sectoresUrl);
  const sectoresArray = await respuesta.json();

  return sectoresArray;
}

// Método init
window.addEventListener("load", async function() {
  const sector = await getSector();
  const zona = await getZona(sector.idZona);
  const nombreSierra = await getNombreSierra(zona.idSierra);
  contenedorRegistroAscension.style.display = "none";
  poblarCroquisFoto(sector);
  poblarBarraDirecciones(sector, zona, nombreSierra);
  poblarDropdown(zona);
  poblarVias();
});

// Código para poblar la barra de direcciones
async function poblarBarraDirecciones(sector, zona, nombreSierra) {
  const barraNombreSierra = $("#sierraNombre");
  const barraNombreZona = $("#zonaNombre");
  const barraNombreSector = $("#sectorNombre");
  barraNombreSierra[0].innerHTML = "> " + nombreSierra;
  barraNombreZona[0].innerHTML = "> " + zona.nombre;
  barraNombreSector[0].innerHTML = "> " + sector.nombre;

  $("#sierraNombre").attr("data-href", "sierra.html?idSierra=" + zona.idSierra);
  $("#zonaNombre").attr("data-href", "zona.html?idZona=" + sector.idZona);

  $(document).ready(function($) {
    $("#sierraNombre").click(function() {
      window.location = $(this).data("href");
    });
  });

  $(document).ready(function($) {
    $("#zonaNombre").click(function() {
      window.location = $(this).data("href");
    });
  });
}

// Código para el mapa
async function initMap() {
  const sector = await getSector();
  const puntoMedio = await puntoMedioPoligono(sector);
  const sectorCoord = await coordenadasPoligono(sector);

  var mapProp= {
    center: new google.maps.LatLng(puntoMedio[0], puntoMedio[1]),
    zoom: 18,
    mapTypeId: "terrain",
    disableDefaultUI: true,
    mapTypeControl: true,
    mapTypeControlOptions: {
      style: google.maps.MapTypeControlStyle.DROPDOWN_MENU
    }
  };

  var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

  const sectorPoligono = new google.maps.Polygon({
    paths: sectorCoord,
    strokeColor: "#fcba03",
    strokeOpacity: 0.8,
    strokeWeight: 2,
    fillColor: "#fcba03",
    fillOpacity: 0.35,
  });

  sectorPoligono.setMap(map);

  google.maps.event.addListener(sectorPoligono,"mouseover",function(){
    this.setOptions({
      strokeColor: "#fce303",
      fillColor: "#fce303"});
   }); 
   
   google.maps.event.addListener(sectorPoligono,"mouseout",function(){
    this.setOptions({
      strokeColor: "#fcba03",
      fillColor: "#fcba03"});
   });
}

async function coordenadasPoligono(sector) {
  let sectorCoord = [];
  let latLng = sector.coordenadas.split("|");
  for (let i = 0; i < latLng.length; i++) {
    let arrayTemp = latLng[i].split(",");
    sectorCoord.push({lat: Number(arrayTemp[0]), lng: Number(arrayTemp[1])});
  }

  sectorCoord.push(sectorCoord[0]);

  return sectorCoord;
}

async function puntoMedioPoligono(sector) {
  const sectorCoord = sector.coordenadas.split("|");
  let longitud = 0;
  let latitud = 0;

  for (let i = 0; i < sectorCoord.length; i++) {
    let arrayTemp = sectorCoord[i].split(",");
    latitud += Number(arrayTemp[0]);
    longitud += Number(arrayTemp[1]);
  }

  const puntoMedio = [latitud / sectorCoord.length, longitud / sectorCoord.length];

  return puntoMedio;
}

// Código para el croquis y la foto
const croquisDetalles = document.getElementById("croquisDetalles");
let toggleDetalles = 0;

function cambiarDetails() {
  if (toggleDetalles === 0) {
    croquisDetalles.innerHTML = "Ocultar croquis";
    
    toggleDetalles++;
  } else {
    croquisDetalles.innerHTML = "Mostrar croquis";
    toggleDetalles--;
  }
}
  

function poblarCroquisFoto(sector) {
  document.getElementById("croquisFoto").src = "resources/images/sectores/" + sector.foto;
}

// Código para controlar el dropdown de la barra lateral
async function poblarDropdown(zona) {
  const idZona = zona.idZona;
  const nombreZona = zona.nombre;

  navRegiones.innerHTML += 
  "<a id='navRegionesSuperior' data-href=''>" + nombreZona + "</a>"
  + "<div id='submenuSeleccionado'>"
    + "<ul id='listaSubmenu'>"
    + "</ul>"
  + "</div>";

  $("#navRegionesSuperior").attr("data-href", "zona.html?idZona=" + idZona);

  $(document).ready(function($) {
    $("#navRegionesSuperior").click(function() {
      window.location = $(this).data("href");
    });
  });

  poblarListaDropdown(idZona);
}

async function poblarListaDropdown(idZona) {
  const sectoresArray = await getSectores(idZona);
  const listaSectores = $("#listaSubmenu");

  for (let i = 0; i < sectoresArray.length; i++) {
    if (sectoresArray[i].idSector == idSector) {
      listaSectores[0].innerHTML +=
      "<li id='sectorActual'>"
        + "<a>" + sectoresArray[i].nombre + "</a>"
      + "</li>";
    } else {
      listaSectores[0].innerHTML +=
      "<li>"
        + "<a data-href=''>" + sectoresArray[i].nombre + "</a>"
      + "</li>";
      $("#listaSubmenu li").last().attr("data-href", "sector.html?idSector=" + sectoresArray[i].idSector);
    }
  }

  $(document).ready(function($) {
    $("#listaSubmenu li:not(#sectorActual)").click(function() {
      window.location = $(this).data("href");
    });
  });
}

// Código para poblar la tabla de vías
async function poblarVias() {
  const viasArray = await getVias();
  for (let i = 0; i < viasArray.length; i++) {
    viasContainer.innerHTML +=
      "<tbody>" 
        + "<tr class='info-sector-valores'>"
          + "<td class='numero-via'>" + viasArray[i].numeroDeCroquis + "</td>"
          + "<td>" + viasArray[i].nombre + "</td>"
          + "<td>" + viasArray[i].grado + "</td>"
          + "<td>" + viasArray[i].metros + "</td>"
          + "<td>" + viasArray[i].numeroChapas + "</td>"
          + "<td>" + viasArray[i].fechaApertura + " / " + viasArray[i].fechaUltimaRevision + "</td>"
          // + "<td>" + viasArray[i].aperturistas + "</td>"
          + "<td class='celda-registro'><a><i class='fa-regular fa-pen-to-square'></i></a></td>"
        + "</tr>"
      + "</tbody>";
    $(".celda-registro").last().on("click", function() {
      mostrarRegistroVia(viasArray[i]);
    });
  }
}

// Código para registrar una vía
const contenedorRegistroAscension = document.getElementById("contenedorRegistroAscension");
let viaRegistrar;
let fechaValor;
let tipoAscensionValor;
const nombreViaRegistro = $("#contenedorRegistroAscensionTitulo h3");
function mostrarRegistroVia(via) {
  viaRegistrar = via;
  nombreViaRegistro[0].innerHTML = via.nombre;
  contenedorRegistroAscension.style.display = "block";
}

function ocultarRegistroAscension() {
  contenedorRegistroAscension.style.display = "none";
}

function registrarAscension() {
  fechaValor = document.getElementById('fechaAscension').value;
  tipoAscensionValor = document.getElementById('selectTipoAscension').value;
  const ascension = {
    usuario: JSON.parse(sessionStorage.getItem("usuario")),
    via: viaRegistrar,
    fechaAscension: fechaValor,
    tipoDeAscension: tipoAscensionValor
  }
  nuevaAscension(ascension);
  alert("Vía registrada con éxito");
  ocultarRegistroAscension();
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
