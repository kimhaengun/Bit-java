/*
1. A~Z까지 출력하시오
A, B, C ...
2. A(a)~Z(z)까지 출력하시오
A(a), B(b), C(c)...
3.  출력
1 2 3
4 5 6
7 8 9

4. 
1 2 3
2 3 4
3 4 5

5.
■ ■ ■
■ ■ ■
■ ■ ■

*/

class Ex11{
	public static void main(String[] args){
		System.out.println("===A~Z까지 출력하시오.===");
		/*
		for(int i=65; i<91; i++){
			//숫자 int --> 문자 char
			char alp = (char)i;
			if(i<90){
				System.out.print(alp+", ");	
			}else{
				System.out.print(alp);
			}
			
		}*/

		boolean boo = true;
		char a = 'A';
		while(boo){
			System.out.print(a++);
			if(a>='Z'){
				System.out.print(a);
				boo=false;
			}
		}

		System.out.println("\n\n===A(a)~Z(z)까지 출력하시오.===");
		for(int i=65; i<91; i++){
			//숫자 int --> 문자 char
			// 대문자-소문자 = 32
			//대문자
			char alp = (char)i;
			//소문자
			char salp = (char)(i+32);
			if(i<90){
				System.out.print(alp+"("+salp+")"+", ");	
			}else{
				System.out.print(alp+"("+salp+")");
			}
			
		}		

		System.out.println("\n\n===ex3. 출력.===");
 //                       1     2     3
  //                      4     5     6
  //                      7     8     9
		for(int i = 1; i< 10; i+=3){
			for(int j = i; j < (i+3); j++){
				System.out.print(j);
			}
			System.out.print("\n");
		}


		System.out.println("\n\n===ex4. 출력.===");		
//		  1    2    3
//                        2    3    4
//                        3    4    5
		for(int i = 1; i< 4; i++){
			for(int j = i; j < (i+3); j++){
				System.out.print(j);
			}
			System.out.print("\n");
		}
		System.out.println("\n\n===ex5. 출력.===");		
//		  ■    ■    ■
//                        ■    ■    ■
//                        ■    ■    ■
		for(int i = 1; i< 4; i++){
			for(int j = i; j < (i+3); j++){
				System.out.print("■");
			}
			System.out.print("\n");
		}	
	}
} 