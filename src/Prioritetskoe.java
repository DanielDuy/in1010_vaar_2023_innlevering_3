class Prioritetskoe <E extends  Comparable<E>> extends Lenkeliste<E>{

    @Override
    public void leggTil(E x) {
        // Lager en ny kopi av "lenkelist" med en til plass og legger til den nye elementet.
        E[] nyLenkeliste = (E[]) new Comparable[lenkeliste.length + 1];
        for (int i = 0; i < lenkeliste.length; i++) {
            nyLenkeliste[i] = lenkeliste[i];
        }
        lenkeliste = nyLenkeliste;
        lenkeliste[lenkeliste.length - 1] = x;

        // Sorterer det nye elementet på riktig plass.
        for (int i = lenkeliste.length - 2; i >= 0; i--) {
            if (x.compareTo(lenkeliste[i]) < 0) {
                E temp = lenkeliste[i];
                lenkeliste[i] = x;
                lenkeliste[i + 1] = temp;
            }
        }
    }
}