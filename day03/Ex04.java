class Ex04{
	public static void main(String[] args){
		//연산자
		int a = 5, b = 2;
		a++;
		b++;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);			

		System.out.println("===비교 연산자===");
		System.out.println(a>b);
		System.out.println(a>=b);
		System.out.println(a<b);
		System.out.println(a<=b);
		System.out.println(a==b);
		System.out.println(a!=b);

		System.out.println("===boolean===");
		boolean bool1=true;
		boolean bool2=false;
		System.out.println(!bool1);
		System.out.println(!bool2);

		System.out.println("===and or===");
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && false);
		System.out.println(false && true);
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || false);
		System.out.println(false || true);

		System.out.println("============");
		int x0=3, y0, z0;
		x0+=1;
		System.out.println(x0);
		x0-=1;
		System.out.println(x0);
		x0*=1;
		System.out.println(x0);
		x0/=1;
		System.out.println(x0);

		System.out.println("============");
		int x=3, y=2 , z=1;
		x+=y+z; // x=x+y+z
		System.out.println(x);
		x-=y+z; // x=x-y+z
		System.out.println(x);
		x*=y+z; // x=x*(y+z)
		System.out.println(x);
		x/=y+z; // x=x/(y+z)
		System.out.println(x);



	} 
}

