package advjunittestingexercise;

public class ExceptionThrower {
	public void throwException() {
		throw new IllegalArgumentException("Throwed from "+this.getClass().getName());
	}
}