package com.ls.inkmaneger.InkManager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "worktype")
public class WorkType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "worktype_generator")
    @SequenceGenerator(name = "worktype_generator", sequenceName = "public.worktype_id_worktype_seq", allocationSize = 1)
    private long id_worktype;

    @Column(nullable = false, length = 128)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="users.id_users", nullable = false)
    private Users user;

    @Column(name="deleted_at")
    private LocalDate deletedAt;
}
