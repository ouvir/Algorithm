SELECT P.PT_NAME, P.PT_NO, P.GEND_CD, P.AGE, IFNULL(P.TLNO, 'NONE') AS TLNO
FROM PATIENT P
WHERE P.AGE <= 12 AND P.GEND_CD = 'W'
ORDER BY P.AGE DESC, P.PT_NAME ASC;