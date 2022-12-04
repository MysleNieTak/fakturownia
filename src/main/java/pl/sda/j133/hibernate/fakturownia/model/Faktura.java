package pl.sda.j133.hibernate.fakturownia.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Faktura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate dataWystawienia;

    private String numerFaktury;
    private LocalDate terminPlatnosci;
    private Double kwota;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Firma firma;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Kontrahent kontrahent;

    @OneToMany (mappedBy = "faktura")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Platnosc> platnosci;
}
