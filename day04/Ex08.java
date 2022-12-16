/*
 가위, 바위, 보 게임(ver 0.1.0)
게임을 시작합니다.

1.가위 2.바위 3. 보 0.종료 >1
com : 바위
you : 가위
졌습니다.

1.가위 2.바위 3. 보 0.종료 >1
com : 보
you : 가위
이겼습니다.

1.가위 2.바위 3. 보 0.종료 >1
com : 보
you : 보
비겼습니다.

1.가위 2.바위 3. 보 0.종료 >1
1승1무1패
이용해주셔서 감사합니다.

*/
class Ex08{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("게임을 시작합니다.");
		boolean a = true;
		int win = 0;
		int moo = 0;
		int lose =0;
		String comResult = "";
		String youResult = "";		
		
		while(a){
			double ran;
			ran = Math.random()*10;
			int a1 = (int)ran%3;
			int com = a1+1; //1 ,2, 3   가위 바위 보

			System.out.print("1.가위 2.바위 3. 보 0.종료 > ");
			int userResult = sc.nextInt();
			switch(userResult){
				case 1: youResult="가위"; break;
				case 2: youResult="바위"; break;
				case 3: youResult="보"; break;
			}
			switch(com){
				case 1: comResult="가위"; break;
				case 2: comResult="바위"; break;
				case 3: comResult="보"; break;
				default : break;
			}

			
			//비겼을 경우
			if(userResult == com){
				System.out.println("com : "+comResult);
				System.out.println("you : "+youResult);
				System.out.println("비겻습니다.");
				moo++;
			} else if(userResult==1){
				//유저가 가위일 경우 승, 패
				if(com==3) {
					//컴퓨터 보 = 승
					win++;
					System.out.println("com : "+comResult);
					System.out.println("you : "+youResult);
					System.out.println("이겼습니다.");
				}else if(com== 2){
					//컴퓨터 바위 = 패
					lose++;
					System.out.println("com : "+comResult);
					System.out.println("you : "+youResult);
					System.out.println("졌습니다.");
				}
			} else if(userResult==2){
				//유저가 바위일 경우 승, 패	
				if(com==1) {
					//컴퓨터 가위 = 승
					win++;
					System.out.println("com : "+comResult);
					System.out.println("you : "+youResult);
					System.out.println("이겼습니다.");
				}else if(com== 3){
					//컴퓨터 보 = 패
					lose++;
					System.out.println("com : "+comResult);
					System.out.println("you : "+youResult);
					System.out.println("졌습니다.");
				}
			} else if(userResult==3){
				//유저가 보일 경우 승, 패
				if(com==2) {
					//컴퓨터 바위 = 승
					win++;
					System.out.println("com : "+comResult);
					System.out.println("you : "+youResult);
					System.out.println("이겼습니다.");
				}else if(com== 1){
					//컴퓨터 가위 = 패
					lose++;
					System.out.println("com : "+comResult);
					System.out.println("you : "+youResult);
					System.out.println("졌습니다.");
				}	
			} else if(userResult ==0){
				System.out.println(win+"승 "+moo+"무 "+lose+"패");
				System.out.println("이용해주셔서 감사합니다.");
				a = false;
			}
		}
	}

}