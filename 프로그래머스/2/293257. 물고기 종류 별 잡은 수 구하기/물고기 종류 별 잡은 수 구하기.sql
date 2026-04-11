-- 코드를 작성해주세요
select count(*) as FISH_COUNT, n.fish_name
from fish_info i
join fish_name_info n
on i.fish_type = n.fish_type
group by n.fish_name
order by count(i.fish_type) desc

