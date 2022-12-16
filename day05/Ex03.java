class Ex03{
	public static void gugu(int su, int dan){
			System.out.println(dan+"x"+su+"="+dan*su);
	}
	public static void main(String[] args){
		System.out.print(" 몇단 볼래? : ");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int dan = sc.nextInt();
		for(int i =1; i<10; i++){
			gugu(i,dan);
		}
	}
}


