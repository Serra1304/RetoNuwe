package com.hackathon.hackathon.model;

/**
 * Esta clase representa una obra de arte que puede ser subastada.
 * Extiende la clase {@link Item}.
 */
public class Art extends Item {
    private String artist;
    private int yearCreated;

    /**
     * Construye un nuevo objeto de tipo Art con los detalles especificados.
     * @param name El nombre de la obra de arte.
     * @param initialPrice El precio inicial de la obra de arte.
     * @param currentBidder El ofertante actual de la obra de arte.
     * @param type El tipo de la obra de arte.
     * @param artist El nombre del artista que creó la obra de arte.
     * @param yearCreated El año en que se creó la obra de arte.
     */
    public Art(String name, double initialPrice, Bidder currentBidder, String type, String artist, int yearCreated) {
        super(name, initialPrice, currentBidder,type);
        this.artist = artist;
        this.yearCreated = yearCreated;
    }

    /**
     * Obtiene el nombre del artista que creó la obra de arte.
     * @return El nombre del artista.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Establece el nombre del artista que creó la obra de arte.
     * @param artist El nombre del artista.
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Obtiene el año en que se creó la obra de arte.
     * @return El año en que se creó la obra de arte.
     */
    public int getYearCreated() {
        return yearCreated;
    }

    /**
     * Establece el año en que se creó la obra de arte.
     * @param yearCreated El año en que se creó la obra de arte.
     */
    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }
}
