-- 코드를 입력하세요
SELECT i.ingredient_type as INGREDIENT_TYPE, sum(f.total_order) as TOTAL_ORDER
from first_half f, icecream_info i
where f.flavor = i.flavor
group by i.ingredient_type
order by sum(f.total_order) asc;