-- 코드를 작성해주세요
SELECT YEAR(E.DIFFERENTIATION_DATE) AS YEAR,
    (
        (
            SELECT MAX(E2.SIZE_OF_COLONY)
            FROM ECOLI_DATA E2
            WHERE YEAR(E2.DIFFERENTIATION_DATE) = YEAR(E.DIFFERENTIATION_DATE)
        )
        - E.SIZE_OF_COLONY) AS YEAR_DEV,
    E.ID
FROM ECOLI_DATA E
ORDER BY YEAR, YEAR_DEV
