package exam.musicdb.model.service;

import exam.musicdb.model.entity.ArtistName;
import exam.musicdb.model.entity.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumServiceModel extends BaseService{
    private String name;
    private String imgUrl;
    private String description;
    private long copies;
    private BigDecimal price;
    private LocalDate releaseDate;
    private String producer;
    private Genre genre;
    private ArtistName artist;
    private UserServiceModel addedFrom;

    public AlbumServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCopies() {
        return copies;
    }

    public void setCopies(long copies) {
        this.copies = copies;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public ArtistName getArtist() {
        return artist;
    }

    public void setArtist(ArtistName artist) {
        this.artist = artist;
    }

    public UserServiceModel getAddedFrom() {
        return addedFrom;
    }

    public void setAddedFrom(UserServiceModel addedFrom) {
        this.addedFrom = addedFrom;
    }
}
