// Código para el mapa
function myMap() {
    var mapProp= {
      center:new google.maps.LatLng(51.508742,-0.120850),
      zoom:5,
    };
    var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
}

// Código para la API
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const idSierra = urlParams.get('idSierra');
const zonasContainer = document.getElementById('sierraTabla');
const zonasUrl = "http://localhost:8086/api/zona/leer-zonas-por-id-sierra/" + idSierra;

async function getZonas() {
  const respuesta = await fetch(zonasUrl);
  const zonasArray = await respuesta.json();

  return zonasArray;
}

async function poblarZonas() {
  const zonasArray = await getZonas();
  for (let i = 0; i < zonasArray.length; i++) {
    zonasContainer.innerHTML +=
      "<tbody>"
        + "<tr class='info-sierra-valores'>"
          + "<td>" + (i + 1) + "</td>"
          + "<td>" + zonasArray[i].nombre + "</td>"
          + "<td>" + zonasArray[i].sectores.length + "</td>"
        + "</tr>"
      + "</tbody>"
  }
}
