package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pizza {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 55)
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "weight")
    private Integer weight;
}
