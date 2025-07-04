package com.example.usermanagement.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email format is invalid")
    private String email;

//   private String role;

    //New : Create Timestamp
    @Column(name="created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    //New : Update TimeStamp
    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User() {
    }



    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
//        this.role = role;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

//    public String getRole() { return role; }
//    public void setRole(String role) { this.role = role; }
}
