// Código para la API
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const idZona = urlParams.get('idZona');
const sectoresContainer = document.getElementById('zonaTabla');
const navRegiones = document.getElementById('contenedorNavRegiones');
const zonaUrl = "http://localhost:8086/api/zona/leer-zona/" + idZona;
let nombreSierraUrl = "http://localhost:8086/api/sierra/leer-nombre-sierra/";
let zonasUrl = "http://localhost:8086/api/zona/leer-zonas-por-id-sierra/";
let sectoresUrlBase = "http://localhost:8086/api/sector/leer-sectores-por-id-zona/";

async function getZona() {
  const respuesta = await fetch(zonaUrl);
  const zona = await respuesta.json();

  return zona;
}

async function getSectores(idZona) {
  const sectoresUrl = sectoresUrlBase + idZona;
  const respuesta = await fetch(sectoresUrl);
  const sectoresArray = await respuesta.json();

  return sectoresArray;
}

async function getNombreSierra(idSierra) {
  nombreSierraUrl += idSierra;
  const respuesta = await fetch(nombreSierraUrl);
  const nombreSierra = respuesta.text();

  return nombreSierra;
}

async function getZonas(idSierra) {
  zonasUrl += idSierra;
  const respuesta = await fetch(zonasUrl);
  const zonasArray = await respuesta.json();

  return zonasArray;
}

// Método init
window.addEventListener("load", async function() {
  const zona = await getZona();
  const nombreSierra = await getNombreSierra(zona.idSierra);
  poblarBarraDirecciones(zona, nombreSierra);
  poblarDropdown(zona, nombreSierra);
  poblarSectores();
});

// Código para poblar la barra de direcciones
async function poblarBarraDirecciones(zona, nombreSierra) {
  const barraNombreSierra = $("#sierraNombre");
  const barraNombreZona = document.getElementById('zonaNombre');
  barraNombreSierra[0].innerHTML = "> " + nombreSierra;
  barraNombreZona.innerHTML = "> " + zona.nombre;

  $("#sierraNombre").attr("data-href", "sierra.html?idSierra=" + zona.idSierra);
  jQuery(document).ready(function($) {
    $("#sierraNombre").click(function() {
      window.location = $(this).data("href");
    });
  });
}

// Código para el mapa
async function initMap() {
  const zona = await getZona();
  const puntoMedio = await puntoMedioPoligono(zona);
  const sectorCoord = await coordenadasPoligono(zona);

  var mapProp= {
    center: new google.maps.LatLng(puntoMedio[0], puntoMedio[1]),
    zoom: 15,
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
}

async function coordenadasPoligono(zona) {
  let zonaCoord = [];
  let latLng = zona.coordenadas.split("|");
  for (let i = 0; i < latLng.length; i++) {
    let arrayTemp = latLng[i].split(",");
    zonaCoord.push({lat: Number(arrayTemp[0]), lng: Number(arrayTemp[1])});
  }

  zonaCoord.push(zonaCoord[0]);

  return zonaCoord;
}

async function puntoMedioPoligono(zona) {
  const zonaCoord = zona.coordenadas.split("|");
  let longitud = 0;
  let latitud = 0;

  for (let i = 0; i < zonaCoord.length; i++) {
    let arrayTemp = zonaCoord[i].split(",");
    latitud += Number(arrayTemp[0]);
    longitud += Number(arrayTemp[1]);
  }

  const puntoMedio = [latitud / zonaCoord.length, longitud / zonaCoord.length];

  return puntoMedio;
}

// Código para controlar el dropdown de la barra lateral
async function poblarDropdown(zona, nombreSierra) {
  navRegiones.innerHTML += 
  "<a id='navRegionesSuperior' href='sierra.html?idSierra=" + zona.idSierra + "'>" + nombreSierra + "</a>"
  + "</div>";

  poblarZonasDropdown(zona.idSierra);
}

async function poblarZonasDropdown(idSierra) {
  const zonasArray = await getZonas(idSierra);

  for (let i = 0; i < zonasArray.length; i++) {
    if (zonasArray[i].idZona == idZona) {
      navRegiones.innerHTML +=
      "<div id='submenuSeleccionado'>"
        + "<a class='nav-regiones-padre region-zona' id='regionActual'>" + zonasArray[i].nombre + "</a>"
        + "<div class='submenu-dropdown'>"
          + "<ul></ul>"
        + "</div>"
      + "</div>";
    } else {
      navRegiones.innerHTML +=
      "<div class='submenu-dropdown'>"
        + "<a class='nav-regiones-padre region-zona' data-href=''>" + zonasArray[i].nombre + "</a>"
        + "<div class='submenu-dropdown-oculto'>"
          + "<ul data-idzona=''></ul>"
        + "</div>"
      + "</div>";

      $(".nav-regiones-padre").last().attr("data-href", "zona.html?idZona=" + zonasArray[i].idZona);
      $(".submenu-dropdown-oculto ul").last().attr("data-idzona", zonasArray[i].idZona);
    }
  }

  $(document).ready(function() {
    $(".nav-regiones-padre:not(#regionActual)").click(function() {
      window.location = $(this).data("href");
    });
  });

  poblarListaDropdown();
}

async function poblarListaDropdown() {
  const sectoresVisiblesArray = await getSectores(idZona);
  const listaSectoresVisible = $("#submenuSeleccionado .submenu-dropdown ul");
  const listasSectoresInvisibles = $(".submenu-dropdown-oculto ul");

  for (let i = 0; i < sectoresVisiblesArray.length; i++) {
    listaSectoresVisible[0].innerHTML +=
    "<li>"
      + "<a class='region-sector' data-href=''>" + sectoresVisiblesArray[i].nombre + "</a>"
    + "</li>";
    $(".region-sector").last().attr("data-href", "sector.html?idSector=" + sectoresVisiblesArray[i].idSector);
  }

  for (let i = 0; i < listasSectoresInvisibles.length; i++) {
    const sectoresInvisiblesArray = await getSectores(listasSectoresInvisibles[i].dataset.idzona);
    for (let j = 0; j < sectoresInvisiblesArray.length; j++) {
      listasSectoresInvisibles[i].innerHTML +=
      "<li>"
        + "<a class='region-sector' data-href=''>" + sectoresInvisiblesArray[j].nombre + "</a>"
      + "</li>";
      $(".region-sector").last().attr("data-href", "sector.html?idSector=" + sectoresInvisiblesArray[j].idSector);
    }
  }

  $(document).ready(function() {
    $(".region-sector:not(#regionActual)").click(function() {
      window.location = $(this).data("href");
    });
  });
}

// Código para poblar la tabla de sectores
async function poblarSectores() {
  const sectoresArray = await getSectores(idZona);
  for (let i = 0; i < sectoresArray.length; i++) {
    sectoresContainer.innerHTML +=
      "<tbody>"
        + "<tr class='info-zona-valores' data-href=''>"
          + "<td>" + sectoresArray[i].nombre + "</td>"
          + "<td>" + sectoresArray[i].tiposDeEscalada + "</td>"
          + "<td>" + sectoresArray[i].vias.length + "</td>"
        + "</tr>"
      + "</tbody>";

    $(".info-zona-valores").last().attr("data-href", "sector.html?idSector=" + sectoresArray[i].idSector);
  }

  jQuery(document).ready(function($) {
    $(".info-zona-valores").click(function() {
      window.location = $(this).data("href");
    });
  });
}
