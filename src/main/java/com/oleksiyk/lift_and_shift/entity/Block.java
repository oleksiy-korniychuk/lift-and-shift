package com.oleksiyk.lift_and_shift.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "block")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @Column(name = "block_number")
    private Integer blockNumber;

    @Column(name = "description")
    private String description;

    public Integer getId() {
        return id;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgramId(Program program) {
        this.program = program;
    }

    public Integer getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
