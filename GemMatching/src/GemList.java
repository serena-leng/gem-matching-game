public class GemList 
{
	private Node head;
	private int size;
	
	private class Node {
		private Gem gem;
		private Node next;
		
		public Node(Gem gem) { this.gem = gem; next = null; }
		
		@Override
		public String toString() { return this.gem.toString(); }
	}
	
	public GemList() {
		head = null;
		size = 0;
	}
	
	public int size() { return size; }
	
	public void draw(double y) {
		if (size == 0) { return; }
		int index = 0;
		Node current = head;
		while (current != null) {
			current.gem.draw(GemGame.indexToX(index), y);
			current = current.next;
			index++;
		}
	}
	
	@Override
	public String toString() {
		String result = "";
		Node current = head;
		if (current == null) {
			return "";
		}
		while (current != null && current.next != null) {
			if (current.gem.getType() == GemType.GREEN) { result += "GREEN -> ";}
			if (current.gem.getType() == GemType.BLUE) { result += "BLUE -> "; }
			if (current.gem.getType() == GemType.ORANGE) { result += "ORANGE -> ";} 
			current = current.next;
		}
		if (current.gem.getType() == GemType.GREEN) { result += "GREEN";}
		if (current.gem.getType() == GemType.BLUE) { result += "BLUE"; }
		if (current.gem.getType() == GemType.ORANGE) { result += "ORANGE";}
		return result;
	}
	
	public void insertBefore(Gem gem, int index) {
		int ind = 0;
		Node add = new Node(gem);
		if (head == null) {
			head = add;
		}
		if (index == 0) {
			add.next = head;
			head = add;
			size++;
			return;
		}
		if (index >= size) {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = add;
			add.next = null;
			size++;
			return;
		}
		Node current = head;
		while (ind < index - 1) {
			current = current.next;
			ind++;
		}
		add.next = current.next;
		current.next = add;
		size++;
	}
	
	public int score() {
		//calculate the total score of the list
		if (head == null) {
			return 0;
		}
		int block = 1;
		GemType currentType = head.gem.getType();
		int scoreTot = 0;
		int scoreTemp = head.gem.getPoints();
		Node current = head.next;
		while (current != null) {
			if (currentType == current.gem.getType()) {
				block++;
				scoreTemp += current.gem.getPoints();
			} else {
				scoreTot += block * scoreTemp;
				block = 1;
				scoreTemp = current.gem.getPoints();
				currentType = current.gem.getType();
			}
			current = current.next;
		}
		scoreTot += block * scoreTemp;
		return scoreTot;
	}
	
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}	
}
