package com.ls.inkmaneger.InkManager.models.embeddeds;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class WorkMaterialKey implements Serializable {
    private Long id_work;
    private Long id_material;

}