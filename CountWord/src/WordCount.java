import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

class WordCount {


	public static void main(String[] args) {


		String arr[] = new String[10000]; // [WORD1] [WORD2] [] [] [][]...[]
		int cnt[] = new int[10000]; // [2] [1] [] [] [][]...[]
		int n = 0; // 배열에서 index를 진행할 변수
		try {
			// 파일 객체 생성
			File file = new File("GetOut.txt");
			// 입력 스트림 생성
			FileReader filereader = new FileReader(file);
			// 입력 버퍼 생성
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
				line = line.replaceAll(match, "");
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens()) {
					String s = st.nextToken().replaceAll(" ", "");
					// 만약 중복되면 중복되는 배열에 index를 알고 cnt[index]를 1증가한다.
					int i = 0;
					for (i = 0; i < n; i++) {
						if (s.equalsIgnoreCase(arr[i])) { // 토큰에서 뽑아온 글자가 배열에 이미 있는지 검사하는것
							break;
						}
					}
					if (i < n) {
						cnt[i]++;
					}
					if (n == 0 || i == n) {
						arr[n] = s;
						cnt[n] = 1;
						n++;
					}

				}
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + " --> " + cnt[i]);
		}

	}
	
	
		
	}


