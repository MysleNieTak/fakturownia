package pl.sda.j133.hibernate.fakturownia.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Kontrahent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;
    private String nip;
    private String adres;

    @OneToMany(mappedBy = "kontrahent")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Faktura> faktury;
}
