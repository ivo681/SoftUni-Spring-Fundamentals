package exam.musicdb.model.binding;

import exam.musicdb.model.entity.Artist;
import exam.musicdb.model.entity.ArtistName;
import exam.musicdb.model.entity.Genre;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumBindingModel {
    private String name;
    private String imgUrl;
    private String description;
    private long copies;
    private BigDecimal price;
    private LocalDate releaseDate;
    private String producer;
    private Genre genre;
    private ArtistName artist;

    public AlbumBindingModel() {
    }

    @NotBlank(message = "Name cannot be empty string")
    @Length(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Image url cannot be empty string")
    @Length(min = 5, message = "Image url must be minimum 5 characters")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @NotBlank(message = "Description cannot be empty string")
    @Length(min = 5, message = "Description length must be minimum 5 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Copies cannot be empty")
    @Min(value = 10, message = "Copies must be more than 10")
    public long getCopies() {
        return copies;
    }

    public void setCopies(long copies) {
        this.copies = copies;
    }

    @NotNull(message = "Price cannot be empty")
    @DecimalMin(value = "0", message = "Price must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = "The release date cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "The release date cannot be in the future")
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

    @NotNull(message = "You must select a genre")
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @NotNull(message = "You must select an artist")
    public ArtistName getArtist() {
        return artist;
    }

    public void setArtist(ArtistName artist) {
        this.artist = artist;
    }
}
