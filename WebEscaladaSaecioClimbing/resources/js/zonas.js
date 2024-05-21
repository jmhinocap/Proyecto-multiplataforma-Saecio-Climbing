// Código para la API
const queryString = window.location.search;
const refsSierra = document.getElementsByClassName('sierra-ref');
const nombreSierra = document.getElementsByClassName('nombre-sierra');
const refsZona = document.getElementsByClassName('zona-ref');
const sierrasContainer = document.getElementById('contenedorSierras');
const sierrasUrl = "http://localhost:8086/api/sierra/leer-todas-las-sierras";
const zonasUrlBase = "http://localhost:8086/api/zona/leer-zonas-por-id-sierra/"

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

// Método init
window.addEventListener("load", async function() {
  poblarCartasSierra();
});

// Código para poblar las entradas de las sierras
async function poblarCartasSierra() {
  const sierrasArray = await getSierras();

  for (let i = 0; i < sierrasArray.length; i++) {
    sierrasContainer.innerHTML +=
    "<div class='carta-sierra'>"
      + "<div class='contenido-carta-sierra'>"
        + "<a class='nombre-sierra sierra-ref' data-href=''><h2>" + sierrasArray[i].nombre + "</h2></a>"
        + "<a class='sierra-ref' data-href=''><img src='resources/images/Sierras/Nuevo_Mundo,_Sierra_de_Gádor.jpg' class='thumbnail'/></a>"
      + "</div>"
      + "<div class='zonas'>"
        + "<ul class='lista-zonas' data-idsierra=''>"
      + "</div>"
    + "</div>";
    $(".sierra-ref:nth-last-of-type(2)").attr("data-href", "sierra.html?idSierra" + sierrasArray[i].idSierra);
    $(".lista-zonas").last().attr("data-idsierra", sierrasArray[i].idSierra);
  }

  $(document).ready(function() {
    $(".sierra-ref").click(function() {
      window.location = $(this).data("href");
    });
  })

  poblarListasZonas();
}

async function poblarListasZonas() {
  const listasZonas = $(".lista-zonas");
  for(let i = 0; i < listasZonas.length; i++) {
    const zonasArray = await getZonas(listasZonas[i].dataset.idsierra);
    for(let j = 0; j < zonasArray.length; j++) {
      listasZonas[i].innerHTML +=
      "<li class='elemento-lista-zona'><a class='zona-ref' data-href=''>" + zonasArray[j].nombre + "</a></div>"
      $(".zona-ref").last().attr("data-href", "zona.html?idZona=" + zonasArray[j].idSierra);
    }
    listasZonas[i].innerHTML +=
    "<li class='elemento-lista-zona'><a class='sierra-ref mas-zonas' data-ref=''>Más zonas</a></li>";
    $(".sierra-ref").last().attr("data-href", "sierra.html?idSierra=" + listasZonas[i].dataset.idSierra);
  }

  $(document).ready(function() {
    $(".zona-ref").click(function() {
      window.location = $(this).data("href");
    });
  })

  $(document).ready(function() {
    $(".sierra-ref").click(function() {
      window.location = $(this).data("href");
    });
  })
}

// async function crearCartasSierra() {
//   const sierrasArray = await getSierras();
//   for (let i = 0; i < sierrasArray.length; i++) {
//     sierrasContainer.innerHTML +=
//       "<div class='carta-sierra'>"
//         + "<div class='contenido-carta-sierra'>"
//           + "<a class='nombre-sierra sierra-ref' href='sierra.html?idSierra='>"
//           + "</a>"
//           + "<a class='sierra-ref' href='sierra.html?idSierra='><img src='resources/images/Sierras/Nuevo_Mundo,_Sierra_de_Gádor.jpg' class='thumbnail'/>"
//         + "</div>"
//         + "<div class='zonas'>"
//             + "<ul class='lista-zonas'>"
//               + "<li class='elemento-lista-zona'><a class='zona-ref' href='zona.html?idZona='></a></li>"
//               + "<li class='elemento-lista-zona'><a class='zona-ref' href='zona.html?idZona='></a></li>"
//               + "<li class='elemento-lista-zona'><a class='zona-ref' href='zona.html?idZona='></a></li>"
//               + "<li class='elemento-lista-zona'><a class='sierra-ref' href='sierra.html?idSierra='>Más zonas</a></li>"
//             + "</ul>"
//         + "</div>"
//       + "</div>"
//   }
// }