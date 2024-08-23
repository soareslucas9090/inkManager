package com.ls.inkmaneger.InkManager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "work")
public class Work implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_generator")
    @SequenceGenerator(name = "work_generator", sequenceName = "public.work_id_work_seq", allocationSize = 1)
    private long id_work;

    @Column(nullable = false, length = 128, name = "client_name")
    private String clientName;

    @Column(nullable = false, length = 256)
    private String description;

    @Column(nullable = false, name = "scheduled_date")
    private LocalDate scheduledDate;

    @Column(nullable = false, name = "completed_date")
    private LocalDate completedDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="users.id_users", nullable = false)
    private Users user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="worktype.id_worktype", nullable = false)
    private WorkType workType;

}
