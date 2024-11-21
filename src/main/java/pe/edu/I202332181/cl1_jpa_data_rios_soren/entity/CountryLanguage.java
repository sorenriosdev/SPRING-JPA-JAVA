package pe.edu.I202332181.cl1_jpa_data_rios_soren.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @Id
    @Column(name = "language")
    private String name;

    @Id
    @Column(name = "countryCode")
    private String countryCode;

    @Column(name = "isOfficial")
    private String isOfficial;

    @Column(name = "percentage")
    private float percentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryCode", referencedColumnName = "code", insertable = false, updatable = false)
    private Country country;
}
