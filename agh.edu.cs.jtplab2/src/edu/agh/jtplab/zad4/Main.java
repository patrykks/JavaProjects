package edu.agh.jtplab.zad4;

import com.thoughtworks.xstream.XStream;

import edu.agh.jtplab.zad3.MyPojoObj;

public class Main {
	public static void main(String [] argv)
	{
		MyPojoObj obj1 = new MyPojoObj("cat",1);
		MyPojoObj obj2 = new MyPojoObj("dog",2);
		MyPojoObj des_obj1;
		MyPojoObj des_obj2;
		System.out.println("XSTREAM:Before serialization");
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		XStream xstream = new XStream();
        xstream.alias("MyPojoObj", MyPojoObj.class);
        String xml1 = xstream.toXML(obj1);
        String xml2 = xstream.toXML(obj2);
        xml1 = xml1.replace("cat","crocodile");
        xml2 = xml2.replace("dog","predator");
        des_obj1 = (MyPojoObj)xstream.fromXML(xml1);
        des_obj2 = (MyPojoObj)xstream.fromXML(xml2);
		System.out.println("XSTREAM:After serialization");
		System.out.println(des_obj1.toString());
		System.out.println(des_obj2.toString());
        
	}
}
