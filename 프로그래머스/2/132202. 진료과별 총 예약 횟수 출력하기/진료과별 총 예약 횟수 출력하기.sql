-- 코드를 입력하세요
SELECT MCDP_CD AS 진료과코드, count(PT_NO) as 5월예약건수
from appointment
where date_format(apnt_ymd, "%Y%m") = '202205'
group by MCDP_CD
order by 5월예약건수 asc, 진료과코드 asc