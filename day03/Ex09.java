class Ex09{
	public static void main(String[] args){
		String water ="생수";
		String gum ="풍선껌";
		String snack ="과자";

		int waterValue = 1200;
		int gumValue = 500;
		int snackValue = 3500;
		
		int waterSum, gumSum, snackSum, sum;
		
		int waterCount = 7;
		int gumCount = 9;
		int snackCount = 5;

		waterSum = waterValue *waterCount;
		gumSum =gumValue * gumCount;
		snackSum= snackValue * snackCount;

		int countSum = waterCount+gumCount+snackCount;
		sum = waterSum + gumSum + snackSum;

		System.out.println("-------------------------------");
		System.out.println("비플제로페이 영수증");
		System.out.println("-------------------------------");
		System.out.println("품목        정가   수량   금액");
		System.out.println("-------------------------------");
		System.out.println(water+ "        "+waterValue+"    "+waterCount+"     "+waterSum);
		System.out.println(gum+ "      "+gumValue+"     "+gumCount+"     "+gumSum);
		System.out.println(snack+"        "+snackValue+"    "+snackCount+"     "+snackSum);
		System.out.println("-------------------------------");
		System.out.println("합계         "+"       "+countSum+"    "+sum);



	} 
}

