class Ex01{
	public static void main(String[] args){
		int a = 1234;
		a = 0b00000011;
		a = 010;
		a = 0x10;
		System.out.println(a);
		long b = 1234111111010101L;
		System.out.println(b);
		b=a;
		System.out.println(b);
		int c = (int)b;
		System.out.println(c);
		
		byte d=127;
		d=-128;
		d=(byte)129;
		System.out.println(d);
	} 
}

