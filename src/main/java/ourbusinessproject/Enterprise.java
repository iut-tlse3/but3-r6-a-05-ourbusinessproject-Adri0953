package ourbusinessproject;
import jakarta.validation.constraints.*;

public class Enterprise {
    @NotBlank
    private String name;
    @Size(min = 10)
    private String description;
    @NotBlank
    private String contactName;
    @NotBlank @Email
    private String contactEmail;

    public Enterprise() {}

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


}

