public class Stabel<E> extends Lenkeliste<E> {
    @Override
    public void leggTil(E x) {
        // Lager en ny kopi av "lenkelist" med en til plass og legger til den nye elementet på første plass.
        E[] nyLenkeliste = (E[]) new Comparable[lenkeliste.length+1];
        for (int i = 0; i<lenkeliste.length; i++) {
            nyLenkeliste[i+1] = lenkeliste[i];
        }
        lenkeliste = nyLenkeliste;
        lenkeliste[0] = x;
    }
}
