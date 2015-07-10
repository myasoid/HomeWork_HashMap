package com.gmail.miv.translator;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static final String FILE_PATH = "./src/" + Main.class.getPackage().getName().replace(".", "/") + "/English.in";

    public static Vocabulary vocabulary = new Vocabulary();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        unmarshal();

        while (true) {

            int option = getOption();

            switch (option) {

                case 1:

                    sc.nextLine();
                    System.out.print(" en: ");
                    String key = sc.nextLine();
                    System.out.print(" ua: ");
                    String value = sc.nextLine();

                    vocabulary.put(key, value);

                    break;

                case 2:

                    sc.nextLine();
                    System.out.print(" input en: ");
                    String input = sc.nextLine();
                    System.out.println(" output ua: " + vocabulary.translate(input));

                    break;

                default:
                    break;
            }

            if (option == 3) {
                break;
            }

        }

        marshal();

    }

    private static int getOption() {

        System.out.println("1 - add word to vocabulary; 2 - translate; 3 - quit");

        int option = sc.nextInt();

        return option;

    }

    public static void marshal() {

        try {

            File file = new File(FILE_PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(Vocabulary.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(vocabulary, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void unmarshal() {

        try {
            File file = new File(FILE_PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(Vocabulary.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            vocabulary = (Vocabulary) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
