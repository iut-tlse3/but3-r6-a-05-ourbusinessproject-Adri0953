package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty @NotNull
    private String title;
    private String description;

    @NotNull
    @ManyToOne
    private Enterprise enterprise;

    public Project () {}

    public Long getId() {
        return this.id;
    }
    /**
     * Set the title
     * @param title
     */
    public void setTitle(String title) {
            this.title = title;
    }

    /**
     * Set the description
     * @param description
     */
    public void setDescription(String description) {
            this.description = description;
    }

    /**
     * Set the entreprise
     * @param enterprise
     */
    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    /**
     *
     * @return the enterprise of the project
     */
    public Enterprise getEnterprise() {
        return this.enterprise;
    }

    /**
     *
     * @return the title of the project
     */
    public String getTitle() {
        return this.title;
    }
}
