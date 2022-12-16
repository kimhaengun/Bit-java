class Ex04{
	public static void main(String[] args){
		// 구구단 (while)
		System.out.println("===구구단 while===");
		int a=2;
		int i=1;
		int j=2;
		while(a<10){
			System.out.print(a+"단 \t");
			a++;
		}
		System.out.print("\n");
		while(i<10){
			while(j<10){
				System.out.print(j+"x"+i+"="+j*i+"\t");
				j++;
			}
			j=2;
			i++;
			System.out.print("\n");
		}

		
		// 1~50까지의 합을 구하시오
		System.out.println("\n===1~50까지의 합을 구하시오===");
		int sum = 0;
		/*
		for(i=1; i<51; i++){
			sum+=i;
		}
		*/
		i=1;
		while(i<51){
			sum+=i;
			i++;
		}
		System.out.println("1~50까지의 합 = "+sum);
		
		// 1+3+5+7+9=000을 출력하시오
		System.out.println("\n===1+3+5+7+9=000을 출력하시오===");
		sum=0;
		/*
		for(i=1; i<10;i++){
			if(i%2==1){
				sum+=i;
			}	
		}
		*/
		i =1;
		while(i<10){
			if(i%2==1){
				sum+=i;	
			}
			i++;
		}
		System.out.println("1+3+5+7+9 = "+sum);

		// 1~50까지의 3의 배수를 출력하시오.
		System.out.println("\n===1~50까지의 3의 배수를 출력하시오.===");
		System.out.println("3의 배수");
		/*
		for(i=1; i<51; i++){
			if(i%3==0){
				System.out.print(i+" ");
			}
		}
		*/
		i=1;
		while(i<51){
			if(i%3==0){
				System.out.print(i+" ");
			}
			i++;
		}
		System.out.print("\n");

		// 2,4,6,8,10 출력하시오.
		System.out.println("\n===2,4,6,8,10 출력하시오.===");
		/*
		for(i=1; i<=10; i++){
			if(i%2==0){
				System.out.print(i+ " ");
			}
		}
		*/
		i=1;
		while(i<=10){
			if(i%2==0){
				System.out.print(i+ " ");
			}
			i++;	
		}
		System.out.print("\n");

				
	}
}
