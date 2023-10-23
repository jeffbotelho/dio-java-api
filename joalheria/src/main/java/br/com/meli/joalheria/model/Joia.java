package joalheria.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Joia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numIdentificacao;

    @Enumerated(EnumType.STRING)
    private Catalogo material;

    private Double peso;
    private Double quilates;
}
