package org.spring.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;


@Entity
@XmlRootElement(name = "alien")
@Table(schema = "public", name = "ALIEN")
public class Alien {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "alive")
    private boolean alive;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "race_id")
    private Race race;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alien alien = (Alien) o;
        return id == alien.id &&
                alive == alien.alive &&
                fullName.equals(alien.fullName) &&
                race.equals(alien.race);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, alive, race);
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", alive=" + alive +
                ", race=" + race.toString() +
                '}';
    }
}
