package com.ls.inkmaneger.InkManager.models;

import com.ls.inkmaneger.InkManager.models.embeddeds.WorkMaterialKey;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "workmaterial")
public class WorkMaterial implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private WorkMaterialKey id;

    @ManyToOne
    @MapsId("id_work")
    @JoinColumn(name = "id_work", nullable = false)
    private Work work;

    @ManyToOne
    @MapsId("id_material")
    @JoinColumn(name = "id_material", nullable = false)
    private Material material;

    @Column(name = "used_quantity", nullable = false)
    private Float usedQuantity;

}
