select PT_NAME, PT_NO, GEND_CD, AGE, COALESCE(TLNO, "NONE") AS TLNO
from PATIENT
where AGE <= 12 and gend_cd = 'W'
order by age desc, pt_name asc