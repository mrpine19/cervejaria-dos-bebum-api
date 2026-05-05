package br.com.bebuns.dos.cervejaria.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "beer")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double alcoholContent;
    private String harmonization;

    @ManyToMany
    @JoinTable(
            name = "beer_brewery",
            joinColumns = @JoinColumn(name = "beer_id"),
            inverseJoinColumns = @JoinColumn(name = "brewery_id")
    )
    private List<Brewery> breweries;
}
