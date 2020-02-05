package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import daoImpl.AngajatDao;
import daoImpl.DepartamentDao;
import daoImpl.FurnizorDao;
import helper.DatabaseHelper;
import model.Angajat;
import model.Departament;
import model.Furnizor;

public class Main {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		DatabaseHelper dh = DatabaseHelper.getInstance();
		System.out.println();
		System.out.println("1. Angajat 2.Departament 3.Furnizor");
		int option = sc.nextInt();
		while (option != 0) {
			switch (option) {

			case 0:
				System.out.println("1. Angajat 2.Departament 3.Furnizor");
				break;
			case 1:

				System.out.println("1.Save 2.Read 3.Delete");
				AngajatDao daoA = new AngajatDao(dh);

				int option1 = sc.nextInt();

				switch (option1) {
				case 1:
					Angajat newA = new Angajat();
					System.out.println();
					System.out.println("A new employee joined the hospital team! His id:");
					newA.setIdAngajat(sc.nextInt());
					System.out.println("His name is:");
					newA.setNumeAngajat(sc.next());
					System.out.println("And he's :");
					newA.setVarstaAngajat(sc.nextInt());
					System.out.println("years old With function: ");
					newA.setFunctieAngajat(sc.next());

					daoA.create(newA);
					System.out.println("Employee has been Successfully Saved!");
					break;
				case 2:
					System.out.println("Employee List:");
					List<Angajat> angj = daoA.getAll();
					for (Angajat s : angj) {
						System.out.println(s.getIdAngajat() + " " + s.getNumeAngajat() + "  " + s.getVarstaAngajat()
								+ " " + s.getFunctieAngajat());
					}
					break;
				case 3:
					System.out.println("Select which id will be deleted");
					int idD = sc.nextInt();
					List<Angajat> angjat = daoA.getAll();
					for (Angajat s : angjat) {
						if (s.getIdAngajat() == idD) {
							daoA.delete(s);
						}
					}
					System.out.println("Your Employee has been Successfully Deleted!");
					break;
				default:
					System.out.println("Invalid input");
					option1 = sc.nextInt();
					break;
				}
				System.out.println();
				System.out.println("1. Angajat 2.Departament 3.Furnizor");
				option = sc.nextInt();
				break;

			case 2:

				System.out.println("1.Save 2.Read 3.Delete");
				DepartamentDao daoD = new DepartamentDao(dh);

				option1 = sc.nextInt();

				switch (option1) {
				case 1:
					Departament newD = new Departament();
					System.out.println();
					System.out.println("A new department was constructed. His id:");
					newD.setIdDepartament(sc.nextInt());
					System.out.println("His name is:");
					newD.setNumeDepartament(sc.next());
					System.out.println("His capacity is:");
					newD.setCapacitateDepartament(sc.nextInt());
					System.out.println("His location is at *floor*: ");
					newD.setEtajDepartament(sc.next());
					System.out.println("and his actual capacity *for instruments* :");
					newD.setNumarAparate(sc.nextInt());

					daoD.create(newD);
					System.out.println("Department has been Successfully Saved!");
					break;
				case 2:
					System.out.println("Department list:");
					List<Departament> dep = daoD.getAll();
					for (Departament d : dep) {
						System.out.println(d.getIdDepartament() + " " + d.getNumeDepartament() + " "
								+ d.getCapacitateDepartament());
					}
					break;
				case 3:
					System.out.println("Select which id will be deleted");
					int idD = sc.nextInt();
					List<Departament> depart = daoD.getAll();
					for (Departament d : depart) {
						if (d.getIdDepartament() == idD) {
							daoD.delete(d);
						}
					}
					System.out.println("Department has been Successfully Deleted!");
					break;
				default:
					System.out.println("Invalid input");
					option1 = sc.nextInt();
					break;
				}
				System.out.println();
				System.out.println("1. Angajat 2.Departament 3.Furnizor");
				option = sc.nextInt();
				break;

			case 3:

				System.out.println("1.Save 2.Read 3.Delete");
				FurnizorDao daoF = new FurnizorDao(dh);

				option1 = sc.nextInt();

				switch (option1) {
				case 1:
					Furnizor newF = new Furnizor();
					System.out.println();
					System.out.println("A new provider was confirmed. His id:");
					newF.setIdFurnizor(sc.nextInt());
					System.out.println("His name is:");
					newF.setNumeFurnizor(sc.next());
					System.out.println("His address is:");
					newF.setAdresaFurnizor(sc.next());
					System.out.println("And his number is: ");
					newF.setNrTelefonFurnizor(sc.next());

					daoF.create(newF);
					System.out.println("Provider has been Successfully Saved!");
					break;
				case 2:
					System.out.println("Provider List:");
					List<Furnizor> prov = daoF.getAll();
					for (Furnizor f : prov) {
						System.out.println(f.getIdFurnizor() + " " + f.getNumeFurnizor() + " " + f.getAdresaFurnizor()
								+ " " + f.getNrTelefonFurnizor());
					}
					break;
				case 3:
					System.out.println("Select which id will be deleted");
					int idD = sc.nextInt();
					List<Furnizor> provider = daoF.getAll();
					for (Furnizor f : provider) {
						if (f.getIdFurnizor() == idD) {
							daoF.delete(f);
						}
					}
					System.out.println("Provider has been Successfully Deleted!");
					break;
				default:
					System.out.println("Invalid input");
					option1 = sc.nextInt();
					break;
				}
				System.out.println();
				System.out.println("1. Angajat 2.Departament 3.Furnizor");
				option = sc.nextInt();
				break;
			}
		}

