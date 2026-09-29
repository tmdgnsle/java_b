-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from rest_info
where FAVORITES = (select max(favorites)
      from rest_info r2
      where rest_info.food_type = r2.food_type)
order by food_type desc