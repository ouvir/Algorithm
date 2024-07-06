def solution(participant, completion):
    count = dict()
    for p in participant:
        if p in count:
            count[p] += 1
        else:
            count[p] = 1

    for c in completion:
        count[c] -= 1
        if count[c] == 0:
            del count[c]

    answer = list(count.keys())[0]
    return answer