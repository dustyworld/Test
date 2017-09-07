package test.jim.xstream;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * To change this template use File | Settings | File Templates.
 */
public class test {
    
    public static void main(String[] args) {
        String res=toXML();
        toEntity(res);
    }
    
    public static void toEntity(String inputXML){
        XStream xs = new XStream(new DomDriver());
//        这句和@XStreamAlias("person")等效
//        xs.alias("person",Person.class);
//        xs.alias("address",Address.class);
        xs.setMode(XStream.NO_REFERENCES);
//      这句和@XStreamImplicit()等效
//        xs.addImplicitCollection(Person.class,"addresses");
//        这句和@XStreamAsAttribute()
//        xs.useAttributeFor(Person.class, "name");
        //注册使用了注解的VO
        xs.processAnnotations(new Class[]{Person.class,Address.class});
        Person person = (Person)xs.fromXML(inputXML);
        System.out.println(person.getAddresses().get(0).getHouseNo()+person.getName());
        


    }
    
    public static String toXML(){
        XStream xStream = new XStream();
        Person person = new Person();
        person.setName("Jim");
        person.setPhoneNuber(999);
        Address address1 = new Address();
        address1.setHouseNo(208);
        address1.setStreet("cq");
        Address address2 = new Address();
        address2.setHouseNo(2727);
        address2.setStreet("sh");
        person.getAddresses().add(address1);
        person.getAddresses().add(address2);
//        xStream.alias("person", Person.class);
//        xStream.alias("address",Address.class);
        xStream.setMode(XStream.NO_REFERENCES);
//        xStream.addImplicitCollection(Person.class, "addresses");
//        xStream.useAttributeFor(Person.class,"name");
        //注册使用了注解的VO
        xStream.processAnnotations(new Class[]{Person.class,Address.class});
        String xml = xStream.toXML(person);

        System.out.println(xml);
        return xml;
    }
}

