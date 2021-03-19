package exam.musicdb.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{
    private ArtistName name;
    private String careerInformation;

    public Artist() {
    }

    public Artist(ArtistName name, String careerInformation) {
        this.name = name;
        this.careerInformation = careerInformation;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    public ArtistName getName() {
        return name;
    }

    public void setName(ArtistName name) {
        this.name = name;
    }

    @Column(name = "career_information", columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
