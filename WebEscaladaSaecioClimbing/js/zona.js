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
const idZona = urlParams.get('idZona');
const sectoresContainer = document.getElementById('zonaTabla');
const sectoresUrl = "http://localhost:8086/api/sector/leer-sectores-por-id-zona/" + idZona;

async function getSectores() {
  const respuesta = await fetch(sectoresUrl);
  const sectoresArray = await respuesta.json();

  return sectoresArray;
}

async function poblarSectores() {
  const sectoresArray = await getSectores();
  for (let i = 0; i < sectoresArray.length; i++) {
    sectoresContainer.innerHTML +=
      "<tbody>"
        + "<tr class='info-zona-valores'>"
          + "<td>" + sectoresArray[i].nombre + "</td>"
          + "<td>" + sectoresArray[i].tipoDeEscalada + "</td>"
          + "<td>" + sectoresArray[i].vias.length + "</td>"
        + "</tr>"
      + "</tbody>"
  }
}
