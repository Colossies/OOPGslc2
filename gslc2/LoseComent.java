package gslc2;

public class LoseComent extends DungeonComment{
	public void comment() {
		System.out.println("You Died");
	}
	LoseComent(int gold) {
		comment();
		super.displayScore(gold);
	}
}
