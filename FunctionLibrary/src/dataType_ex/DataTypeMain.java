package dataType_ex;

import java.util.Scanner;

public class DataTypeMain {

	public static void main(String[] args) {

		while (true) {
			System.out.println("원하는 데이터를 선택하세요.");
			System.out.println(
					"[1] byte, [2]int, [3]short, [4]long, [5]float, [6]double, [7]char, [8]String, [9]boolean");
			byte by = 0;
			int num = 0;
			short sh = 0;
			long lo = 0;
			float f = 0;
			double d = 0;
			char ch = 'A';
			String str = "B";
			boolean bo = true;

			Scanner sc = new Scanner(System.in);
			String scStr = sc.nextLine();

			switch (scStr) {
			case "1":
				DataTypeMethod.getInstance().dataTypePrint(by);
				break;

			case "2":
				DataTypeMethod.getInstance().dataTypePrint(num);
				break;

			case "3":
				DataTypeMethod.getInstance().dataTypePrint(sh);
				break;

			case "4":
				DataTypeMethod.getInstance().dataTypePrint(lo);
				break;

			case "5":
				DataTypeMethod.getInstance().dataTypePrint(f);
				break;

			case "6":
				DataTypeMethod.getInstance().dataTypePrint(d);
				break;

			case "7":
				DataTypeMethod.getInstance().dataTypePrint(ch);
				break;

			case "8":
				DataTypeMethod.getInstance().dataTypePrint(str);
				break;

			case "9":
				DataTypeMethod.getInstance().dataTypePrint(bo);
				break;
			
			default:
				System.out.println("1~9 사이의 숫자를 다시 선택해주세요.");
				System.out.println("---------------------------");
			}
			
			sc.close();

		}
	}

}
