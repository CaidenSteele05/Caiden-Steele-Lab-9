import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
			}
		}
	}
	
	public int size() {
		return cards.size();
	}
	
	public Card draw() {
		return cards.isEmpty() ? null : cards.remove(0);
	}
	
	public List<Card> draw(int count){
		List<Card> list = new ArrayList<>();
		int lastIndex = count > cards.size() ? cards.size() : count;
		for(int i = 0; i < lastIndex; i++) {
			list.add(cards.remove(0));
		}
		return list;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public List<Card> getCardsByRank(Rank rank){
		List<Card> list = new ArrayList<>();
		for(int i = 0; i < cards.size(); i ++) {
			if(cards.get(i).getRank() == rank) {
				list.add(cards.get(i));
			}
		}
		return list;
	}
	
	public String toString() {
		return cards.toString();
	}
}
