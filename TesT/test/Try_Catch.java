package TesT.test;

public class Try_Catch {
    public static int rtest() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }

    public static void main(String[] args) {
        int rtest = rtest();
        System.out.println(rtest);
    }

}

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

class Human {

    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
        } finally {
            System.out.println("Hello World!");
        }
    }
}
