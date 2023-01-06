package com.bit;
interface Ball{
	void play();
}
class Box<T>{
	T su;
	void setSu(T su) {
		this.su = su;
	}
	T getSu() {
		return su;
	}
	
}

class Lotto implements Ball{
	String msg;
	Lotto(int su){
		msg = su+"번";
	}
	public void play() {
		System.out.println(msg+"입니다.");
	}
}

class BaseBall implements Ball{
	String msg;
	BaseBall() {
		// TODO Auto-generated constructor stub
		msg = "거친 실밥이 박혀있는";
	}
	public void play() {
		System.out.println(msg+"공을 던지고 놉니다.");
	}
}
public class Ex04 {
	public static void main(String[] args) {
		BaseBall ball2 = new BaseBall();
		Lotto ball1 = new Lotto(45);
		
		Box<Ball> box = new Box<Ball>();
		box.setSu(ball2);
		
		Ball su =box.getSu();
		
		su.play();
		
		
	}
}
