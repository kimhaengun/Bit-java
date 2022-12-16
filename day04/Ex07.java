class Ex07{
	public static void main(String[] args){
		// 0<=ran<1
		/*
		double ran;
		ran=Math.random();
		System.out.println(ran);			
		*/
		double ran;
		ran=Math.random()*10;
		int a = (int)ran;
		System.out.println(a);
	}
}