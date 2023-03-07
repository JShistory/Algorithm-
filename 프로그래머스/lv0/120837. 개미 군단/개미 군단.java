class Solution {
    public int solution(int hp) {
        int answer = 0;
        int ant1 = 0;
        int ant2 = 0;
        int ant3 = 0;

        ant1 = hp / 5;
        hp %= 5;
        ant2 = hp / 3;
        hp %= 3;
        ant3 = hp;
        return ant1 + ant2 + ant3;
    }
}
