package src.uy.edu.um.clases;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import src.uy.edu.um.tad.linkedlist.MyLinkedListImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Musica {

    private String spotify_id;
    private String name;
    //private String artists;

    // deberia de ser una lista los artistas
    private List<String> artists;

    private Integer daily_rank;
    //private String daily_movement;
    //private String weekly_movement;
    private String country;
    //private String snapshot_date;
    private Integer popularity;
    //private String is_explicit;
    //private String duration_ms;
    private String album_name;
    private String album_release_date;
    //private String danceability;
    //private String energy;
    //private String key;
    //private String loudness;
    //private String mode;
    //private String speechiness;
    //private String acousticness;
    //private String instrumentalness;
    //private String liveness;
    //private String valence;
    private Float tempo;
    //private String time_signature;




}
