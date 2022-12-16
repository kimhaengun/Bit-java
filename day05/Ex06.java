/*
 계산기(ver 0.1.0)
 첫번째 숫자를 입력하시오 > 4
 두번째 숫자를 입력하시오 > 2
1. + 2. - 3. x 4. ÷ > 1
결과 >
4+2 =6
*/

class Ex06{
	public static int firstNum, secondNum, operationNum,resultNum;
	//덧셈
	public void add(int firstNum, int secondNum){
			resultNum = firstNum+secondNum;
			System.out.print(firstNum+" + "+secondNum+" = "+resultNum);						
	}

	//뺄셈
	public void minus(int firstNum, int secondNum){
			resultNum = firstNum-secondNum;
			System.out.print(firstNum+" - "+secondNum+" = "+resultNum);
	}

	//곱셈
	public void multiplication(int firstNum, int secondNum){
			resultNum = firstNum*secondNum;
			System.out.print(firstNum+" * "+secondNum+" = "+resultNum);		
	}
	//나눗셈
	public void division(int firstNum, int secondNum){
			double doubNum = (double)firstNum/(double)secondNum;
			resultNum = firstNum/secondNum;
			// 소수점 없을 경우
			if((doubNum*10)%10 == 0 ){
				resultNum = (int)(doubNum*10)/10;
				System.out.print(firstNum+" ÷ "+secondNum+" = "+resultNum);
			}else{
			// 입력값 : 5 2 or 30 7
			// 소수점 있을 경우
				if( (doubNum*100)%10 == 0){
					//소수점 한자리만 있을 경우
					System.out.print(firstNum+" ÷ "+secondNum+" = "+doubNum);
				}else{
					//소수점 여러개 --> 두 자리만 출력하기
					// doubNum = 4.285714 /   428 / 4.28
					int intNum = (int)(doubNum*100);
					double dNum = (double)intNum/100;
					System.out.print(firstNum+" ÷ "+secondNum+" = "+dNum);
				}
				
			}	
	}

	public void operation(int firstNum, int secondNum, int operationNum){
		if(operationNum == 1){
			//덧셈			
			add(firstNum, secondNum);
		}else if(operationNum == 2){
			//뺄셈			
			minus(firstNum, secondNum);
		}else if(operationNum == 3){
			//곱셈			
			multiplication(firstNum, secondNum);
		}else if(operationNum == 4){
			//나눗셈			
			division(firstNum,secondNum);			
		}else{
			//예외처리
			System.out.println("없는 계산식 입니다.");
		}			
	}

	public static void main(String[] args){

		java.util.Scanner sc = new java.util.Scanner(System.in);
		Ex06 ex06 = new Ex06();
		System.out.println("=== 계산기(ver 0.1.0)===");		
		System.out.print("첫번째 숫자를 입력하시오 > ");
		firstNum = sc.nextInt();
		System.out.print("두번째 숫자를 입력하시오 > ");
		secondNum = sc.nextInt();
		System.out.println("입력 받은 데이터 :  "+firstNum+", "+ secondNum);
		System.out.print(" 1. + 2. - 3. x 4. ÷ > ");
		operationNum = sc.nextInt();
		System.out.println("결과 >");
		ex06.operation(firstNum, secondNum, operationNum);
		// 연산 선택 중 4초과의 수가 들어왔을 때 다시 입력받게 하기 바로 끝내면 안됨
		
	}
}