-- 코드를 입력하세요
SELECT month(start_date) as MONTH, CAR_ID, count(history_id) as RECORDS
from car_rental_company_rental_history
where start_date >= '2022-08-01' and start_date < '2022-11-01'
    and car_id in (
    select car_id
    from car_rental_company_rental_history
    where start_date >= '2022-08-01' and start_date < '2022-11-01'
    group by car_id
    having count(*) >= 5)
    group by month(start_date), car_id
    order by month asc, car_id desc
