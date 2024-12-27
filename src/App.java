import java.util.Scanner;
import java.util.regex.Pattern;

import Entities.Producto;
import Entities.User;
import Entities.Utiles;

public class App {

    public static void menu(User user) {
        int opc = 0;
        System.out.println("- BIENVENIDO A LA PLATAFORMA DE DONACIONES -" +
                "\t\nCompleta el registro para comenzar:");

        // llamo al metodo que pide el mail y la contraseña y hace las comprobaciones
        // necesarias
        pedirMail(user);
        pedirPass(user);

        do {
            System.out.println("- MENU PRINCIPAL"
                    + "\n1. Donar dinero."
                    + "\n2. Donar productos."
                    + "\n3. Salir"
                    + "\nElige una opción:");

            opc = pedirInt();

            switch (opc) {
                case 1:
                    donarDinero(user);
                    break;
                case 2:
                    donarProductos(user.getProd());
                    break;
                case 3:
                    System.out.println("¡Gracias por participar!");
                    System.out.println("Tu donación es de: " + user.getDineroDonado());
                    System.out.println("Estos son los detalles de tu donación:"
                            + "\nEntrega de:" + user.getEmail() + ":"
                            + "\n\t" + user.getProd().toString());
                    break;
                default:
                    System.out.println("Introduzca un valor correcto");
                    break;
            }
        } while (opc != 3);

    }

    public static void pedirMail(User user) {
        int cont = 4;
        String mail = "";

        // Bucle para pedir el mail 5 veces.
        for (int i = 0; i < 5; i++) {
            System.out.println("Email:");
            mail = getString();

            // Si lo que inserto no contiene @iesvjp.es entro y hago lo del if
            if (!mail.contains("@iesvjp.es")) {
                System.out.println("Email incorrecto. Por favor, vuelva a intentarlo.\n" + cont + " intentos.");
                cont--;
            } else {
                // Igualo a 5 para que salga del bucle
                i = 5;
            }

            // Si pasa de los intentos muestro mensaje
            if (i == 4) {
                System.out.println("No se ha podido completar el inicio de sesión. Cerrando aplicación...");
                break;
            }

            // Como es correcto, le asigno al usuario el mail
            if (i == 5) {
                user.setEmail(mail);
                System.out.println("Email correcto");
            }
        }
    }

    public static void pedirPass(User user) {
        int cont = 4;
        String pass = "";
        int suma = 0;

        // Bucle para pedir la contraseña 5 veces.
        for (int i = 0; i < 5; i++) {
            System.out.println("Contraseña:");
            pass = getString();

            // Verifica que tenga al menos 8 caracteres
            if (pass.length() < 8) {
                System.out.println("La contraseña debe tener al menos 8 caracteres.");
                cont--;
            } else {
                suma++;
            }

            // Verifica que tenga al menos una letra mayúscula
            if (!Pattern.compile("[A-Z]").matcher(pass).find()) {
                System.out.println("La contraseña debe tener al menos una letra mayúscula.");
                cont--;
            } else {
                suma++;
            }

            // Verifica que tenga al menos una letra minúscula
            if (!Pattern.compile("[a-z]").matcher(pass).find()) {
                System.out.println("La contraseña debe tener al menos una letra minúscula.");
                cont--;
            } else {
                suma++;
            }

            // Verifica que tenga al menos un número
            if (!Pattern.compile("[0-9]").matcher(pass).find()) {
                System.out.println("La contraseña debe tener al menos un número.");
                cont--;
            } else {
                suma++;
            }

            // Verifica que tenga al menos un carácter especial
            if (!Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(pass).find()) {
                System.out.println("La contraseña debe tener al menos un carácter especial.");
                cont--;
            } else {
                suma++;
            }

            System.out.println(cont + " intentos.");

            // Como es correcto, le asigno al usuario el pass
            if (suma == 5) {
                user.setPassword(pass);
                System.out.println("Contraseña correcta");
                i = 5;
            }
        }

    }

    public static void donarDinero(User user) {
        int opc;
        int dinero = user.getDineroDonado();
        do {
            System.out.println("- Donaciones -"
                    + "\n1. 1€."
                    + "\n2. 20€"
                    + "\n3. 50€"
                    + "\n4. Otra cantidad."
                    + "\n5. Volver atrás");
            opc = pedirInt();

            switch (opc) {
                case 1:
                    dinero += 1;
                    System.out.println("¡Gracias! Con tu donación podemos comprar 1L de leche");
                    break;
                case 2:
                    dinero += 20;
                    System.out.println("¡Gracias! Con tu donación podemos alimentar a una familia por un día");
                    break;
                case 3:
                    dinero += 50;
                    System.out.println("¡Gracias! Con tu donación podemos alimentar a una familia por una semana");
                    break;
                case 4:
                    System.out.println("Introduce una cantidad:");
                    dinero += pedirInt();
                    break;
                case 5:
                    System.out.println("¡Gracias por donar!");
                    user.setDineroDonado(dinero);
                    break;

                default:
                    System.out.println("Introduzca un valor correcto.");
                    break;
            }
        } while (opc != 5);

    }

    public static void donarProductos(Producto prod) {
        int opc;
        System.out.print("¿Qué producto quieres donar?");
        prod.setProducto(getString());
        System.out.print("Introduce una hora de entrega:");
        prod.setHora(pedirInt());

        if (prod.getHora() == 9) {
            do {
                System.out.println("- Puntos de entrega disponibles en tu horario -"
                        + "\n1. " + Utiles.AVDA_PLASENCIA);
                System.out.print("Elige un punto de entrega:");
                opc = pedirInt();
                if (opc == 1) {
                    System.out.println("¡Gracias! Tu donación se ha procesado correctamente.");
                    prod.setPuntoEntrega(Utiles.AVDA_PLASENCIA);
                } else {
                    System.out.println("Introduzca una opción correcta.");
                }
            } while (opc != 1);
        }

        if (prod.getHora() > 9 && prod.getHora() < 15) {
            do {
                System.out.println("- Puntos de entrega disponibles en tu horario -"
                        + "\n1. Avda Plasencia, 20. CP: 10600. Horario: 9 - 14"
                        + "\n2. Avda Salamanca, 3. CP: 10600. Horario: 10 - 14");
                opc = pedirInt();

                switch (opc) {
                    case 1:
                        System.out.println("¡Gracias! Tu donación se ha procesado correctamente.");
                        prod.setPuntoEntrega(Utiles.AVDA_PLASENCIA);
                        break;
                    case 2:
                        System.out.println("¡Gracias! Tu donación se ha procesado correctamente.");
                        prod.setPuntoEntrega(Utiles.AVDA_SALAMANCA);
                        break;
                    default:
                        System.out.println("Introduzca una opción correcta.");
                        break;
                }
            } while (opc != 1 && opc != 2);
        }

        if (prod.getHora() > 14) {
            do {
                System.out.println("- Puntos de entrega disponibles en tu horario -"
                        + "\n1. " + Utiles.AVDA_CACERES);
                System.out.print("Elige un punto de entrega:");
                opc = pedirInt();
                if (opc == 1) {
                    System.out.println("¡Gracias! Tu donación se ha procesado correctamente.");
                    prod.setPuntoEntrega(Utiles.AVDA_CACERES);
                } else {
                    System.out.println("Introduzca una opción correcta.");
                }
            } while (opc != 1);
        }

    }

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int pedirInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        menu(user);
    }
}
