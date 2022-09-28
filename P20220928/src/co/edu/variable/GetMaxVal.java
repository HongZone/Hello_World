package co.edu.variable;

public class GetMaxVal {
	public static void main(String[] args) {
		int[] randomAry = new int[5];
		randomAry[0] = (int) (Math.random() * 100) + 1;//+1은 1부터10까지 임의의 수 //0~1사이의 임의수 생성 randomAry[0] = Math.random(); Math.random();은 실수!
		randomAry[1] = (int) (Math.random() * 100) + 1;                                              //타입이 안맞아 에러남 (int)=정수로 바꿔주겠습니다 라는뜻
		randomAry[2] = (int) (Math.random() * 100) + 1;
		randomAry[3] = (int) (Math.random() * 100) + 1;
		randomAry[4] = (int) (Math.random() * 100) + 1;

		int maxVal = 100; //배열요소 중 가장 큰 값을 저장할 용도
		for(int i=0; i<5; i++) {
			System.out.println(randomAry[i]);
			//maxVal 변수에 두 값을 비교해서 큰값을 담기
			if((maxVal > randomAry[i])){
				maxVal = randomAry[i];
			}

		}

		System.out.println("생성된 배열의 임의의 값중 최대값?" + maxVal);
	}
}
