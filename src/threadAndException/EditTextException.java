package threadAndException;

public class EditTextException extends Exception {



    public EditTextException () {
        super("Inserimento non valido: ");
    }


    public String emptyEditText() {
        return getMessage() + "campo vuoto";
    }


    public String wrongDimension() {
        return getMessage() + "dimensione errata";
    }


    public String wrongAddress () {
        return getMessage()+ "caratteri indirizzo non accettati";
    }



    public String wrongID() {
        return getMessage() + "ID inesistente";
    }

    public String wrongData() {
        return getMessage() + "dati errati";
    }


}
