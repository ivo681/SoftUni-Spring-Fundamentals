package exam.musicdb.model.view;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {
    private String id;
    private String name;
    private String imgUrl;
    private String artist;
    private String genre;
    private BigDecimal price;
    private LocalDate releaseDate;
    private long copies;

    public AlbumViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public long getCopies() {
        return copies;
    }

    public void setCopies(long copies) {
        this.copies = copies;
    }
}
