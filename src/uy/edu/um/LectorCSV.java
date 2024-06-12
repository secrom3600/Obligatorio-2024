package src.uy.edu.um;

import src.uy.edu.um.clases.Musica;
import src.uy.edu.um.tad.linkedlist.MyLinkedListImpl;
import src.uy.edu.um.tad.linkedlist.MyList;
import src.uy.edu.um.tad.linkedlist.Node;
import src.uy.edu.um.util.FileUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectorCSV {

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
                        //.snapshot_date(data[7].replace("\"", ""))
                        .popularity(Integer.parseInt(data[8].replace("\"", "")))
                        //.is_explicit(data[9])
                        //.duration_ms(data[10])
                        .album_name(data[11].replace("\"", ""))
                        .album_release_date(LocalDate.parse(data[12].replace("\"", "")))
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
            System.out.println(musicaNode.getValue().getAlbum_release_date());
            musicaNode = musicaNode.getNext();


        }
    }
}
