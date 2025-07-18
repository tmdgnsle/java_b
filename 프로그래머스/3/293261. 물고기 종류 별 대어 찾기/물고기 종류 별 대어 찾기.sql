-- 코드를 작성해주세요

SELECT I.ID, N.FISH_NAME, I.LENGTH
FROM FISH_INFO I
INNER JOIN FISH_NAME_INFO N ON I.FISH_TYPE = N.FISH_TYPE
WHERE I.LENGTH IN (
    SELECT MAX(I2.LENGTH)
    FROM FISH_INFO I2
    INNER JOIN FISH_NAME_INFO N2 ON I2.FISH_TYPE = N2.FISH_TYPE
    GROUP BY I2.FISH_TYPE
)
ORDER BY I.ID