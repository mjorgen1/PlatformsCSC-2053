import java.util.Scanner;

public class ComputeStairs { //The below code is my FINAL CODE! Please grade this file and not the other two posted on Blackboard

	public static void main(String[] args) {
		boolean runSC = false;
		boolean runSCDP = false;;
		long stairCount[] = new long[41];
		stairCount[0] = 0;
		stairCount[1] = 1;
		stairCount[2] = 2;
		stairCount[3] = 4;
		long answer = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("Input 0 to run the StairCount method or 1 for the StairCountDP method: ");
		int run = scan.nextInt();
		System.out.println();
		if(run == 0)
			runSC = true;
		else if (run == 1)
			runSCDP = true;
		else
			System.out.println("Incorrect input, try running program again.");
		while(runSC) {
			System.out.print("Input the # of stairs the child has to run up using StairCount " +
							 "(enter a # 41+ to stop program or 100 to try the StairCountDP method): ");
			int stairNum = scan.nextInt();
			if(stairNum <=40 && !(stairNum < 0)) {
				answer = StairCount(stairNum);
				System.out.println("This is the # of possible ways to run up the stairs: " + answer + "\n");
			}
			else if(stairNum == 100) { 
				runSC = false;
				runSCDP = true;
				System.out.println();
			}
			else {
				runSC = false;
				runSCDP = false;
				System.out.println("Program ended");
			}
		}
		while(runSCDP) {
			System.out.print("Input the # of stairs the child has to run up using StairCountDP (enter a # 41+ to stop program): ");
			int stairNum = scan.nextInt();
			if(stairNum <=40 && !(stairNum < 0)) { 
				answer = StairCountDP(stairNum, stairCount);
				System.out.println("This is the # of possible ways to run up the stairs: " + answer + "\n");
			}
			else {
				runSCDP = false;
				//Testing for DP
				System.out.println("To test the dynamic programming capability...we show the stairCount array after the program is closed");
				for(int i = 0; i <= 40; i++) {
					System.out.println("The possible ways to walk up " + i + " # of stairs is " + stairCount[i]);
				}
				System.out.println("Program ended");
			}
		}
	}
	
	public static long StairCount(int stairs) {
		long answer;
	
		//Base case
		if(stairs <= 0) {
			answer = 0;
			return answer;
		}
		else if(stairs == 1) {
			answer = 1;
			return answer;
		}
		else if(stairs == 2) {
			answer = 2;
			return answer;
		}
		else if(stairs == 3) {
			answer = 4;
			return answer;
		}
		//Recursive case
		return (StairCount(stairs-3) + StairCount(stairs-2) + StairCount(stairs-1));
	}
	
	public static long StairCountDP(int stairs, long [] memo) {
		if(memo[stairs] != 0)
			return memo[stairs];
		else {
			long answer;
			
			//Base case
			if(stairs <= 0) {
				answer = 0;
				return answer;
			}
			else if(stairs == 1) {
				answer = 1;
				return answer;
			}
			else if(stairs == 2) {
				answer = 2;
				return answer;
			}
			else if(stairs == 3) {
				answer = 4;
				return answer;
			}
			//Recursive case
			answer = StairCountDP(stairs-3, memo) + StairCountDP(stairs-2, memo) + StairCountDP(stairs-1, memo);
			memo[stairs] = answer;
			return answer;
		}
	}
}
