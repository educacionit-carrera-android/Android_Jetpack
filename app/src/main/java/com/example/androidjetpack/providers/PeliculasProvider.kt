package com.example.androidjetpack.providers

import com.example.androidjetpack.data.Pelicula
import io.reactivex.Single

class PeliculasProvider {

    fun getPeliculas(): Single<List<Pelicula>> {
        Thread.sleep(1500)

        return Single.just(
            listOf(
                Pelicula(
                    nombre = "The Shawshank Redemption",
                    descripcion = "Cadena Perpetua nos cuenta la historia de Andy Dufresne (Tim Robbins), un banquero normal y corriente con serios problemas personales, puesto que su querida mujer, lo engaña. Un día, nuestro protagonista decide asesinar a su mujer y al amante, prepara la pistola, munición…, pero en el último momento se detiene. O eso parece, porque al día siguiente los cuerpos de ambos amantes yacen sin vida, convirtiéndose Andy al instante en el principal testigo, ya que dejo algunas pistas de su pensado plan. En el juicio no hay esperanza, Dufresne, un respetado banquero, termina condenado a cumplir dos cadenas perpetuas, un castigo quizás no merecido, pero en teoría, de obligada resolución. Al entrar en la prisión de Shawshank, el protagonista se encontrará con un ambiente muy diferente a todo lo que ha visto hasta el momento. De todas maneras, no le costará demasiado aclimatarse, hará amistad con un miembro de la cárcel (interpretado por Morgan Freeman) e intentará ayudar al resto de compañeros con los que vive.",
                    genero = "Drama",
                    anio = 1972,
                    idioma = "Inglés",
                    calificacion = "9,2",
                    imagen = "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX182_CR0,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "The Godfather",
                    descripcion = "América, años 40. Don Vito Corleone (Marlon Brando) es el respetado y temido jefe de una de las cinco familias de la mafia de Nueva York. Tiene cuatro hijos: Connie (Talia Shire), el impulsivo Sonny (James Caan), el pusilánime Fredo (John Cazale) y Michael (Al Pacino), que no quiere saber nada de los negocios de su padre. Cuando Corleone, en contra de los consejos de 'Il consigliere' Tom Hagen (Robert Duvall), se niega a participar en el negocio de las drogas, el jefe de otra banda ordena su asesinato. Empieza entonces una violenta y cruenta guerra entre las familias mafiosas.",
                    genero = "Drama",
                    anio = 1972,
                    idioma = "Inglés",
                    calificacion = "9,1",
                    imagen = "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY268_CR3,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "The Godfather: Part II",
                    descripcion = "Continuación de la historia de los Corleone por medio de dos historias paralelas: la elección de Michael como jefe de los negocios familiares y los orígenes del patriarca, Don Vito Corleone, primero en su Sicilia natal y posteriormente en Estados Unidos, donde, empezando desde abajo, llegó a ser un poderosísimo jefe de la mafia de Nueva York.",
                    genero = "Drama",
                    anio = 1974,
                    idioma = "Inglés",
                    calificacion = "9,0",
                    imagen = "https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY268_CR3,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "The Dark Knight",
                    descripcion = "Batman/Bruce Wayne (Christian Bale) regresa para continuar su guerra contra el crimen. Con la ayuda del teniente Jim Gordon (Gary Oldman) y del Fiscal del Distrito Harvey Dent (Aaron Eckhart), Batman se propone destruir el crimen organizado en la ciudad de Gotham. El triunvirato demuestra su eficacia, pero, de repente, aparece Joker (Heath Ledger), un nuevo criminal que desencadena el caos y tiene aterrados a los ciudadanos. ",
                    genero = "Acción",
                    anio = 2008,
                    idioma = "Inglés",
                    calificacion = "9,0",
                    imagen = "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_UX182_CR0,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "12 Angry Men",
                    descripcion = "Los doce miembros de un jurado deben juzgar a un adolescente acusado de haber matado a su padre. Todos menos uno están convencidos de la culpabilidad del acusado. El que disiente intenta con sus razonamientos introducir en el debate una duda razonable que haga recapacitar a sus compañeros para que cambien el sentido de su voto.",
                    genero = "Drama",
                    anio = 1957,
                    idioma = "Inglés",
                    calificacion = "8,9",
                    imagen = "https://m.media-amazon.com/images/M/MV5BMWU4N2FjNzYtNTVkNC00NzQ0LTg0MjAtYTJlMjFhNGUxZDFmXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_UX182_CR0,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "Schindler's List",
                    descripcion = "Oskar Schindler (Liam Neeson), un empresario alemán de gran talento para las relaciones públicas, busca ganarse la simpatía de los nazis de cara a su beneficio personal. Después de la invasión de Polonia por los alemanes en 1939, Schindler consigue, gracias a sus relaciones con los altos jerarcas nazis, la propiedad de una fábrica de Cracovia. Allí emplea a cientos de operarios judíos, cuya explotación le hace prosperar rápidamente, gracias sobre todo a su gerente Itzhak Stern (Ben Kingsley), también judío. Pero conforme la guerra avanza, Schindler y Stern comienzan ser conscientes de que a los judíos que contratan, los salvan de una muerte casi segura en el temible campo de concentración de Plaszow, que lidera el Comandante nazi Amon Goeth (Ralph Fiennes), un hombre cruel que disfruta ejecutando judíos.",
                    genero = "Nazismo",
                    anio = 1993,
                    idioma = "Inglés",
                    calificacion = "8,9",
                    imagen = "https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "The Lord of the Rings: The Return of the King",
                    descripcion = "El ejército de Sauron ha atacado Minas Tirith, la capital de Gondor. Una poderosa amenaza pone en peligro la paz del reino, antaño poderoso y que ahora necesita más que nunca a su rey. Ante esta situación límite, Aragorn se presenta como una figura clave para llevar al reino a la victoria pero, ¿será capaz de cumplir con su destino? Mientras tanto, Gandalf intentará contener a las fuerzas destructoras de Gondor y Théoden pedirá a los guerreros de Rohan que se unan al combate. Sin embargo, a pesar de su valor y lealtad, parece que las fuerzas de los Hombres no serán suficientes para derrotar a las inconmensurables legiones de enemigos que se ciernen sobre el reino. Cada victoria vendrá acompañada de grandes sacrificios y, a pesar de las pérdidas, la Comunidad continúara su batalla por sobrevivir hasta el final. Al mismo tiempo, sus miembros intentarán atraer la atención de Sauron para darle a Frodo la última oportunidad para completar su misión. A medida que atraviesa las tierras enemigas, el joven hobbit, acompañado por su fiel amigo Sam y el misterioso Gollum, tratará de evitar sucumbir a las continuas tentaciones del Anillo Único.",
                    genero = " Fantasía/Aventura",
                    anio = 2003,
                    idioma = "inglés",
                    calificacion = "8,8",
                    imagen = "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX182_CR0,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "Pulp Fiction",
                    descripcion = "Jules y Vincent, dos asesinos a sueldo con no demasiadas luces, trabajan para el gángster Marsellus Wallace. Vincent le confiesa a Jules que Marsellus le ha pedido que cuide de Mia, su atractiva mujer. Jules le recomienda prudencia porque es muy peligroso sobrepasarse con la novia del jefe. Cuando llega la hora de trabajar, ambos deben ponerse 'manos a la obra'. Su misión: recuperar un misterioso maletín.",
                    genero = "Thriller",
                    anio = 1994,
                    idioma = "Inglés",
                    calificacion = "8,8",
                    imagen = "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY268_CR1,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "Il buono, il brutto, il cattivo",
                    descripcion = "Durante la guerra civil norteamericana (1861-1865), tres cazadores de recompensas buscan un tesoro que ninguno de ellos puede encontrar sin la ayuda de los otros dos. Así que colaboran entre sí para conseguir el botín.",
                    genero = "Western",
                    anio = 1966,
                    idioma = "Inglés",
                    calificacion = "8,8",
                    imagen = "https://m.media-amazon.com/images/M/MV5BOTQ5NDI3MTI4MF5BMl5BanBnXkFtZTgwNDQ4ODE5MDE@._V1_UX182_CR0,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "The Lord of the Rings: The Fellowship of the Ring",
                    descripcion = "En la Tierra Media, el Señor Oscuro Sauron ordenó a los Elfos que forjaran los Grandes Anillos de Poder. Tres para los reyes Elfos, siete para los Señores Enanos, y nueve para los Hombres Mortales. Pero Saurón también forjó, en secreto, el Anillo Único, que tiene el poder de esclavizar toda la Tierra Media. Con la ayuda de sus amigos y de valientes aliados, el joven hobbit Frodo emprende un peligroso viaje con la misión de destruir el Anillo Único. Pero el malvado Sauron ordena la persecución del grupo, compuesto por Frodo y sus leales amigos hobbits, un mago, un hombre, un elfo y un enano. La misión es casi suicida pero necesaria, pues si Sauron con su ejército de orcos lograra recuperar el Anillo, sería el final de la Tierra Media.",
                    genero = "Acción",
                    anio = 2001,
                    idioma = "Inglés",
                    calificacion = "8,8",
                    imagen = "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_UX182_CR0,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "Fight Club",
                    descripcion = "Un joven hastiado de su gris y monótona vida lucha contra el insomnio. En un viaje en avión conoce a un carismático vendedor de jabón que sostiene una teoría muy particular: el perfeccionismo es cosa de gentes débiles; sólo la autodestrucción hace que la vida merezca la pena. Ambos deciden entonces fundar un club secreto de lucha, donde poder descargar sus frustaciones y su ira, que tendrá un éxito arrollador.",
                    genero = "Drama | Thriller",
                    anio = 1999,
                    idioma = "Inglés",
                    calificacion = "8,8",
                    imagen = "https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX182_CR0,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "Forrest Gump",
                    descripcion = "Forrest Gump (Tom Hanks) sufre desde pequeño un cierto retraso mental. A pesar de todo, gracias a su tenacidad y a su buen corazón será protagonista de acontecimientos cruciales de su país durante varias décadas. Mientras pasan por su vida multitud de cosas en su mente siempre está presente la bella Jenny (Robin Wright), su gran amor desde la infancia, que junto a su madre será la persona más importante en su vida.",
                    genero = " Comedia. Drama. Romance ",
                    anio = 1994,
                    idioma = "Inglés",
                    calificacion = "8,8",
                    imagen = "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UY268_CR1,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "Inception",
                    descripcion = "Dom Cobb (DiCaprio) es un experto en el arte de apropiarse, durante el sueño, de los secretos del subconsciente ajeno. La extraña habilidad de Cobb le ha convertido en un hombre muy cotizado en el mundo del espionaje, pero también lo ha condenado a ser un fugitivo y, por consiguiente, a renunciar a llevar una vida normal. Su única oportunidad para cambiar de vida será hacer exactamente lo contrario de lo que ha hecho siempre: la incepción, que consiste en implantar una idea en el subconsciente en lugar de sustraerla. Sin embargo, su plan se complica debido a la intervención de alguien que parece predecir cada uno de sus movimientos, alguien a quien sólo Cobb podrá descubrir.",
                    genero = "Ciencia ficción | Thriller",
                    anio = 2010,
                    idioma = "Inglés",
                    calificacion = "8,7",
                    imagen = "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_UX182_CR0,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "The Lord of the Rings: The Two Towers",
                    descripcion = "Tras la disolución de la Compañía del Anillo, Frodo y su fiel amigo Sam se dirigen hacia Mordor para destruir el Anillo Único y acabar con el poder de Sauron, pero les sigue un siniestro personaje llamado Gollum. Mientras, y tras la dura batalla contra los orcos donde cayó Boromir, el hombre Aragorn, el elfo Legolas y el enano Gimli intentan rescatar a los medianos Merry y Pipin, secuestrados por los orcos de Mordor. Por su parte, Saurón y el traidor Sarumán continúan con sus planes en Mordor, a la espera de la guerra contra las razas libres de la Tierra Media.",
                    genero = "Fantástico | Aventuras",
                    anio = 2002,
                    idioma = "Inglés",
                    calificacion = "8,7",
                    imagen = "https://m.media-amazon.com/images/M/MV5BZGMxZTdjZmYtMmE2Ni00ZTdkLWI5NTgtNjlmMjBiNzU2MmI5XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg"
                ),
                Pelicula(
                    nombre = "Star Wars: Episode V - The Empire Strikes Back",
                    descripcion = "Tras un ataque sorpresa de las tropas imperiales a las bases camufladas de la alianza rebelde, Luke Skywalker, en compañía de R2D2, parte hacia el planeta Dagobah en busca de Yoda, el último maestro Jedi, para que le enseñe los secretos de la Fuerza. Mientras, Han Solo, la princesa Leia, Chewbacca, y C3PO esquivan a las fuerzas imperiales y piden refugio al antiguo propietario del Halcón Milenario, Lando Calrissian, en la ciudad minera de Bespin, donde les prepara una trampa urdida por Darth Vader.",
                    genero = "Ciencia ficción",
                    anio = 1980,
                    idioma = "Inglés",
                    calificacion = "8,7",
                    imagen = "https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX182_CR0,0,182,268_AL_.jpg"
                )

            )
        )
    }
}