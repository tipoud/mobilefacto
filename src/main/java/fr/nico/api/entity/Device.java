package fr.nico.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "device")
public class Device {
    
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    
    @Column(name = "customname")
    private String customName;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "marque")
    private String marque;
    
    @Column(name = "os")
    private String os;
    
    @Column(name = "image")
    private String image;
    
    @Column(name = "dimension")
    private String dimension;
    
    @Column(name="type", columnDefinition = "Decimal(2,0) default '1'")
    @NotNull
    private Integer type;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "developer_id")
    private Developer developer;

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String Marque) {
        this.marque = Marque;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String Os) {
        this.os = Os;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


    
}
