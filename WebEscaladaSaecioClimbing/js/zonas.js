// Código para la API
const queryString = window.location.search;
const sierrasContainer = document.getElementById('contenedorSierras');
const sierrasUrl = "http://localhost:8086/api/sierra/leer-todas-las-sierras";

async function getSierras() {
  const respuesta = await fetch(sierrasUrl);
  const sierrasArray = await respuesta.json();

  return sierrasArray;
}

async function getZonas(idSierra) {
  const zonasUrl = "http://localhost:8086/api/zona/leer-zonas-por-id-sierra/" + idSierra;
  const respuesta = await fetch(zonasUrl);
  const zonasArray = await respuesta.json();

  return zonasArray;
}

async function poblarCartasSierra() {
  crearCartasSierra();
  const sierrasArray = await getSierras();
  const refsSierra = document.getElementsByClassName('sierra-ref');
  const nombreSierra = document.getElementsByClassName('nombre-sierra');
  const refsZona = document.getElementsByClassName('zona-ref');

  for (let i = 0; i < sierrasArray.length; i++) {
    console.log(sierrasArray[i]);
    console.log(refsSierra[i]);
    const zonasArray = await getZonas(sierrasArray[i].idSierra);
    nombreSierra[i].innerHTML = "<h2>" + sierrasArray[i].nombre + "</h2>";

    for (let j = 0; j < refsSierra.length; j++) {
      refsSierra[j].href += sierrasArray[i].idSierra;
    }

    for (let j = 0; j < zonasArray.length; j++) {
      refsZona[j].href += zonasArray[j].idZona;
      refsZona[j].innerHTML += zonasArray[j].nombre;
    }
  }
}

async function crearCartasSierra() {
  const sierrasArray = await getSierras();
  for (let i = 0; i < sierrasArray.length; i++) {
    sierrasContainer.innerHTML +=
      "<div class='carta-sierra'>"
        + "<div class='contenido-carta-sierra'>"
          + "<a class='nombre-sierra sierra-ref' href='sierra.html?idSierra='>"
          + "</a>"
          + "<a class='sierra-ref' href='sierra.html?idSierra='><img src='resources/images/Sierras/Nuevo_Mundo,_Sierra_de_Gádor.jpg' class='thumbnail'/>"
        + "</div>"
        + "<div class='zonas'>"
            + "<ul class='lista-zonas'>"
              + "<li class='elemento-lista-zona'><a class='zona-ref' href='zona.html?idZona='></a></li>"
              + "<li class='elemento-lista-zona'><a class='zona-ref' href='zona.html?idZona='></a></li>"
              + "<li class='elemento-lista-zona'><a class='zona-ref' href='zona.html?idZona='></a></li>"
              + "<li class='elemento-lista-zona'><a class='sierra-ref' href='sierra.html?idSierra='>Más zonas</a></li>"
            + "</ul>"
        + "</div>"
      + "</div>"
  }
}