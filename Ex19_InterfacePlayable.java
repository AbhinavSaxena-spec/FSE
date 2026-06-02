// Exercise 19: Interface Implementation
public class Ex19_InterfacePlayable {

    interface Playable {
        void play();
    }

    static class Guitar implements Playable {
        @Override
        public void play() {
            System.out.println("Strumming the guitar: twang twang!");
        }
    }

    static class Piano implements Playable {
        @Override
        public void play() {
            System.out.println("Playing the piano: plink plink!");
        }
    }

    public static void main(String[] args) {
        Playable g = new Guitar();
        Playable p = new Piano();

        g.play();
        p.play();
    }
}
