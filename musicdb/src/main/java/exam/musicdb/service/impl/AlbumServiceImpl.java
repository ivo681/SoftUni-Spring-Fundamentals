package exam.musicdb.service.impl;

import exam.musicdb.model.entity.Album;
import exam.musicdb.model.service.AlbumServiceModel;
import exam.musicdb.model.view.AlbumViewModel;
import exam.musicdb.repository.AlbumRepository;
import exam.musicdb.service.AlbumService;
import exam.musicdb.service.ArtistService;
import exam.musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final UserService userService;
    private final ArtistService artistService;
    private final ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, UserService userService, ArtistService artistService, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.userService = userService;
        this.artistService = artistService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AlbumServiceModel saveAlbum(AlbumServiceModel albumServiceModel) {
        Album album = this.modelMapper.map(albumServiceModel, Album.class);
        album.setArtist(this.artistService.findByArtistName(albumServiceModel.getArtist()));
        album.setAddedFrom(this.userService.setUserToAlbum(albumServiceModel.getAddedFrom().getUsername()));
        return this.modelMapper.map(this.albumRepository.save(album), AlbumServiceModel.class);
    }

    @Override
    public List<AlbumViewModel> findAllAlbums() {
        List<AlbumViewModel> albumViewModels = this.albumRepository.getAllAlbumsSorted().stream().map(album -> {
            AlbumViewModel albumViewModel = this.modelMapper.map(
                            album, AlbumViewModel.class);
            albumViewModel.setArtist(album.getArtist().getName().name());
            return albumViewModel;
                }
        ).collect(Collectors.toList());
        return albumViewModels;
    }

    @Override
    public Long totalSoldCopies() {
        return this.albumRepository.getAllSoldCopies();
    }

    @Override
    public void deleteAlbum(String id) {
        this.albumRepository.deleteById(id);
    }
}
