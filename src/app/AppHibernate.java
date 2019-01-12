/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import entity.Seguro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author joshu
 */
public class AppHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op, IdSeguro, edad, numHijos;
        String nif, nombre, ape1, ape2;
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        Session session;
        Query query;
        List<Seguro> seguros;
        Scanner sc = new Scanner(System.in);
        Seguro seguro;
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
        do {
            menu();
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Añadir seguro a la BBDD");
                    System.out.println("Introduce los siguientes datos");
                    System.out.println("NIF:");
                    sc.nextLine();
                    nif = sc.nextLine();
                    System.out.println("Nombre:");
                    nombre = sc.nextLine();
                    System.out.println("Primer apellido:");
                    ape1 = sc.nextLine();
                    System.out.println("Segundo apellido:");
                    ape2 = sc.nextLine();
                    System.out.println("Edad:");
                    edad = sc.nextInt();
                    System.out.println("Nº de hijos:");
                    numHijos = sc.nextInt();
                    session = sessionFactory.openSession();
                    query = session.createQuery("SELECT s FROM Seguro s");
                    seguros = query.list();
                    seguro = new Seguro(seguros.size() + 1, nif, nombre, ape1, ape2, edad, numHijos);
                    session.beginTransaction();
                    session.save(seguro);
                    session.getTransaction().commit();
                    session.close();
                    break;
                case 2:
                    System.out.println("Seguros en la BBDD:");
                    session = sessionFactory.openSession();
                    query = session.createQuery("SELECT s FROM Seguro s");
                    seguros = query.list();
                    for (Seguro s : seguros) {
                        System.out.println("----------------------");
                        System.out.println(s.toString());
                        System.out.println("----------------------");
                    }
                    session.close();
                    break;
                case 3:
                    System.out.println("Actualizar seguro de la BBDD");
                    System.out.println("Introduce los siguientes datos");
                    System.out.println("ID del seguro:");
                    IdSeguro = sc.nextInt();
                    System.out.println("NIF:");
                    sc.nextLine();
                    nif = sc.nextLine();
                    System.out.println("Nombre:");
                    nombre = sc.nextLine();
                    System.out.println("Primer apellido:");
                    ape1 = sc.nextLine();
                    System.out.println("Segundo apellido:");
                    ape2 = sc.nextLine();
                    System.out.println("Edad:");
                    edad = sc.nextInt();
                    System.out.println("Nº de hijos:");
                    numHijos = sc.nextInt();
                    seguro = new Seguro(IdSeguro, nif, nombre, ape1, ape2, edad, numHijos);
                    session = sessionFactory.openSession();
                    session.beginTransaction();
                    session.update(seguro);
                    session.getTransaction().commit();
                    session.close();
                    break;
                case 4:
                    System.out.println("Borrar seguro de la BBDD");
                    System.out.println("Introduce el ID del seguro:");
                    IdSeguro = sc.nextInt();
                    seguro = new Seguro(IdSeguro);
                    session = sessionFactory.openSession();
                    session.beginTransaction();
                    session.delete(seguro);
                    session.getTransaction().commit();
                    session.close();
                    break;
                case 0:
                    System.out.println("Hasta luego! ^:D");
                    break;
                default:
                    System.out.println("Opción incorrecta...");
                    break;
            }
        } while (op != 0);
        sessionFactory.close();
    }

    public static void menu() {
        System.out.println("-- Introduce una opción --");
        System.out.println("1.- Insertar seguro");
        System.out.println("2.- Leer seguros");
        System.out.println("3.- Actualizar seguro");
        System.out.println("4.- Borrar seguro");
    }

}
