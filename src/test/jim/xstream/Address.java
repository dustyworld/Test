package test.jim.xstream;


import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("address")
public class Address {
    private String street;
    private int houseNo;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }
}

