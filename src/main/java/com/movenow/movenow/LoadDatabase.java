package com.movenow.movenow;

import com.movenow.movenow.domain.MoveUser;
import com.movenow.movenow.domain.MoveUsersRepository;
import com.movenow.movenow.domain.User;
import com.movenow.movenow.domain.UserRepository;
import com.movenow.movenow.domain.move.Move;
import com.movenow.movenow.domain.move.MoveRepository;
import com.movenow.movenow.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

@Configuration
public class LoadDatabase
{
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository,
            MoveRepository moveRepository,
            FileStorageService fileStorageService,
            MoveUsersRepository moveUsersRepository)
    {

        return args -> {
            userRepository.save(new User("Dominik", "M", "dominik"));
            userRepository.save(new User("Matthias", "W", "matthias"));
            userRepository.save(new User("Thomas", "B", "thomas"));
            userRepository.save(new User("Patrick", "S", "patrick"));
            userRepository.save(new User("Jean", "S", "jean"));
            userRepository.save(new User("Karim", "A", "karim"));

            var video = fileStorageService.store("23e9V8YB8wQ");

            moveRepository.save(new Move("Spontane Volleyball Mitspieler gesucht",
                    "Sind zu 2. und suchen Mitspieler",
                    Date.from(Instant.parse("2021-07-11T20:00:00Z")),
                    Date.from(Instant.parse("2021-07-11T21:00:00Z")),
                    47.504041D,
                    9.731780D,
                    12L,
                    GetRandomNumber(1L, 3L),
                    1L,
                    video.getId()));
            
            moveRepository.save(new Move("HobbyKick Bregenz",
                    "Tschutta in Neu Amerika",
                    Date.from(Instant.parse("2021-07-10T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-10T18:00:00Z")),
                    47.503406D,
                    9.711289D,
                    10L,
                    GetRandomNumber(1L, 3L),
                    1L,
                    null));

            moveRepository.save(new Move("Tennis am Mittag",
                    "Bewegung in der Mittagspause",
                    Date.from(Instant.parse("2021-07-13T12:00:00Z")),
                    Date.from(Instant.parse("2021-07-13T13:00:00Z")),
                    47.505227D,
                    9.728391D,
                    21L,
                    GetRandomNumber(1L, 3L),
                    1L,
                    null));

            moveRepository.save(new Move("HuddleUp Main Event ",
                    "",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.30708461233331,
                    9.644373449062941,
                    1L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Vorarlberg International Badminton Championships 2021",
                    "Gr????tes Badminton Turnier Vorarlbergs.",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.26177893700077,
                    9.613741232361356,
                    2L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("All-Star Game Series",
                    "",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.21631825137593,
                    9.631705634109322,
                    3L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("K??rbe, K??rbe, K??rbe Nachwuchstraining",
                    "Gro??er Nachwuchs gesucht",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.14806504966838,
                    9.8074923608507,
                    4L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Schnuppertraining f??r Anf??nger",
                    "Einfach vorbei kommen",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.255008229953226,
                    9.594718253053069,
                    5L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Leichtgewicht Sparring Partner gesucht!",
                    "",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.20338131206267,
                    9.647245460277741,
                    6L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Dart am Nachmittag",
                    "",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.26701600856421,
                    9.631763757095731,
                    7L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Eishockey Gr??mpel Turnier",
                    "4 Spieler Kleinfeld",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.181919641041816,
                    9.703971522959092,
                    8L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Rocket League Mitspieler gesucht",
                    "F??r t??glichen Grind und viele Tore",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.40980943886363,
                    9.76521380211019,
                    9L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Hobby Kick Mannschafft sucht neuen Messi",
                    "Jede Woche 1 Training + 1 Match",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.465869431770656,
                    9.90198822525022,
                    10L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Landesmeisterschaften Golf Qualifikation",
                    "Jeder kann mitmachen",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.35077208271478,
                    9.883551877676414,
                    11L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Waldlaufweg 48",
                    "Gem??tliches Tempo",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.354974422945176,
                    9.948286194685103,
                    12L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Auf und Ab / Passtour",
                    "Ca. 1000 H??henmeter",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.14866947825357,
                    9.806092771827391,
                    13L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Skipper gesucht - Bodensee",
                    "2 Personen Brigg Kapit??n sucht Skipper",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.49764431823677,
                    9.682848954473613,
                    14L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Partner verletzt - Spontane Mitspieler/innen gesucht",
                    "",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.41084840289788,
                    9.662350615842861,
                    15L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Pensionistenausflug Skigebiet",
                    "Nur begrenzt Pl??tze",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.484558731167695,
                    9.688161390371821,
                    16L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Powdern - wer kommt mit?",
                    "",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.14250303501762,
                    9.832013552558047,
                    17L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Raserturnier - Mitspieler gesucht",
                    "",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.29814849368846,
                    9.654156935171038,
                    18L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Nachwuchs Turner gesucht",
                    "F??r Wettkampf und Kunstturnen",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.401541640171324,
                    9.746494236289745,
                    19L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Tanzpartner f??r Klassischen Tanz gesucht",
                    "",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.30583502071338,
                    9.646692542565427,
                    20L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("3er Gruppe sucht 4. Spieler ",
                    "Platz jede Woche reserviert",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.42081178022948,
                    9.758381972661645,
                    21L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Beachvolleyball-Duo sucht Gegener",
                    "",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.41538691994165,
                    9.721612927604376,
                    22L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Selbstverteidigungskurs f??r M??nner",
                    "Verschiedenste Abwehrtechniken lernen",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.483250919544744,
                    9.683738046605532,
                    23L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Yoga Summit - der elegante Klassiker",
                    "Erste Einheit gratis und ohne Voranmeldung",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.377022828576386,
                    9.694243488050468,
                    24L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));
            moveRepository.save(new Move("Zumba! Zumba! Dance with us",
                    "Einstieg jederzeit m??glich",
                    Date.from(Instant.parse("2021-07-12T16:00:00Z")),
                    Date.from(Instant.parse("2021-07-12T17:00:00Z")),
                    47.506413048351135,
                    9.728800861224594,
                    25L,
                    GetRandomNumber(1L, 3L),
                    GetRandomNumber(1L, 6L),
                    null));

            var moves = moveRepository.findAll();
            var users = userRepository.findAll();

            for (var move : moves) {
                for (int i = 0; i < GetRandomNumber(1L, Long.valueOf(users.size())); i++) {
                    var mover = new MoveUser();

                    mover.setMoveId(move.getId());
                    mover.setUserId(users.get(i).getId());

                    moveUsersRepository.save(mover);
                }
            }
        };
    }

    private Long GetRandomNumber(Long minValue, Long maxValue)
    {
        var random = new Random();
        var number = random.nextInt((int) (maxValue - minValue + 1));

        return Long.valueOf(number + minValue);
    }
}


