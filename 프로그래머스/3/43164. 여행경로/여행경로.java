import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String[]> ticketList = new ArrayList<>(Arrays.asList(tickets));

        // 출발지, 도착지 기준 정렬
        ticketList.sort((a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        List<String> route = dfs(new ArrayList<>(List.of("ICN")), ticketList, "no");
        return route.toArray(new String[0]);
    }

    private List<String> dfs(List<String> route, List<String[]> unusedTickets, String count) {
        if (unusedTickets.isEmpty()) return route;

        String current = route.get(route.size() - 1);

        // 현재 위치에서 출발하는 티켓만 사용
        for (String[] ticket : new ArrayList<>(unusedTickets)) {
            if (ticket[0].equals(current)) {
                if (ticket[1].equals(count)) continue;

                List<String[]> deepCopy = new ArrayList<>(unusedTickets);
                deepCopy.remove(ticket);

                List<String> newRoute = new ArrayList<>(route);
                newRoute.add(ticket[1]);

                return dfs(newRoute, deepCopy, "-1");
            }
        }

        // 백트래킹: 사용 가능 티켓 X
        if (route.size() < 2) return route;
        
        List<String> backRoute = new ArrayList<>(route);
        String last = backRoute.remove(backRoute.size() - 1); // 마지막 공항 제거

        List<String[]> restored = new ArrayList<>(unusedTickets);
        restored.add(new String[]{route.get(route.size() - 2), last});
        restored.sort((a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        return dfs(backRoute, restored, last);
    }
}
