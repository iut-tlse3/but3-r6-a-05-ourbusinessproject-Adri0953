package ourbusinessproject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @Size(min = 10)
    private String description;

    @NotBlank
    private String contactName;

    @NotBlank @Email
    private String contactEmail;

    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;

    public Enterprise() {}

    public Long getId() {
        return this.id;
    }

    /**
     * Set the name
     * @param name .
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the description
     * @param description .
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the contact name
     * @param contactName .
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * Set the contact Email
     * @param contactEmail .
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     *
     * @return la liste des projets de l'entreprise
     */
    @JsonIgnore
    public Collection<Project> getProjects() {
        return projects;
    }

    /**
     * Add a project to the collection of projects
     * @param project
     */
    public void addProject(Project project) {
        if (this.projects == null) {
            this.projects = new HashSet<>();
        }
        projects.add(project);
    }

    public String getName() {
        return this.name;
    }
}

