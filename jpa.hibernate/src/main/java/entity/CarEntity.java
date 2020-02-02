package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "model")
    private String modelName;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "electric")
    private boolean isElectric;

    @Column(name = "price")
    private long price;

    @ManyToMany(mappedBy = "carsSupported")
    private List<PhoneEntity> telephoneSupported;

    public CarEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<PhoneEntity> getTelephoneSupported() {
        return telephoneSupported;
    }

    public void setTelephoneSupported(List<PhoneEntity> telephoneSupported) {
        this.telephoneSupported = telephoneSupported;
    }
}
