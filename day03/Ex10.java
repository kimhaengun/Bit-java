class Ex10{
	public static void main(String[] args){
		String kor = "국어";
		String eng = "영어";
		String mat = "수학";
		
		int korScore = 80;
		int engScore = 81;		
		int matScore = 80;
		int scoreSum = korScore+engScore+matScore;
		
		double value = (double)scoreSum/3;
		int a = (int)(value*100.0);
		double average = (double)a/100;

		char grade;

		System.out.println("---------------------");
		System.out.println("학생 성적 관리");
		System.out.println("---------------------");			
		System.out.println(kor+ " : "+korScore+ ", "+eng+ " : "+engScore+ ", "+mat+ " : "+matScore);
		System.out.println("합계 : "+scoreSum+ ", 평균 : "+average);			
		System.out.println("---------------------");			
		/*
		if(average >= 90){
			grade = 'A';
		}else if(80<=average && average<90){
			grade = 'B';
		}else if(70<=average && average<80){
			grade = 'C';
		}else if(60<=average && average<70){
			grade = 'D';
		}else {
			grade = 'F';
			System.out.print("재수강 요망 ");
		}
		*/
		average = (int)average/10;
		switch((int)average){
			case 10 :
			case 9:  grade = 'A' ; break;
			case 8 : grade = 'B'  ; break;
			case 7 :  grade = 'C' ; break;
			case 6 :  grade = 'D' ; break;
			default  : grade = 'F' ; 
		}
		System.out.println("학점 : "+grade);
	} 
}

