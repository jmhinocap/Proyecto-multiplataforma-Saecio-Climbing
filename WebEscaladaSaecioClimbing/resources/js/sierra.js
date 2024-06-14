// Código para la API
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const idSierra = urlParams.get('idSierra');
const sierraBarraDirecciones = document.getElementById('sierraNombre');
const zonasContainer = document.getElementById('sierraTabla');
const navRegiones = document.getElementById('contenedorNavRegiones');
const sierraNombreUrl = "http://localhost:8086/api/sierra/leer-nombre-sierra/" + idSierra;
const sierraUrl = "http://localhost:8086/api/sierra/leer-sierra/" + idSierra;
const sierrasUrl = "http://localhost:8086/api/sierra/leer-todas-las-sierras";
const zonasUrlBase = "http://localhost:8086/api/zona/leer-zonas-por-id-sierra/";
const sectoresUrlBase = "http://localhost:8086/api/sector/leer-sectores-por-id-zona/";

async function getSierraNombre() {
  const respuesta = await fetch(sierraNombreUrl);
  const sierraNombre = respuesta.text();

  return sierraNombre;
}
async function getSierra() {
  const respuesta = await fetch(sierraUrl);
  const sierra = await respuesta.json();

  return sierra;
}

async function getSierras() {
  const respuesta = await fetch(sierrasUrl);
  const sierrasArray = await respuesta.json();

  return sierrasArray;
}

async function getZonas(idSierra) {
  const zonasUrl = zonasUrlBase + idSierra;
  const respuesta = await fetch(zonasUrl);
  const zonasArray = await respuesta.json();

  return zonasArray;
}

async function getSectores(idZona) {
  const sectoresUrl = sectoresUrlBase + idZona;
  const respuesta = await fetch(sectoresUrl);
  const sectoresArray = await respuesta.json();

  return sectoresArray;
}

// Método init
window.addEventListener("load", async function() {
  const sierraNombre = await getSierraNombre();
  sierraBarraDirecciones.innerHTML += sierraNombre;
  poblarDropdown();
  poblarZonas();
});

// Código para el mapa
async function initMap() {
  const sierra = await getSierra();
  const puntoMedio = await puntoMedioPoligono(sierra);
  const sierraCoord = await coordenadasPoligono(sierra);

  var mapProp = {
    center: new google.maps.LatLng(puntoMedio[0], puntoMedio[1]),
    zoom: 11,
    mapTypeId: "terrain",
    disableDefaultUI: true,
    mapTypeControl: true,
    mapTypeControlOptions: {
      style: google.maps.MapTypeControlStyle.DROPDOWN_MENU
    }
  };

  var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);

  const sierraPoligono = new google.maps.Polygon({
    paths: sierraCoord,
    strokeColor: "#fcba03",
    strokeOpacity: 0.8,
    strokeWeight: 2,
    fillColor: "#fcba03",
    fillOpacity: 0.35,
  });

  sierraPoligono.setMap(map);
}

async function coordenadasPoligono(sierra) {
  let sierraCoord = [];
  let latLng = sierra.coordenadas.split("|");
  for (let i = 0; i < latLng.length; i++) {
    let arrayTemp = latLng[i].split(",");
    sierraCoord.push({lat: Number(arrayTemp[0]), lng: Number(arrayTemp[1])});
  }

  sierraCoord.push(sierraCoord[0]);

  return sierraCoord;
}

async function puntoMedioPoligono(sierra) {
  const sierraCoord = sierra.coordenadas.split("|");
  let longitud = 0;
  let latitud = 0;

  for (let i = 0; i < sierraCoord.length; i++) {
    let arrayTemp = sierraCoord[i].split(",");
    latitud += Number(arrayTemp[0]);
    longitud += Number(arrayTemp[1]);
  }

  const puntoMedio = [latitud / sierraCoord.length, longitud / sierraCoord.length];

  return puntoMedio;
}

// Código para controlar el dropdown de la barra lateral
async function poblarDropdown() {
  const sierrasArray = await getSierras();
  
  for(let i = 0; i < sierrasArray.length; i++) {
    if (sierrasArray[i].idSierra == idSierra) {
      navRegiones.innerHTML +=
      "<div id='submenuSeleccionado'>"
        + "<a class='nav-regiones-padre region-sierra' id='regionActual'>" + sierrasArray[i].nombre + "</a>"
        + "<div class='submenu-dropdown submenu-sierras'>"
          + "<ul></ul>"
        + "</div>"
      + "</div>";
    } else {
      navRegiones.innerHTML +=
      "<div class='submenu-dropdown'>"
        + "<a class='nav-regiones-padre region-sierra' data-href=''>" + sierrasArray[i].nombre + "</a>"
        + "<div class='submenu-dropdown-oculto'>"
          + "<ul data-idsierra=''></ul>"
        + "</div>"
      + "</div>";

      $(".nav-regiones-padre").last().attr("data-href", "sierra.html?idSierra=" + sierrasArray[i].idSierra);
      $(".submenu-dropdown-oculto ul").last().attr("data-idsierra", sierrasArray[i].idSierra);
    }
  }

  $(document).ready(function() {
    $(".nav-regiones-padre:not(#regionActual)").click(function() {
      window.location = $(this).data("href");
    });
  });

  poblarZonasDropdown();
}

