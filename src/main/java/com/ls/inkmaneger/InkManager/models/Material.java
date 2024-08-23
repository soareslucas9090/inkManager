package com.ls.inkmaneger.InkManager.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "material")
public class Material implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_generator")
    @SequenceGenerator(name = "material_generator", sequenceName = "public.material_id_material_seq", allocationSize = 1)
    private long material_id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 128)
    private String description;

    @Column(nullable = false)
    private float quantity;

    @Column(nullable = false, length = 256, name = "image_url")
    private String imageUrl;

    @Column(nullable = false, length = 16)
    private String unit;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="users.id_users", nullable = false)
    private Users user;

    @OneToMany(mappedBy = "material")
    private Set<WorkMaterial> workMaterials;

}
