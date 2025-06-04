SELECT 
    e.EMP_NO,
    e.EMP_NAME,
    CASE 
        WHEN total_scores.total_score >= 96 THEN 'S'
        WHEN total_scores.total_score >= 90 THEN 'A'
        WHEN total_scores.total_score >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE 
        WHEN total_scores.total_score >= 96 THEN e.SAL * 0.20
        WHEN total_scores.total_score >= 90 THEN e.SAL * 0.15
        WHEN total_scores.total_score >= 80 THEN e.SAL * 0.10
        ELSE 0
    END AS BONUS
FROM HR_EMPLOYEES e
JOIN (
    SELECT 
        EMP_NO,
        SUM(SCORE) / 2 AS total_score
    FROM HR_GRADE
    WHERE YEAR = 2022
    GROUP BY EMP_NO
) total_scores ON e.EMP_NO = total_scores.EMP_NO
ORDER BY e.EMP_NO;