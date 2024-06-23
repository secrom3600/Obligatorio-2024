package src.uy.edu.um.funciones;

import src.uy.edu.um.clases.Musica;
import src.uy.edu.um.tad.linkedlist.MyLinkedListImpl;
import src.uy.edu.um.tad.linkedlist.MyList;
import src.uy.edu.um.tad.linkedlist.Node;
import src.uy.edu.um.util.FileUtil;

import java.util.*;

public class Funciones {

    private MyList<Musica> musicas = new MyLinkedListImpl<>();

    public void cargarMusicas()
    {


        String[] linesMusicas = FileUtil.readFile("universal_top_spotify_songs.csv");
        for (String line : linesMusicas)
        {

            try
            {
                String[] data = line.split(",\"");
                String data2 = data[2].replace("\"", "");
                List<String> artistsList = new ArrayList<>(Arrays.asList(data2.split(",")));
                Musica unConductor = Musica.builder()
                        .spotify_id(data[0].replace("\"", ""))
                        .name(data[1].replace("\"", ""))
                        .artists(artistsList)
                        .daily_rank(Integer.parseInt(data[3].replace("\"", "")))
                        //.daily_movement(data[4])
                        //.weekly_movement(data[5])
                        .country(data[6].replace("\"", ""))
                        .snapshot_date(data[7].replace("\"", ""))
                        .popularity(Integer.parseInt(data[8].replace("\"", "")))
                        //.is_explicit(data[9])
                        //.duration_ms(data[10])
                        .album_name(data[11].replace("\"", ""))
                        //.album_release_date(data[12].replace("\"", ""))
                        //.danceability(data[13])
                        //.energy(data[14])
                        //.key(data[15])
                        //.loudness(data[16])
                        //.mode(data[17])
                        //.speechiness(data[18])
                        //.acousticness(data[19])
                        //.instrumentalness(data[20])
                        //.liveness(data[21])
                        //.valence(data[22])
                        .tempo(Integer.parseInt(data[23].replace("\"", "")))
                        //.time_signature(data[24])
                        .build();

                musicas.add(unConductor);


            }
            catch (Exception e)
            {
                continue;
            }
        }

    }

    //funcion de prueba
    public void listarVariables()
    {

        Node<Musica> musicaNode = this.musicas.getFirst();
        while(musicaNode!= null) {

            if(musicaNode.getValue().getSnapshot_date().equals("2022-12-06"))
                System.out.println(musicaNode.getValue().getAlbum_name());
            musicaNode = musicaNode.getNext();
        }

    }



    public void Top5Canciones50top(String dia){

        // Mapa para contar la cantidad de apariciones de cada canción
        Map<String, Integer> conteoCanciones = new HashMap<>();
        // Mapa para almacenar los nombres de las canciones
        Map<String, String> idANombre = new HashMap<>();
        // Min-Heap para mantener las top 5 canciones más populares
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue().compareTo(b.getValue())
        );

        Node<Musica> musicaNode = this.musicas.getFirst();

        while (musicaNode != null) {
            if (musicaNode.getValue().getSnapshot_date().equals(dia)) {
                String idCancion = musicaNode.getValue().getSpotify_id();
                String nombreCancion = musicaNode.getValue().getName();
                conteoCanciones.put(idCancion, conteoCanciones.getOrDefault(idCancion, 0) + 1);
                idANombre.put(idCancion, nombreCancion);
            }
            musicaNode = musicaNode.getNext();
        }


