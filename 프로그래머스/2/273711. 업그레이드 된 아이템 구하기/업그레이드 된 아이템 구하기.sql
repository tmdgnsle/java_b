select c.ITEM_ID, c.ITEM_NAME, c.RARITY
from ITEM_INFO i
join ITEM_TREE t
on i.item_id = t.parent_item_id
join ITEM_INFO c
on t.item_id = c.item_id
where i.rarity = 'RARE'
order by c.item_id desc