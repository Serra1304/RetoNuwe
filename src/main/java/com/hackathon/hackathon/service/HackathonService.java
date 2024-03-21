package com.hackathon.hackathon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hackathon.model.Bidder;
import com.hackathon.hackathon.model.Item;


/**
 * Para el desarrollo de la prueba:
 * 
 * (La lista de items ya viene inyectada en el servicio procedente del fichero MockDataConfig.java)
 * 
 * - Completa el cuerpo del método getItemsByType(String type) que recibiendo el parámetro type, devuelva una lista de ítems del tipo especificado.
 *
 * - Completa el cuerpo del método makeOffer(String itemName, double amount, Bidder bidder), que al recibir el nombre del ítem (itemName), la cantidad de la oferta (amount), y el postor que realiza la oferta (bidder).
 * 		Comprueba si el ítem especificado por itemName existe en la lista de ítems:
 * 		# Si el ítem no se encuentra, devuelve la constante ITEM_NOT_FOUND.
 * 		# Si el ítem se encuentra, compara la oferta (amount) con la oferta más alta actual del ítem (highestOffer).
 * 			# Si la oferta es mayor que la oferta más alta, actualiza la oferta más alta y el postor actual del ítem y devuelve la constante OFFER_ACCEPTED.
 * 			# Si la oferta es igual o menor que la oferta más alta, devuelve la constante OFFER_REJECTED.
 * 
 * - Completa el cuerpo del método getWinningBidder() que debe devolver un Map de los Items en los que se haya pujado (que existe un Bidder) y cuyo valor sea el nombre del Bidder que ha pujado.
 */

@Service
public class HackathonService {
	
	private static String ITEM_NOT_FOUND = "Item not found";
	private static String OFFER_ACCEPTED = "Offer accepted";
	private static String OFFER_REJECTED = "Offer rejected";

    private List<Item> items;

    @Autowired
    public HackathonService(List<Item> items) {
        this.items = items;
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }

    /**
     * Recupera elementos de un tipo específico.
     * @param type El tipo de elementos a recuperar.
     * @return Una lista de elementos del tipo especificado.
     */
    public List<Item> getItemsByType(String type) {
        List<Item> itemsByType = new ArrayList<>();

        for(Item item : items) {
            if(item.getType().equals(type)) {
                itemsByType.add(item);
            }
        }
        return itemsByType;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Permite a un ofertante hacer una oferta por un elemento específico.
     * @param itemName El nombre del elemento.
     * @param amount El monto de la oferta.
     * @param bidder El ofertante que realiza la oferta.
     * @return Una cadena que indica el resultado del intento de oferta.
     */
	public String makeOffer(String itemName, double amount, Bidder bidder) {

        for (Item item : items) {
            if(item.getName().equals(itemName)) {
                if(item.getHighestOffer() < amount) {
                    item.setName(bidder.getName());
                    item.setHighestOffer(amount);

                    return OFFER_ACCEPTED;
                }
                return OFFER_REJECTED;
            }
        }
        return ITEM_NOT_FOUND;
	}

    /**
     * Recupera un mapa que contiene los nombres de los elementos y los nombres de sus ofertantes ganadores.
     * @return Un mapa que contiene los nombres de los elementos como claves y los nombres de sus ofertantes ganadores como valores.
     */
	public Map<String, String> getWinningBidder() {
        Map<String, String> bidItems = new HashMap<>();

        for(Item item : items) {
            bidItems.put(item.getName(), item.getCurrentBidder().getName());
        }
        return bidItems;
    }
}