		/*
		 * Scanner sc = new Scanner(System.in); DatabaseHelper dh =
		 * DatabaseHelper.getInstance(); AngajatDao daoA = new AngajatDao(dh); int
		 * employeeCounter = 5, departmentCounter = 0, providerCounter = 0;
		 * 
		 * // Angajat newA = new Angajat(2,"chirurg","Popa Ion",30);
		 * 
		 * Angajat newA = new Angajat(); System.out.println();
		 * System.out.println("A new employee joined the hospital team!");
		 * newA.setIdAngajat(employeeCounter); employeeCounter = employeeCounter + 1;
		 * System.out.println("His name is:"); newA.setNumeAngajat(sc.nextLine());
		 * System.out.println("With function:"); newA.setFunctieAngajat(sc.nextLine());
		 * System.out.println("And he's :"); newA.setVarstaAngajat(sc.nextInt());
		 * System.out.println("years old.");
		 * 
		 * daoA.create(newA);
		 * 
		 * List<Angajat> angj = daoA.getAll();
		 * 
		 * System.out.println("Select which id will be deleted"); int idD =
		 * sc.nextInt();
		 * 
		 * for (Angajat s : angj) { if(s.getIdAngajat()==idD) { daoA.delete(s); } }
		 * 
		 * System.out.println();
		 * 
		 * for (Angajat s : angj) { System.out.println(s.getIdAngajat() + " " +
		 * s.getNumeAngajat() + "  " + s.getVarstaAngajat() + " " +
		 * s.getFunctieAngajat()); }
		 * 
		 * System.out.println();
		 * 
		 * DepartamentDao daoD = new DepartamentDao(dh); List<Departament> dep =
		 * daoD.getAll(); for (Departament d : dep) {
		 * System.out.println(d.getIdDepartament() + " " + d.getNumeDepartament() + " "
		 * + d.getEtajDepartament() + " " + d.getNumarAparate() + " " +
		 * d.getCapacitateDepartament()); }
		 * 
		 * System.out.println();
		 * 
		 * FurnizorDao daoF = new FurnizorDao(dh); List<Furnizor> furn = daoF.getAll();
		 * for (Furnizor f : furn) { System.out.println(f.getIdFurnizor() + " " +
		 * f.getNumeFurnizor() + " " + f.getAdresaFurnizor() + " " +
		 * f.getNrTelefonFurnizor()); }
		 */

	}

}
