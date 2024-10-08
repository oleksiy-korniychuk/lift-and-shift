package com.oleksiyk.lift_and_shift.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "day")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Integer getId() {
        return id;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
