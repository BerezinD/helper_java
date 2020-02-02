package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phone")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "model")
    private String modelName;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "price")
    private long price;

    public PhoneEntity() {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<CarEntity> getCarsSupported() {
        return carsSupported;
    }

    public void setCarsSupported(List<CarEntity> carsSupported) {
        this.carsSupported = carsSupported;
    }

    public PhoneEntity getPreviousModel() {
        return previousModel;
    }

    public void setPreviousModel(PhoneEntity previousModel) {
        this.previousModel = previousModel;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "phone_car", joinColumns={@JoinColumn(referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
    private List<CarEntity> carsSupported;

    private PhoneEntity previousModel;
}
