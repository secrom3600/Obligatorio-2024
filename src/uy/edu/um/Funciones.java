package src.uy.edu.um;

import src.uy.edu.um.clases.Musica;
import src.uy.edu.um.tad.linkedlist.MyLinkedListImpl;
import src.uy.edu.um.tad.linkedlist.MyList;
import src.uy.edu.um.tad.linkedlist.Node;
import src.uy.edu.um.util.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                List<String> artistsList = new ArrayList<>(Arrays.asList(data[2].split(",")));
                Musica unConductor = Musica.builder()
                        .spotify_id(data[0])
                        .name(data[1])
                        .artists(artistsList)
                        .daily_rank(data[3])
                        .daily_movement(data[4])
                        .weekly_movement(data[5])
                        .country(data[6])
                        .snapshot_date(data[7])
                        .popularity(data[8])
                        .is_explicit(data[9])
                        .duration_ms(data[10])
                        .album_name(data[11])
                        .album_release_date(data[12])
                        .danceability(data[13])
                        .energy(data[14])
                        .key(data[15])
                        .loudness(data[16])
                        .mode(data[17])
                        .speechiness(data[18])
                        .acousticness(data[19])
                        .instrumentalness(data[20])
                        .liveness(data[21])
                        .valence(data[22])
                        .tempo(data[23])
                        .time_signature(data[24])
                        .build();


                musicas.add(unConductor);
            }
            catch (Exception e)
            {

            }
        }
    }

    public void listarTodasLasMusicas()
    {

        Node<Musica> musicaNode = this.musicas.getFirst();
        while(musicaNode!= null) {
            System.out.println(musicaNode.getValue().getArtists());
            musicaNode = musicaNode.getNext();


        }
    }
}
