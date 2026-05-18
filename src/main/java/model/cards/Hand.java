package model.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import allShared.ICardsCollection;


/**
 * Objet qui contient l'ensemble des cartes de la main d'un joueur
 * 
 * Il est capable d'exécuter les traitements communs à toutes 
 * les collections de cartes (ajouter, supprimer, mélanger, trier, etc.)
 * et en plus révéler, cacher, jouer une carte
 * 
 * @author francoise.perrin
 */
public class Hand extends AbstractCardsCollection {

	public Hand() {
		super();
	}

	public Hand(Collection<Card> collection) {
		super(collection);
	}

	public Hand(ICardsCollection iCardsCollection) {
		super(iCardsCollection);
	}

	@Override
	public final void addCard(Card pc) {
		cards.add(pc);
	}

	@Override
	public final Card removeCard(int index) {
		if (index < 0 || index >= size()){
			return null;
		}
		Card card = cards.get(index);
		cards.remove(card);
		return card;
	}

	@Override
	public final boolean isEmpty() {
		boolean ret = false;

		if (size() == 0) {return true;}

		return ret;
	}

	@Override
	public final void clear() {
		cards.clear();
	}

	@Override
	public final int size() {
		int ret = cards.size();
		return ret;
	}

	@Override
	public String toString() {
		return "[" + cards + "]";
	}

	/**
	 * @param index
	 * @return la carte à jouer si elle existe
	 * Supprime la carte de la liste
	 */
	public final Card playCard(int index) {
		Card card = null;
		if (index < 0 || index >= cards.size()){
			card = null;
		}else {
			revealeCard(index);
			card = cards.get(index);
			removeCard(index);
		}
		return card;
	}

	/**
	 * @param index
	 * @return true si la carte existe 
	 */
	public final boolean revealeCard(int index) {

		Card card;

		if (index < 0 || index >= cards.size()){
			card = null;
		}else {
			card = cards.get(index);
			card.reveale();
		}
		return card != null ? true : false;
	}

	/**
	 * @param index
	 * @return true si la carte existe 
	 */
	public final boolean hideCard(int index) {


		Card card;

		if (index < 0 || index >= cards.size()){
			card = null;
		}else {
			card = cards.get(index);
			card.hide();
		}

		return card != null ? true : false;
	}


	/**
	 * Mélange les cartes de manière aléatoire
	 * 
	 * Ecrivez et testez cette méthode de 2 manières :
	 *  1 - en utilisant la méthode native shuffle() de la classe Collections
	 *  2 - en utilisant la méthode swap() et un nombre aléatoire (Random)  
	 */


	/*
	  * Illustration du Design Pattern Iterator
	  * et des classes anonymes
	  * 
	  * [ Cette partie du code sera utile à partir de l'atelier 2
	  * Ce n'est pas grave si vous ne la comprenez pas ...]
	  */
	 @Override
	 public final Iterator<Card> iterator() {

		 return new Iterator<Card>() {
			 Iterator<Card> it =  cards.iterator();
			 @Override
			 public boolean hasNext() {
				 return it.hasNext();
			 }

			 @Override
			 public Card next() {
				 return it.next();
			 }

		 };
	 }


}