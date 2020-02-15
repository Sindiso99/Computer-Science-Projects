/**
 * Class used to test the Rotation class
 * @author Sindiso
 * 
 */
public class RotationMain {

	public static void main(String[] args) {
		System.out.println("'Hello World' with rotation 13:");
		Rotation test1 = new Rotation("Hello World", 13);
		System.out.println(test1.getNewWord());
		
		System.out.println("'The Number 16' with rotation 13:");
		Rotation test2 = new Rotation("The Number 16", 13);
		System.out.println(test2.getNewWord());
		
		System.out.println("'Hello World!' with rotation 19");
		Rotation test3 = new Rotation("Hello World!", 19);
		System.out.println(test3.getNewWord());

	}

}
