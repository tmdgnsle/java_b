-- 코드를 입력하세요
SELECT CAR_TYPE, COUNT(CAR_ID) AS CARS
from car_rental_company_car
where options like '%통풍시트%' or options like '%열선시트%' or options like '%가죽시트'
group by CAR_TYPE
order by CAR_TYPE