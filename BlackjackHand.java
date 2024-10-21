import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
	private static Map<Rank, Integer> CARD_VALUES = setupCardValues();
	private static int MAX_VALUE = 21;
	private List<Card> cards = new ArrayList<>();
	private int value = 0;
	private int numAcesAs11 = 0;
	
	public BlackjackHand(Card c1, Card c2) {
		addCard(c1);
		addCard(c2);
	}
	
	public static Map<Rank, Integer> setupCardValues() {
		Map<Rank, Integer> values = new HashMap<>();
		int counter = 1;
		for(Rank rank : Rank.values()) {
			counter++;
			int val = counter <= 10 ? counter : 10;
			val = counter == 14 ? 11 : val;
			values.put(rank, val);
		}
		return values;
	}
	
	public void addCard(Card card) throws NullPointerException{
		if(card == null) {
			throw new NullPointerException();
		}
		if(value < MAX_VALUE) {
			cards.add(card);
			if(CARD_VALUES.get(card.getRank()) == 11) {
				numAcesAs11++;
			}
			value += CARD_VALUES.get(card.getRank());
		}
	}
	
	public int size() {
		return cards.size();
	}
	
	public static Map<Rank, Integer> getCardValues(){
		Map<Rank, Integer> copy = new HashMap<>();
		copy.putAll(CARD_VALUES);
		return copy;
	}
	
	public List<Card> getCards(){
		List<Card> copy = new ArrayList<>();
		copy.addAll(cards);
		return copy;
	}
	
	public int getValue() {
		while(value > MAX_VALUE && numAcesAs11 > 0) {
			numAcesAs11--;
			value -= 10;
		}
		return value;
	}
	
	public String toString() {
		return cards.toString();
	}
}
