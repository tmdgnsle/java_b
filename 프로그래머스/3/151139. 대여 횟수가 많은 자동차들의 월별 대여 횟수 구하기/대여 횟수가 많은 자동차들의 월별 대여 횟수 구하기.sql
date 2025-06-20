SELECT 
    MONTH(START_DATE) AS MONTH,
    CAR_ID,
    COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE >= '2022-08-01' 
  AND START_DATE < '2022-11-01'
  AND CAR_ID IN (
      -- 해당 기간 동안 총 대여 횟수가 5회 이상인 자동차
      SELECT CAR_ID
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
      WHERE START_DATE >= '2022-08-01' 
        AND START_DATE < '2022-11-01'
      GROUP BY CAR_ID
      HAVING COUNT(*) >= 5
  )
GROUP BY MONTH(START_DATE), CAR_ID
ORDER BY MONTH ASC, CAR_ID DESC;