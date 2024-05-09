// Código para la API
const queryString = window.location.search;
const sierrasContainer = document.getElementById('contenedorSierras');
const sierrasUrl = "http://localhost:8086/api/sierra/leer-todas-las-sierras/";

async function getSierras() {
  const respuesta = await fetch(sierrasUrl);
  const sierrasArray = await respuesta.json();

  return sierrasArray;
}

async function poblarSierras() {
  const sierrasArray = await getSierras();
  for (let i = 0; i < sierrasArray.length; i++) {
    sierrasContainer.innerHTML +=
      "<div class='carta-sierra'>"
        + "<div class='contenido-carta-sierra'>"
            + "<a class='nombre-sierra' href='sierra.html'>"
                + "<h2>Nombre de la sierra</h2>"
            + "</a>"
            + "<a href='sierra.html'><img src='resources/images/Sierras/Nuevo_Mundo,_Sierra_de_Gádor.jpg' class='thumbnail'/>"
        + "</div>"
        + "<div class='zonas'>"
            + "<ul class='lista-zonas'>"
            + "</ul>"
        + "</div>"
     + "</div>"
  }
}