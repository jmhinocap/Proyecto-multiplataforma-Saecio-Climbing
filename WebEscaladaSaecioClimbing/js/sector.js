// Código para el mapa
function myMap() {
  var mapProp = {
    center: new google.maps.LatLng(51.508742, -0.120850),
    zoom: 5,
  };
  var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
}

// Código para la API
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const idSector = urlParams.get('idSector')
const viasContainer = document.getElementById('sectorTabla');
const viasUrl = "http://localhost:8086/api/via/leer-vias-por-id-sector/" + idSector;

async function getVias() {
  const respuesta = await fetch(viasUrl);
  const viasArray = await respuesta.json();

  return viasArray;
}

async function poblarVias() {
  const viasArray = await getVias();
  for (let i = 0; i < viasArray.length; i++) {
    viasContainer.innerHTML +=
      "<tbody>" 
        + "<tr class='info-sector-valores'>"
          + "<td>" + (i + 1) + "</td>"
          + "<td>" + viasArray[i].nombre + "</td>"
          + "<td>" + viasArray[i].grado + "</td>"
          + "<td>" + viasArray[i].metros + "</td>"
          + "<td>" + viasArray[i].numeroChapas + "</td>"
          + "<td>" + viasArray[i].fechaApertura + " / " + viasArray[i].fechaUltimaRevision + "</td>"
          + "<td>" + viasArray[i].aperturistas + "</td>"
        + "</tr>"
      + "</tbody>"
  }
}
