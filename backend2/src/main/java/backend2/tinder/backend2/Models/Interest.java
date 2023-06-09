package backend2.tinder.backend2.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity(name = "Interest")
@Table(name = "interest")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotBlank(message = "name cannot be blank")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_interest", 
        joinColumns = @JoinColumn(name = "interest_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private List<Users> users = new ArrayList<>();

    public Interest( String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Interest [id=" + id + ", name=" + name + "]";
    }

    
}
