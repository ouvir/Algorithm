class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        boolean[] isLate = new boolean[n];

        int dayOfWeek = startday;  // 1=Mon, ..., 7=Sun
        for (int d = 0; d < 7; d++) {
            if (dayOfWeek == 6 || dayOfWeek == 7) {
                dayOfWeek = (dayOfWeek == 7) ? 1 : dayOfWeek + 1;
                continue;
            }

            for (int i = 0; i < n; i++) {
                if (isLate[i]) continue;

                int scheduledHHMM = schedules[i];
                int loggedHHMM    = timelogs[i][d];

                // “HHMM 형식을 분으로 변환” 후 10분을 더해 허용 시각 계산
                int sh = scheduledHHMM / 100;
                int sm = scheduledHHMM % 100;
                int allowedMinutes = sh * 60 + sm + 10;

                // 실제 출근 시각 분 단위
                int th = loggedHHMM / 100;
                int tm = loggedHHMM % 100;
                int actualMinutes = th * 60 + tm;

                if (actualMinutes > allowedMinutes) {
                    isLate[i] = true;
                }
            }

            dayOfWeek = (dayOfWeek == 7) ? 1 : dayOfWeek + 1;
        }

        int count = 0;
        for (boolean late : isLate) {
            if (!late) count++;
        }
        return count;
    }
}