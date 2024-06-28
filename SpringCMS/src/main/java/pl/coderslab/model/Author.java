package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank

    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String description) {
        this.lastName = description;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", description='" + lastName + '\'' +
                '}';
    }
}
