package projects;

/* List all possible 10-digit numbers that has...
 * the first-digit divisible by 1
 * the first two digits divisible by 2
 * the first three digits divisible by 3
 * And so forth
 * Until the first 10 digits are divisible by 10
 */

public class The10DigitNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 0;
		
		//Divisible by 1		
		for (int i = 0; i <= 9; i++) {
			num = i;
			//Divisible by 2
			for (int j = 0; j <= 9; i++) {
				num = (num * 10) + j;
				if (num % 2 == 0) {
					//Divisible by 3
					for (int k = 0; k <= 9; k++) {
						num = (num * 10) + k;
						if (num % 3 == 0) {
							//Divisible by 4
							for (int a = 0; a <= 9; a++) {
								num = (num * 10) + a;
								/*if (num % 4 == 0) {
									//Divisible by 5
									for (int b = 0; b <= 9; b++) {
										num = (num * 10) + b;
										if (num % 5 == 0) {
											//Divisible by 6
											for (int c = 0; c <= 9; c++) {
												num = (num * 10) + c;
												if (num % 6 == 0) {
													//Divisible by 7
													for (int d = 0; d <= 9; d++) {
														num = (num * 10) + d;
														if (num % 7 == 0) {
															//Divisible by 8
															for (int e = 0; e <= 9; e++) {
																num = (num * 10) + e;
																if (num % 8 == 0) {
																	//Divisible by 9
																	for (int f = 0; f <= 9; f++) {
																		num = (num * 10) + f;
																		if (num % 9 == 0) {
																			System.out.println(num * 10);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}*/
							}
						}
					}
				}
			}
		}
		
	}
}

