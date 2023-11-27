package dataClasses;

import java.util.Objects;

public class Address {

    private String street = null;
    private String city = null;
    private int zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return getZip() == address.getZip() &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getCity(), address.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getCity(), getZip());
    }

}
