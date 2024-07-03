import sys

N = int(sys.stdin.readline())

meetings = list()
end_meeting_time = 0
count = 0

for _ in range(N):
    meetings.append(tuple(map(int,sys.stdin.readline().split())))

meetings.sort(key=lambda x : (x[1],x[0]))

for meeting in meetings:
    if meeting[0] < end_meeting_time:
        continue
    end_meeting_time = meeting[1]
    count += 1

print(count)