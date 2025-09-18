-- 코드를 입력하세요
SELECT DISTINCT a.CART_ID
from cart_products a join cart_products b on a.cart_id = b.cart_id AND a.name='Milk' AND b.name='Yogurt'
order by a.id
