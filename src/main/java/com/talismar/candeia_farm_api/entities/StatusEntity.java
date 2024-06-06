/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "status")
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name="status_task", joinColumns = @JoinColumn(name="status_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Set<TaskEntity> tasks;

    public StatusEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StatusEntity() {}

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
}
