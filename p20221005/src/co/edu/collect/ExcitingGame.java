package co.edu.collect;

import java.util.Scanner;

public class ExcitingGame {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		long gameStart = System.currentTimeMillis();

		System.out.println("1.게임시작 2.종료");
		int start = scn.nextInt();
		scn.nextLine();

		if (start == 1) {
			while (run) {
				gameStart = System.currentTimeMillis();

				String target = "Power is dangerous unless you have humility";
				String[] targetAry = target.split(" ");
				System.out.println(target);

				for (int i = 0; i < targetAry.length; i++) {
					System.out.println("입력>>");
					String input = scn.nextLine();
					if (targetAry[i].equals(input)) {
						targetAry[i] = null;
					} else if (targetAry[i] != input) {
						i = i - 1;
						System.out.println("단어가 틀렸습니다");
					}

					for (String str : targetAry) {
						if (str != null) {
							System.out.printf("%s ", str);
						}
					}
				}
				if (System.currentTimeMillis() - gameStart > 3000) {
					System.out.println("시간초과");
					break;
				}

				

			}
		} else if (start == 2) {
			run = false;
			System.out.println("종료하였습니다");

		}
		long gameEnd = System.currentTimeMillis();
		long during = (gameEnd - gameStart); // 1*60*1000 + 30*1000 = 63000/60000 분, 63000%

		System.out.println((during / 1000) / 60 + " 분 " + during / 1000 + " 초 걸렸습니다");
		// while
	}
}