async function poblarZonasDropdown() {
  const zonasVisiblesArray = await getZonas(idSierra);
  const listaZonasVisible = $("#submenuSeleccionado .submenu-dropdown ul");
  const listasZonasInvisibles = $(".submenu-dropdown-oculto:not(.sector-sierra-actual) ul");

  for (let i = 0; i < zonasVisiblesArray.length; i++) {
    listaZonasVisible[0].innerHTML +=
    "<li>"
      + "<div class='region-zona-contenedor'>"
        + "<a class='region-zona' data-href=''>" + zonasVisiblesArray[i].nombre + "</a>"
        + "<i class='fa-solid fa-caret-right region-zona-after'></i>"
      + "</div>"
      + "<div class='submenu-dropdown-oculto sector-sierra-actual'>"
        + "<ul data-idzona=''></ul>"
    + "</li>";
    $("#submenuSeleccionado .submenu-dropdown ul li a").last().attr("data-href", "zona.html?idZona=" + zonasVisiblesArray[i].idZona);
    $(".sector-sierra-actual ul").last().attr("data-idzona", zonasVisiblesArray[i].idZona);
  }

  for (let i = 0; i < listasZonasInvisibles.length; i++) {
    const zonasInvisiblesArray = await getZonas(listasZonasInvisibles[i].dataset.idsierra);
    for (let j = 0; j < zonasInvisiblesArray.length; j++) {
      listasZonasInvisibles[i].innerHTML +=
      "<li>"
        + "<a data-href=''>" + zonasInvisiblesArray[j].nombre + "</a>"
      + "</li>";
      $(".submenu-dropdown-oculto:not(.sector-sierra-actual) ul li a").last().attr("data-href", "zona.html?idZona=" + zonasInvisiblesArray[j].idZona);
    }
  }

  $(document).ready(function() {
    $(".submenu-dropdown-oculto:not(.sector-sierra-actual) ul li a").click(function() {
      window.location = $(this).data("href");
    });
  });

  $(document).ready(function() {
    $("#submenuSeleccionado .submenu-dropdown ul li a").click(function() {
      window.location = $(this).data("href");
    })
  });

  poblarSectoresDropdown();
}

async function poblarSectoresDropdown() {
  const dropdownsZonas = $(".sector-sierra-actual ul");
  for(let i = 0; i < dropdownsZonas.length; i++) {
    const sectoresArray = await getSectores(dropdownsZonas[i].dataset.idzona);
      for(let j = 0; j < sectoresArray.length; j++) {
        dropdownsZonas[i].innerHTML +=
        "<li>"
          + "<a>" + sectoresArray[j].nombre + "</a>"
        + "</li>";

        $(".sector-sierra-actual ul li a").last().attr("data-href", "sector.html?idSector=" + sectoresArray[j].idSector);
      }
  }

  $(document).ready(function() {
    $(".sector-sierra-actual ul li a").click(function() {
      window.location = $(this).data("href");
    });
  });
}

// Código para poblar la tabla de zonas
async function poblarZonas() {
  const zonasArray = await getZonas(idSierra);
  for (let i = 0; i < zonasArray.length; i++) {
    let numeroVias = numeroDeVias(zonasArray[i].sectores);
    zonasContainer.innerHTML +=
      "<tbody>"
          + "<tr class='info-sierra-valores' data-href=''>"
            + "<td>" + zonasArray[i].nombre + "</td>"
            + "<td>" + zonasArray[i].tiposDeEscalada + "</td>"
            + "<td>" + zonasArray[i].sectores.length + "</td>"
            + "<td>" + numeroVias + "</td>"
            // hacer componente de grados
            // + "<td>" + + "</td>"
          + "</tr>"
        + "</tbody>";

    $(".info-sierra-valores").last().attr("data-href", "zona.html?idZona=" + zonasArray[i].idZona);
  }

  jQuery(document).ready(function($) {
    $(".info-sierra-valores").click(function() {
      window.location = $(this).data("href");
    });
  });
}

function numeroDeVias(sectores) {
  let numeroVias = 0;
  for (let i = 0; i < sectores.length; i++) {
    numeroVias += sectores[i].vias.length;
  }

  return numeroVias;
}
