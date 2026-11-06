-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, (p.PRICE * s.AMOUNT) as SALES
FROM PRODUCT p
JOIN (
    SELECT PRODUCT_ID, SUM(SALES_AMOUNT) as AMOUNT
    FROM OFFLINE_SALE
    GROUP BY PRODUCT_ID
) s
on p.product_id = s.product_id
order by SALES desc, p.product_code asc