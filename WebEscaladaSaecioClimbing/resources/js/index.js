// Métodos y variables para el slideshow de index
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var imagenes = document.getElementsByClassName("index-slideshow");

  if (n > imagenes.length) {
    slideIndex = 1
  }

  if (n < 1) {
    slideIndex = imagenes.length;
  }

  for (i = 0; i < imagenes.length; i++) {
    imagenes[i].style.display = 'none';
  }

  imagenes[slideIndex - 1].style.display = 'block';
}

// Métodos y variables para el botón de más de la barra de búsqueda de index
// TODO refactorizar todo este código para optimizarlo
var focus = 0;

function abrirMasOpciones(event) {
  var boton = event.target.matches("#buttonMasOpcionesBuscar");

  if (boton && focus === 0) {
    document.getElementById("dropdownIndexBuscar").classList.toggle("mostrar-dropdown");
    focus++;
  } else if (boton && focus == 1) {
    cerrarIniciarSesion();
    document.getElementById("buttonMasOpcionesBuscar").blur();
  }
}

function cerrarMasOpciones() {
  var dropdowns = document.getElementsByClassName("contenido-dropdown");
  var i;
  for (i = 0; i < dropdowns.length; i++) {
    var abrirDropdown = dropdowns[i];
    if (abrirDropdown.classList.contains('mostrar-dropdown')) {
      abrirDropdown.classList.remove('mostrar-dropdown');
    }

    if (focus === 1) {
      focus--;
    }
  }
}

// Código para el carrusel de cartas de escuelas
$(document).ready(function () {
  $('.escuelas').slick({
    centerMode: true,
    dots: true,
    pauseOnHover: true,
    pauseOnDotsHover: true,
    arrows: true,
    prevArrow: $('#buttonDeslizarIzquierda'),
    nextArrow: $('#buttonDeslizarDerecha'),
    infinite: true,
    autoplay: true,
    autoplaySpeed: 5000,
    variableWidth: true,
    speed: 800,
    slidesToShow: 3,
    slidesToScroll: 1,
    responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 3
        }
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 2
        }
      },
      {
        breakpoint: 480,
        settings: {
          slidesToShow: 1
        }
      }
    ]
  }
  );

  $('.slick-dots').find('li').find('button').text('');
}
);

// Código para la API
const tablaUltimasVias = document.getElementById('tablaUltimasVias');
const viasUrl = "http://localhost:8086/api/via/leer-ultimas-cinco-vias";
let sectorUrlBase = "http://localhost:8086/api/sector/leer-sector/";

async function getVias() {
  const respuesta = await fetch(viasUrl);
  const viasArray = await respuesta.json();

  return viasArray;
}

async function getSector(idSector) {
  const sectorUrl = sectorUrlBase + idSector;
  const respuesta = await fetch(sectorUrl);
  const sector = await respuesta.json();

  return sector;
}

async function poblarUltimasEntradas() {
  const viasArray = await getVias();
  for (let i = 0; i < viasArray.length; i++) {
    const sector = await getSector(viasArray[i].idSector);
    tablaUltimasVias.innerHTML +=
      "<tbody>"
        + "<tr>"
          + "<td><h4 class='entrada-via'>" + viasArray[i].nombre + "</h4></td>"
          + "<td><h4 class='entrada-grado'>" + viasArray[i].grado + "</h4></td>"
          + "<td><h4 class='entrada-sector'>" + sector.nombre + "</h4></td>"
        + "</tr>"
      + "</tbody>";

    $(".ultima-entrada").last().attr("data-href", "via.html?idVia=" + viasArray[i].idVia);
  }

  // jQuery(document).ready(function($) {
  //   $(".ultima-entrada").click(function() {
  //     window.location = $(this).data("href");
  //   });
  // });
}
