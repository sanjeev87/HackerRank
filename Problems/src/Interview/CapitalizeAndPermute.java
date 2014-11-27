package Interview;

public class CapitalizeAndPermute {

	StringBuilder out;
	String input;
	
	public CapitalizeAndPermute(String input){
		
		this.input = input;
		out = new StringBuilder();
		
		CapitalizeAndPermute(input,0);
		
	}
	
	
	public void CapitalizeAndPermute(String input, int position){

		if(out.length() ==  input.length()){
			System.out.println(out);
			return;
		}
		
		//for(int i = position; i < input.length() ; i ++){

			out.append(input.charAt(position));
			CapitalizeAndPermute(input,position+1);
			out.setLength(out.length() - 1);

			char c = input.charAt(position);
			if(Character.isLetter(c)){
				out.append(Character.toUpperCase(c));
				CapitalizeAndPermute(input,position+1);
				out.setLength(out.length() - 1);
			}

		//}


	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "a1b2c";
		CapitalizeAndPermute algo = new CapitalizeAndPermute(input);
		

	}

}
