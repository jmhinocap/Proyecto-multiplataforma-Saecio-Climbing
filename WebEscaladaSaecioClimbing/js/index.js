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
var focus = 0;

function controlarDropdown(event) {
    var boton = event.target.matches('#buttonMasOpcionesBuscar');

    if (boton && focus === 0) {
        document.getElementById("dropdownIndexBuscar").classList.toggle("mostrar-dropdown");
        focus++;
    } else if (boton && focus == 1) {
        cerrarDropdown();
        document.getElementById("buttonMasOpcionesBuscar").blur();
    }
}

function cerrarDropdown() {
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

// Métodos para el carrusel de cartas de escuelas
$(document).ready(function() {
    $('.escuelas').slick({
        centerMode: true,
        dots: true,
        pauseOnHover: true,
        pauseOnDotsHover: true,
        arrows: true,
        prevArrow: $('#button-deslizar-izquierda'),
        nextArrow: $('#button-deslizar-derecha'),
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
