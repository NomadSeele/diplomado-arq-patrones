import java.util.ArrayList;

import model.Directory;
import model.Element;
import model.File;

public class Main {
	public static void main(String[] args) {
		System.out.println("****************************************");
		System.out.println("******         PROBLEMA 4         ******");
		System.out.println("****************************************");
		/*
		  d-DIR_01
		  d---DIR_0101
		  f-----F_010101
		  f-----F_010102
		  f-----F_010103
		  d---DIR_0102
		  f-----F_010201
		  d---DIR_0103
		  d-----DIR_010301
		  f-------F_01030101
		  f-------F_01030102
		  f-----F_010301
		  f-----F_010302
		  f---F_0101
		  f---F_0102
		  f---F_0103
		*/
		
			ArrayList<Element> arrayListDIR_0101 = new ArrayList<Element>();
			arrayListDIR_0101.add(new File("F_010101", 4567));
			arrayListDIR_0101.add(new File("F_010102", 67));
			arrayListDIR_0101.add(new File("F_010103", 345));
		  Directory dDIR_0101 = new Directory("DIR_0101", arrayListDIR_0101);
			ArrayList<Element> arrayListDIR_0102 = new ArrayList<Element>();
			arrayListDIR_0102.add(new File("F_010201", 6545));
		  Directory dDIR_0102 = new Directory("DIR_0102", arrayListDIR_0102);  
			  ArrayList<Element> arrayListDIR_010301 = new ArrayList<Element>();
			  arrayListDIR_010301.add(new File("F_01030101", 1234));
			  arrayListDIR_010301.add(new File("F_01030102", 2314));
			Directory dDIR_010301 = new Directory("DIR_010301", arrayListDIR_010301);
			ArrayList<Element> arrayListDIR_0103 = new ArrayList<Element>();
			arrayListDIR_0103.add(dDIR_010301);
			arrayListDIR_0103.add(new File("F_010301", 234));
		    arrayListDIR_0103.add(new File("F_010302", 567));
		  Directory dDIR_0103 = new Directory("DIR_0103", arrayListDIR_0103);
		  ArrayList<Element> arrayListDIR_01 = new ArrayList<Element>();
		  arrayListDIR_01.add(dDIR_0101);
		  arrayListDIR_01.add(dDIR_0102);
		  arrayListDIR_01.add(dDIR_0103);
		  arrayListDIR_01.add(new File("F_0101", 346));
		  arrayListDIR_01.add(new File("F_0102", 5686));
		  arrayListDIR_01.add(new File("F_0103", 87));
		Directory dDIR_01 = new Directory("DIR_01", arrayListDIR_01);
		
		System.out.println("* TAMAÑO CARPETA = "+dDIR_01.getWeight());
		System.out.println("****************************************");
		System.out.println("* JERARQUIA ANTES DE BORRADO = ");
		System.out.println(dDIR_01.printHierarchy(""));
		System.out.println("****************************************");
		System.out.println("* BORRAR ELEMENTO = "+dDIR_01.deleteElement("F_0101"));
		System.out.println("****************************************");
		System.out.println("* JERARQUIA DESPUES DE BORRADO = ");
		System.out.println(dDIR_01.printHierarchy(""));
		System.out.println("****************************************");
		System.out.println("* BORRAR ELEMENTO = "+dDIR_01.deleteElement("DIR_0103"));
		System.out.println("****************************************");
		System.out.println("* JERARQUIA DESPUES DE BORRADO = ");
		System.out.println(dDIR_01.printHierarchy(""));
		System.out.println("****************************************");
		System.out.println("* RENOMBRAR ELEMENTO = ");
		dDIR_01.renameElement("DIR_0102","DIRECTORIO_0102");
		System.out.println("****************************************");
		System.out.println("* JERARQUIA DESPUES DE RENOMBRADO = ");
		System.out.println(dDIR_01.printHierarchy(""));
		System.out.println("****************************************");
		System.out.println("* MOVER ELEMENTO = "+dDIR_01.moveElement("DIRECTORIO_0102","DIR_0101"));
		System.out.println("****************************************");
		System.out.println("* JERARQUIA DESPUES DE MOVER = ");
		System.out.println(dDIR_01.printHierarchy(""));
		System.out.println("****************************************");
		System.out.println("* MOVER ELEMENTO = "+dDIR_01.moveElement("F_0102","DIR_0101"));
		System.out.println("****************************************");
		System.out.println("* JERARQUIA DESPUES DE MOVER = ");
		System.out.println(dDIR_01.printHierarchy(""));
		System.out.println("****************************************");
		    
	}
}
