/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /*
    * cascade temos alguns options:
    * ALL: Deletar todos os object relacionado quando deletar
    *
    * */
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;

    public UserEntity() {}

    public UserEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ON REMOVE SET NULL
//    @PreRemove
//    public void updateTaskOnDelete() {
//        System.out.println("PRE REMOVE");
//        for (TaskEntity task : this.tasks) {
//            task.setOwner(null);
//        }
//    }
}