        for (Map.Entry<String, Integer> entry : conteoCanciones.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > 5) {
                minHeap.poll();
            }
        }

        Stack<Map.Entry<String, Integer>> stack = new Stack<>();
        while (!minHeap.isEmpty()) {
            stack.push(minHeap.poll());
        }


        System.out.println("Las 5 canciones más populares son:");
        while (!stack.isEmpty()) {
            String id = stack.pop().getKey();
            System.out.println(idANombre.get(id));
        }


    }

    public void CantArtistaEnTop50EnFecha(String Artista,String fecha){

        int cantAparicion = 0;

        Node<Musica> musicaNode = this.musicas.getFirst();

        while (musicaNode != null) {
            if (musicaNode.getValue().getSnapshot_date().equals(fecha)) {
                List<String> artistas = musicaNode.getValue().getArtists();
                for (String artist : artistas) {
                    if (artist.equals(Artista)) {
                        cantAparicion++;
                    }

                }
            }
            musicaNode = musicaNode.getNext();
        }
        System.out.println("El artista " + Artista + " aparece " + cantAparicion + " veces en la fecha " + fecha);





    }

    public void CancionesConTempo (Integer tempoIn, Integer tempoOut,String fechaIn, String fechaOut){



        int count = 0;
        Node<Musica> musicaNode = this.musicas.getFirst();
        while (musicaNode != null) {
            if (musicaNode.getValue().getSnapshot_date().compareTo(fechaIn) > 0 &&
                musicaNode.getValue().getSnapshot_date().compareTo(fechaOut) < 0 &&
                    musicaNode.getValue().getTempo() > tempoIn &&
                    musicaNode.getValue().getTempo() < tempoOut
                ){
                    count += 1;
                }
            musicaNode = musicaNode.getNext();
        }
        System.out.println("la cantidad de canciones entre el rango de tempo dado y la fecha dado es: " + count);


    }

    public void Top7ArtistasEnTops50 (String fechaIn,String fechaOut){


        List<String> todosLosArtistas = new ArrayList<>();

        Node<Musica> musicaNode = this.musicas.getFirst();

        while (musicaNode != null) {
            if (musicaNode.getValue().getSnapshot_date().compareTo(fechaIn) > 0 &&
                    musicaNode.getValue().getSnapshot_date().compareTo(fechaOut) < 0) {
                List<String> artistas = musicaNode.getValue().getArtists();
                todosLosArtistas.addAll(artistas);
            }
            musicaNode = musicaNode.getNext();
        }

        Map<String, Integer> contadorDeArtistas = new HashMap<>();
        for (String artista : todosLosArtistas) {
            contadorDeArtistas.put(artista, contadorDeArtistas.getOrDefault(artista, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
                7, Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<String, Integer> entry : contadorDeArtistas.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > 7) {
                priorityQueue.poll();
            }
        }

        List<Map.Entry<String, Integer>> topArtistas = new ArrayList<>(priorityQueue);
        topArtistas.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        System.out.println("Los 7 artistas más frecuentes son:");
        for (Map.Entry<String, Integer> entry : topArtistas) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " veces");
        }


    }

    public void Top10CancionesEnUnDia (String pais,String fecha){


        Map<String, Integer> conteoCanciones = new HashMap<>();

        MyList<Musica> musicaList = new MyLinkedListImpl<>();

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue().compareTo(b.getValue())
        );


        Node<Musica> musicaNode = this.musicas.getFirst();
        while (musicaNode != null) {
            if (musicaNode.getValue().getSnapshot_date().equals(fecha) &&
                    musicaNode.getValue().getCountry().equals(pais)) {
                String idCancion = musicaNode.getValue().getSpotify_id();
                conteoCanciones.put(idCancion, conteoCanciones.getOrDefault(idCancion, 0) + 1);
                musicaList.add(musicaNode.getValue());
            }
            musicaNode = musicaNode.getNext();
        }


        for (Map.Entry<String, Integer> entry : conteoCanciones.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > 10) {
                minHeap.poll();
            }
        }


        Stack<Map.Entry<String, Integer>> stack = new Stack<>();
        while (!minHeap.isEmpty()) {
            stack.push(minHeap.poll());
        }

        System.out.println("Las 10 canciones más populares son:");



        while (!stack.isEmpty()) {
            musicaNode = musicaList.getFirst();
            String id = stack.pop().getKey();
            while (musicaNode != null) {
                 if (musicaNode.getValue().getSpotify_id().equals(id)) {
                     System.out.println("Nombre: " + musicaNode.getValue().getName()
                             + " artistas: " + musicaNode.getValue().getArtists()
                             + " con la posicion: " + musicaNode.getValue().getDaily_rank() );
                 }
                musicaNode = musicaNode.getNext();
            }
        }



    }



}
