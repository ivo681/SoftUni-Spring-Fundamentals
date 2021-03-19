package exam.musicdb.service;

import exam.musicdb.model.entity.Artist;
import exam.musicdb.model.entity.ArtistName;

public interface ArtistService {

    void initArtists();

    Artist findByArtistName(ArtistName artistName);
}
