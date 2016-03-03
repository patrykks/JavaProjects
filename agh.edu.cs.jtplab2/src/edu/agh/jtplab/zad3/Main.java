package edu.agh.jtplab.zad3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String [] argv)
	{
		MyPojoObj obj1 = new MyPojoObj("cat",1);
		MyPojoObj obj2 = new MyPojoObj("dog",2);
		MyPojoObj des_obj1;
		MyPojoObj des_obj2;
		System.out.println("Before serialization");
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
	     try
	      {
	         FileOutputStream fileOut = new FileOutputStream("./SerializedObjects/obj1.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(obj1);
	         out.close();
	         fileOut.close();
	         fileOut = new FileOutputStream("./SerializedObjects/obj2.ser");
	         out = new ObjectOutputStream(fileOut);
	         out.writeObject(obj2);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in ./SerializedObjectsr");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	     // Desrialize 
	     try
	      {
	         FileInputStream fileIn = new FileInputStream("./SerializedObjects/obj1.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         des_obj1 = (MyPojoObj) in.readObject();
	         in.close();
	         fileIn.close();
	         fileIn = new FileInputStream("./SerializedObjects/obj2.ser");
	         in = new ObjectInputStream(fileIn);
	         des_obj2 = (MyPojoObj) in.readObject();
	         System.out.println("Desrialized data operation ends with success");
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
			System.out.println("After serialization");
			System.out.println(des_obj1.toString());
			System.out.println(des_obj2.toString());
	     
	}
}
