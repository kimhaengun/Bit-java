package com.bit;

public class Ex01 {
	
//	// 1. return = 메소드 종료 
//	// 	  return은 메소드 어느 곳에서 실행 시킬 수 있다.
//	public static void func01() {
//		for (int i = 0; i < 10; i++) {
//			if(i>5) return;
//			System.out.println("i="+i);
//		}
//	}
	
//	// 1. break = 문법 종료
//	// 2. switch문 or 반복문에서 사용 가능하다.
//	// 3. !! for문만 빠져나감 
//		public static void func01() {
//			for (int i = 0; i < 10; i++) {
//				if(i>5) break;
//				System.out.println("i="+i);
//			}
//		}
		
	// 1. continue = 반복문에서만 존재 
	// 2. continue를 만난 시점부터 밑 코드는 실행하지 않고 for문으로 돌아감
	// 3. ex) for문은 10번 모두 진행 된다.
		public static void func01() {
			for (int i = 0; i < 10; i++) {
				if(i>5) continue;
				System.out.println("i="+i);
			}
		}
		
		public static void func02() {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(j==2)continue;
					System.out.println("i="+i+", j="+j);
				}
			}
		}
		
		public static void func03() {
			System.out.println("func03 start");
			int su = 5;
			for (int i = 0; i < 10; i++) {
				switch (i) {
				case 5: break;
				case 3: 
				case 1: 

				}
				System.out.println("실행중..."+i);
			}
			System.out.println("func03 end");
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * while ~ continue - 반복문 (이후 반복에서 이후 실행문을 skip)
		 * 		 ~ return - 메서드 내부 어디서든 (메서드 탈출)
		 * 		 ~ break - switch문, 반복문 - (최근 반복문 탈출)
		 */
		
		
		func03();
	}

		
}
