package model.cards;

import allShared.ICard;

import java.util.Objects;

/**
 * Cette classe peut être vue comme un Proxy ou un Adapter [Design Pattern] de la classe Card
 * Ses instances sont utilisées par la View qui
 * n'a accès qu'aux "Getters" de l'objet encapsulé
 * 
 * Cette classe restreint donc le nombre de fonctionnalités existantes de l'objet enveloppé
 * et lui délègue le soin de réaliser les traitements
 * 
 * @author francoise.perrin
 */
public class CardRender implements ICard, Comparable<CardRender> {
	private final Card card;
	
	public CardRender(Card card) {
		super();
		this.card = card;
	}

	@Override
	public final Rank getRank() {
		Rank ret = card.getRank();
		return ret;
	}

	@Override
	public final Suit getSuit() {
		Suit ret = card.getSuit();
		return ret;
	}
	
	@Override
	public final boolean isRevealed() {
		boolean ret = card.isRevealed();
		return ret;
	}
	
	@Override
	public int compareTo(CardRender o) {
		int ret = card.compareTo(o.card);
		return ret;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		CardRender that = (CardRender) o;
		return Objects.equals(card, that.card);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(card);
	}

	@Override
	public String toString() {
		String ret = card.toString();
		return ret;
	}
}

