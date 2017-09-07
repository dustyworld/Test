package test.jim.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * To change this template use File | Settings | File Templates.
 */
//����Person����xml�еı���
@XStreamAlias("person")
public class Person {
    //��name����ΪXML person Ԫ�ص� attribute
    @XStreamAsAttribute()
    private String name;
    private int phoneNuber;
    //�����ֶ�����XML��ȥ��
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
