package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String modelName;
    private String vendor;
    private long price;
    @ManyToMany
    private List<CarEntity> carsSupported;

    private PhoneEntity previousModel;
}
