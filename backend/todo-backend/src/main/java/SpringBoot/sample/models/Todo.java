package SpringBoot.sample.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    Long id;
    @NotBlank
    @NotNull
    String title;
    @NotBlank
    @NotNull
    String description;
    Boolean isCompleted;
    @Email
    String email;
}

