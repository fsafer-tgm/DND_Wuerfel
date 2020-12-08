package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;
/**
 * Interface, welches die Methoden rollTheDice und getSites ermöglicht.
 * @author Florian Safer
 * @version 2020-11-25
 */
public interface Dices {
    /**
     * Diese Methode soll zum würfeln mit beliebig vielen Würfelseiten verwendet werden
     * @return Das Ergebnis des Würfelns
     */
    String getInformation();

    /**
     * Diese Methode wird verwendet, um die Anzahl an Würfelseiten zurückzugeben
     * @return Anzahl der Würfelseiten
     */
    int getErgebnis();
}
