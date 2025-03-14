-- 코드를 작성해주세요
SELECT EMP_NO, EMP_NAME,
    CASE 
        WHEN AVG(SCORE) >= 96 THEN 'S'
        WHEN AVG(SCORE) >= 90 THEN 'A'
        WHEN AVG(SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    FLOOR(
        SAL *
        CASE
            WHEN AVG(SCORE) >= 96 THEN 0.2
            WHEN AVG(SCORE) >= 90 THEN 0.15
            WHEN AVG(SCORE) >= 80 THEN 0.1
            ELSE 0
        END
    ) AS BONUS
FROM HR_EMPLOYEES E JOIN HR_GRADE G USING (EMP_NO)
GROUP BY EMP_NO, EMP_NAME, SAL
ORDER BY EMP_NO