class IndeksertListe <E> extends Lenkeliste<E> {

    public void leggTil (int pos, E x) {

        if (pos == 0) {

            E[] nyLenkeliste = (E[]) new Comparable[lenkeliste.length+1];
            for (int i = 0; i<lenkeliste.length; i++) {
                nyLenkeliste[i+1] = lenkeliste[i];
            }
            lenkeliste = nyLenkeliste;
            lenkeliste[0] = x;

        } else if (pos == lenkeliste.length) {

            E[] nyLenkeliste = (E[]) new Comparable[lenkeliste.length+1];
            for (int i = 0; i<lenkeliste.length; i++) {
                nyLenkeliste[i] = lenkeliste[i];
            }
            lenkeliste = nyLenkeliste;
            lenkeliste[lenkeliste.length-1] = x;

        } else if (0 <= pos && pos <=lenkeliste.length) {

            E[] nyLenkeliste = (E[]) new Comparable[lenkeliste.length+1];
            int teller = 0;
            while (teller < nyLenkeliste.length) {
                if (teller < pos) {
                    nyLenkeliste[teller] = lenkeliste[teller];
                } else if (teller == pos) {
                    nyLenkeliste[pos] = x;
                } else {
                    nyLenkeliste[teller] = lenkeliste[teller-1];
                }
                teller += 1;
            }
            lenkeliste = nyLenkeliste;

        } else {

            throw new UgyldigListeindeks(pos);

        }

    }

    public void sett(int pos, E x) {

        if (0 <= pos && pos <= lenkeliste.length-1) {

            lenkeliste[pos] = x;

        } else {

            throw new UgyldigListeindeks(-1);

        }

    }
    public E hent (int pos) {

        if (0 <= pos && pos <= lenkeliste.length-1) {

            return lenkeliste[pos];

        } else {

            throw new UgyldigListeindeks(-1);

        }

    }
    public E fjern (int pos) {

        if (pos == 0) {

            E[] nyLenkeliste = (E[]) new Comparable[lenkeliste.length-1];
            for (int i = 0; i<nyLenkeliste.length; i++) {
                nyLenkeliste[i] = lenkeliste[i+1];
            }
            E fjernetElement = lenkeliste[pos];
            lenkeliste = nyLenkeliste;
            return fjernetElement;

        } else if (pos == lenkeliste.length-1) {

            E[] nyLenkeliste = (E[]) new Comparable[lenkeliste.length-1];
            for (int i = 0; i<nyLenkeliste.length; i++) {
                nyLenkeliste[i] = lenkeliste[i];
            }
            E fjernetElement = lenkeliste[pos];
            lenkeliste = nyLenkeliste;
            return fjernetElement;

        } else if (0 <= pos && pos <= lenkeliste.length-1) {

            E[] nyLenkeliste = (E[]) new Comparable[lenkeliste.length-1];
            int teller = 0;
            while (teller < nyLenkeliste.length) {
                if (teller < pos) {
                    nyLenkeliste[teller] = lenkeliste[teller];
                } else if (pos < teller) {
                    nyLenkeliste[teller] = lenkeliste[teller+1];
                }
                teller += 1;
            }
            E fjernetElement = lenkeliste[pos];
            lenkeliste = nyLenkeliste;
            return fjernetElement;

        } else {

            throw new UgyldigListeindeks(pos);

        }

    }
}
