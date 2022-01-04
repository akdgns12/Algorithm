package 프로그래머스_Level_1;

/*
 * 스마트폰 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서
 * 숫자만을 입력하려 한다.
 * 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드에 위치에서
 * 시작. 
 * 엄지손가락 사용 규칙
 * 1. 엄지손가락은 상하좌우 4가지 방향으로만 이동가능하며 키패드 이동한 칸은 
 * 거리로 1
 * 2. 왼쪽 열의 3개의 숫자 1,4,7을 입력할 때는 왼손
 * 3. 오른쪽 3개의 숫자 3,6,9를 입력할 대는 오른손
 * 4. 가운데 열의 4개의 숫자 2,5,8,0을 입력할 때는 두 엄지손가락의 현재
 * 키패드의 위치에서 더 가까운 엄지손가락을 사용
 * 4-1 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락,
 * 왼손잡이는 왼손 엄지손가락을 사용
 * 
 * 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인지를 
 * 나타내는 문자열 hand가 매개변수, 각 번호를 누른 엄지손가락이 왼손인지
 * 오른손인지를 나타내는 연속된 문자열 형태로 return하는 solution
 * 
 */
/*
 * <알고리즘> 
 * 1. 1,4,7 일때는 왼손을 사용하고, 3,6,9 일때는 무조건 오른손을 사용하고,
 * 현재 Left, Right의 위치를 갱신한다
 * 2.규칙 (키패드 -1 ) / 3 은 x좌표, (키패드 - 1) %3은 Y좌표
 * 3. 키패드 0은 11로 바꿔줘야한다. *,# 도 각각 10,12로 바꿔준다
 * 4. 마지막으로 L또는 R이 위치한 좌표와 누르려는 키패드(n)의 차이를 구한다.
 */
public class 키패드누르기 {
	public String solution(int[] numbers, String hand) {
		StringBuilder bd = new StringBuilder();

        int leftLocation = 10;
        int rightLocation = 12;

        for(int number : n) {
            if(number ==1 || number == 4 || number == 7) {
                bd.append("L");
                leftLocation = number;
            }else if(number == 3 || number == 6 || number == 9) {
                bd.append("R");
                rightLocation = number;
            }else { // 2 5 8 0 
                int distanceL = getDist(leftLocation, number);
                int distanceR = getDist(rightLocation, number);

                if(distanceL > distanceR) {
                    bd.append("R");
                    rightLocation = number;
                }else if(distanceL < distanceR) {
                    bd.append("L");
                    leftLocation = number;
                }else {
                    if(hand.equals("right")) {
                        bd.append("R");
                        rightLocation = number;
                    }else {
                        bd.append("L");
                        leftLocation = number;
                    }
                }

            }
        }
        return bd.toString();
    }

    public static int getDist(int location, int number) {

        if(number == 0) {
            number = 11;
        }

        if(location == 0) {
            location = 11;
        }

        int locationX = (location-1) / 3;
        int locationY = (location-1) % 3;

        int numberX = (number-1) / 3;
        int numberY = (number-1) % 3;

        return Math.abs(locationX-numberX) + Math.abs(locationY - numberY);

    }
}
