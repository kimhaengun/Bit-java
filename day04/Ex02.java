class Ex02{
	public static void main(String[] args){
		//2단
		System.out.println(2+"x"+1+"="+2*1);
		System.out.println(2+"x"+2+"="+2*2);
		System.out.println(2+"x"+3+"="+2*3);
		System.out.println(2+"x"+4+"="+2*4);
		System.out.println(2+"x"+5+"="+2*5);
		
		System.out.println("===2단===");
		for(int i=1; i<10; i++){
			System.out.println(2+"x"+i+"="+2*i);
		}

		System.out.println("===구구단===");
		
		for(int i =1; i<10; i++){
			System.out.print(i+"단 \t");			
		}
			System.out.print("\n");			

		for(int i =1; i<10; i++){
						
			for(int j = 1; j<10; j++){			
				System.out.print(j+"x"+i+"="+i*j+"\t");
								
			}
			System.out.print("\n");
		}
		
	}
}





