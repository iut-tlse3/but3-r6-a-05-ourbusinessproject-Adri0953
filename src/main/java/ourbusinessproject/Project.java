package ourbusinessproject;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Project {
    @NotEmpty
    @NotNull
    private String title;
    private String description;

    public Project () {}

    public void setTitle(String title) {
            this.title = title;
    }

    public void setDescription(String description) {
            this.description = description;
    }
}
