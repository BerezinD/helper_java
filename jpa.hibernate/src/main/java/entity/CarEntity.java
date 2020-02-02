package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String modelName;
    private String vendor;
    private boolean isElectric;
    private long price;
    @ManyToMany
    private List<PhoneEntity> telephoneSupported;
}
