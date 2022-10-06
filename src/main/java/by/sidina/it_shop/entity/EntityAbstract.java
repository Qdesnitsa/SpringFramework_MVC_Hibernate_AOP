package by.sidina.it_shop.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class EntityAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public EntityAbstract() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
}
