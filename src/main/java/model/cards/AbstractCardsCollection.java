package model.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import allShared.ICardsCollection;

/**
 * Classe qui décrit les attributs et méthodes commun(e)s à toutes les Collections de cartes
 * elle implémente l'interface Iterable pour être parcourue par un Iterator [Design pattern]
 * 
 * Elle s'appuie sur les méthodes de sa Collection enveloppée (ici List)  
 * enrichies des méthodes shuffle(), max() et iterator()
 * [On peut la voir comme un adapter de List - Design Pattern]
 * 
 * [Question du Carnet de Bord : qu'est-ce qui justifie l'existence de cette classe ?
 * La réponse n'est pas "... factoriser le code commun à ses classes dérivées" 
 * (même si cette phrase est néanmoins vraie ;-)) ]
 * 
 * @author francoise.perrin
 */
public abstract class AbstractCardsCollection implements ICardsCollection, Iterable<Card> {

	protected List<Card> cards;

    public AbstractCardsCollection() {
        this.cards = new ArrayList<>();
    }

    public AbstractCardsCollection(Collection<Card> collection) {
        this.cards = new ArrayList<>(collection);
    }

    public AbstractCardsCollection(ICardsCollection iCardsCollection) {
		this( ( (AbstractCardsCollection) iCardsCollection).cards); // ?
	}

    @Override
    public final void shuffle(){
        Collections.shuffle(cards);
    }

    @Override
    public final void sort(){
        Collections.sort(cards);
    }

    @Override
    public final void sort(Comparator<Card> comparator){
        cards.sort(comparator);
    }

    @Override
    public final Card max(Comparator<Card> comparator){
        return Collections.max(cards, comparator);
    }

    @Override
    public final Card max(){
        return Collections.max(cards);
    }

    @Override
    public final Card removeTopCard() {

        if (cards.isEmpty() ){
            return null;
        }
        return cards.remove(0);
    }
}
