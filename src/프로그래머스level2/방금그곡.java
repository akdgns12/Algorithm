package ���α׷��ӽ�level2;
/*
 * ��������, ����� ���۵ǰ� ���� �ð�, �Ǻ�
 * �׿��� ����� ��ε� ���� ���ڿ� m, ��۵� ���� ���� ����ִ� �迭 musicinfos
 * musicinfos ���� ���۽ð�, �����ð�, ���� ����, �Ǻ����� ','�� ���е� ���ڿ�
 * 
 * ������ ��ġ�ϴ� ������ �������� ������ �������� ����� �ð��� ���� �� ����������
 * ��ȯ, ����� �ð��� ���� ��� ���� �Է��� ���� ������ ��ȯ
 * ��ġ�ϴ°� ������ none
 */
// ���۽ð�, ����ð�,����, ��ε� 4���� ������ ������ �ִ� ���ڿ��� �̷���� �迭��
// ����ڰ� ����ϰ� �ִ� ��ε� ������ ����ڰ� ����ϴ� �뷡�� ������ ã�� ����
public class ��ݱװ� {
	
	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int maxtime = 0;
		for(int i=0; i<m.length(); i++) {
			m = m.replace("A#", "a");
			m = m.replace("C#", "c");
			m = m.replace("D#", "d");
			m = m.replace("F#", "f");
			m = m.replace("G#", "g");
			m = m.replace("E#", "e");
		}
		
		for(int i=0; i<musicinfos.length; i++) {
			String[] tmp = musicinfos[i].split(",");
			
			tmp[3] = tmp[3].replace("A#", "a");
			tmp[3] = tmp[3].replace("C#", "c");
			tmp[3] = tmp[3].replace("D#", "d");
			tmp[3] = tmp[3].replace("F#", "f");
			tmp[3] = tmp[3].replace("G#", "g");
			tmp[3] = tmp[3].replace("E#", "e");
			
			String[] starttime = tmp[0].split(":");
			String[] endtime = tmp[1].split(":");
			
			int hour = Integer.parseInt(endtime[0]) - Integer.parseInt(starttime[0]);
			int min = Integer.parseInt(endtime[1]) - Integer.parseInt(starttime[1]) + (hour*60);
			
			String meltmp = "";
			for(int j=0; j<min; j++) {
				meltmp += tmp[3].charAt(j % tmp[3].length());
			}
			
			//sysout(meltmp); �뷡�� ����Ǵ� ������ ����
			if(meltmp.contains(m)) {
				if(maxtime < meltmp.length()) {
					maxtime = meltmp.length();
					answer = tmp[2];
				}
			}
		}
		
		return answer;
	}
}
