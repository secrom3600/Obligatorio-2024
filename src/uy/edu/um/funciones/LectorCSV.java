package src.uy.edu.um.funciones;

import src.uy.edu.um.clases.Musica;
import src.uy.edu.um.tad.linkedlist.MyLinkedListImpl;
import src.uy.edu.um.tad.linkedlist.MyList;
import src.uy.edu.um.tad.linkedlist.Node;
import src.uy.edu.um.util.FileUtil;

import java.util.*;

public class LectorCSV {

    public MyList<Musica> musicas = new MyLinkedListImpl<>();

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
                        .tempo(Float.parseFloat(data[23].replace("\"", "")))
                        //.time_signature(data[24])
                        .build();

                musicas.add(unConductor);



            }
            catch (Exception e)
            {

            }
        }
    }

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

        // Agregar los conteos al Min-Heap y mantener solo las 5 canciones más populares
        for (Map.Entry<String, Integer> entry : conteoCanciones.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > 5) {
                minHeap.poll();
            }
        }

        // Obtener las 5 canciones más populares desde el Min-Heap
        List<String> top5CancionesIds = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            top5CancionesIds.add(minHeap.poll().getKey());
        }

        // Imprimir los nombres de las 5 canciones más populares
        System.out.println("Las 5 canciones más populares son:");
        for (String id : top5CancionesIds) {
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



}
