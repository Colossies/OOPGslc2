package gslc2;

public class victoryComment extends DungeonComment{
	public void comment() {
		System.out.println("You won against the enemy!");
	}
	victoryComment(int gold) {
		comment();
		super.displayScore(gold);
	}
}
