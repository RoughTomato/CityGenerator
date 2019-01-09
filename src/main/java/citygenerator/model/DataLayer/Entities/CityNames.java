package citygenerator.model.DataLayer.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CityNames {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    protected CityNames() {}

    public CityNames(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("CityNames[id=%d, name=%s]",id,name);
    }
}
