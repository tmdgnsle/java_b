select b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, date_format(r.CREATED_DATE, "%Y-%m-%d") as CREATED_DATE
from USED_GOODS_BOARD b
join USED_GOODS_REPLY r
on b.board_id = r.board_id
where date_format(b.created_date, '%Y%m') = '202210'
order by r.created_date asc, b.title asc