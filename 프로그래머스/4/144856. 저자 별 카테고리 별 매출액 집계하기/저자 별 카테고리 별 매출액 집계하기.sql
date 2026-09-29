-- 코드를 입력하세요
SELECT b.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(b.PRICE * s.SALES) AS TOTAL_SALES
from book b
join author a
on b.author_id = a.author_id
join book_sales s
on b.book_id = s.book_id
where s.sales_date >= '2022-01-01' and s.sales_date < '2022-02-01'
group by b.author_id, b.category
order by b.author_id asc, b.category desc