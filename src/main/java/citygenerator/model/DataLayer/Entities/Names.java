package citygenerator.model.DataLayer.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* TODO: Add premade training data in sql format for quick filling of the database */

@Entity
public class Names {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private NameTypes type;

    protected Names() { }

    public Names(String name, NameTypes type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public NameTypes getType() {
        return this.type;
    }

    public void setType(NameTypes type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
}

