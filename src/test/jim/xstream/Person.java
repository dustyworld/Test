package test.jim.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * To change this template use File | Settings | File Templates.
 */
//设置Person类在xml中的别名
@XStreamAlias("person")
public class Person {
    //将name设置为XML person 元素的 attribute
    @XStreamAsAttribute()
    private String name;
    private int phoneNuber;
    //将此字段名在XML中去掉
   // @XStreamImplicit()
    private List<Address> addresses = new ArrayList<Address>();

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNuber() {
        return phoneNuber;
    }

    public void setPhoneNuber(int phoneNuber) {
        this.phoneNuber = phoneNuber;
    }


}
