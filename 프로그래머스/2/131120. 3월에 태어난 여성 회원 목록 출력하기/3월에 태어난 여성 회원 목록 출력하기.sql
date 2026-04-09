select MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH, "%Y-%m-%d") as DATE_OF_BIRTH
from member_profile
where gender = 'W' and date_format(date_of_birth, "%m") = 3
and tlno is not null
order by member_id asc