-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
from ANIMAL_OUTS
where ANIMAL_ID not in (
    select i.animal_id
    from animal_ins i
    join animal_outs o
    on i.animal_id = o.animal_id
)
order by ANIMAL_ID