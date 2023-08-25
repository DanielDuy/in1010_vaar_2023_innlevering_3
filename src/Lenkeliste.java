abstract class Lenkeliste <E> implements Liste<E> {

    public E[] lenkeliste = (E[]) new Comparable[0];

    @Override
    public int stoerrelse() {
        return lenkeliste.length;
    }

    @Override
    public void leggTil(E x) {
        // Lager en ny kopi av "lenkelist" med en til plass og legger til den nye elementet.
        E[] nyLenkeliste = (E[]) new Comparable[lenkeliste.length+1];
        for (int i = 0; i<lenkeliste.length; i++) {
            nyLenkeliste[i] = lenkeliste[i];
        }
        lenkeliste = nyLenkeliste;
        lenkeliste[lenkeliste.length-1] = x;
    }

    @Override
    public E hent() {
        return lenkeliste[0];
    }

    @Override
    public E fjern() {
        if (lenkeliste.length == 0) {

            throw new UgyldigListeindeks(-1);

        } else if (lenkeliste.length == 1) {

            // Lager en tom Array og erstatter Array-et med den tomme Array-et.
            E[] nyLenkeliste = (E[]) new Comparable[0];
            E fjernetElement = lenkeliste[0];
            lenkeliste = nyLenkeliste;
            return fjernetElement;

        } else {

            // Lager en ny kopi av "lenkelist" med en mindre plass, fjerner det første elementet og flytter alle elementer en plass til venstre.
            E[] nyLenkeliste = (E[]) new Comparable[lenkeliste.length-1];
            for (int i = 0; i < lenkeliste.length-1; i++) {
                nyLenkeliste[i] = lenkeliste[i+1];
            }
            E fjernetElement = lenkeliste[0];
            lenkeliste = nyLenkeliste;
            return fjernetElement;
        }
    }

    @Override
    public String toString() {
        String utStreng = "[";
        if (lenkeliste.length != 0) {
            for (int i = 0; i<lenkeliste.length; i++) {
                utStreng += lenkeliste[i];
                if (i+1 != lenkeliste.length) {
                    utStreng += ", ";
                }
            }
        }
        utStreng += "]";
        return utStreng;
    }
}