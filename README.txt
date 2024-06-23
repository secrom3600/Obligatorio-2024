El archivo universal_top_spotify_songs.csv debe de estar en la ruta de las carpetas a la altura del readme.txt

Procesos de Carga:
    Se utilizo un FileUtil recibido del practicotad_lic2024 visto en clase
    donde
    readFile(String path): toma la ruta del archivo universal_top_spotify_songs como parámetro y devuelve
    un arreglo de cadenas (String[]) con las líneas del archivo leídas.
    Utiliza un BufferedReader para leer el archivo línea por línea y almacenar cada línea en una lista (List<String>).
    Al final, convierte la lista en un arreglo de cadenas y lo retorna.

    El método cargarMusicas() lee datos desde el archivo "universal_top_spotify_songs.csv" y
    crea objetos del tipo Musica basándose en esos datos. El proceso general del método es el siguiente:
    Lee todas las líneas del archivo CSV y las almacena en
    líneas en un arreglo llamado linesMusicas.
    Dentro del bucle, procesa cada línea para extraer los datos necesarios y crea un objeto Musica utilizando el
    patrón Builder.
    Divide la línea en campos utilizando ","" como delimitador, ya que algunos campos, como artistas, tiene cada artista
    separado con ",".
    Elimina las comillas dobles extras que puedan estar presentes en los datos extraídos.
    Construye un objeto Musica utilizando los datos extraídos de la línea del archivo CSV.
    Agrega el objeto Musica creado a una lista llamada musicas

Decisiones Tomadas:
    Decidimos hacer el obligatorio

Consumo de memoria:
    Top5Canciones50top: O(n)
    CantArtistaEnTop50EnFecha: O(n)
    CancionesConTempo: O(n)
    Top7ArtistasEnTops50: O(n)
    Top10CancionesEnUnDia: O(n)

Consumo de RAM:
    Non-Heap Memory(Memoria no del monton): clases y funciones:15 MB
    Heap Memory(Memoria del Monton): Objetos: 388 MB

Tiempo ejecucion promedio
    cargarMusicas(): 4362 ms
    Top5Canciones50top(): 59 ms
    CantArtistaEnTop50EnFecha():58 ms
    CancionesConTempo():302 ms
    Top7ArtistasEnTops50():65 ms
    Top10CancionesEnUnDia:38 ms
    Promedio:814 ms