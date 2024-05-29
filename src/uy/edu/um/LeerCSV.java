package uy.edu.um.prog2.adt;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.Entities.HashTag;
import uy.edu.um.prog2.adt.Entities.Tweet;
import uy.edu.um.prog2.adt.Entities.User;
import uy.edu.um.prog2.adt.TADs.ListaEnlazada.Lista;
import uy.edu.um.prog2.adt.TADs.ListaEnlazada.ListaEnlazada;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;

public class LeerCSV {

    private Lista<User> users = new ListaEnlazada<>();
    private Lista<HashTag> hashTags = new ListaEnlazada<>();
    private Lista<Tweet> tweets = new ListaEnlazada<>();

    private HashMap<Long, Boolean> nombresUsers = new HashMap<>();

    public Lista<User> getUsers() {
        return users;
    }

    public void setUsers(Lista<User> users) {
        this.users = users;
    }

    public Lista<HashTag> getHashTags() {
        return hashTags;
    }

    public void setHashTags(Lista<HashTag> hashTags) {
        this.hashTags = hashTags;
    }

    public Lista<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Lista<Tweet> tweets) {
        this.tweets = tweets;
    }

    public void leerCSV(String ruta) throws IOException {


        String SAMPLE_CSV_FILE_PATH = ruta;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

        ) {
            for (CSVRecord csvRecord : csvParser) {
                if (csvRecord.getRecordNumber() == 1) {
                    continue;
                }
                // Accedemos a los valores del archivo CSV
                Long id = Long.parseLong(csvRecord.get(0));
                String userName = csvRecord.get(1);
                Integer userFavourites = 0;
                boolean userVerified = Boolean.parseBoolean(csvRecord.get(8));
                String text = csvRecord.get(10).toLowerCase();
                String hashtagValues = csvRecord.get(11).replaceAll("[\\[\\]]", "").replaceAll("'", "").toLowerCase();
                String[] hashtags = hashtagValues.split(",");
                String source = csvRecord.get(12);
                boolean isRetweet = Boolean.parseBoolean(csvRecord.get(13));
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate fecha = null;
                String date = csvRecord.get(9);
                String[] dateParts = date.split(" ");
                String tweetDateDay = dateParts[0];
                if (isValidDate(tweetDateDay, formatoFecha)) {
                    fecha = LocalDate.parse(tweetDateDay, formatoFecha);
                }
                if (isValidFloat(csvRecord.get(7))) {
                    userFavourites = Math.round(Float.parseFloat(csvRecord.get(7)));
                }
                User user = new User(id, userName, userFavourites, userVerified);

                Tweet tweet = new Tweet(id, text, fecha, isRetweet, source);
                tweets.add(tweet);

                for (int i = 0; i < hashtags.length; i++) {
                    HashTag hashTag = new HashTag(id, hashtags[i], fecha);
                    tweet.getHashTagLista().add(hashTag);
                    hashTags.add(hashTag);

                }
                if (nombresUsers.get(id) == null) {
                    user.getTweetsList().add(tweet);
                    users.add(user);
                    nombresUsers.put(id, true);

                } else {
                    users.getNodo(user).getTweetsList().add(tweet);
                }



            }
        }


    }

    private static boolean isValidDate(String date, DateTimeFormatter format) {
        try {
            LocalDate.parse(date, format);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    private static boolean isValidFloat(String number) {
        try {
            Float.parseFloat(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
