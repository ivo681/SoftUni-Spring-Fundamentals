package exam.musicdb.init;

import exam.musicdb.service.ArtistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    private final ArtistService artistService;

    public DataInit(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.artistService.initArtists();
    }
}
