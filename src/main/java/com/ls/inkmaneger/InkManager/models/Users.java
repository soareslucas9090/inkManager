package com.ls.inkmaneger.InkManager.models;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="users")
public class Users implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "public.users_id_users_seq", allocationSize = 1)
    private long users_id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 128)
    private String email;

    @Column(nullable = false, length = 128)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Work> works;

    @OneToMany(mappedBy = "user")
    private Set<Material> materials;

    @OneToMany(mappedBy = "user")
    private Set<WorkType> workTypes;
}
