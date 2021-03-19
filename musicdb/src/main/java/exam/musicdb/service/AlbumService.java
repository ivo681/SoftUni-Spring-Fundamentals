package exam.musicdb.service;

import exam.musicdb.model.service.AlbumServiceModel;
import exam.musicdb.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    AlbumServiceModel saveAlbum(AlbumServiceModel albumServiceModel);

    List<AlbumViewModel> findAllAlbums();

    Long totalSoldCopies();

    void deleteAlbum(String id);
}
