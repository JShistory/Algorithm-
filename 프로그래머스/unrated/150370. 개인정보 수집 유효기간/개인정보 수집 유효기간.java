import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    static HashMap<String, String> data;
    static HashMap<String, String> terms_data;
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> ans = new ArrayList<>();

        terms_data = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            String[] info = terms[i].split(" ");
            terms_data.put(info[0], info[1]);
        }

        int today_year = Integer.parseInt(today.split("\\.")[0]);
        int today_month = Integer.parseInt(today.split("\\.")[1]);
        int today_day = Integer.parseInt(today.split("\\.")[2]);
        int today_cnt = (today_year * 12 * 28) + (today_month * 28) + today_day;

        for (int i = 0; i < privacies.length; i++) {
            //정보, 몇개월 늘릴 것인지

            String terms_info = String.valueOf(privacies[i].charAt(privacies[i].length() - 1));

            int addYear = 0;
            int addMonth = Integer.parseInt(terms_data.get(terms_info));
            //2021.05.02 A

            String[] data_info = privacies[i].split(" ")[0].split("\\.");
            int year = Integer.parseInt(data_info[0])%10000;
            int month = Integer.parseInt(data_info[1])%100;
            int day = Integer.parseInt(data_info[2])%100;



            month += addMonth;
            if (month > 12) {
                year = ((month) / 12) + year;
                if (month % 12 == 0) {
                    year -= 1;
                    month = 12;
                }
                else{
                    month %= 12;
                }
            }
            day -= 1;
            if (day == 0) {
                day = 28;
                month -= 1;
                if (month == 0) {
                    year -= 1;
                    month = 12;
                }
            }
            int passCnt = (year * 12 * 28) + (month * 28) + day;
            if (passCnt < today_cnt) {
                ans.add(i + 1);
            }

        }
        int[] answer = ans.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
}